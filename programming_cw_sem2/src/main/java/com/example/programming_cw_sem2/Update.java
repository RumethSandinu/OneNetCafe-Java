package com.example.programming_cw_sem2;

public final class Update {
    //Private variables
    private String itemCode;
    private String itemName;

    //Default constructor
    public Update(){}

    //Parametarised constructor
    public Update(String itemCode,String itemName){
        this.itemCode = itemCode;
        this.itemName = itemName;
    }

    //Getters
    public String getItemCode(){
        return itemCode;
    }
    public String getItemName(){
        return itemName;
    }
}
