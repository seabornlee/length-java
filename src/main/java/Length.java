public class Length {
    private final double value;
    private final Units unit;

    public Length(double value, Units unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length temp_as(Units targetUnit) {
        Length length = this;
        if (this.unit == Units.F) {
            if (targetUnit == Units.YARD) {
                length = new Length(this.value / 3, targetUnit);
            } else if (targetUnit == Units.INCH) {
                length = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit == Units.YARD) {
            if (targetUnit == Units.INCH) {
                length = new Length(this.value * 36, targetUnit);
            } else if (targetUnit == Units.F){
                length = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit == Units.INCH) {
            if (targetUnit == Units.F) {
                length = new Length(this.value / 12, targetUnit);
            } else if (targetUnit == Units.YARD) {
                length = new Length(this.value / 36, targetUnit);
            }
        }

        return length;
    }

    public double getValue() {
        return this.value;
    }

    public Units getUnit() {
        return this.unit;
    }
}
