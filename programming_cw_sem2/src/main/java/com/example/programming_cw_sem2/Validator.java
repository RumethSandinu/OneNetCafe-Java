package com.example.programming_cw_sem2;

public class Validator extends CafeController{
    //Globle variabloes
    private static String ItemCode;
    private static String ItemName;
    private static String ItemBrand;
    private static String ItemPrice;
    private static String ItemQuantity;
    private static String ItemCategory;
    private static String ItemPurchaseYear;
    private static String ItemPurchaseMonth;
    private static String ItemPurchaseDay;
    private int validatepoints;
    private static boolean imageValidationCheck;
    private boolean itemCodeMatch;
    private boolean validationCheck;
    private boolean validationCheckYear;
    private boolean validationCheckMonth;
    private boolean validationCheckDay;
    private int itemPurchaseYearInt;
    private int itemPurchaseMonthInt;
    private static String itemImagePath;

    //Files used to store data
    protected static final String itemsFile = "Items.txt";
    protected static final String dealersFile = "Dealers.txt";
    protected static final String tempItemsFile = "TempItems.txt";

    //Arrays that used to store data
    protected static String[] itemRecord = new String[10];
    protected static String[][] dealerRecord;
    protected static String[] dealersArray = new String[72];
    protected static String[][] selectedDealers = new String[4][6];

    //default constructor
    public Validator(){}

    //Parametarised constructors
    public Validator(String ItemCode){
        Validator.ItemCode = ItemCode;
    }
    public Validator(String ItemCode,String ItemName,String ItemBrand,String ItemPrice,String ItemQuantity,String ItemCategory,String ItemPurchaseYear,String ItemPurchaseMonth,String ItemPurchaseDay){
        Validator.ItemCode = ItemCode;
        Validator.ItemName = ItemName;
        Validator.ItemBrand = ItemBrand;
        Validator.ItemPrice = ItemPrice;
        Validator.ItemQuantity = ItemQuantity;
        Validator.ItemCategory = ItemCategory;
        Validator.ItemPurchaseYear = ItemPurchaseYear;
        Validator.ItemPurchaseMonth = ItemPurchaseMonth;
        Validator.ItemPurchaseDay = ItemPurchaseDay;
    }
    public Validator(String ItemName,String ItemBrand,String ItemPrice,String ItemQuantity,String ItemCategory,String ItemPurchaseYear,String ItemPurchaseMonth,String ItemPurchaseDay){
        Validator.ItemName = ItemName;
        Validator.ItemBrand = ItemBrand;
        Validator.ItemPrice = ItemPrice;
        Validator.ItemQuantity = ItemQuantity;
        Validator.ItemCategory = ItemCategory;
        Validator.ItemPurchaseYear = ItemPurchaseYear;
        Validator.ItemPurchaseMonth = ItemPurchaseMonth;
        Validator.ItemPurchaseDay = ItemPurchaseDay;
    }

    //Getters and setters
    public static String getItemCode(){
        return ItemCode;
    }
    public static void setItemCode(String ItemCode){
        Validator.ItemCode = ItemCode;
    }
    public static String getItemName(){
        return ItemName;
    }
    public static void setItemName(String ItemName) {
        Validator.ItemName = ItemName;
    }
    public static void setItemBrand(String ItemBrand) {
        Validator.ItemBrand = ItemBrand;
    }
    public static void setItemPrice(String ItemPrice) {
        Validator.ItemPrice = ItemPrice;
    }
    public static void setItemQuantity(String ItemQuantity) {
        Validator.ItemQuantity = ItemQuantity;
    }
    public static void setItemCategory(String ItemCategory) {
        Validator.ItemCategory = ItemCategory;
    }
    public static void setItemPurchaseYear(String ItemPurchaseYear) {
        Validator.ItemPurchaseYear = ItemPurchaseYear;
    }
    public static void setItemPurchaseMonth(String ItemPurchaseMonth) {Validator.ItemPurchaseMonth = ItemPurchaseMonth;}
    public static void setItemPurchaseDay(String ItemPurchaseDay) {
        Validator.ItemPurchaseDay = ItemPurchaseDay;
    }
    public static String getItemBrand(){
        return ItemBrand;
    }
    public static String getItemPrice(){
        return ItemPrice;
    }
    public static String getItemQuantity(){
        return ItemQuantity;
    }
    public static String getItemCategory(){
        return ItemCategory;
    }
    public static String getItemPurchaseYear(){
        return ItemPurchaseYear;
    }
    public static String getItemPurchaseMonth(){
        return ItemPurchaseMonth;
    }
    public static String getItemPurchaseDay(){
        return ItemPurchaseDay;
    }
    public int getValidatepoints(){
        return validatepoints;
    }
    public void setValidatepoints(int validatepoints){
        this.validatepoints = validatepoints;
    }
    public boolean getItemCodeMatch(){
        return itemCodeMatch;
    }
    public void setItemCodeMatch(boolean itemCodeMatch){
        this.itemCodeMatch = itemCodeMatch;
    }
    public static boolean getImageValidationCheck(){
        return imageValidationCheck;
    }
    public static void setImageValidationCheck(boolean imageValidationCheck){Validator.imageValidationCheck = imageValidationCheck;}
    public boolean getValidationCheck(){
        return validationCheck;
    }
    public boolean getValidationCheckYear(){return validationCheckYear;
    }
    public boolean getValidationCheckMonth(){
        return validationCheckMonth;
    }
    public boolean getValidationCheckDay() {return validationCheckDay;}
    public static String getItemImagePath() {
        return itemImagePath;
    }
    public static void setItemImagePath(String itemImagePath) {
        Validator.itemImagePath = itemImagePath;
    }

