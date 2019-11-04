public class Length {
    private final double value;
    private final Units unit;

    public Length(double value, Units unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Units targetUnit) {
        double value = this.value;
        if (this.unit == Units.FOOT) {
            if (targetUnit == Units.YARD) {
                value = this.value / 3;
            } else if (targetUnit == Units.INCH) {
                value = this.value * 12;
            }
        }

        if (this.unit == Units.YARD) {
            if (targetUnit == Units.INCH) {
                value = this.value * 36;
            } else if (targetUnit == Units.FOOT){
                value = this.value * 3;
            }
        }

        if (this.unit == Units.INCH) {
            if (targetUnit == Units.FOOT) {
                value = this.value / 12;
            } else if (targetUnit == Units.YARD) {
                value = this.value / 36;
            }
        }

        return new Length(value, targetUnit);
    }

    public double getValue() {
        return this.value;
    }

    public Units getUnit() {
        return this.unit;
    }
}
