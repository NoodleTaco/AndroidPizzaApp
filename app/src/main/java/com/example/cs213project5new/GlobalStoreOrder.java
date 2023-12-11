package com.example.cs213project5new;

/**
 * This class implements the singleton design pattern by having an instance of storeOrder be shared
 * between all activities
 * @author Donald Yubeaton, Michael Kassie
 */
public final class GlobalStoreOrder {
    private static GlobalStoreOrder globalStoreOrder;
    private StoreOrder storeOrder;

    /**
     * Private Constructor to be called when the global instance has not been initialized
     */
    private GlobalStoreOrder(){}

    /**
     * Retrieves or creates the global instance of GlobalStoreOrder
     * @return The instance of GlobalStoreOrder
     */
    public static synchronized GlobalStoreOrder getInstance(){
        if(globalStoreOrder == null){
            globalStoreOrder = new GlobalStoreOrder();
        }
        return globalStoreOrder;
    }

    /**
     * Sets the GlobalStoreOrder
     * @param storeOrder The GlobalStoreOrder
     */
    public void setGlobalStoreOrder(StoreOrder storeOrder){
        this.storeOrder = storeOrder;
    }

    /**
     * Gets the storeOrder contained within the GlobalStoreOrder instance
     * @return The store order
     */
    public StoreOrder getStoreOrder(){
        return storeOrder;
    }


}
