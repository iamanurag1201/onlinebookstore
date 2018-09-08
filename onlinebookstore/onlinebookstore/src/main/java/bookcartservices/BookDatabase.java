package bookcartservices;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;


import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import bookdetailservices.BookDetailAdapter;
import datatabseconnection.DatabaseConnection;
import model.Book_Details;
import model.UserCart;

public class BookDatabase {

	
	
	static MongoCollection<Document> requestCollection;
	static {
		requestCollection = DatabaseConnection.getUserCartCollection();
	}

	//add to cart 
	public static void addToCart(Document addtoCart) {
		requestCollection.insertOne(addtoCart);
		System.out.println("added");
		
		
	}


	//view from cart
	public static ArrayList viewCartDetail(Document d) {
		ArrayList al=new ArrayList();
		Book_Details viewcart=new Book_Details();
		String mobile_no=d.getString("mobile_no");
		FindIterable <Document>doc=requestCollection.find(Filters.eq("mobile_no",mobile_no));
		Iterator<Document> it=doc.iterator();
		while(it.hasNext()) {
			al.add(BookDetailAdapter.getBook(it.next()));
		}
		
		return al;
	}


	public static UserCart getPurchaseDetails(String book_name, String mobile_no, String product_id) {
		
		FindIterable <Document>fit=requestCollection.find(Filters.and(Filters.eq("mobile_no",mobile_no),
				Filters.eq("product_id",product_id),Filters.eq("book_name",book_name)));
		
		
		
		return BookAdapter.getBook(fit.first());
		
	}
	
	public static void delete(String book_name, String mobile_no, String product_id)
	{
		Document doc=BookAdapter.getDocument(getPurchaseDetails(book_name, mobile_no,product_id));
		requestCollection.deleteOne(Filters.and(Filters.eq("mobile_no",mobile_no),
				Filters.eq("product_id",product_id),Filters.eq("book_name",book_name)));
	}


	public static Document getBookRequest(String book_name, String mobile_no, String product_id) {
		
		return BookAdapter.getDocument(getPurchaseDetails(book_name, mobile_no, product_id));
	}
}
