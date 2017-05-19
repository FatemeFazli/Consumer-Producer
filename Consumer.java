import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class Consumer implements Runnable{
	
	private volatile boolean exit = false;
    
      private Buffer buffer;
      int time ;
       
       public Consumer(Buffer b) { 
         buffer = b;
    
         
      }
   
       public void run(){
    	
         Date message = null;
         
         
         while (true){
            System.out.println("C nap");
            Sleep.nap(); 
            System.out.println("Consumer Turn");
            message = (Date)buffer.remove();
            System.out.println("Consumer consumed [" + message + "]");
     
         }
      }
     
   }