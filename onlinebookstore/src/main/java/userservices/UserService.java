package userservices;

import java.util.ArrayList;

import org.bson.Document;

import bookdetailservices.BookDetailDatabase;
import model.User_Detail;
import orderservices.OrderDatabase;
import orderservices.OrderService;


public class UserService {

	
	// for add new User
		public static void addUser(User_Detail user) {

			System.out.println("objectss " + user);
			Document userDoc = UserAdapter.getUserDoc(user);
			System.out.println("doc "+userDoc);
			UserDatabase.addUser(userDoc);
		}

		// for retreive user
		public static ArrayList getAllUser() {

			ArrayList al = UserDatabase.retreiveAllUser();
			return al;
		}	
		
		//get user profile
		public static User_Detail getProfile(Document doc) {
			
			return UserDatabase.getProfile(doc);
		}

		public static boolean delete(String mobile_no) {

			UserDatabase.delete(mobile_no);
			// problem always true
			return true;
		
		}
		
		public static ArrayList getUserOrders( Document d)
		{
			
			return OrderService.getUserOrders(d);
		}
		
}
