package classes.entity;

public class Book {
    private String title;
    private String author;
    private String price;
    private String isBestseller;

    public Book() {

    }

    public Book(String title, String author, String price, String isBestseller) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isBestseller = isBestseller;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIsBestseller() {
        return isBestseller;
    }

    public void setIsBestseller(String isBestseller) {
        this.isBestseller = isBestseller;
    }


}
