package org.example.XMLBasedDI.SetterDIXmlBased;

public class SelfOwnedOneBHKFlat {
    public float calculatePlot(float length, float breadth, float height){
        return length * breadth * height;

    }

    public double finalPriceOfFlat(float length, float breadth, float height){
        return 10000 * calculatePlot(length,breadth,height);
    }

}
