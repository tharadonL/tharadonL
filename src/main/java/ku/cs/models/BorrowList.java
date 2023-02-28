package ku.cs.models;

import java.util.ArrayList;

public class BorrowList {
    private ArrayList<Borrow> borrows;
    public BorrowList(){
        borrows = new ArrayList<>();
    }

    public String toCsv() {
        String result = "";
        for (Borrow borrow : this.borrows){
            result += borrow.toCsv() + "\n";
        }
        return result;
    }

    public void addBorrow(Borrow borrow){
        borrows.add(borrow);
    }

    public ArrayList<Borrow> getAllBorrows(){return borrows;}
}
