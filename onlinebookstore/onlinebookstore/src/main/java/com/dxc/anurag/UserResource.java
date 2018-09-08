package com.dxc.anurag;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;

import bookdetailservices.BookDetailService;
import model.User_Detail;
import userservices.UserService;



@Path("enduser")
public class UserResource {

	@POST
	@Path("adduser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User_Detail input) {
		// Response.ok().build();
		// System.out.println("input student"+input.toString());
		UserService.addUser(input);
		System.out.println("hiiii" + input);
		return Response.ok("{\"status\":\"0\",\"message\":\"successfuly added\"}")
				// .header("Access-Control-Allow-Origin", "*")
				.build();

	}

	@Path("getalluser")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUser() {

		return Response.ok(UserService.getAllUser())
				// .header("Access-Control-Allow-Origin", "*")
				// whatever other CORS headers
				.build();

	}

	// get user profile by mobile
	@Path("getprofile")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User_Detail getProfile(Document doc) // mobile
	{
		return UserService.getProfile(doc);
	}
	//delete user by mobileno
	@DELETE
	@Path("delete/{mobile_no}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("mobile_no") String mobile_no) {
		if (UserService.delete(mobile_no)) {
			return Response.ok( "{\"status\":\"0\",\"message\":\"successfuly deleted\"}").build();
		} else {
			return Response.ok("{\"status\":\"1\",\"message\":\"Not found\"}").build();
		}
	}
	
	@Path("getorders")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList getUserOrders( Document d) //mobile_no
	{
		return UserService.getUserOrders(d);
	}
}
