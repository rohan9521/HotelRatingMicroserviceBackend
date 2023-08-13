class Hello{
    private  int count=0;
    public synchronized void inc(){
        count++;
    }
    public int getCount(){
        return this.count;
    }
}
public class ThreadPrac {

    public static void main(String args[]) throws InterruptedException {
        Hello h = new Hello();
        Thread t1 = new Thread(()->{
            for(int i=0;i<100000;i++)
                h.inc();
        });
        Thread t2 = new Thread(()->{
            for(int i=0;i<100000;i++)
                h.inc();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(h.getCount());
    }
}
