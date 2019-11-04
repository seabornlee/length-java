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
        double value = this.value;
        if (this.unit == Units.FOOT) {
            if (targetUnit == Units.YARD) {
                return this.value / 3;
            } else if (targetUnit == Units.INCH) {
                return this.value * 12;
            }
        }

        if (this.unit == Units.YARD) {
            if (targetUnit == Units.INCH) {
                return this.value * 36;
            } else if (targetUnit == Units.FOOT){
                return this.value * 3;
            }
        }

        if (this.unit == Units.INCH) {
            if (targetUnit == Units.FOOT) {
                return this.value / 12;
            } else if (targetUnit == Units.YARD) {
                return this.value / 36;
            }
        }
        return value;
    }

    public double getValue() {
        return this.value;
    }

    public Units getUnit() {
        return this.unit;
    }
}
