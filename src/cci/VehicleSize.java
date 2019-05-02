package cci;

public enum VehicleSize {
    Motorcycle(0),
    Compact(1),
    Large(2);
    private final int size;
    VehicleSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }
}
