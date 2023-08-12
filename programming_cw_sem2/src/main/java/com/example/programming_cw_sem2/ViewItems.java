package com.example.programming_cw_sem2;

public final class ViewItems {
    //Private variables
    private String itemCode;
    private String itemName;
    private String itemBrand;
    private String itemPrice;
    private String itemQuantity;
    private String itemCategory;
    private String itemPurchaseDate;
    private String itemImagePath;

    //Getters
    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemBrand() {
        return itemBrand;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public String getItemPurchaseDate() {
        return itemPurchaseDate;
    }

    public String getItemImagePath() {
        return itemImagePath;
    }

    //Default constructor
    public ViewItems() {}

    //Parametarised constructor
    public ViewItems(String itemCode, String itemName, String itemBrand, String itemPrice, String itemQuantity, String itemCategory,String itemPurchaseDate,String itemImagePath){
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemBrand = itemBrand;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemCategory = itemCategory;
        this.itemPurchaseDate = itemPurchaseDate;
        this.itemImagePath = itemImagePath;
    }
}
