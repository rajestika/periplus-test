package entity;

public class Product {
	private String name;
	private String isbn;
	private Integer price;
	
	public Product(String name, String isbn, Integer price) {
		this.name = name;
		this.isbn = isbn;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public Integer getPrice() {
		return this.price;
	}
	
	@Override  
    public boolean equals(Object obj) {  
        if (this == obj) {  
            return true;  
        }  
          
        if (obj == null || getClass() != obj.getClass()) {  
            return false;  
        }  
           
        Product other = (Product) obj;  
          
        return this.isbn != null && this.isbn.equals(other.isbn);
	}
	
}
