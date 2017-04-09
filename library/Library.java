import java.util.*;

public class Library{
    List<Book> shelf = new ArrayList<Book>();

    void run(){
        this.printWelcomeMessage();
        this.addBooks(shelf);
        this.list();
        this.printBook(this.find("聖教新聞"));
        this.printBook(this.find("腹腹時計"));
    }

    Book find(String searchName){
        Book foundBook = null;
        for(Book book: shelf){
            if(Objects.equals(book.title,searchName)){
                foundBook = book;
            }
        }
        return foundBook;
    }

    //本の一覧を表示するメソッド
    void list(){
        for(Book book: shelf){
            this.printBook(book);
        }
    }

    // 一冊の本の情報を表示するメソッド
    void printBook(Book book){
        if(book == null){
            System.out.println("そんな本ないです");
            return;
        }
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
