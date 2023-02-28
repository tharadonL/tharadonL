package ku.cs.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Material {
    private String category;
    private String name;
    private String amount;
    private String number;
    private String date;
    private String username;

    public Material(String name,String category, String amount, String date){
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getAmount() {
        return amount;
    }

    public String getNumber() {return number; }

    public String getDate() {return date; }

    @Override
    public String toString() {
        return  name + " , " + category + " , " + amount + " , " + date;
    }

    public String toCSV() {
        return  name + ',' + category + ',' + amount + ',' + date + ',' + username;
    }

}
