package demo.expresso.expresstestapp18feb2020;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.jar.JarEntry;

import static android.content.ContentValues.TAG;

class WorkedThread implements Runnable{

    String message;
    WorkedThread(String msg){
        this.message=msg;
    }

    @Override
    public void run() {

    try {
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                Date d = new Date();
                SimpleDateFormat df = new SimpleDateFormat("HH:MM:SS");
                System.out.println(("Task"+message +" :Time-" + df.format(d)));
            } else {
                Date d = new Date();
                SimpleDateFormat df = new SimpleDateFormat("HH:MM:SS");
                System.out.println("Start Time:" + df.format(d));
            }
            Thread.sleep(1000);
        }
        System.out.println("Completed");

    }
        catch(Exception e){
        e.printStackTrace();
        }
    }

}


public class ThreadPool {

    public static void main(String[] args) {
        WorkedThread t1=new WorkedThread("Task1");
        WorkedThread t2=new WorkedThread("Task2");
        WorkedThread t3=new WorkedThread("Task3");
        WorkedThread t4=new WorkedThread("Task4");
        WorkedThread t5=new WorkedThread("Task5");

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(t1);
        executor.execute(t2);
        executor.execute(t3);
        executor.execute(t4);
        executor.execute(t5);
        executor.shutdown();
        WorkedThread t6=new WorkedThread("Task6");
        WorkedThread t7=new WorkedThread("Task7");

        executor.execute(t6);
        executor.execute(t7);
        executor.shutdown();
    }
}
