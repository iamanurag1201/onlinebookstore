package com.dxc.anurag;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;

import bookdetailservices.BookDetailService;
import model.Book_Details;




@Path("books")
public class BookResource {

	
	//get all book
	@Path("getall")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {

		return Response.ok(BookDetailService.getAllBook())
				// .header("Access-Control-Allow-Origin", "*")
				// whatever other CORS headers
				.build();

	}
	
	//add book
	@POST
	@Path("addbooks")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Book_Details input) {
		// Response.ok().build();
		System.out.println("input student" + input.toString());
		BookDetailService.add(input);
		return Response.ok("{\"status\":\"0\",\"message\":\"successfuly added\"}")
				// .header("Access-Control-Allow-Origin", "*")
				.build();

	}
	//delete book by book name
	@DELETE
	@Path("delete/{book_name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("book_name") String book_name) {
		if (BookDetailService.delete(book_name)) {
			return Response.ok( "{\"status\":\"0\",\"message\":\"successfuly deleted\"}").build();
		} else {
			return Response.ok("{\"status\":\"1\",\"message\":\"Not found\"}").build();
		}
	}
	
	@Path("getbookbycategory/{category}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBookByCategory(@PathParam("category") String category) {

		return Response.ok(BookDetailService.getBookByCategory(category))
				// .header("Access-Control-Allow-Origin", "*")
				// whatever other CORS headers
				.build();

	}
	@Path("getbookbytitle/{title}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBookByTitle(@PathParam("title") String title ) {
		return Response.ok(BookDetailService.searchBookByTitle(title)).build();
				
	}
	
	@Path("getbookbyprice/{price}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBookByPrice(@PathParam("price") Double price ) {
		return Response.ok(BookDetailService.searchBookByPrice(price)).build();
				
	}
	//get book profile by book_name and author
	@Path("getbookprofile")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Book_Details getBookProfile(Document doc) {
		return BookDetailService.getBookProfile(doc);
	}
	//update book
//	@PUT
//    @Path("update/{rollno}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response update (@PathParam("rollno") String product_id,Book_Details input)
//    {
//    	if(BookDetailService.update(product_id, input))
//    	return Response.ok("{\"status\":\"0\",\"message\":\"successfuly added\"}")
//    			.build();
//    else
//    	return Response.ok("{\"status\":\"1\",\"message\":\"Roll no. not found\"}").build();
//    }
 	
	//get book by product id
	@Path("getbookbyproductid/{productid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBookByProductId(@PathParam("productid") String product_id ) {
		return Response.ok(BookDetailService.searchBookByProductId(product_id)).build();
				
	}
	
}
