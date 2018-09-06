package com.dxc.anurag;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.Document;

import bookcartservices.BookService;
import purchaserequestservices.PurchaseService;


@Path("usercart")
public class UserCartResource {

	
	//add book to cart
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	//book& product_id &mobile
	public static void addBookToCart(Document doc) 
	{
		BookService.addToCart(doc);
	}
	//view book from cart
	@POST
	@Path("viewcart")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList viewcart(Document doc) {
		return BookService.viewCart(doc);
		
	}

}
