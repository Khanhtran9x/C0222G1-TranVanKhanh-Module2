package _00_case_study.model;

public class House extends Facility{
    private String houseStandard;
    private int floor;

    public House(String facilityId,
                 String serviceName,
                 double useArea,
                 int rentalPrice,
                 int maxRentalPeople,
                 String rentalStyle,
                 String houseStandard,
                 int floor) {
        super(facilityId, serviceName, useArea, rentalPrice, maxRentalPeople, rentalStyle);
        this.houseStandard = houseStandard;
        this.floor = floor;
    }

    public House(String[] arr){
        super(arr[0],arr[1],Double.parseDouble(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4]),arr[5]);
        this.houseStandard = arr[6];
        this.floor = Integer.parseInt(arr[7]);
    }

    @Override
    public String toString() {
        return this.getFacilityId() + ","
                + this.getServiceName() + ","
                + this.getUseArea() + ","
                + this.getRentalPrice() + ","
                + this.getMaxRentalPeople() + ","
                + this.getRentalStyle() + ","
                + this.houseStandard + ","
                + this.floor;
    }

    @Override
    public String getInfo() {
        return "--HOUSE-- \n"
                + "Facility ID: " + this.getFacilityId() + "\n"
                + "Service name: " + this.getServiceName() + "\n"
                + "Use area: " + this.getUseArea() + "\n"
                + "Rental price: " + this.getRentalPrice() + "\n"
                + "Max rental people: " + this.getMaxRentalPeople() + "\n"
                + "Rental style: " + this.getRentalStyle() + "\n"
                + "House standard: " + this.houseStandard + "\n"
                + "Floor: " + this.floor + "\n";
    }
}
