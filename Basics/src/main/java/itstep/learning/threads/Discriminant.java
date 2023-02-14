package itstep.learning.threads;

public class Discriminant {
    private int D;
    private Object locker_timer = new Object();
    private int root_count = 2;
    private long time1;

    public void calculate(int a, int b, int c) {
        time1 = System.nanoTime();
        D = (int)Math.pow(b, 2) - (4 * a * c);
        Runnable positive_root = new Runnable() {
            @Override
            public void run() {
                double x1;
                if (D >= 0) {
                    x1 = (-b - Math.sqrt(D)) / (2 * a);
                    System.out.println("x1 = " + x1);
                } else {
                    System.out.println("root not exist");
                }
                synchronized (locker_timer) {
                    root_count -= 1;
                    if(root_count == 0) onFinish();
                }
            }
        };

        Runnable negative_root = new Runnable() {
            @Override
            public void run() {
                double x2;
                if (D >= 0) {
                    x2 = (-b + Math.sqrt(D)) / (2 * a);
                    System.out.println("x2 = " + x2);
                } else {
                    System.out.println("root not exist");
                }
                synchronized (locker_timer) {
                    root_count -= 1;
                    if(root_count == 0) onFinish();
                }
            }
        };

        new Thread(positive_root).start();
        new Thread(negative_root).start();
    }

    private void onFinish() {
        long time2 = System.nanoTime();
        System.out.println("time: " + (time2 - time1) / 1e9);
    }
}
