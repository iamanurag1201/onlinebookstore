package bookdetailservices;

import org.bson.Document;

import model.Book_Details;



public class BookDetailAdapter {

	
	public static Book_Details getBook(Document d) {
		Book_Details emp = new Book_Details();
		emp.setBook_name(d.getString("book_name"));
		emp.setAuthor(d.getString("author"));
		emp.setTitle(d.getString("title"));
	    emp.setCategory(d.getString("category"));
		emp.setPublished_year(d.getString("published_year"));
		emp.setPrinted_price(d.getDouble("printed_price"));
		emp.setDiscount_price(d.getDouble("discount_price"));
		emp.setProduct_id(d.getString("product_id"));
		return emp;

	}

	public static Document getDocument(Book_Details emp) {
		Document doc = new Document()
				.append("book_name", emp.getBook_name())
				.append("author", emp.getAuthor())
				.append("title", emp.getTitle())
				.append("category", emp.getCategory())
			     .append("published_year", emp.getPublished_year())
				.append("printed_price", emp.getPrinted_price())
				.append("discount_price", emp.getDiscount_price())
				.append("product_id",emp.getProduct_id());
		return doc;

	}
	
}
