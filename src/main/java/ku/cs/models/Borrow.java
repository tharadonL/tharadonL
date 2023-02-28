package ku.cs.models;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Borrow {
    private LocalDateTime borrowTime;
    private String serialNumber;
    private LocalDateTime returnTime;
    private String username;
    private String assetName;

    public Borrow(String borrowTime, String returnTime, String username, String assetName,String serialNumber) {
        this.borrowTime = LocalDateTime.parse(borrowTime);
        this.returnTime = LocalDateTime.parse(returnTime);
        this.username = username;
        this.assetName = assetName;
        this.serialNumber= serialNumber;
    }
    public String toCsv(){
        return serialNumber+","+borrowTime+","+ username +","+ assetName+","+returnTime;
    }

    public LocalDateTime getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(LocalDateTime borrowTime) {
        this.borrowTime = borrowTime;
    }

    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String BorrowFormatDateTime = borrowTime.format(format);
        String ReturnFormatDateTime = returnTime.format(format);
        return assetName+", "+username+", "+BorrowFormatDateTime+", "+ReturnFormatDateTime;
    }
}
