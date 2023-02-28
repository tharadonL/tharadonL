package ku.cs.models;

public class Asset {
    private String name;

    private String category;

    private String serialNumber;
    private String imagePath;
    private String username;
    private String status;

    public Asset(String serialNumber, String name, String category) {
        this.name = name;
        this.category = category;
        this.serialNumber = serialNumber;
        this.imagePath = "images/default.png";

    }

    public Asset(String serialNumber, String name, String category,String imagePath,String username,String status) {
        this.name = name;
        this.category = category;
        this.serialNumber = serialNumber;
        this.imagePath = imagePath;
        this.username = username;
        this.status = status;
    }

    public String getName() {
        return name;
    }
    public boolean isType(String type){
        return this.category.equals(type);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }
    public String getStatus(){return  status;}

    public void setCategory(String category) {
        this.category = category;
    }


    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return  serialNumber + " " + name + " " + category ;
    }
    public String toString1(){return category;}

    public boolean isName(String existName){
        return this.name.equals(existName);
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String toCsv(){
        return serialNumber+","+ name +","+ category+","+imagePath;
    }
    public String getImagePath() {
        return imagePath;
    }
    //    public void setImagePath() {this.imagePath = "images/user_default.png";}
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
    public void setImagePath(){this.imagePath = "images/default.png";}

    public void setUsername(String currentUsername){this.username = currentUsername;}

    public void setStatus(String newStatus){this.status = newStatus;}


}
