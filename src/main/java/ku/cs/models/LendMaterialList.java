package ku.cs.models;

import java.util.ArrayList;

public class LendMaterialList {
    private ArrayList<LendMaterial> lendMaterialList;

    public LendMaterialList(){
        lendMaterialList = new ArrayList<>();
    }

    public void lendMaterial(LendMaterial lendMaterial){
        lendMaterialList.add(lendMaterial);
    }

    public ArrayList<LendMaterial> getLendMaterialList() {
        return lendMaterialList;
    }

}
