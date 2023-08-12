package com.example.programming_cw_sem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    //ItemCode or DealerId Test
    @Test
    void itemCodeValidateText() {
        //Text value as itemCode
        String itemCode = "W";
        String itemName = "Macbook M1";
        String itemBrand = "Apple";
        String itemPrice = "300000";
        String itemQuantity = "2";
        String itemCategory = "Laptop";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "4";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemCodeValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemCodeValidationObj.itemCodeValidate();
        boolean actualOutput = itemCodeValidationObj.getValidationCheck();
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void itemCodeValidateRange() {
        //0 > value as itemCode
        String itemCode = "-1";
        String itemName = "Macbook M1";
        String itemBrand = "Apple";
        String itemPrice = "300000";
        String itemQuantity = "2";
        String itemCategory = "Laptop";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "4";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemCodeValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemCodeValidationObj.itemCodeValidate();
        boolean actualOutput = itemCodeValidationObj.getValidationCheck();
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    void itemCodeValidateValidRange() {
        //0 > value as itemCode
        String itemCode = "1";
        String itemName = "Macbook M1";
        String itemBrand = "Apple";
        String itemPrice = "300000";
        String itemQuantity = "2";
        String itemCategory = "Laptop";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "4";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemCodeValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemCodeValidationObj.itemCodeValidate();
        boolean actualOutput = itemCodeValidationObj.getValidationCheck();
        assertNotEquals(expectedOutput,actualOutput);
    }

    @Test
    void itemNameValidateInteger() {
        //Item name as an integer
        String itemCode = "1";
        String itemName = "1";
        String itemBrand = "Apple";
        String itemPrice = "300000";
        String itemQuantity = "2";
        String itemCategory = "Laptop";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "4";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemNameValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemNameValidationObj.itemNameValidate();
        boolean actualOutput = itemNameValidationObj.getValidationCheck();
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void itemNameValidateValidType() {
        //Item name as a string
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "300000";
        String itemQuantity = "2";
        String itemCategory = "Laptop";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "4";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemNameValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemNameValidationObj.itemNameValidate();
        boolean actualOutput = itemNameValidationObj.getValidationCheck();
        assertNotEquals(expectedOutput,actualOutput);
    }

    @Test
    void itemBrandValidateInteger() {
        //Item brand as an integer
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "1";
        String itemPrice = "300000";
        String itemQuantity = "2";
        String itemCategory = "Laptop";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "4";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemBrandValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemBrandValidationObj.itemBrandValidate();
        boolean actualOutput = itemBrandValidationObj.getValidationCheck();
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void itemBrandValidateValidType() {
        //Item brand as an string
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "300000";
        String itemQuantity = "2";
        String itemCategory = "Laptop";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "4";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemBrandValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemBrandValidationObj.itemBrandValidate();
        boolean actualOutput = itemBrandValidationObj.getValidationCheck();
        assertNotEquals(expectedOutput,actualOutput);
    }

    @Test
    void itemPriceValidateRange() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "-1";
        String itemQuantity = "2";
        String itemCategory = "Laptop";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "4";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemPriceValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemPriceValidationObj.itemPriceValidate();
        boolean actualOutput = itemPriceValidationObj.getValidationCheck();
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void itemPriceValidateText() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "Hi";
        String itemQuantity = "2";
        String itemCategory = "Laptop";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "4";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemPriceValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemPriceValidationObj.itemPriceValidate();
        boolean actualOutput = itemPriceValidationObj.getValidationCheck();
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    void itemPriceValidateValidType() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "2";
        String itemCategory = "Laptop";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "4";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemPriceValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemPriceValidationObj.itemPriceValidate();
        boolean actualOutput = itemPriceValidationObj.getValidationCheck();
        assertNotEquals(expectedOutput,actualOutput);
    }

    @Test
    void itemQuantityValidateRange() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "-2";
        String itemCategory = "Laptop";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "4";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemQuantityValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemQuantityValidationObj.itemQuantityValidate();
        boolean actualOutput = itemQuantityValidationObj.getValidationCheck();
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void itemQuantityValidateDataType() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "Hi";
        String itemCategory = "Laptop";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "4";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemQuantityValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemQuantityValidationObj.itemQuantityValidate();
        boolean actualOutput = itemQuantityValidationObj.getValidationCheck();
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    void itemQuantityValidateValid() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "2";
        String itemCategory = "Laptop";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "4";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemQuantityValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemQuantityValidationObj.itemQuantityValidate();
        boolean actualOutput = itemQuantityValidationObj.getValidationCheck();
        assertNotEquals(expectedOutput,actualOutput);
    }

    @Test
    void itemCategoryValidateDataType() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "2";
        String itemCategory = "2";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "4";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemCategoryValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemCategoryValidationObj.itemCategoryValidate();
        boolean actualOutput = itemCategoryValidationObj.getValidationCheck();
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    void itemCategoryValidateValid() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "2";
        String itemCategory = "Laptop";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "4";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemCategoryValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemCategoryValidationObj.itemCategoryValidate();
        boolean actualOutput = itemCategoryValidationObj.getValidationCheck();
        assertNotEquals(expectedOutput,actualOutput);
    }

    @Test
    void itemPurchaseDateValidateDataType1() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "2";
        String itemCategory = "2";
        String itemPurchaseYear = "Hi";
        String itemPurchaseMonth = "4";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemPurchaseDateValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemPurchaseDateValidationObj.itemPurchaseDateValidate();
        boolean actualOutput = itemPurchaseDateValidationObj.getValidationCheckYear();
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    void itemPurchaseDateValidateDataType2() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "2";
        String itemCategory = "2";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "Hi";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemPurchaseDateValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemPurchaseDateValidationObj.itemPurchaseDateValidate();
        boolean actualOutput = itemPurchaseDateValidationObj.getValidationCheckMonth();
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    void itemPurchaseDateValidateDataType3() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "2";
        String itemCategory = "2";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "2";
        String itemPurchaseDay = "Hi";
        boolean expectedOutput = false;
        Validator itemPurchaseDateValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemPurchaseDateValidationObj.itemPurchaseDateValidate();
        boolean actualOutput = itemPurchaseDateValidationObj.getValidationCheckDay();
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    void itemPurchaseDateValidateRange1() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "2";
        String itemCategory = "2";
        String itemPurchaseYear = "1999";
        String itemPurchaseMonth = "2";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemPurchaseDateValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemPurchaseDateValidationObj.itemPurchaseDateValidate();
        boolean actualOutput = itemPurchaseDateValidationObj.getValidationCheckYear();
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    void itemPurchaseDateValidateRange2() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "2";
        String itemCategory = "2";
        String itemPurchaseYear = "2500";
        String itemPurchaseMonth = "2";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemPurchaseDateValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemPurchaseDateValidationObj.itemPurchaseDateValidate();
        boolean actualOutput = itemPurchaseDateValidationObj.getValidationCheckYear();
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    void itemPurchaseDateValidateRange3() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "2";
        String itemCategory = "2";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "20";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemPurchaseDateValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemPurchaseDateValidationObj.itemPurchaseDateValidate();
        boolean actualOutput = itemPurchaseDateValidationObj.getValidationCheckMonth();
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    void itemPurchaseDateValidateRange4() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "2";
        String itemCategory = "2";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "-1";
        String itemPurchaseDay = "1";
        boolean expectedOutput = false;
        Validator itemPurchaseDateValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemPurchaseDateValidationObj.itemPurchaseDateValidate();
        boolean actualOutput = itemPurchaseDateValidationObj.getValidationCheckMonth();
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    void itemPurchaseDateValidateRange5() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "2";
        String itemCategory = "2";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "5";
        String itemPurchaseDay = "-1";
        boolean expectedOutput = false;
        Validator itemPurchaseDateValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemPurchaseDateValidationObj.itemPurchaseDateValidate();
        boolean actualOutput = itemPurchaseDateValidationObj.getValidationCheckDay();
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    void itemPurchaseDateValidateRange6() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "2";
        String itemCategory = "2";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "5";
        String itemPurchaseDay = "32";
        boolean expectedOutput = false;
        Validator itemPurchaseDateValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemPurchaseDateValidationObj.itemPurchaseDateValidate();
        boolean actualOutput = itemPurchaseDateValidationObj.getValidationCheckDay();
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    void itemPurchaseDateValidateValid1() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "2";
        String itemCategory = "2";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "5";
        String itemPurchaseDay = "13";
        boolean expectedOutput = false;
        Validator itemPurchaseDateValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemPurchaseDateValidationObj.itemPurchaseDateValidate();
        boolean actualOutput = itemPurchaseDateValidationObj.getValidationCheckYear();
        assertNotEquals(expectedOutput,actualOutput);
    }
    @Test
    void itemPurchaseDateValidateValid2() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "2";
        String itemCategory = "2";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "5";
        String itemPurchaseDay = "13";
        boolean expectedOutput = false;
        Validator itemPurchaseDateValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemPurchaseDateValidationObj.itemPurchaseDateValidate();
        boolean actualOutput = itemPurchaseDateValidationObj.getValidationCheckMonth();
        assertNotEquals(expectedOutput,actualOutput);
    }
    @Test
    void itemPurchaseDateValidateValid3() {
        String itemCode = "1";
        String itemName = "Macbook M2";
        String itemBrand = "Apple";
        String itemPrice = "40000.50";
        String itemQuantity = "2";
        String itemCategory = "2";
        String itemPurchaseYear = "2025";
        String itemPurchaseMonth = "5";
        String itemPurchaseDay = "13";
        boolean expectedOutput = false;
        Validator itemPurchaseDateValidationObj = new Validator(itemCode,itemName,itemBrand,itemPrice,itemQuantity,itemCategory,itemPurchaseYear,itemPurchaseMonth,itemPurchaseDay);
        itemPurchaseDateValidationObj.itemPurchaseDateValidate();
        boolean actualOutput = itemPurchaseDateValidationObj.getValidationCheckDay();
        assertNotEquals(expectedOutput,actualOutput);
    }
}