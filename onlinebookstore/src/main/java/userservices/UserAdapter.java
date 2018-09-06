package userservices;

import org.bson.Document;

import model.User_Detail;

public class UserAdapter {

	public static User_Detail getuser(Document d) {
		User_Detail usr = new User_Detail();
		usr.setFname(d.getString("fname"));
		usr.setLname(d.getString("lname"));
		usr.setAddress(d.getString("address"));
		usr.setMobile_no(d.getString("mobile_no"));
		usr.setEmail(d.getString("email"));
		usr.setPassword(d.getString("password"));
		usr.setGender(d.getString("gender"));
		return usr;

	}

	public static Document getUserDoc(User_Detail user) {

		Document doc = new Document().append("fname", user.getFname()).append("lname", user.getLname())
				.append("address", user.getAddress()).append("email", user.getEmail())
				.append("password", user.getPassword()).append("mobile_no", user.getMobile_no())
				.append("gender", user.getGender());

		return doc;

	}

}
