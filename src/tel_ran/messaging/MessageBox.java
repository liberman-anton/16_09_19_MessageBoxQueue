package tel_ran.messaging;

import java.util.LinkedList;

public class MessageBox {
	private LinkedList<String> messages = new LinkedList<>();
	
	synchronized public void putMessage(String message){ 
		this.messages.add(message);
		this.notify();
	}
	
	synchronized public String getMessage(){
		while(this.messages.isEmpty()){
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("Thread was iterrupted");
			}
		}
		String message = this.messages.remove();
		return message;
	}
}