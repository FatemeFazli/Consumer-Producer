import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;





class Producer implements Runnable {
	private  boolean exit = false;
      private  Buffer buffer;
      int time ;
      RunMeTask t ;      
      
       public Producer(Buffer b ) {
    	   
         buffer = b;
       
        
      }
   

     
       public void run() {
    	
   
     
    	   System.out.println("timer working");  
    	   Date message;
    	   
    	   
           while (true) {
              System.out.println("P nap");
              Sleep.nap();
              message = new Date();      
              System.out.println("Producer produced [" + message + "]");
              buffer.insert(message);

              
    	   }    
   }

}