    //Validation checking methods
    //Validate item code
    public void itemCodeValidate() {
        validationCheck = false;
        validatepoints = 0;
        //If the item name is empty or space
        if (ItemCode.isEmpty() || ItemCode.equals(" ")) {
            validationCheck = false;
            System.out.println("\u001B[31mItem Code or DealerID can not be empty\u001B[39m");
        } //If the item name is nor empty and not space
        else {
            try {
                //Convert item code to double
                double itemCodeDouble = Double.parseDouble(ItemCode);
                //Convert item code to integer
                int itemCodeInt = Integer.parseInt(ItemCode);
                //If the item code does have decimals or item code is less than 0
                if(itemCodeDouble - itemCodeInt > 0 || itemCodeInt < 0){
                    System.out.println("\u001B[31mItem Code or DealerID must be an integer value and greater than -1\u001B[39m");
                }//If the item code does not have decimals or item code is greater than -1
                else {
                    validationCheck = true;
                    ItemCode = Integer.toString(itemCodeInt);
                }
            } catch (Exception e) {
                validationCheck = false;
                System.out.println("\u001B[31mItem Code or DealerID must be a integer value\u001B[39m");
            }
        }
    }

    //Validate item name
    public void itemNameValidate() {
        validationCheck = false;
        //If the item name is not empty or space
        if (ItemName.isEmpty() || ItemName.equals(" ")) {
            validationCheck = false;
            System.out.println("\u001B[31mName can not be empty\u001B[39m");
        } //If the item name is not empty and not space
        else {
            try {
                //Convert item name to double
                double itemNameDouble = Double.parseDouble(ItemName);
                validationCheck = false;
                System.out.println("\u001B[31mName must be a string value\u001B[39m");
            } catch (Exception e) {
                validationCheck = true;
            }
        }
    }

    //Validate item brand
    public void itemBrandValidate() {
        validationCheck = false;
        //If the item brand is empty or space
        if (ItemBrand.isEmpty() || ItemBrand.equals(" ")){
            validationCheck = false;
            System.out.println("\u001B[31mBrand can not be empty\u001B[39m");
        }//If the item brand is not empty and not space
        else {
            try {
                //Convert item brand to double
                double itemBrandDouble = Double.parseDouble(ItemBrand);
                validationCheck = false;
                System.out.println("\u001B[31mName must be a string value\u001B[39m");
            } catch (Exception e) {
                validationCheck = true;
            }
        }
    }

    //Validate item price
    public void itemPriceValidate() {
        validationCheck = false;
        //If the item price is empty or space
        if (ItemPrice.isEmpty() || ItemPrice.equals(" ")) {
            validationCheck = false;
            System.out.println("\u001B[31mPrice can not be empty\u001B[39m");
        } //If the item price is not empty and not space
        else {
            try {
                //Convert item price to double
                double priceDouble = Double.parseDouble(ItemPrice);
                //Convert double price to integer
                int aidPriceInt = (int) priceDouble;
                //If the decimal points of double price greater than 0.6 or integer price is less than 0
                if ((priceDouble - aidPriceInt) >= 0.6 || aidPriceInt < 0) {
                    validationCheck = false;
                    System.out.println("\u001B[31mPrice must be greater than 0 and cents must be less than .60\u001B[39m");
                } //If the decimal points of double price less than or eual 0.6 and integer price is greater than -1
                else {
                    validationCheck = true;
                }
            } catch (Exception e) {
                validationCheck = false;
                System.out.println("\u001B[31mPrice must be an integer or double value\u001B[39m");
            }
        }
    }

    //Validate item quantity
    public void itemQuantityValidate() {
        validationCheck = false;
        //If the item quantity is empty or space
        if (ItemQuantity.isEmpty() || ItemQuantity.equals(" ")) {
            validationCheck = false;
            System.out.println("\u001B[31mQuantity can not be empty\u001B[39m");
        }//If the item quantity is not empty and not space
        else {
            try {
                //Convert item quantity to double
                double itemQuantityDouble = Double.parseDouble(ItemQuantity);
                //Convert item quantity to imteger
                int itemQuantityInt = Integer.parseInt(ItemQuantity);
                //If double qantity has decimal points or int quantity is less than 1
                if ((itemQuantityDouble - itemQuantityInt) > 0 || itemQuantityDouble <= 0) {
                    validationCheck = false;
                    System.out.println("\u001B[31mQuantity must be and integer value and greater than 0\u001B[39m");
                } //If double qantity has no decimal points and int quantity is greater than 0
                else {
                    validationCheck = true;
                }
            } catch (Exception e) {
                validationCheck = false;
                System.out.println("\u001B[31mQuantity must be an integer value\u001B[39m");
            }
        }
    }

