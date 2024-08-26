package org.example.XMLBasedDI.SetterDIXmlBased;

public class SelfOwnedTwoBHKFlat {
    public float calculatePlot(float length, float breadth, float height) {
        return length * breadth * height;
    }
    public double finalPriceOfFlat(float length, float breadth, float height){
        return 30000 * calculatePlot(length,breadth,height);
    }


}
