public class Length {
    private final double value;
    private final Units unit;

    public Length(double value, Units unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Units targetUnit) {
        double value = calculateValue(targetUnit);
        return new Length(value, targetUnit);
    }

    private double calculateValue(Units targetUnit) {
        if (this.unit == Units.FOOT) {
            if (targetUnit == Units.YARD) {
                return this.value / 3;
            }

            if (targetUnit == Units.INCH) {
                return this.value * 12;
            }
        }

        if (this.unit == Units.YARD) {
            if (targetUnit == Units.INCH) {
                return this.value * 36;
            }

            if (targetUnit == Units.FOOT){
                return this.value * 3;
            }
        }

        if (this.unit == Units.INCH) {
            if (targetUnit == Units.FOOT) {
                return this.value / 12;
            }

            if (targetUnit == Units.YARD) {
                return this.value / 36;
            }
        }

        return this.value;
    }

    public double getValue() {
        return this.value;
    }

    public Units getUnit() {
        return this.unit;
    }
}
