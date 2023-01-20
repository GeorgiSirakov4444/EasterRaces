package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.racers.Race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static easterRaces.common.ExceptionMessages.RACE_INVALID;

public class RaceRepository implements Repository<Race>{

    private ArrayList<Race> models = new ArrayList<>();

    @Override
    public Race getByName(String name) {

        for (Race race :
                this.models) {
            if (race.getName().equals(name)) {
                return race;
            }
        }

        return null;
    }

    @Override
    public ArrayList<Race> getAll() {
        return this.models;
    }

    public void add(Race model) {
        if (model == null) {
            throw new IllegalArgumentException(RACE_INVALID);
        }

        this.getAll().add(model);
    }

    public boolean remove(Race model) {

        if (this.getAll().contains(model)) {
            this.getAll().remove(model);
            return true;
        }

        return false;
    }


}
