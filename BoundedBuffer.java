import java.util.concurrent.Semaphore;

class BoundedBuffer implements Buffer{ 
    
      private static final int BUFFER_SIZE = 3;
      private int count; 
      private int in;  
      private int out; 
      private Object[] buffer;
      private Semaphore mutex; 
      private Semaphore empty; 
      private Semaphore full; 
       
       public BoundedBuffer(){

         count = 0;
         in = 0;
         out = 0;
         buffer = new Object[BUFFER_SIZE];
         mutex = new Semaphore(1);
         empty = new Semaphore(BUFFER_SIZE); 
         full = new Semaphore(0);
      }
   
  
       public void insert(Object item) {
    
         try{
            empty.acquire(); 
            mutex.acquire(); 
         }
             catch (InterruptedException e) { 
               System.out.println("ERROR " + e);
            } 

         ++count;
         buffer[in] = item;
     
         in = (in + 1) % BUFFER_SIZE; 
         if (count == BUFFER_SIZE){
            System.out.println("BUFFER FULL "
               + "Producer inserted \"" + item 
               + "\" count=" + count + ", "
               + "in=" + in + ", out=" + out);
         }
         else{
            System.out.println("Producer inserted \"" + item 
               + "\" count=" + count + ", "
               + "in=" + in + ", out=" + out);
         }
       
         mutex.release(); 
         full.release();     	
 
      }
   

       public Object remove() {
         Object item=null;
   
      
         try{
            full.acquire();
            mutex.acquire(); 
         }
             catch (InterruptedException e) { 
               System.out.println("ERROR in try(): " + e);
            } 

         --count;
         item = buffer[out];
   
         out = (out + 1) % BUFFER_SIZE;
         if (count == 0){
            System.out.println("BUFFER EMPTY "
               + "Consumer removed \"" + item 
               + "\" count=" + count + ", "
               + "in=" + in + ", out=" + out);
         }
         else{
            System.out.println("Consumer removed \"" + item 
               + "\" count=" + count + ", "
               + "in=" + in + ", out=" + out);
         }
       
         mutex.release(); 
         empty.release();   	  
         return item;
      }
   
   }