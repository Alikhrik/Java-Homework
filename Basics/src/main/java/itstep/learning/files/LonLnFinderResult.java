package itstep.learning.files;

import itstep.learning.ConsoleColors;

public class LonLnFinderResult implements CreatedResult {
    private int length;
    private int number;
    private String context;

    public LonLnFinderResult(int length, int number, String context) {
        this.length = length;
        this.number = number;
        this.context = context;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return String.format(
                "The longest line -" +
                        ConsoleColors.BLUE + " length: " + ConsoleColors.RESET + "%d" +
                        ConsoleColors.YELLOW + " number: " + ConsoleColors.RESET + "%d\n" +
                        ConsoleColors.GREEN + "content: " + ConsoleColors.RESET + " %s",
                this.length, this.number, this.context);
    }
}
