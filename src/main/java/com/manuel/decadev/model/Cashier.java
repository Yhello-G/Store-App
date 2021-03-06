package com.manuel.decadev.model;


import com.manuel.decadev.model.Interface.IPrint;
import com.manuel.decadev.model.ProductCataloque.Biscuit;

public class Cashier extends  Staff implements IPrint <Item>{

    final private short weeklyHour = 70;
    private static short allowableAbsentTimes = 2;
    private int workExperience = 0;

    public Cashier(String firstName, String lastName, String department, String role, String gender, int compId) {
        super(firstName,lastName, gender, department, role, compId);

    }

    public void sellProduct (Customer customer, String productName){
        // TODO
        // Implement the logic of cashier withdrawing money from customer's account
        // and removing product from catalogue

        Biscuit selectedProduct = customer.handleProductSelection(productName);

    }

    public void receiveProductPayment( Customer customer, String product ){

        Biscuit item = customer.handleProductSelection(product);
       Item biscuit = customer.purchaseProduct("Biscuit", item.getProductNAme());
        if (customer.makePayment(biscuit)){
                print(biscuit);
        }
    }

    @Override
    public void print(Item item){
        String desc = item.price + " " + item.manufacturer;
        System.out.println("Cashier Printing Receipt for Customer");
        System.out.println("________________________________________________________");
        System.out.println("Customer Bought a Product");
        System.out.println(desc);
    }

    @Override
    public void stateGender(String gender){
        setGender(gender);
    }

    @Override
    public boolean canWorkOverTime(){

        return true;
    }

    public void setAllowableAbsentTimes(short allowableAbsentTimes) {
        this.allowableAbsentTimes = allowableAbsentTimes;
    }

    public short getWeeklyHour() {
        return weeklyHour;
    }

    public short getAllowableAbsentTimes() {
        return allowableAbsentTimes;
    }

    @Override
    public String getRole() {
        return super.getRole();
    }

    public void resetCashierData(String resetFirst,
                                 String resetLastName, int resetId){
       super.setId(resetId);
       this.setFirstName(resetFirst);
       this.setLastName(resetLastName);

    }

    @Override
    public boolean isBonafideStaff(Staff staff){
        Cashier cashier = (Cashier) staff;
        return cashier.getId() == 0 &&
                (cashier.getFirstName().equals("")) && cashier.getLastName().equals("");
    }

    public int setWorkExperience(int years){
        return this.workExperience = years;
    }


    public int retrieveWorkExperience() {
        return workExperience;
    }
}
