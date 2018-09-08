package userservices;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import bookdetailservices.BookDetailDatabase;
import datatabseconnection.DatabaseConnection;
import model.User_Detail;

public class UserDatabase {

	static MongoCollection<Document> requestCollection;
	static {
		requestCollection = DatabaseConnection.getUserCollection();
	}

	// add enduser
	public static void addUser(Document user) {
		requestCollection.insertOne(user);
	}

	// retrive all the user
	public static ArrayList retreiveAllUser() {
		ArrayList al = new ArrayList();
		FindIterable<Document> fit = requestCollection.find();
		Iterator<Document> it = fit.iterator();
		while (it.hasNext()) {
			Document userDocument = (Document) it.next();
			User_Detail userObject = UserAdapter.getuser(userDocument);
			al.add(userObject);
		}
		return al;
	}

	// getuserprofile

	public static User_Detail getProfile(Document doc) {
		String mobile = doc.getString("mobile");
		return viewProfile(mobile);
	}

	// view profile(mobile)
	public static User_Detail viewProfile(String mobile) {
		User_Detail userProfile = new User_Detail();
		System.out.println(mobile);
		FindIterable<Document> fit = requestCollection.find(Filters.eq("mobile", mobile));
		userProfile = UserAdapter.getuser(fit.first());
		return userProfile;
	}

	public static boolean delete(String mobile_no) {
		// TODO Auto-generated method stub
		
		Document d = new Document();
		d.append("mobile_no",mobile_no);

		UserDatabase.requestCollection.deleteOne(d);
		// problem always true
		return true;
		
	}

}
