package isahasa.fleet;

public class CanCarryGoodsBehaviour implements CanCarryGoods{

    private int cargoWeight;
    private final int maxCargoWeight;

    public CanCarryGoodsBehaviour(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }



    @Override
    public int loadCargo(int cargoWeight) {
        this.cargoWeight = (cargoWeight < maxCargoWeight) ? cargoWeight : maxCargoWeight;
        if (cargoWeight < maxCargoWeight) return 0;
        return cargoWeight - maxCargoWeight;
    }

    @Override
    public int getCargoWeight() {
        return cargoWeight;
    }
}
