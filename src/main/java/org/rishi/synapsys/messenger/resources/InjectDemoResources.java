package org.rishi.synapsys.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResources {
	
	@GET
	@Path("annotations")
	public String getParamsUsingAnotations(@MatrixParam("param") String matrixParam,
											@HeaderParam("header") String headerParam,
											@CookieParam("cookie") String cookieParam){
		
		return "MatrixParam Value = "+matrixParam +"  header param = "+headerParam + " cookie Param = " +cookieParam;                           

}
}