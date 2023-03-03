package entity;

public class Person {
    String gender;
    float height;
    float weight;
    String occupation;

    float BMI;
    float standardWeight;
    String bodyType;
    String laborIntensity;

    private final static Person PERSON = new Person();

    private Person(){}

    public static Person getInstance() {
        return PERSON;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public float getBMI() {
        return BMI;
    }

    public float getStandardWeight() {
        return standardWeight;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void computeBMI() {
        BMI = (float) (weight / Math.pow((height / 100.0), 2));
    }

    public void computeStandardWeight() {
        if ("男".equals(gender)) {
            standardWeight = (float) ((height - 80) * 0.7);
        } else {
            standardWeight = (float) ((height - 70) * 0.6);
        }
    }

    public void computeBodyType() {
        bodyType = "正常";
    }

    public String getLaborIntensity() {
        return laborIntensity;
    }

    public void setLaborIntensity(String laborIntensity) {
        this.laborIntensity = laborIntensity;
    }

    public int computeEnergyCoefficient() {
        return 35;
    }
}
