package cci;

// assumption: multi-level; check vehicle size

public class ParkingLot {
    private Level[] levels;

    public ParkingLot(int levelNum, int spotsPerLevel) {
        levels = new Level[levelNum];
        for (int i = 0; i < levelNum; i++) {
            levels[i] = new Level(spotsPerLevel);
        }
    }
    public boolean isFull() {
        for (int i = 0; i < levels.length; i++) {
            if (!levels[i].isFull()) {
                return false;
            }
        }
        return true;
    }
    // return level and spot number for the user to find the spot
    public int[] park(Vehicle v) {
        for (int i = 0; i < levels.length; i++) {
            Integer spotNum = levels[i].park(v);
            if (spotNum != null) {
                return new int[] {i, spotNum};
            }
        }
        return null;
    }
    // return level and spot number for the user to find the vehicle
    public int[] leave(Vehicle v) {
        for (int i = 0; i < levels.length; i++) {
            Integer spotNum = levels[i].leave(v);
            if (spotNum != null) {
                return new int[] {i, spotNum};
            }
        }
        return null;
    }
}
