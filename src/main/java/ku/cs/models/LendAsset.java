package ku.cs.models;

public class LendAsset {
    private String date;
    private String time;
    private String category;
    private String name;
    private String username;

    public LendAsset(String date, String time, String category, String name, String username) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.time = time;
        this.username = username;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }





    @Override
    public String toString() {
        return  date + " " + time + " " + category + " " + name + " " + username;
    }

//    public void setSerialNumber(String serialNumber) {
//        this.serialNumber = serialNumber;
//    }

    public String toCsv(){
        return date + time + category + name + username;
    }

}