    //Validate item category
    public void itemCategoryValidate() {
        validationCheck = false;
        //If the item category is empty or space
        if (ItemCategory.isEmpty() || ItemCategory.equals(" ")) {
            validationCheck = false;
            System.out.println("\u001B[31mCategory can not be empty\u001B[39m");
        } //If the item category is not empty and not space
        else {
            try {
                //Convert item category to double
                double itemCategoryDouble = Double.parseDouble(ItemCategory);
                validationCheck = false;
                System.out.println("\u001B[31mCategory must be a string value\u001B[39m");
            } catch (Exception e) {
                validationCheck = true;
            }
        }
    }

    //Validate item purchase date
    public void itemPurchaseDateValidate() {
        validationCheckYear = false;
        validationCheckMonth = false;
        validationCheckDay = false;
        //If the item purchase year if empty or space
        if (ItemPurchaseYear.isEmpty() || ItemPurchaseYear.equals(" ")) {
            validationCheckYear = false;
            System.out.println("\u001B[31mYear can not be empty\u001B[39m");
        } //If the item purchase year if not empty and not space
        else {
            try {
                //Convert item purchase year to integer
                itemPurchaseYearInt = Integer.parseInt(ItemPurchaseYear);
                //If item purchase year greater than 2021 and less than 2031
                if (itemPurchaseYearInt >= 2022 && itemPurchaseYearInt < 2031) {
                    validationCheckYear = true;
                    //If item purchase month is not empty and not space
                    if (!ItemPurchaseMonth.isEmpty() || !ItemPurchaseMonth.equals(" ")) {
                        try {
                            //Convert item purchase moth to integer
                            itemPurchaseMonthInt = Integer.parseInt(ItemPurchaseMonth);
                            //If the month is greater than 0 and less than 13
                            if (itemPurchaseMonthInt >= 1 && itemPurchaseMonthInt <= 12) {
                                validationCheckMonth = true;
                                //If the item purchase day is not empty and not space
                                if (!ItemPurchaseDay.isEmpty() || !ItemPurchaseDay.equals(" ")) {
                                    try {
                                        //Convert item purchase day to integer
                                        int itemPurchaseDayInt = Integer.parseInt(ItemPurchaseDay);
                                        //Check the day ranges
                                        if (itemPurchaseYearInt % 4 == 0) {
                                            if (itemPurchaseMonthInt == 2) {
                                                if(itemPurchaseDayInt > 0 && itemPurchaseDayInt < 30){
                                                validationCheckDay = true;
                                                }
                                            }
                                        } else {
                                            if (itemPurchaseMonthInt == 2) {
                                                if(itemPurchaseDayInt > 0 && itemPurchaseDayInt < 29){
                                                    validationCheckDay = true;
                                                }
                                            }
                                        }
                                        if (itemPurchaseMonthInt == 1 || itemPurchaseMonthInt == 3 || itemPurchaseMonthInt == 5 || itemPurchaseMonthInt == 7 || itemPurchaseMonthInt == 8 || itemPurchaseMonthInt == 10 || itemPurchaseMonthInt == 12) {
                                            if(validationCheckDay = itemPurchaseDayInt > 0 && itemPurchaseDayInt < 32){
                                                validationCheckDay = true;
                                            }
                                        } else if (itemPurchaseMonthInt == 4 || itemPurchaseMonthInt == 6 || itemPurchaseMonthInt == 9 || itemPurchaseMonthInt == 11) {
                                            if(validationCheckDay = itemPurchaseDayInt > 0 && itemPurchaseDayInt < 31){
                                                validationCheckDay = true;
                                            }
                                        }
                                    } catch (NumberFormatException ed) {
                                        validationCheckDay = false;
                                    }
                                }//If the item purchase day is empty or space
                                else{
                                    System.out.println("\u001B[31mDay can not be empty\u001B[39m");
                                }
                            }//If the month is less than 1 or greater than 12
                            else{
                                System.out.println("\u001B[31mMonth must be greater than 0 and less than 13\u001B[39m");
                            }
                        } catch (NumberFormatException em) {
                            validationCheckMonth = false;
                        }
                    }//If item purchase month is empty or space
                    else{
                        System.out.println("\u001B[31mMonth can not be empty\u001B[39m");
                    }
                }//If item purchase year less than 2022 or greater than 2030
                else{
                    System.out.println("\u001B[31myears less than 2022 or greater than 2030 are declined\u001B[39m");
                }
            } catch (NumberFormatException ey) {
                validationCheckYear = false;
            }
        }
    }
}
