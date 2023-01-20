package easterRaces.repositories.interfaces;

import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;

import static easterRaces.common.ExceptionMessages.DRIVER_INVALID;

public class DriverRepository implements Repository<Driver> {

    private ArrayList<Driver> Models = new ArrayList<>();

    @Override
    public Driver getByName(String name) {

        for (Driver driver :
                this.Models) {
            if (driver.getName().equals(name)) {
                return driver;
            }
        }

        return null;
    }

    @Override
    public ArrayList<Driver> getAll() {
        return this.Models;
    }

    public void add(Driver model) {
        if (model == null) {
            throw new IllegalArgumentException(DRIVER_INVALID);
        }

        this.getAll().add(model);
    }

    public boolean remove(Driver model) {

        if (this.getAll().contains(model)) {
            this.getAll().remove(model);
            return true;
        }

        return false;
    }
}
