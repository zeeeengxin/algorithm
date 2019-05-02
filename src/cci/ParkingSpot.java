package cci;

public class ParkingSpot {
    private VehicleSize size;
    private Vehicle vehicle;

    public ParkingSpot(VehicleSize size) {
        this.size = size;
    }
    VehicleSize getSize() {
        return size;
    }
    Vehicle getVehicle() {
        return vehicle;
    }
    boolean park(Vehicle v) {
        if (this.vehicle != null) {
            return false;
        }
        this.vehicle = v;
        return true;
    }
    Vehicle leave() {
        Vehicle v = this.vehicle;
        this.vehicle = null;
        return v;
    }
    boolean isAvailable() {
        return this.vehicle == null;
    }
    public boolean canFitInSpot(Vehicle v) {
        if (!isAvailable()) {
            return false;
        }
        return v.getSize().getSize() <= this.size.getSize();
    }
}
