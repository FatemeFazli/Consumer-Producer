





class Stopper implements Runnable {
     
      int time ;
      Thread a ;
      Thread b ;
      
       public Stopper(int time , Thread a , Thread b ) {
    	    this.time = time;
    	    this.a = a ;
    	    this.b = b ;
    	   
      }
   
       public void run() {
    	   
    	   new java.util.Timer().schedule( 
    		        new java.util.TimerTask() {
    		            @Override
    		            public void run() {
    		               a.stop();
    		               b.stop();
    		               System.out.println("---------------------- threads stoped after " + time + " seconds ---------------------- " );
    		            }
    		        }, 
    		        time*1000
    		);   
   }

}