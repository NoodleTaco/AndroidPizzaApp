package com.example.cs213project5new;

public final class GlobalStoreOrder {
    private static GlobalStoreOrder globalStoreOrder; //single instance
    private StoreOrder storeOrder;

    private GlobalStoreOrder(){}

    public static synchronized GlobalStoreOrder getInstance(){
        if(globalStoreOrder == null){
            globalStoreOrder = new GlobalStoreOrder();
        }
        return globalStoreOrder;
    }

    public void setGlobalStoreOrder(StoreOrder storeOrder){
        this.storeOrder = storeOrder;
    }
    public StoreOrder getGlobalStoreOrder(){
        return storeOrder;
    }


}
