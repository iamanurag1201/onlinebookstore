package orderservices;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import bookcartservices.BookAdapter;
import datatabseconnection.DatabaseConnection;
import model.Orders;

public class OrderDatabase {

	static MongoCollection<Document> orderCollection;
	static {
		orderCollection = DatabaseConnection.getOrderCollection();
	}
	public static void addConfirmOrder(Document toAdd) {
		orderCollection.insertOne(toAdd);
		
	}
	
	public static ArrayList getUserOrders( String mobile_no)
	{
		ArrayList al=new ArrayList<>();
		FindIterable <Document>fit=orderCollection.find(Filters.and(Filters.eq("mobile_no",mobile_no)
				));
		Iterator it=fit.iterator();
		while(it.hasNext())
		{
			Document d=(Document) it.next();
			System.out.println(d);
			al.add(BookAdapter.getBook(d));
		}
		return al;
	}

}
