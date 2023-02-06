package itstep.learning.ioc;


public class Service1 implements IService3 {
    @Override
    public void show() {
        System.out.println("I am " + this);
    }
}
