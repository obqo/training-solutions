package inheritanceconstructor.cars;

public class Jeep extends Car{

    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    public void drive(int km) { // csökkenti az üzemanyag mennyiségét, nem fogyhat ki!
        double consum = km * super. getFuelRate() / 100;
        if (consum > (super.getFuel() + extraFuel)) {
            throw new RuntimeException("Not enough fuel available!");
        }
        extraFuel -= consum;
        if (extraFuel < 0) {
            modifyFuelAmount(extraFuel);
            extraFuel = 0;
        }
    }

    public double calculateRefillAmount() { //kiszámolja, mennyit lehet tankolni
        return extraCapacity + super.getTankCapacity() - super.getFuel() - extraFuel;
    }
}
