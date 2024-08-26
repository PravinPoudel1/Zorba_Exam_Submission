package org.example.XMLBasedDI.ConstructorDIXmlBased;

public class RentOfFlat {
    private RentOfOneBHKFlat rentOfOneBHKFlat;
    private  RentOfTwoBHKFlat rentOfTwoBHKFlat;
    private RentOfThreeBHKFlat rentOfThreeBHKFlat;

    public RentOfFlat(RentOfOneBHKFlat rentOfOneBHKFlat, RentOfTwoBHKFlat rentOfTwoBHKFlat, RentOfThreeBHKFlat rentOfThreeBHKFlat) {
        this.rentOfOneBHKFlat = rentOfOneBHKFlat;
        this.rentOfTwoBHKFlat = rentOfTwoBHKFlat;
        this.rentOfThreeBHKFlat = rentOfThreeBHKFlat;
     }
    public void printRentDetails(int noOfPerson) {
        System.out.println("Rent of One BHK flat is -> " + rentOfOneBHKFlat.calculateRentOfFlat(noOfPerson));
        System.out.println("Rent of Two BHK flat is -> " + rentOfTwoBHKFlat.calculateRentOfFlat(noOfPerson));
        System.out.println("Rent of Three BHK flat is -> " + rentOfThreeBHKFlat.calculateRentOfFlat(noOfPerson));
    }


}
