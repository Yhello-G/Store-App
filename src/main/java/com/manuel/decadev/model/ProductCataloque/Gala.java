package com.manuel.decadev.model.ProductCataloque;

import com.manuel.decadev.model.Item;

public class Gala extends Item {


    private String productNAme;
    private int serialNo;
    private String manufacturer;
    private int expiryDate = 0;
    private static int purchaseCount = 0;


    public Gala(String productNAme,int price, String manufacturer,
                 String productCategory, int manufacturingDate
                 , int serialNo ){

        super(price, manufacturer, manufacturingDate, productCategory);

        this.productNAme = productNAme;
        this.serialNo = serialNo;
        this.manufacturer = manufacturer;

        purchaseCount += 1;

    }

    public  boolean hasPositiveBrandReview(){

        return true;
    };

    public  int checkExpiry(Item p){

        return 0;
    }

    public void setPrice(int price){

        super.price = price;
    }

}
