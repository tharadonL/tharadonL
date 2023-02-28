package ku.cs.models;

import java.util.ArrayList;

public class AssetList {
    private Asset asset;

    private ArrayList<Asset> assets;

    public AssetList(){
        assets = new ArrayList<>();
    }

    public ArrayList<Asset> getAssetType(){return assets;}

    public String getAssetType1(){return asset.getCategory();}

    public ArrayList<Asset> getAllAsset(){
        return assets;
    }


    public String toCsv() {
        String result = "";
        for (Asset asset : this.assets){
            result += asset.toCsv() + "\n";
        }
        return result;
    }

    public  Asset searchAssetName(String name){
        for(Asset asset : this.assets){
            if(asset.isName(name)){
                return asset;
            }
        }return null;
    }


    public void addAsset(Asset asset){assets.add(asset);}
}
