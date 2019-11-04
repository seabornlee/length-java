public class Length {
    private final double value;
    private final Units unit;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = Units.valueOf(unit.toUpperCase());
    }

    public Length as(String unit) {
        Length length = this;
        Units targetUnit = Units.valueOf(unit.toUpperCase());
        if (this.unit == Units.F) {
            if (targetUnit == Units.YARD) {
                length = new Length(this.value / 3, unit);
            } else if (targetUnit == Units.INCH) {
                length = new Length(this.value * 12, unit);
            }
        }

        if (this.unit == Units.YARD) {
            if (targetUnit == Units.INCH) {
                length = new Length(this.value * 36, unit);
            } else if (targetUnit == Units.F){
                length = new Length(this.value * 3, unit);
            }
        }

        if (this.unit == Units.INCH) {
            if (targetUnit == Units.F) {
                length = new Length(this.value / 12, unit);
            } else if (targetUnit == Units.YARD) {
                length = new Length(this.value / 36, unit);
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
