package demo.expresso.expresstestapp18feb2020;


class Thread01 extends Thread{

    boolean zeroFlag=true;
    Print print;
    int max;
    int i=0;
    Thread01(Print print,int max,boolean flag){
        this.zeroFlag = flag;
        this.max =max;
        this.print =print;
    }


    @Override
    public void run() {

        while(i <=10){
            if(zeroFlag) {
                print.printZero();
            }
            else print.printOne();

            i=i+1;
        }
    }
}


class Print{

    boolean isZeroPrinted =false;
    synchronized void printZero()  {

        if(isZeroPrinted) {
            try {
                wait();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(0);
        isZeroPrinted =true;
        notify();


    }

    synchronized  void printOne()  {
        if(!isZeroPrinted) {
            try {
                wait();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(1);
        isZeroPrinted =false;
        notify();

    }

}

public class ThreadWaitingDemo {

    public static void main(String[] args) throws InterruptedException {
        Print p= new Print();
        Thread01 t1 =new Thread01( p,10,true);
        Thread01 t2 = new Thread01(p,10,false);
        t1.start();
        t2.start();

        System.out.println("Main Method");
    }


}
