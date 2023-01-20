package easterRaces.entities.drivers;

import easterRaces.entities.cars.Car;

import static easterRaces.common.ExceptionMessages.CAR_INVALID;
import static easterRaces.common.ExceptionMessages.INVALID_NAME;

public class DriverImpl implements Driver {

    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate = false;

    public DriverImpl(String name) {
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    public Car getCar() {
        return this.car;
    }


    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(CAR_INVALID);
        }
        this.setCar(car);
        this.setCanParticipate(true);
    }


    public void winRace() {
        this.numberOfWins += 1;
    }

    public boolean getCanParticipate() {
        return this.canParticipate;
    }

    public void setCanParticipate(boolean canParticipate) {
        this.canParticipate = canParticipate;
    }

    public void setName(String name) {

        if (name.equals("") || name == null || name.length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name,5));
        }

        this.name = name;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

}
