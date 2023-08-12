package com.example.programming_cw_sem2;

public final class Dealer {
    //Private variables
    private String dealerID;
    private String dealerFirstName;
    private String dealerLastName;
    private String dealerLocation;
    private String dealerContactNo;
    private String dealerItem;

    //Default constructor
    public Dealer(){}

    //Parametarised constructors
    public Dealer(String dealerID, String dealerFirstName, String dealerLastName, String dealerLocation, String dealerContactNo) {
        this.dealerID = dealerID;
        this.dealerFirstName = dealerFirstName;
        this.dealerLastName = dealerLastName;
        this.dealerLocation = dealerLocation;
        this.dealerContactNo = dealerContactNo;
    }

    public Dealer(String dealerID, String dealerFirstName, String dealerItem) {
        this.dealerID = dealerID;
        this.dealerFirstName = dealerFirstName;
        this.dealerItem = dealerItem;
    }

    //Getters and setters
    public String getDealerID() {
        return dealerID;
    }

    public String getDealerFirstName() {
        return dealerFirstName;
    }

    public String getDealerLastName() {
        return dealerLastName;
    }

    public String getDealerLocation() {
        return dealerLocation;
    }

    public String getDealerContactNo() {
        return dealerContactNo;
    }
    public String getDealerItem() {
        return dealerItem;
    }
}
