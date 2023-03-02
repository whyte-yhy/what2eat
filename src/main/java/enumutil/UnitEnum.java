package enumutil;

public enum UnitEnum {
    mg("毫克"), g("克"), kg("千克");

    private String weightUnit;

    UnitEnum(String weight) {
        this.weightUnit = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }
}
