package edu.epam.task.entity;

public class Book implements Entity{
    private int id;
    private String title;
    private String author;
    private String publishingHouse;
    private int publishYear;
    private int pages;
    private int price;
    private Binding bindingType;

    public Book() {}

    public Book(int id, String title, String author, String publishingHouse, int publishYear, int pages, int price, Binding bindingType) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.publishYear = publishYear;
        this.pages = pages;
        this.price = price;
        this.bindingType = bindingType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Binding getBindingType() {
        return bindingType;
    }

    public void setBindingType(Binding bindingType) {
        this.bindingType = bindingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (publishYear != book.publishYear) return false;
        if (pages != book.pages) return false;
        if (price != book.price) return false;
        if (!title.equals(book.title)) return false;
        if (!author.equals(book.author)) return false;
        if (!publishingHouse.equals(book.publishingHouse)) return false;
        return bindingType == book.bindingType;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publishingHouse.hashCode();
        result = 31 * result + publishYear;
        result = 31 * result + pages;
        result = 31 * result + price;
        result = 31 * result + bindingType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id = ").append(id).append(", title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", publishingHouse='").append(publishingHouse).append('\'');
        sb.append(", publishYear=").append(publishYear);
        sb.append(", pages=").append(pages);
        sb.append(", price=").append(price);
        sb.append(", bindingType='").append(bindingType).append('\'').append('}');
        return sb.toString();
    }
}
