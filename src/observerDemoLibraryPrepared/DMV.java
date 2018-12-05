package observerDemoLibraryPrepared;
import java.util.Observable;
import java.util.Observer;



class DMV extends Observable implements Runnable {
	private int queueIndex = 0;
	private int currentlyServing =0;
    public void run() {
    	boolean continueLoop = true;
        while (continueLoop) {
        	currentlyServing++;
        	System.out.println("");
    		System.out.println("DMV currently Serving :" + currentlyServing);
            setChanged();
            System.out.println("");
            notifyObservers("DMV currently Serving :" + currentlyServing);
            continueLoop = currentlyServing <= queueIndex-1;
            System.out.println("");
        }
    }
   
    public synchronized void addObserver(Peasant p) {
    	// TODO Auto-generated method stub
    	queueIndex++;
    	p.setQueuePosition(""+queueIndex);
    	super.addObserver(p);
    }
}