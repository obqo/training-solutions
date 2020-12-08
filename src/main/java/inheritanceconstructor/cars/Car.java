package inheritanceconstructor.cars;

public class Car {

    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if (fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public double getFuel() {
        return fuel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void modifyFuelAmount(double fuel) {
        this.fuel += fuel;
    }

    public void drive(int km) { // csökkenti az üzemanyag mennyiségét, nem fogyhat ki!
        double consum = km * fuelRate / 100;
        if (consum > fuel) {
            throw new RuntimeException("Not enough fuel available!");
        }
        this.fuel -= consum;
    }
    public double calculateRefillAmount() { //kiszámolja, mennyit lehet tankolni
        return tankCapacity - fuel;
    }
}
