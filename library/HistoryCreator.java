import java.util.Date;

public class HistoryCreator{
    void run(){
        Book book = createBook("宮沢賢治", "セロ弾きのゴーシュ", "青空文庫", 1999);
        User user = createUser("玉田", "男", 38);

        History history = createHistory(book, user);
        history.print();

        history.returnDate = new Date();
        history.print();
    }

    Book createBook(String authors, String title, String publisher, Integer publishYear){
        Book book = new Book();

        book.title = title;
        book.authors = authors;
        book.publisher = publisher;
        book.publishYear = publishYear;

        return book;
    }

    User createUser(String name, String gender, Integer age){
        User user = new User();
        user.name = name;
        user.gender = gender;
        user.age = age;

        return user;
    }

    History createHistory(Book book, User user){
        Date date = new Date();
        History history = new History();
        history.book = book;
        history.user = user;
        // 3日前の日付を作成する．
        history.lendDate = new Date(date.getTime() - 1000*60*60*24*3);

        return history;
    }

    public static void main(String[] args){
        HistoryCreator creator = new HistoryCreator();
        creator.run();
    }
}
