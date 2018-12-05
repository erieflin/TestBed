package observerDemoPrepared;

public class ObserverPatternTest {

		public static void main(String[] args) {
			//create subject
			DMV dmv = new DMV();
			
			//create observers
			Peasant obj1 = new Peasant("Elliot");
			Peasant obj2 = new Peasant("Poe");
			Peasant obj3 = new Peasant("MT");
			
			//register observers to the subject
			dmv.register(obj1);
			dmv.register(obj2);
			dmv.register(obj3);
			
			obj1.setSubject(dmv);
			obj2.setSubject(dmv);
			obj3.setSubject(dmv);
			
			//check if any update is available
			Thread threadObj1 = new Thread(){
			    public void run(){
			    	boolean continueLoop = true;;
			    	while(continueLoop) {
			    		System.out.println();
			    	
			    		dmv.postMessage();
			    		System.out.println();
			    		try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		continueLoop = dmv.getCurrentlyServing() <= dmv.getQueueIndex()-1;
			    	}
			    }
			 };
			 threadObj1.start();

		}
}
