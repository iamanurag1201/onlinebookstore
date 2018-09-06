package bookcartservices;

import org.bson.Document;


import model.UserCart;

public class BookAdapter {
	
	
	public static UserCart getBook(Document d) {
		UserCart cartBook = new UserCart();
		cartBook.setBook_name(d.getString("book_name"));
		cartBook.setAuthor(d.getString("author"));
		cartBook.setTitle(d.getString("title"));
	    cartBook.setCategory(d.getString("category"));
		cartBook.setPublished_year(d.getString("published_year"));
		cartBook.setPrinted_price(d.getDouble("printed_price"));
		cartBook.setDiscount_price(d.getDouble("discount_price"));
		cartBook.setProduct_id(d.getString("product_id"));
		cartBook.setMobile_no(d.getString("mobile_no"));
		return cartBook;

	}

	public static Document getDocument(UserCart cartBook) {
		Document doc = new Document()
				.append("book_name", cartBook.getBook_name())
				.append("author", cartBook.getAuthor())
				.append("title", cartBook.getTitle())
				.append("category", cartBook.getCategory())
			     .append("published_year", cartBook.getPublished_year())
				.append("printed_price", cartBook.getPrinted_price())
				.append("discount_price", cartBook.getDiscount_price())
				.append("product_id",cartBook.getProduct_id())
				.append("mobile_no",cartBook.getMobile_no());
		return doc;

	}
	

}
