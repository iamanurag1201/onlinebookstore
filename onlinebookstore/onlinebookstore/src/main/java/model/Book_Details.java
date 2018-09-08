package model;

public class Book_Details {
		private String author;
		private String book_name;
		private String title;
		private double printed_price;
		private double discount_price;
		private String published_year;
	    private String category;
	    private String product_id;
	    
	    
		public Book_Details() {
			super();
		}
		public Book_Details(String author, String book_name, String title, double printed_price, double discount_price,
				String published_year, String category, String product_id) {
			super();
			this.author = author;
			this.book_name = book_name;
			this.title = title;
			this.printed_price = printed_price;
			this.discount_price = discount_price;
			this.published_year = published_year;
			this.category = category;
			this.product_id = product_id;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getBook_name() {
			return book_name;
		}
		public void setBook_name(String book_name) {
			this.book_name = book_name;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public double getPrinted_price() {
			return printed_price;
		}
		public void setPrinted_price(double printed_price) {
			this.printed_price = printed_price;
		}
		public double getDiscount_price() {
			return discount_price;
		}
		public void setDiscount_price(double discount_price) {
			this.discount_price = discount_price;
		}
		public String getPublished_year() {
			return published_year;
		}
		public void setPublished_year(String published_year) {
			this.published_year = published_year;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getProduct_id() {
			return product_id;
		}
		public void setProduct_id(String product_id) {
			this.product_id = product_id;
		}
	
		
	}


