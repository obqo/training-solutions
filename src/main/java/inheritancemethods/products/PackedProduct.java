package inheritancemethods.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PackedProduct extends Product{

    private int packingUnit;
    private BigDecimal weightOfBox;

    public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }

    public BigDecimal totalWeight(int pieces) {
        int boxes = pieces % packingUnit == 0 ? pieces / packingUnit : pieces / packingUnit + 1;
        BigDecimal boxesWeight = weightOfBox.multiply(new BigDecimal(String.valueOf(boxes)));
        return super.totalWeight(pieces).add(boxesWeight).setScale(getNumberOfDecimals(), RoundingMode.HALF_UP);
    }
}
