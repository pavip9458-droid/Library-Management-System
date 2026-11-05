import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        LibraryService library = new LibraryService();

        int choice;

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Add Member");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            switch (choice) {

                case 1: {
                    System.out.print("Enter Book ID: ");
                    int bookId = scan.nextInt();

                    scan.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = scan.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = scan.nextLine();

                    Book book = new Book(bookId, title, author);

                    library.addBook(book);
                    break;
                }

                case 2: {
                    library.viewBooks();
                    break;
                }

                case 3: {
                    System.out.print("Enter Book ID: ");
                    int searchId = scan.nextInt();

                    Book result = library.searchBook(searchId);

                    if (result != null) {
                        System.out.println("Book Found!");
                        System.out.println("Title: " + result.getTitle());
                        System.out.println("Author: " + result.getAuthor());
                    } else {
                        System.out.println("Book Not Found!");
                    }

                    break;
                }

                case 4: {
                    System.out.print("Enter Member ID: ");
                    int memberId = scan.nextInt();

                    scan.nextLine();

                    System.out.print("Enter Member Name: ");
                    String memberName = scan.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = scan.nextLine();

                    Member member = new Member(memberId, memberName, phone);

                    library.addMember(member);
                    break;
                }

                case 5: {
                    System.out.print("Enter Book ID: ");
                    int borrowBookId = scan.nextInt();

                    System.out.print("Enter Member ID: ");
                    int borrowMemberId = scan.nextInt();

                    library.borrowBook(borrowBookId, borrowMemberId);
                    break;
                }

                case 6: {
                    System.out.print("Enter Book ID: ");
                    int returnBookId = scan.nextInt();

                    System.out.print("Enter Member ID: ");
                    int returnMemberId = scan.nextInt();

                    library.returnBook(returnBookId, returnMemberId);
                    break;
                }

                case 7: {
                    System.out.println("Thank you for using Library Management System!");
                    break;
                }

                default: {
                    System.out.println("Invalid choice! Try again.");
                }
            }

        } while (choice != 7);

        scan.close();
    }
}
