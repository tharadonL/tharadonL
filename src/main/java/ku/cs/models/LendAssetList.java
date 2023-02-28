package ku.cs.models;

import java.util.ArrayList;

public class LendAssetList {

    private ArrayList<LendAsset> lendAssets;

    public LendAssetList(){
        lendAssets = new ArrayList<>();
    }

    public ArrayList<LendAsset> getAllAsset(){
        return lendAssets;
    }

    public String toCsv() {
        String result = "";
        for (LendAsset asset : this.lendAssets){
            result += asset.toCsv() + "\n";
        }
        return result;
    }


    public void addAsset(LendAsset lendasset){lendAssets.add(lendasset);}
}
