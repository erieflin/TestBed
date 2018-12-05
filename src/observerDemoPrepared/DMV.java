package observerDemoPrepared;

import java.util.ArrayList;
import java.util.List;

public class DMV implements Subject {

	private List<Observer> waitingPeople;
	
	private final Object MUTEX = new Object(); // private variable to syncronize on to prevent issues with multithreading
	private int queueIndex = 0;
	private int currentlyServing =0;
	public DMV(){
			this.waitingPeople=new ArrayList<>();
		}

	@Override
		public void register(Observer obj) {
			if(obj == null) throw new NullPointerException("Null Observer");
			synchronized (MUTEX) {
				if(!waitingPeople.contains(obj)){
					waitingPeople.add(obj);
					queueIndex++;
					obj.update("queued at:"+queueIndex);
				}
			}
		}

	@Override
	public void unregister(Observer obj) {
		synchronized (MUTEX) {
			waitingPeople.remove(obj);
		}
	}

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
		//synchronization is used to make sure any observer registered after opening is available is not notified
		synchronized (MUTEX) {
			observersLocal = new ArrayList<>(this.waitingPeople);
		}
		for (Observer obj : observersLocal) {
			obj.update("serving:"+currentlyServing);
		}

	}
	
	//method to post message to the topic
	public void postMessage(){
		currentlyServing++;
		System.out.println("DMV currently Serving " + currentlyServing);
		notifyObservers();
	}
	
	public List<Observer> getWaitingPeople() {
		return waitingPeople;
	}

	public void setWaitingPeople(List<Observer> waitingPeople) {
		this.waitingPeople = waitingPeople;
	}

	public int getQueueIndex() {
		return queueIndex;
	}

	public void setQueueIndex(int queueIndex) {
		this.queueIndex = queueIndex;
	}

	public int getCurrentlyServing() {
		return currentlyServing;
	}

	public void setCurrentlyServing(int currentlyServing) {
		this.currentlyServing = currentlyServing;
	}

}
