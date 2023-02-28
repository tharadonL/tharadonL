package ku.cs.services;
import ku.cs.models.Borrow;
import ku.cs.models.BorrowList;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class BorrowFileDataSource implements DataSource<BorrowList>{
    private String directoryName;
    private String filename;

    private BorrowList borrowList = new BorrowList();

    public BorrowFileDataSource(String directoryName,String filename){
        this.directoryName = directoryName;
        this.filename = filename;
        checkFileIsExisted();
    }
    private void checkFileIsExisted() {
        File file = new File(directoryName);

        if(!file.exists()){ //ถ้า directory ไม่มีอยู่ให้สร้าง
            file.mkdir();
        }

        String path = directoryName+File.separator+filename;

        file = new File(path);

        //ถ้าไม่มี file ให้สร้าง file
        if(!file.exists()){
            try {
                file.createNewFile();

            } catch (IOException e) { throw new RuntimeException(e); }
        }
    }

    @Override
    public BorrowList readData() {
        String path = "data/csv" + File.separator + "borrowReturn.csv";
        File file = new File(path);

        FileReader reader = null;
        BufferedReader buffer = null;

        try {
            reader = new FileReader(file, StandardCharsets.UTF_8);
            buffer = new BufferedReader(reader);

            String line = "";

            while ((line = buffer.readLine()) != null) {
                String[] data = line.split(",");
                borrowList.addBorrow(new Borrow(
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4]
                ));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                buffer.close();
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return borrowList;
    }

    @Override
    public void writeData(BorrowList borrowList) {
        String path = directoryName + File.separator + filename;
        File file = new File(path);

        FileWriter writer = null;
        BufferedWriter buffer = null;
        try {
            writer = new FileWriter(file, StandardCharsets.UTF_8);
            buffer = new BufferedWriter(writer);

            buffer.write(borrowList.toCsv());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                buffer.close();
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public BorrowList getAllBorrowList(){
        return borrowList;
    }
}
