package org.example.XMLBasedDI.SetterDIXmlBased;

public class SelfOwnedFlat {
    private SelfOwnedOneBHKFlat selfOwnedOneBHKFlat;
    private SelfOwnedTwoBHKFlat selfOwnedTwoBHKFlat;
    private SelfOwnedThreeBHKFlat selfOwnedThreeBHKFlat;

    public void setSelfOwnedOneBHKFlat(SelfOwnedOneBHKFlat selfOwnedOneBHKFlat) {
        this.selfOwnedOneBHKFlat = selfOwnedOneBHKFlat;
    }
    public void setSelfOwnedTwoBHKFlat(SelfOwnedTwoBHKFlat selfOwnedTwoBHKFlat) {
        this.selfOwnedTwoBHKFlat = selfOwnedTwoBHKFlat;
    }

    public void setSelfOwnedThreeBHKFlat(SelfOwnedThreeBHKFlat selfOwnedThreeBHKFlat) {
        this.selfOwnedThreeBHKFlat = selfOwnedThreeBHKFlat;
    }

    public void printPriceDetails(float length, float breadth, float height){
        System.out.println("Final Price of Self Owned One BHK flat is -> " + selfOwnedOneBHKFlat.finalPriceOfFlat(length, breadth, height));
        System.out.println("Final Price of Self Owned Two BHK flat is ->" + selfOwnedTwoBHKFlat.finalPriceOfFlat(length, breadth, height));
        System.out.println("Final Price of Self Owned Three BHK flat is ->" + selfOwnedThreeBHKFlat.finalPriceOfFlat(length, breadth, height));


    }





}
