
/*
Subject code : CSEB5133 / CSEB534 Java Programming
Section      : 01A
Student name : Muhammad Izzat Fikri Bin Zurilan
Student ID no: SW01082295
Question no  : 3
*/

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Chemistry Form 4", new Author("Roslan Ahmad", "roslan@pustakarawang.my", 'm'), 23.00);
        Book book2 = new Book("Mathematics Form 4", new Author("Naaimah Sulong", "naaimah@pustakarawang.my", 'f'), 30.00, 10);

        // Printing author information
        System.out.println("Author of book1: " + book1.getAuthor().getName() + ", Email: " + book1.getAuthor().getEmail());
        System.out.println("Author of book2: " + book2.getAuthor().getName() + ", Email: " + book2.getAuthor().getEmail());

        System.out.println(book1);
        System.out.println(book2);
    }
}

class Author{
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString(){
        return getName() + " (" + getGender() + ")" + " at " + getEmail();
    }

}

class Book{
    private String name;
    private double price;
    private Author author;
    private int qtyInStock;


    public Book(String name, Author author, double price){
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public Book(String name, Author author, double price, int qtyInStock){
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    @Override
    public String toString(){
        return getName() + " by " + getAuthor() + " RM" + getPrice();
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

}
