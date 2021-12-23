package task3.model;

public class Book implements Comparable<Book>{

    private String name;
    private String author;
    private String publishedBy;
    private int publicYear;
    private int pages;
    private double price;

    public Book(String name, String author, String publishedBy, int publicYear, int pages, double price) {
        this.name = name;
        this.author = author;
        this.publishedBy = publishedBy;
        this.publicYear = publicYear;
        this.pages = pages;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(String publishedBy) {
        this.publishedBy = publishedBy;
    }

    public int getPublicYear() {
        return publicYear;
    }

    public void setPublicYear(int publicYear) {
        this.publicYear = publicYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n{" +
                "\nname='" + name + '\'' +
                "\nauthor='" + author + '\'' +
                "\npublishedBy='" + publishedBy + '\'' +
                "\npublicYear=" + publicYear +
                "\npages=" + pages +
                "\nprice=" + price +
                "\n}\n";
    }

    @Override
    public int compareTo(Book o) {
        return this.publishedBy.compareTo(o.publishedBy);
    }
}
