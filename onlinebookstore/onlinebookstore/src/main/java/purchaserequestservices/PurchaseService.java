package purchaserequestservices;

import java.util.ArrayList;

import org.bson.Document;

import bookcartservices.BookAdapter;
import bookcartservices.BookDatabase;
import bookcartservices.BookService;
import model.UserCart;
import orderservices.OrderService;

public class PurchaseService {

	public static void addBookRequest(Document doc) {
		Document purchase=BookService.getPurchaseDetails(doc);
		PurchaseDatabase.addBookRequest(purchase);
		
	}

	public static ArrayList getAll() {
		return PurchaseDatabase.getAll();
		
	}

	public static void getBookRequest(Document doc) {
		String book_name=doc.getString("book_name");
		String product_id= doc.getString("product_id");
		String mobile_no=doc.getString("mobile_no");
		System.out.println(mobile_no);
		Document book=BookDatabase.getBookRequest(book_name, mobile_no, product_id);
		System.out.println(book);
		BookService.delete(book_name,mobile_no,product_id);
		PurchaseDatabase.delete(book_name,mobile_no,product_id);
		OrderService.addConfirmOrder(book);
		
	}

}
