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

import org.rishi.synapsys.messenger.model.Comment;
import org.rishi.synapsys.messenger.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private CommentService commentService= new CommentService();
	
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageID){
		return commentService.getAllComments(messageID);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId")long messageID, Comment comment){
		return commentService.addComment(messageID, comment);
	}
	
	@PUT
	@Path("/{CommentId}")
	public Comment updateComment(@PathParam("messageId")long messageID, Comment comment){
		comment.setId(messageID);
		return commentService.updateComment(messageID, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long messageID,@PathParam("commentId") long commentID){
		commentService.removeComment(messageID, commentID);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getMessageComment(@PathParam("mesageId")long messageID, @PathParam("commentId") long commentID){
		return commentService.getComment(messageID, commentID);
	}

}
