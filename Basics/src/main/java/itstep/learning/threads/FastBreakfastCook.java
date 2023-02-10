package itstep.learning.threads;

public class FastBreakfastCook implements ICookOfBreakfast {
    private Breakfast breakfast = new Breakfast();

    public void Reset() {
        this.breakfast = new Breakfast();
    }

    @Override
    public void makeTea() {
        this.breakfast.setTea("hot bleak tea");
    }

    @Override
    public void makeOmelette() {
        this.breakfast.setOmelette("delicious fresh omelet");
    }

    @Override
    public void fryBacon() {
        this.breakfast.setBacon("roasted bacon");
    }

    @Override
    public void makeToasts() {
        this.breakfast.setToasts("roasted toasts");
    }

    public Breakfast getResult() {
        return this.breakfast;
    }
}
