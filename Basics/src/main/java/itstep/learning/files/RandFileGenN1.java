package itstep.learning.files;

import itstep.learning.ConsoleColors;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class RandFileGenN1 implements FileGenerator {

    private File file;

    public void Reset() {
        this.file = null;
    }

    private String genRandFileName() {
        String name = "./createdFiles/";
        Random rand = new Random();
        int max_len = 10, min_len = 5;
        StringBuilder sb = new StringBuilder();
        int len = rand.nextInt(max_len - min_len) + min_len;
        for (; len > 0; len--) {
            name += ((char) (rand.nextInt(26) + 'a'));
        }
        name += ".txt";
        return name;
    }

    public void GenFile() {
        String name;
        if (this.file != null) {
            name = this.file.getName();
        } else {
            name = genRandFileName();
        }
        Path path = Paths.get(name);

        if (!Files.exists(path)) {
            try {
                path = Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (Files.exists(path)) {
                this.file = path.toFile();
                Random rand = new Random();
                int max_cnt = 50, min_cnt = 1;
                int max_len = 100, min_len = 1;
                StringBuilder strBldr = new StringBuilder();

                int ln_cnt = rand.nextInt(max_cnt - min_cnt) + min_cnt;
                for (int cnt = 0; cnt < ln_cnt; cnt++) {
                    int ln_len = rand.nextInt(max_len - min_len) + min_len;

                    for (int len = 0; len < ln_len; len++) {
                        strBldr.append((char) (rand.nextInt(26) + 'a'));
                    }
                    strBldr.append("\n");
                }

                String gen_content = strBldr.toString();

                try (FileWriter fw = new FileWriter(this.file)) {
                    fw.write(gen_content);
                    fw.flush();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(ConsoleColors.GREEN + "File created" + ConsoleColors.RESET);
            }
        }
    }

    public File getFile() {
        return this.file;
    }
}
