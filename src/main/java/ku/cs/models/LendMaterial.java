package ku.cs.models;

public class LendMaterial {
    private String category;
    private String name;
    private String amount;
    private String number;
    private String date;
    private String username;

    public LendMaterial(String name, String category, String amount, String date, String username){
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.username = username;
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

    @Override
    public String toString() {
        return  name + " , " + category + " , " + amount + " , " + date + " , " + username;
    }

    public String toCSV() {
        return  name + ',' + category + ',' + amount + ',' + date + ',' + username;
    }
}
