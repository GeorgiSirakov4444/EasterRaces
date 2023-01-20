package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static easterRaces.common.ExceptionMessages.CAR_INVALID;

public class CarRepository implements Repository<Car> {

    private ArrayList<Car> Models = new ArrayList<>();

    @Override
    public Car getByName(String name) {
        for (Car car :
                this.Models) {
            if (car.getModel().equals(name)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Car> getAll() {
        return this.Models;
    }

    public void add(Car model) {

        if (model == null) {
            throw new IllegalArgumentException(CAR_INVALID);
        }

        this.getAll().add(model);
    }

    public boolean remove(Car model) {

        if (this.getAll().contains(model)) {
            this.getAll().remove(model);
            return true;
        }

        return false;
    }
}
