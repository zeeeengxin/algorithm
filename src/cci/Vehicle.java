package cci;

public abstract class Vehicle {
    protected int spotsNeeded;
    protected VehicleSize size;

    public VehicleSize getSize() {
        return size;
    }
    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    //A subclass does not inherit the private members of its parent class
}
