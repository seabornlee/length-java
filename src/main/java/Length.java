public class Length {
    private final double value;
    private final String unit;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String unit) {
        Length len = this;
        if (this.unit.equals("f")) {
            if (unit.equals("yard")) {
                len = new Length(this.value / 3, unit);
            } else if (unit.equals("inch")) {
                len = new Length(this.value * 12, unit);
            }
        }

        if (this.unit.equals("yard")) {
            if (unit.equals("inch")) {
                len = new Length(this.value * 36, unit);
            } else if (unit.equals("f")){
                len = new Length(this.value * 3, unit);
            }
        }

        if (this.unit.equals("inch")) {
            if (unit.equals("f")) {
                len = new Length(this.value / 12, unit);
            } else if (unit.equals("yard")) {
                len = new Length(this.value / 36, unit);
            }
        }

        return len;
    }

    public double getVal() {
        return this.value;
    }

    public String getUinnt() {
        return this.unit;
    }
}
