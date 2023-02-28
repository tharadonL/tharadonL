package ku.cs.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MaterialList {
    private ArrayList<Material> materialList;

    public MaterialList(){
        materialList = new ArrayList<>();
    }

    public void addMaterial(Material material){
        materialList.add(material);
    }

    public ArrayList<Material> getMaterialList() {
        return materialList;
    }

}


