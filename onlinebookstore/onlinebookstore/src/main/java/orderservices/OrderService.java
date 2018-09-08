package orderservices;

import java.util.ArrayList;

import org.bson.Document;

import purchaserequestservices.PurchaseService;

public class OrderService {
	
	public static void addConfirmOrder(Document toAdd)
	{
		OrderDatabase.addConfirmOrder(toAdd);
	}
	
	public static ArrayList getUserOrders( Document d)
	{
		String mobile_no=d.getString("mobile_no");
		
		return OrderDatabase.getUserOrders(mobile_no);
	}

}
