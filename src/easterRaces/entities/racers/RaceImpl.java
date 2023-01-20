package easterRaces.entities.racers;

import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static easterRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race {

    private String name;
    private int laps;
    private ArrayList<Driver> drivers = new ArrayList<>();

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
    }

    public void setName(String name) {

        if (name.trim().isEmpty() || name == null || name.length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }

        this.name = name;
    }

    public void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS, 1));
        }
        this.laps = laps;
    }

    public String getName() {
        return this.name;
    }

    public int getLaps() {
        return this.laps;
    }


    public Collection<Driver> getDrivers() {
        return this.drivers;
    }


    public void addDriver(Driver driver) {

        if (driver == null) {
            throw new IllegalArgumentException(DRIVER_INVALID);
        }
        if (!driver.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE, driver.getName()));
        }
        if (this.getDrivers().contains(driver)) {
            throw new IllegalArgumentException(String.format(DRIVER_ALREADY_ADDED, driver.getName(), this.getName()));
        }
        this.getDrivers().add(driver);
    }

}
