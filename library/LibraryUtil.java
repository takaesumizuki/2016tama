import java.io.*;
import java.util.*;

/**
 * csvファイルから情報を読み取り，Bookオブジェクトを作成する．
 *
 * @author Haruaki Tamada
 */
public class LibraryUtil{
    /**
     * 
     */
    public List<Book> readFromFile(String fileName){
        List<Book> books = new ArrayList<Book>();
        try(BufferedReader in = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), "utf-8"))){
            String line;
            while((line = in.readLine()) != null){
                line = line.trim();
                if(Objects.equals(line, "") || line.startsWith("#")){
                    continue;
                }
                String[] data = line.split(",");
                Book book = this.createBook(data[0], data[1], data[2], data[3]);
                books.add(book);
            }
        } catch(IOException e){
            e.printStackTrace();
            // ignore
        }
        return Collections.unmodifiableList(books);
    }

    public Book createBook(String title, String authors, String publisher, String publishYear){
        return this.createBook(title, authors, publisher, new Integer(publishYear));
    }

    public Book createBook(String title, String authors, String publisher, Integer publishYear){
        Book book = new Book();
        book.title = title;
        book.authors = authors;
        book.publisher = publisher;
        book.publishYear = publishYear;

        return book;
    }
}
