package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;
import static easterRaces.common.ExceptionMessages.INVALID_MODEL;

public class MuscleCar extends BaseCar {

    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, 5000);
    }

    @Override
    public void setModel(String model) {
        if (model.length() < 4 || model.trim().isEmpty() || model == null) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL,model, 4));
        }
        this.model = model;
    }

    @Override
    public void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return super.calculateRacePoints(laps);
    }

    @Override
    public void setHorsePower(int horsePower) {
        if (horsePower < 400 || horsePower > 600) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        this.horsePower = horsePower;
    }
}
