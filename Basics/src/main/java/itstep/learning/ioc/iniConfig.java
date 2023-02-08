package itstep.learning.ioc;

import itstep.learning.ConsoleColors;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedReader;

public class iniConfig implements IConfigService {
    private File config_file;

    public void setConfigFile(Path path) {
        if (Files.exists(path)) {
            this.config_file = path.toFile();
            System.out.println(ConsoleColors.GREEN + "File is set" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "File not found" + ConsoleColors.RESET);
        }
    }

    public String getParameter(String name) {
        String parameter = null;
        if (this.config_file != null) {
            BufferedReader reader;
            try {
                String str;
                reader = new BufferedReader(new FileReader(this.config_file));
                while ((str = reader.readLine()) != null) {
                    int index = str.indexOf('=');
                    if(str.substring(0, index).equals(name)) {
                        parameter = str.substring(index + 1);
                        break;
                    }
                }
                reader.close();
            } catch (IOException e) {
                System.out.println(ConsoleColors.RED + "Error: " + ConsoleColors.RESET + e.getMessage());
            }
        } else {
            System.out.println(ConsoleColors.GREEN + "File isn't set" + ConsoleColors.RESET);
        }
        return parameter;
    }
}
