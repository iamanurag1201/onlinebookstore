package com.dxc.anurag;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.Document;

import purchaserequestservices.PurchaseService;


@Path("purchase")
public class PurchaseResource {
	
	
	//mobile,book_name,product_id purchase book
	@POST
	@Path("add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void purchaseBook(Document doc) 
	{
		System.out.println("hi");
		PurchaseService.addBookRequest(doc);
	}
	
	@GET
	@Path("getall")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList getAll()
	{
		System.out.println("hi");
		return PurchaseService.getAll();
	}
	
	@POST
	@Path("confirmorder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void getBook(Document doc)  //mobile,book_name,product_id
	{
		System.out.println("hi");
		PurchaseService.getBookRequest(doc);
	}
}
