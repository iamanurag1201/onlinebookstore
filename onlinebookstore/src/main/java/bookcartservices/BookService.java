package bookcartservices;

import java.util.ArrayList;

import javax.ws.rs.Path;

import org.bson.Document;

import com.mongodb.client.model.Filters;

import bookdetailservices.BookDetailAdapter;
import bookdetailservices.BookDetailService;
import model.UserCart;


public class BookService {



	//add to cart
	public static void addToCart(Document d)
	{
		Document doc=new Document("book_name",d.getString("book_name"));
		doc.append("product_id", d.getString("product_id"));
		String mobile_no=d.getString("mobile_no");
		System.out.println(mobile_no);
		Document addtoCart=BookDetailAdapter.getDocument(BookDetailService.getBookProfile(doc));
		addtoCart.append("mobile_no",mobile_no);
		System.out.println("heyy");
		System.out.println(addtoCart);
		BookDatabase.addToCart(addtoCart);
		
		
	}
	
	//view cart
	public static ArrayList viewCart(Document d) {
		
		return BookDatabase.viewCartDetail(d);
		
		
	}
	public static void delete(String book_name, String mobile_no, String product_id)
	{
		BookDatabase.delete(book_name, mobile_no, product_id);
	}
	public static Document getPurchaseDetails(Document doc)
	{
		String book_name=doc.getString("book_name");
		String product_id= doc.getString("product_id");
		String mobile_no=doc.getString("mobile_no");
		UserCart book=BookDatabase.getPurchaseDetails(book_name,mobile_no,product_id);
		return BookAdapter.getDocument(book);
	}
	
	
	
}
