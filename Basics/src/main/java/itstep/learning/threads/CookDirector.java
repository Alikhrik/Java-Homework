package itstep.learning.threads;


import static java.lang.Thread.sleep;

public class CookDirector {
    private ICookOfBreakfast cook;

    public CookDirector(ICookOfBreakfast cook) {
        this.cook = cook;
    }

    public void setCook(ICookOfBreakfast cook) {
        this.cook = cook;
    }

    public void MakeFastBreakfast() {
        Runnable makeTea = new Runnable() {
            @Override
            public void run() {
                System.out.println("Start make tea");
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cook.makeTea();
                System.out.println("Tea is ready!");
            }
        };
        Runnable makeOmelette = new Runnable() {
            @Override
            public void run() {
                System.out.println("Start make omelette");
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cook.makeOmelette();
                System.out.println("Omelette is ready!");
            }
        };
        Runnable fryBacon = new Runnable() {
            @Override
            public void run() {
                System.out.println("Start make bacon");
                try {
                    sleep(2500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cook.fryBacon();
                System.out.println("Bacon is ready!");
            }
        };
        Runnable makeToasts = new Runnable() {
            @Override
            public void run() {
                System.out.println("Start make toasts");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cook.makeToasts();
                System.out.println("Toasts is ready");
            }
        };

        Thread a = new Thread(makeTea);
        Thread b = new Thread(makeOmelette);
        Thread c = new Thread(makeToasts);
        Thread d = new Thread(fryBacon);
        a.start();
        b.start();
        c.start();
        d.start();
        try {
            d.join();
            c.join();
            b.join();
            a.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
