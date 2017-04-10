import java.util.Date;
public class History{
    Date lendDate;
    Date returnDate;
    Book book;
    User user;
    Boolean isLent(){
        if(returnDate == null) return true;
        else return false;
    }

    void print(){
        if(this.isLent()){
            System.out.print(this.book.title + ", " + this.book.authors + ", " + this.book.publisher +", "+ this.book.publishYear + " (貸出中), " + user.name + "("  + user.gender + "; " + user.age + ") ");
            System.out.println(this.lendDate + "〜");
        }else{
            System.out.print(this.book.title + ", " + this.book.authors + ", " + this.book.publisher +", "+ this.book.publishYear + " (配架中), " + user.name + "("  + user.gender + "; " + user.age + ") ");
            System.out.println(this.lendDate + "〜" + this.returnDate);

        }
    }
}
