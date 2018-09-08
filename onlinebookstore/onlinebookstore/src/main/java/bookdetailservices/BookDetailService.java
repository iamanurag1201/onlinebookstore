package bookdetailservices;

import java.util.ArrayList;

import javax.ws.rs.Path;

import org.bson.Document;

import model.Book_Details;

public class BookDetailService {

	// for add new book
	public static void add(Book_Details book) {
		Document bookDoc = BookDetailAdapter.getDocument(book);
		BookDetailDatabase.addBook(bookDoc);
	}

	// for retreive books
	public static ArrayList getAllBook() {

		ArrayList al = BookDetailDatabase.retreiveAllBook();
		return al;
	}

	// delete book by name
	public static boolean delete(String book_name) {

		
		BookDetailDatabase.delete(book_name);
		// problem always true
		return true;
	}

	// search using category
	public static ArrayList getBookByCategory(String category) {

		ArrayList a = BookDetailDatabase.searchByCategory(category);

		return a;
	}

	// search using title
	public static ArrayList searchBookByTitle(String title) {
		ArrayList a =BookDetailDatabase.searchByTitle(title);
		return a;
	}

	// search using price
	public static ArrayList searchBookByPrice(Double price) {
		ArrayList a = BookDetailDatabase.searchByprice(price);
		return a;
	}

	// get book profile
	public static Book_Details getBookProfile(Document doc) {
		return BookDetailDatabase.viewBookBy(doc);
	}

//	public static boolean update(String product_id, Book_Details input) {
//
//			return BookDetailDatabase.updateByProductId(product_id, input);
//		}
	
	// search using product_id
		public static ArrayList searchBookByProductId(String product_id) {
			ArrayList a =BookDetailDatabase.searchByProductId(product_id);
			return a;
		}
	
	}
	

