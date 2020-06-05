import java.util.Random;

class MyThreadByExtends extends Thread {
    private String name;

    public MyThreadByExtends(String name){
        this.name = name;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                Thread.sleep(new Random().nextInt(10));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThreadByRunnable implements Runnable {
    private String name;

    public MyThreadByRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                Thread.sleep(new Random().nextInt(10));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadDemo{
    public static void main (String[] args){
        MyThreadByExtends t1 = new MyThreadByExtends("A");
        MyThreadByExtends t2 = new MyThreadByExtends("B");
        Thread t3 = new Thread(new MyThreadByRunnable("C"));
        Thread t4 = new Thread(new MyThreadByRunnable("D"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}