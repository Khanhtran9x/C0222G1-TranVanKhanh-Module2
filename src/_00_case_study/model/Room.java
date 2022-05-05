package _00_case_study.model;

public class Room extends Facility{
   private String freeBonusService;

    public Room(String facilityId,
                String serviceName,
                double useArea,
                int rentalPrice,
                int maxRentalPeople,
                String rentalStyle,
                String freeBonusService) {
        super(facilityId, serviceName, useArea, rentalPrice, maxRentalPeople, rentalStyle);
        this.freeBonusService = freeBonusService;
    }

    public Room(String[] arr){
        super(arr[0],arr[1],Double.parseDouble(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4]),arr[5]);
        this.freeBonusService = arr[6];
    }

    @Override
    public String toString() {
        return this.getFacilityId() + ","
                + this.getServiceName() + ","
                + this.getUseArea() + ","
                + this.getRentalPrice() + ","
                + this.getMaxRentalPeople() + ","
                + this.getRentalStyle() + ","
                + this.freeBonusService;
    }

    @Override
    public String getInfo() {
        return "--ROOM-- \n"
                + "Facility ID: " + this.getFacilityId() + "\n"
                + "Service name: " + this.getServiceName() + "\n"
                + "Use area: " + this.getUseArea() + "\n"
                + "Rental price: " + this.getRentalPrice() + "\n"
                + "Max rental people: " + this.getMaxRentalPeople() + "\n"
                + "Rental style: " + this.getRentalStyle() + "\n"
                + "Bonus service: " + this.freeBonusService + "\n";
    }
}
