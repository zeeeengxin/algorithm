package cci;
import java.util.HashMap;
import java.util.Map;

public class Level {
    private ParkingSpot[] spots;
    private int emptySpots;
    private static final Integer SPOTS_PER_ROW = 10;
    int numBus;
    int numBike;
    int numCar;
    Map<Vehicle, Integer> parkingMap;

    Level(int totalNumSpots) {
        initSpots(totalNumSpots);
        emptySpots = totalNumSpots;
        parkingMap = new HashMap<>();
    }
    private void initSpots(int n) {
        spots = new ParkingSpot[n];
        numBus = n / 4;
        numBike = n / 4;
        numCar = n - numBike - numBus;
        for(int i = 0; i < n; i++) {
            if (i < numBus) {
                spots[i] = new ParkingSpot(VehicleSize.Large);
            } else if (i < numBus + numBike) {
                spots[i] = new ParkingSpot(VehicleSize.Motorcycle);
            } else {
                spots[i] = new ParkingSpot(VehicleSize.Compact);
            }
        }
    }

    boolean isFull() {
        return emptySpots == 0;
    }

    Integer park(Vehicle v) {
        if (emptySpots < v.getSpotsNeeded()) {
            return null;
        }
        int spotNumber = findAvailableSpot(v);
        if (spotNumber < 0) {
            return null;
        }
        parkStartingAtSpot(spotNumber, v);
        return spotNumber;
    }
    private int findAvailableSpot(Vehicle v) {
        int startIndex = getStartIndexFitSize(v.getSize());
        int endIndex = getEndIndexFitSize(v.getSize());
        for (int i = startIndex; i < endIndex; i++) {
            if (canParkAt(i, v)) {
                return i;
            }
        }
        return -1;
    }
    private boolean canParkAt(int index, Vehicle v) {
        int spotsNeeded = v.getSpotsNeeded();
        if ((index + spotsNeeded - 1)/10 != index / 10) { // not in same row
            return false;
        }
        for (int i = 0; i < spotsNeeded; i++) {
            if (!spots[index + i].isAvailable()) {
                return false;
            }
        }
        return true;
    }
    private int getEndIndexFitSize(VehicleSize size) {
        if (size == VehicleSize.Large) {
           return numBus - 1;
        }
        return spots.length - 1;
    }
    private int getStartIndexFitSize(VehicleSize size) {
        switch (size) {
            case Large:
                return 0;
            case Motorcycle:
                return numBus;
            case Compact:
                return numBus + numBike;
        }
        return -1;
    }
    private void parkStartingAtSpot(int spotNumber, Vehicle v) {
        int spotsNeeded = v.getSpotsNeeded();
        for (int i = 0; i < spotsNeeded; i++) {
            spots[spotNumber + i].park(v);
        }
        emptySpots -= spotsNeeded;
        parkingMap.put(v, spotNumber);
    }

    Integer leave(Vehicle v) {
        Integer spotNumber = parkingMap.get(v);
        if (spotNumber == null) {
            return null;
        }
        parkingMap.remove(v);
        clearSpots(spotNumber, v);
        return spotNumber;
    }
    private void clearSpots(int spotNumber, Vehicle v) {
        int spotsNeeded = v.getSpotsNeeded();
        for (int i = 0; i < spotsNeeded; i++) {
            spots[i + spotNumber].leave();
        }
        emptySpots += spotsNeeded;
    }
}
