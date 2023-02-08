package bean;

public class RentType {
    private int rentTypeId;
    private String rentTypeName;
    private double rentTypeCost;

    public RentType() {
    }

    public RentType(int rentTypeId, String rentTypeName, double rentTypeCost) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
    }

    public RentType(int rent_type_id, String rent_type_name) {
        this.rentTypeId = rent_type_id;
        this.rentTypeName = rent_type_name;
    }

    public RentType(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public RentType(String name, double cost) {
        this.rentTypeName = name;
        this.rentTypeCost = cost;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }
}
