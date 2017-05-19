import java.util.TimerTask;

public class RunMeTask extends TimerTask
{
	 Thread myThreadObj;
	 public RunMeTask(Thread t){
	   this.myThreadObj=t;
	
	  }
	  public void run() {
	   myThreadObj.start();
	   
	  }
}