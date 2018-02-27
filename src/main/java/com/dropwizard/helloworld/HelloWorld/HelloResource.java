package com.dropwizard.helloworld.HelloWorld;



import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.jetty.http.HttpStatus;
import org.hibernate.validator.constraints.NotEmpty;

import com.codahale.metrics.annotation.Timed;
import com.google.gson.Gson;


@Path("/hello")
//@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
 
	
	@GET
	@Path("/message")
	//@Produces(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	  public String message(@QueryParam("str") @NotEmpty String name) {
		Gson gson=new Gson();
	    return gson.toJson("Helloo World "+":"+ name );
	  }
	
	@POST
	@Path("/greeting")
	@Produces(MediaType.APPLICATION_JSON)
	  public HelloGreeting getGreeting() {
	    return new HelloGreeting("heloo world");
	}
	
	    @GET
	    @Path("/{param}")
	    public Response getMsg(@PathParam("param") String msg) {
	    	Gson gson=new Gson();
	        String output = "Get:Jersey say : " + msg;
	        return Response.status(200).entity((gson.toJson(output))).build();
	    }

	    @POST
	    @Path("{param}")
	    public Response postMsg(@PathParam("param") String msg) {
	    	Gson gson=new Gson();
	        String output = "POST:Jersey say : " + msg;
	        return Response.status(200).entity(output).build();
	    }

	    @POST
	    @Path("/post")
	    //@Consumes(MediaType.TEXT_XML)
	    public Response postStrMsg( String msg) {
	    	Gson gson=new Gson();
	        String output = "POST:Jersey say : " + msg;
	        return Response.status(200).entity(output).build();
	    }

	    @PUT
	    @Path("/{param}")
	    public Response putMsg(@PathParam("param") String msg) {
	    	Gson gson=new Gson();
	        String output = "PUT: Jersey say : " + msg;
	        return Response.status(200).entity(output).build();
	    }

	    @DELETE
	    @Path("/{param}")
	    public Response deleteMsg(@PathParam("param") String msg) {
	    	Gson gson=new Gson();
	        String output = "DELETE:Jersey say : " + msg;
	        return Response.status(200).entity(output).build();
	    }

	    @HEAD
	    @Path("/{param}")
	    public Response headMsg(@PathParam("param") String msg) {
	    	Gson gson=new Gson();
	        String output = "HEAD:Jersey say : " + msg;
	        return Response.status(200).entity(output).build();
	    }
	
	  }
	

