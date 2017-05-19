 class Sleep{
    
      private static final int NAP_TIME = 5; //max nap time in seconds

       public static void nap() {
         nap(NAP_TIME);
      }
   

       public static void nap(int duration) {
         int sleeptime = (int) (NAP_TIME * Math.random() );
         System.out.println("Nap for " + sleeptime + " seconds"); 
         try { Thread.sleep(sleeptime*1000); }
             catch (InterruptedException e) {
            System.out.println("nap() Error: " + e);
            }
      }
   }