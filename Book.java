import java.io.Serializable;

public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    private int borrowedByMemberId;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.borrowedByMemberId = -1;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getBorrowedByMemberId() {
        return borrowedByMemberId;
    }

    public void setBorrowedByMemberId(int memberId) {
        borrowedByMemberId = memberId;
    }
}