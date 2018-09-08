package bookdetailservices;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import datatabseconnection.DatabaseConnection;
import model.Book_Details;

public class BookDetailDatabase {

	static MongoCollection<Document> requestCollection;
	static {
		requestCollection = DatabaseConnection.getBookCollection();
	}

	// add book
	public static void addBook(Document book) {
		requestCollection.insertOne(book);
	}

	// retrive all the book
	public static ArrayList retreiveAllBook() {
		ArrayList al = new ArrayList();
		FindIterable<Document> fit = requestCollection.find();
		Iterator<Document> it = fit.iterator();
		while (it.hasNext()) {
			Document bookDocument = (Document) it.next();
			Book_Details bookObject = BookDetailAdapter.getBook(bookDocument);
			al.add(bookObject);
		}
		return al;
	}

	// delete book by name
	public static boolean delete(String book_name) {

		Document d = new Document();
		d.append("book_name", book_name);

		BookDetailDatabase.requestCollection.deleteOne(d);
		// problem always true
		return true;
	}

	// search by category
	public static ArrayList searchByCategory(String category) {

		ArrayList al = new ArrayList();
		FindIterable<Document> find = requestCollection.find().filter(Filters.eq("category", category));
		Iterator it = find.iterator();
		while (it.hasNext()) {
			al.add(it.next());
			// System.out.println(al);
		}
		return al;
	}

	// search by title

	public static ArrayList searchByTitle(String title) {
		ArrayList a = new ArrayList();
		FindIterable<Document> obj = requestCollection.find().filter(Filters.eq("title", title));
		Iterator it = obj.iterator();
		while (it.hasNext()) {
			a.add(it.next());
		}
		return a;
	}

	// search by product_id
	public static ArrayList searchByProductId(String product_id) {
		ArrayList a = new ArrayList();
		FindIterable<Document> obj = requestCollection.find().filter(Filters.eq("product_id", product_id));
		Iterator it = obj.iterator();
		while (it.hasNext()) {
			a.add(it.next());
		}
		return a;
	}

	// search by price
	public static ArrayList searchByprice(Double price) {
		ArrayList a = new ArrayList();
		FindIterable<Document> obj = requestCollection.find().filter(Filters.lte("printed_price", price));
		Iterator it = obj.iterator();
		while (it.hasNext()) {
			a.add(it.next());
		}
		return a;
	}

	// view book by(bookname and product_id)
	public static Book_Details viewBookBy(Document doc) {
		String book_name = doc.getString("book_name");
		String author = doc.getString("product_id");
		return viewBook(book_name, author);

	}

	// view Book (bookname and product_id)

	public static Book_Details viewBook(String book_name, String author) {
		Book_Details viewBook = new Book_Details();
		System.out.println(book_name + " " + author);
		FindIterable<Document> f = requestCollection
				.find(Filters.and(Filters.eq("book_name", book_name), Filters.eq("product_id", author)));
		viewBook = BookDetailAdapter.getBook(f.first());
		return viewBook;
	}
//		public static boolean updateByProductId(String product_id, Book_Details input) {
//			
//				Bson filter = new Document("product_id", product_id);
//				Bson newValue = new Document("product_id",input.getProduct_id())
//						.append("book_name", input.getBook_name())
//						.append("author",input.getAuthor())
//						.append("title", input.getTitle())
//						.append("category", input.getCategory())
//					     .append("published_year", input.getPublished_year())
//						.append("printed_price", input.getPrinted_price())
//						.append("discount_price",input.getDiscount_price());
//						
//				Bson updateOperationDocument = new Document("$set", newValue);
//				UpdateResult update= Book_Details.updateMany(filter, updateOperationDocument);
//				return update.wasAcknowledged();
//			}

}
