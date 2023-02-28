package ku.cs.models;

import java.util.ArrayList;

public class AddMaterialList {
    private ArrayList<AddMaterial> addMaterialList;

    public AddMaterialList(){
        addMaterialList = new ArrayList<>();
    }

    public void addMaterial(AddMaterial addMaterial){
        addMaterialList.add(addMaterial);
    }

    public ArrayList<AddMaterial> getAddMaterialList() {
        return addMaterialList;
    }

}
