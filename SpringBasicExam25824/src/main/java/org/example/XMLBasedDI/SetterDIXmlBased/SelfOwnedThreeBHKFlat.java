package org.example.XMLBasedDI.SetterDIXmlBased;

public class SelfOwnedThreeBHKFlat {
    public float calculatePlot(float length, float breadth, float height){
        return length * breadth * height;

    }

    public double finalPriceOfFlat(float length, float breadth, float height){
        return 50000 * calculatePlot(length,breadth,height);
    }


}
