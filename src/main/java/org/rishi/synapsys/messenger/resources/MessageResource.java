package org.rishi.synapsys.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rishi.synapsys.messenger.model.Message;
import org.rishi.synapsys.messenger.service.MessageService;

@Path("/messages")

/*Since Consumes and Produces annotation is used by almost all the methods , its better to put it on the class
 * level
 * 
 * **/
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	 MessageService messageService= new MessageService();
	@GET
	//@Produces(MediaType.APPLICATION_XML)
	
	/**mediaType,APPLICATION_JSON tell JAX-B (which come binded with java) to convert all the returned type to XML
	but the model classes needs to be annotated with @XmlRootElement, which tells JAX-B that this is the root based on 
	whose format return type is converted to xml.
	**/
	//@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage(){
		return messageService.getAllMessage();
	}
	
	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		
		return messageService.addMessage(message);
	}
	@PUT
	@Path("/{messageId}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId")long id, Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMEssage(@PathParam ("messageId")long id){
		messageService.removeMessage(id);
	}
	
	
	@GET
	@Path("/{messageId}")
	//@Produces(MediaType.APPLICATION_XML)
	//@Produces(MediaType.APPLICATION_JSON)
	public Message test(@PathParam("messageId")long id ){
		
		return messageService.getMessage(id);
	}

}
