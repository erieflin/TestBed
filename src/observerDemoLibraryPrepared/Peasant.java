package observerDemoLibraryPrepared;

import java.security.InvalidParameterException;
import java.util.Observable;
import java.util.Observer;


public class Peasant implements Observer {
		
		private String queuePosition = "Not Queued";
		private String name = "";
		public Peasant(String name){
			this.name = name;
		}
		
		public String getQueuePosition() {
			return queuePosition;
		}
		
		public void setQueuePosition(String queuePosition) {
			this.queuePosition = queuePosition;
		}

		@Override
		public void update(Observable o, Object arg) {
			if(arg instanceof String) {
				String message = (String) arg;
				if(message.contains(":")) {
					String[] messageParts = message.split(":");
					if(messageParts.length < 2) {
						throw new InvalidParameterException("message should be in the format key:value");
					}
					
						if(messageParts[1].trim().equals(queuePosition)) {
							System.out.println(name + ": Its my turn");
							o.deleteObserver(this);
							System.out.println(name + ": is finally leaving the dmv");
						}else {
							System.out.println(name + ": Still not my turn");
						}
					
				}
			}
			
		}

	}

