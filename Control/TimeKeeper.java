package Control;

import java.awt.*;


public class TimeKeeper implements Runnable {
	
	Controller Class_Controller;
	int i = 0;
	
	boolean threadSuspended;
	Thread t = null;
	int Interval;
	
	public TimeKeeper( Controller Class_Controller, int Interval ) {
		//System.out.println("TimeKeeper created");
		this.Class_Controller = Class_Controller;
		this.Interval = Interval;
		
		//start();
	}
	
	public void Startup() {
		start();
	}

	   public void init() {
	   }

	   public void destroy() {
	   }

	   public void start() {

		   if ( t == null ) {
			   t = new Thread( this );
			   threadSuspended = false;
			   t.start();
		   } else {

	      }
	   }

	   public void stop() {

	   }

	   public void run() {

	      try {
	         while (true) {
	            Class_Controller.TimeTick( );
	            t.sleep( Interval );  // interval given in milliseconds
	         }
	      } catch (InterruptedException T) { 
				System.out.println("Kunne ikke loope timer");
				System.out.println ( "Throwable message: " + T.getMessage ( ) );
				System.out.println ( "Throwable cause: " + T.getCause ( ) );
				System.out.println ( "Throwable class: " + T.getClass ( ) );
	      } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }

	   public void paint( Graphics g ) {

	   }
}
