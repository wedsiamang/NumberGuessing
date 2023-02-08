package pack;

import java.util.Timer;
import java.util.TimerTask;

public class SimpleTimer {
//	public static void main(String[] args){
	public void timer() {
	
		TimerTask task = new TimerTask() {
			@Override
			public void run() {			
				System.out.println("");
			}
		};
		Timer timer= new Timer();
		timer.schedule(task,180000);
	}
}
