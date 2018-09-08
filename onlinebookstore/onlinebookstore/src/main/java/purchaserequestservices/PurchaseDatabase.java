package purchaserequestservices;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import bookcartservices.BookAdapter;
import datatabseconnection.DatabaseConnection;
import model.UserCart;

public class PurchaseDatabase {

	static MongoCollection<Document> purchaseCollection;
	static {
		purchaseCollection = DatabaseConnection.getPurchaseCollection();
	}
	public static void addBookRequest(Document doc) {
		
		purchaseCollection.insertOne(doc);
	}
	public static ArrayList getAll() {
		ArrayList al =new ArrayList();
		FindIterable fit= purchaseCollection.find();
		Iterator it=fit.iterator();
		while(it.hasNext())
		{
			al.add(it.next());
		}
		return al;
	}
	
public static UserCart getPurchaseDetails(String book_name, String mobile_no, String product_id) {
		
		FindIterable <Document>fit=purchaseCollection.find(Filters.and(Filters.eq("mobile_no",mobile_no),
				Filters.eq("product_id",product_id),Filters.eq("book_name",book_name)));
		
		
		
		return BookAdapter.getBook(fit.first());
		
	}
	
	public static void delete(String book_name, String mobile_no, String product_id)
	{
		Document doc=BookAdapter.getDocument(getPurchaseDetails(book_name, mobile_no,product_id));
		purchaseCollection.deleteOne(Filters.and(Filters.eq("mobile_no",mobile_no),
				Filters.eq("product_id",product_id),Filters.eq("book_name",book_name)));
	}

}
