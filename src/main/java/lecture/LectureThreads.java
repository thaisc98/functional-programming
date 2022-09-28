package lecture;

public class LectureThreads {

    public static void main(String[] args) {
        // traditional way
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                for(int x = 0; x < 10000; x++){
                    System.out.println(Thread.currentThread().getId() + ":" +  x);
                }

            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

        Thread thread3 = new Thread(runnable);
        thread3.start();


        // functional Runnable interface
        // Because Runnable is a FunctionalInterface
        Runnable runnable2  = () -> {
                for(int x = 0; x < 10000; x++){
                    System.out.println("func: " +Thread.currentThread().getId() + ":" +  x);
                }
        };

        Thread thread4 = new Thread(runnable2);
        thread4.start();

        Thread thread5 = new Thread(runnable2);
        thread5.start();

        Thread thread6 = new Thread(runnable2);
        thread6.start();
    }
}
