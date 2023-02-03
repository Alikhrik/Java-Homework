package itstep.learning.files;

import itstep.learning.ConsoleColors;

import java.io.*;

public class LongestLineFinder implements FinderByFiles {

    private CreatedResult findResult;
    private String line;

    public void Reset() {

    }

    public void Find(File file) {
        if (file.exists() && file.isFile()) {
            int max_ln_len = 0;
            int ln_len_cnt = 0;

            int ln_cnt = 0;
            int max_ln_num = 0;

            String longest_ln = "null";

            try(InputStream is = new FileInputStream(file)) {
                int code;
                char sym;
                StringBuilder sb = new StringBuilder();

                while ((code = is.read()) != -1) {
                    sym = (char) code;
                    ln_len_cnt++;
                    sb.append(sym);
                    if(sym == '\n' || sym == '\r') {
                        ln_cnt++;
                        if((ln_len_cnt - 1) > max_ln_len) {
                            longest_ln = sb.toString();
                            max_ln_len = (ln_len_cnt - 1);
                            max_ln_num = ln_cnt;
                        }
                        sb.setLength(0);
                        ln_len_cnt = 0;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            this.findResult = new LonLnFinderResult(max_ln_len, max_ln_num, longest_ln);
        } else {
            System.out.println(ConsoleColors.RED + "Object not exist or not file" + ConsoleColors.RESET);
        }
    }

    public CreatedResult GetResult() {
        return this.findResult;
    }
}
