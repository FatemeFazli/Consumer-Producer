import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class ConsumerProducer {

	 
			Thread pro_Thread ;
			Thread con_Thread;
			Thread stopper;
	   	
	       public static void main(String args[]) {
	    	 
	    	ConsumerProducer CP = new ConsumerProducer();
	    	 Scanner sc = new Scanner(System.in);
	    	 System.out.println("Enter time for running threads : ");
	    	 int t = sc.nextInt();
	         Buffer sharedBuffer = new BoundedBuffer();
	         
    		
	         
	       CP.pro_Thread = new Thread(new Producer(sharedBuffer));
	       CP.con_Thread = new Thread(new Consumer(sharedBuffer));
	       CP.stopper = new Thread(new Stopper(t, CP.con_Thread, CP.pro_Thread));
	         
	       CP.stopper.start();
	       CP.pro_Thread.start();
	       CP.con_Thread.start();   
	       
	       
	       //  TimerTask task1 = new RunMeTask(CP.pro_Thread);
	       //  TimerTask task2 = new RunMeTask(CP.con_Thread);
	         
    	   // Timer timer = new Timer();
    	   //  timer.schedule(task1, 100000,t);  
    	   //  timer.schedule(task2,100000,t);  
    	     
    	     
    	     
    	  //   CP.pro_Thread.stop();
   	    //  CP.con_Thread.stop();   
	         
	    
	     
	 
	   }
}
