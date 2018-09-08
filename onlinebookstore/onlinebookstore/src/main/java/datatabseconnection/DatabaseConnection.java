package datatabseconnection;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnection {

	private static final String DBNAME = "casestudy";
	private static final String BookDetail = "bookdetail";
	private static final String UserCollection = "user";
	private static final String AdimnCollection = "admin";
	private static final String UserCartCollection = "usercart";
	private static final String OrderCollection = "order";
	private static final String PurchaseCollection = "purchase";

	private static MongoCollection<Document> bookcollection;
	private static MongoCollection<Document> usercollection;
	private static MongoCollection<Document> admincollection;
	private static MongoCollection<Document> usercartcollection;
	private static MongoCollection<Document> ordercollection;
	private static MongoCollection<Document> purchasecollection;
	
	static {
		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase database = mongo.getDatabase(DBNAME);
		bookcollection = database.getCollection(BookDetail);
		usercollection = database.getCollection(UserCollection);
		admincollection = database.getCollection(AdimnCollection);
		usercartcollection = database.getCollection(UserCartCollection);
		ordercollection = database.getCollection(OrderCollection);
		purchasecollection = database.getCollection(PurchaseCollection);
	}

	public static MongoCollection<Document> getBookCollection() {
		return bookcollection;
	}

	public static MongoCollection<Document> getUserCollection() {
		return usercollection;
	}

	public static MongoCollection<Document> getAdminCollection() {
		return admincollection;
	}

	public static MongoCollection<Document> getUserCartCollection() {
		return usercartcollection;
	}

	public static MongoCollection<Document> getOrderCollection() {
		return ordercollection;
	}

	public static MongoCollection<Document> getPurchaseCollection() {
		return purchasecollection;
	}

}
