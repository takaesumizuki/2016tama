import java.util.*;

public class Library{
    void run(){
        this.printWelcomeMessage();
        List<Book> shelf = new ArrayList<Book>();
        this.addBooks(shelf);

        for(Integer i = 0; i < shelf.size(); i++){
            Book book = shelf.get(i);
            this.printBook(book);
        }
    }

    void printBook(Book book){
        System.out.printf("%s (%s) %s, %d%n",
        book.title, book.authors, book.publisher, book.publishYear);
    }

    /**
    *棚に本を追加するメソッド
    */
    void addBooks(List<Book> shelf){
        LibraryUtil util = new LibraryUtil();
        List<Book> books = util.readFromFile("books.csv");
        for(Integer i = 0; i < books.size(); i++){
            shelf.add(books.get(i));
        }
    }

    Book createBook(String title, String authors, String publisher, Integer publishYear){
        Book book = new Book();
        book.title = title;
        book.authors = authors;
        book.publisher = publisher;
        book.publishYear = publishYear;

        return book;
    }
    void printWelcomeMessage(){
        System.out.println("ようこそ図書館システムへ．");
    }
    public static void main(String[] args){
        Library lib = new Library();
        lib.run();
    }
}
