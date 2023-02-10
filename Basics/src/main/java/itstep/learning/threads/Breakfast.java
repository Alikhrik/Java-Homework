package itstep.learning.threads;

public class Breakfast {
    private String tea = "none";
    private String omelette = "none";
    private String bacon = "none";
    private String toasts = "none";

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public String getOmelette() {
        return omelette;
    }

    public void setOmelette(String omelette) {
        this.omelette = omelette;
    }

    public String getBacon() {
        return bacon;
    }

    public void setBacon(String bacon) {
        this.bacon = bacon;
    }

    public String getToasts() {
        return toasts;
    }

    public void setToasts(String toasts) {
        this.toasts = toasts;
    }

    @Override
    public String toString() {
        return String.format("Breakfast:\n" +
                "\ttea: %s\n" +
                "\tomelette: %s\n" +
                "\tbacon: %s\n" +
                "\ttoasts: %s",
                this.tea, this.omelette, this.bacon, this.toasts);
    }
}
