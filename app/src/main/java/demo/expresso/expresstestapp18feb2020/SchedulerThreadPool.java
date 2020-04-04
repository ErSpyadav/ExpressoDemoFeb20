package demo.expresso.expresstestapp18feb2020;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Task implements Runnable{

    String name;
    public Task(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        Date d=new Date();
        SimpleDateFormat df=new SimpleDateFormat("hh:mm:ss");
        System.out.println("Execute Time:"+df.format(d));
    }
}
public class SchedulerThreadPool {

    public static void main(String[] args) {

        ScheduledThreadPoolExecutor stp = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);
        stp.scheduleWithFixedDelay(new Task("Sp"),2,10, TimeUnit.SECONDS);


    }
}
