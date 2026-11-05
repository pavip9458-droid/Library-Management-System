import java.util.ArrayList;
import java.io.*;

public class LibraryService {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    private final String BOOK_FILE = "books.dat";
    private final String MEMBER_FILE = "members.dat";

    // Constructor
    public LibraryService() {
        loadBooks();
        loadMembers();
    }

    // Add Book
    public void addBook(Book book) {

        for (Book b : books) {

            if (b.getBookId() == book.getBookId()) {
                System.out.println("Book ID already exists!");
                return;
            }
        }

        books.add(book);
        saveBooks();

        System.out.println("Book added successfully!");
    }

    // View Books
    public void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }

        for (Book book : books) {

            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Available: " + book.isAvailable());

            System.out.println("------------------");
        }
    }

    // Search Book
    public Book searchBook(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {
                return book;
            }
        }

        return null;
    }

    // Add Member
    public void addMember(Member member) {

        for (Member m : members) {

            if (m.getMemberId() == member.getMemberId()) {
                System.out.println("Member ID already exists!");
                return;
            }
        }

        members.add(member);
        saveMembers();

        System.out.println("Member added successfully!");
    }

    // Search Member
    public Member searchMember(int memberId) {

        for (Member member : members) {

            if (member.getMemberId() == memberId) {
                return member;
            }
        }

        return null;
    }

    // Borrow Book
    public void borrowBook(int bookId, int memberId) {

        Book book = searchBook(bookId);
        Member member = searchMember(memberId);

        if (book == null) {
            System.out.println("Book not found!");
        }

        else if (member == null) {
            System.out.println("Member not found!");
        }

        else if (!book.isAvailable()) {
            System.out.println("Book is already borrowed!");
        }

        else {
            book.setAvailable(false);
            book.setBorrowedByMemberId(memberId);

            saveBooks();

            System.out.println(member.getMemberName()
                    + " borrowed " + book.getTitle());
        }
    }

    // Return Book
    public void returnBook(int bookId, int memberId) {

        Book book = searchBook(bookId);

        if (book == null) {
            System.out.println("Book not found!");
        }

        else if (book.isAvailable()) {
            System.out.println("This book is not borrowed!");
        }

        else if (book.getBorrowedByMemberId() != memberId) {
            System.out.println("This book was not borrowed by this member!");
        }

        else {
            book.setAvailable(true);
            book.setBorrowedByMemberId(-1);

            saveBooks();

            System.out.println("Book returned successfully!");
        }
    }

    // Save Books
    private void saveBooks() {

        try {
            ObjectOutputStream output =
                    new ObjectOutputStream(new FileOutputStream(BOOK_FILE));

            output.writeObject(books);
            output.close();

        } catch (IOException e) {
            System.out.println("Error saving books!");
        }
    }

    // Load Books
    @SuppressWarnings("unchecked")
    private void loadBooks() {

        try {
            ObjectInputStream input =
                    new ObjectInputStream(new FileInputStream(BOOK_FILE));

            books = (ArrayList<Book>) input.readObject();
            input.close();

        } catch (FileNotFoundException e) {
            // First time program runs
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading books!");
        }
    }

    // Save Members
    private void saveMembers() {

        try {
            ObjectOutputStream output =
                    new ObjectOutputStream(new FileOutputStream(MEMBER_FILE));

            output.writeObject(members);
            output.close();

        } catch (IOException e) {
            System.out.println("Error saving members!");
        }
    }

    // Load Members
    @SuppressWarnings("unchecked")
    private void loadMembers() {

        try {
            ObjectInputStream input =
                    new ObjectInputStream(new FileInputStream(MEMBER_FILE));

            members = (ArrayList<Member>) input.readObject();
            input.close();

        } catch (FileNotFoundException e) {
            // First time program runs
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading members!");
        }
    }
}
