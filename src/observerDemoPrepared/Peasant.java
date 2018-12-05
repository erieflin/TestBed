package observerDemoPrepared;

import java.security.InvalidParameterException;

public class Peasant implements Observer {
		
		private String queuePosition = "Not Queued";
		private String name = "";
		private Subject subject; 
		public Peasant(String name){
			this.name = name;
		}
		@Override
		public void update(String message) {
			if(message.contains(":")) {
				String[] messageParts = message.split(":");
				if(messageParts.length < 2) {
					throw new InvalidParameterException("message should be in the format key:value");
				}
				if(messageParts[0].trim().equalsIgnoreCase("serving")) {
					if(messageParts[1].trim().equals(queuePosition)) {
						System.out.println(name + ": Its my turn");
						this.subject.unregister(this);
						System.out.println("finally leaving the dmv");
					}else {
						System.out.println(name + ": Still not my turn");
					}
				}else {
					this.queuePosition = messageParts[1];
					System.out.println(name +": At queue Position " + queuePosition + "! Going about my life");
				}
			}
		}
		
		public String getQueuePosition() {
			return queuePosition;
		}
		
		public void setQueuePosition(String queuePosition) {
			this.queuePosition = queuePosition;
		}
		@Override
		public void setSubject(Subject sub) {
			this.subject = sub;
			
		}

	}

