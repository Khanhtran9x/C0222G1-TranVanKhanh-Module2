package _00_case_study.model;

public class Villa extends Facility{
    private String villaStandard;
    private double poolArea;
    private int floor;

    public Villa(String facilityId,
                 String serviceName,
                 double useArea,
                 int rentalPrice,
                 int maxRentalPeople,
                 String rentalStyle,
                 String villaStandard,
                 double poolArea,
                 int floor) {
        super(facilityId, serviceName, useArea, rentalPrice, maxRentalPeople, rentalStyle);
        this.villaStandard = villaStandard;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public Villa(String[] arr){
        super(arr[0],arr[1],Double.parseDouble(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4]),arr[5]);
        this.villaStandard = arr[6];
        this.poolArea = Double.parseDouble(arr[7]);
        this.floor = Integer.parseInt(arr[8]);
    }

    @Override
    public String toString() {
        return this.getFacilityId() + ","
                + this.getServiceName() + ","
                + this.getUseArea() + ","
                + this.getRentalPrice() + ","
                + this.getMaxRentalPeople() + ","
                + this.getRentalStyle() + ","
                + this.villaStandard + ","
                + this.poolArea + ","
                + this.floor;
    }

    @Override
    public String getInfo() {
        return "--VILLA-- \n"
                + "Facility ID: " + this.getFacilityId() + "\n"
                + "Service name: " + this.getServiceName() + "\n"
                + "Use area: " + this.getUseArea() + "\n"
                + "Rental price: " + this.getRentalPrice() + "\n"
                + "Max rental people: " + this.getMaxRentalPeople() + "\n"
                + "Rental style: " + this.getRentalStyle() + "\n"
                + "Villa standard: " + this.villaStandard + "\n"
                + "Pool area: " + this.poolArea + "\n"
                + "Floor: " + this.floor+ "\n";
    }
}
