package org.rishi.synapsys.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rishi.synapsys.messenger.database.DatabaseClass;
import org.rishi.synapsys.messenger.model.Message;

public class MessageService {
	
	
	
	public static Map<Long, Message>messages=DatabaseClass.getMessages();
	
  public MessageService(){
	  messages.put(1L, new Message(1,"Hello world","Rishi"));
	  messages.put(2L, new Message(2,"Hello Jersey","Rishi"));
  }
	
	
	public List<Message> getAllMessage(){
//		Message m1= new Message(1L,"Hello World", "Rishi" );
//		Message m2= new Message(2L, "Hello Jersey", "Rishi");
//		List<Message>list= new ArrayList<>();
//		list.add(m1);
//		list.add(m2);
//		return list;
		
		return new ArrayList<Message>(messages.values());
		
	}
	
	public Message getMessage(long id){
		return messages.get(id);//get(id) will return the value form Map
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() +1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
			
		}
	
	public Message removeMessage(long id){
		return messages.remove(id);
			}
	
	
	}
	



