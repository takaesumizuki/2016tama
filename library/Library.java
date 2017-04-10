import java.util.*;

public class Library{
    List<Book> shelf = new ArrayList<Book>();
    UserManager manager = new UserManager();

    void run(){
        this.printWelcomeMessage();
        this.addBooks(shelf);

        this.registerUsers();
        Iterator<User> iterator = manager.iterator();
        while( iterator.hasNext() ){
            manager.print(iterator.next());
        }
    }

    void registerUsers(){
        manager.add(manager.create("岩間","男",50));
        manager.add(manager.create("松本","男",69));
        manager.add(manager.create("金正日","男",70));
        manager.add(manager.create("KRSW","男",39));
        manager.add(manager.create("田所浩二","男",24));
    }

    void remove2(String title, String author, String publisher, Integer publishYear){
        Book book = createBook(title, author, publisher, publishYear);
        shelf.remove(book);
    }

    List<Book> findOrPrint(String title, String authors, String publisher, Integer publishYear){
        List<Book> shelf = this.findOr(title,authors,publisher,publishYear);
        this.printList(shelf);
        return shelf;
    }

    List<Book> findOr(String title, String authors, String publisher, Integer publishYear){
        List<Book> result = new ArrayList<Book>();

        for(Book book: shelf){
            if(this.isOrMatch(book, title, authors, publisher, publishYear)) {
                result.add(book);
            }
        }
        return result;
    }

    Boolean isOrMatch(Book book, String title, String authors,
    String publisher, Integer publishYear){
        Boolean flag = false;
        //titleの比較
        if(title != null && Objects.equals(book.title,title)){
            flag = true;
        }
        //authorsの比較
        if(authors != null && Objects.equals(book.authors,authors)){
            flag = true;
        }
        //publisherの比較
        if(publisher != null && Objects.equals(book.publisher,publisher)){
            flag = true;
        }

        //publishyearの比較
        if(publishYear != null && (publishYear == book.publishYear)){
            flag = true;
        }
        return flag;
    }

    List<Book> findAndPrint(String title, String authors, String publisher, Integer publishYear){
        List<Book> shelf = this.findAnd(title,authors,publisher,publishYear);
        this.printList(shelf);
        return shelf;
    }

    void printList(List<Book> shelf){
        for(Book book: shelf){
            this.printBook(book);
        }
    }

    void remove(Book book){
        this.shelf.remove(book);
    }

    List<Book> findAnd(String title, String authors, String publisher, Integer publishYear){
        List<Book> result = new ArrayList<Book>();

        for(Book book: shelf){
            if(this.isMatch(book, title, authors, publisher, publishYear)) {
                result.add(book);
            }
        }
        return result;
    }

    Boolean isMatch(Book book, String title, String authors,
    String publisher, Integer publishYear){
        Boolean flag = true;
        //titleの比較
        if(title != null && !Objects.equals(book.title,title)){
            flag = false;
        }
        //authorsの比較
        if(authors != null && !Objects.equals(book.authors,authors)){
            flag = false;
        }
        //publisherの比較
        if(publisher != null && !Objects.equals(book.publisher,publisher)){
            flag = false;
        }

        //publishyearの比較
        if(publishYear != null && !(publishYear == book.publishYear)){
            flag = false;
        }
        return flag;
    }

    //本のタイトルから本を探すメソッド
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
