package _00_case_study.model;

public class House extends Facility{
    private String houseStandard;
    private double floor;

    public House(String facilityId,
                 String serviceName,
                 double useArea,
                 int rentalPrice,
                 int maxRentalPeople,
                 String rentalStyle,
                 String houseStandard,
                 double floor) {
        super(facilityId, serviceName, useArea, rentalPrice, maxRentalPeople, rentalStyle);
        this.houseStandard = houseStandard;
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House{" + "id facility=" + super.getFacilityId()+
                ", service name=" +super.getServiceName() +
                ", user area=" + super.getUseArea() +
                ", rental price=" + super.getRentalPrice() +
                ", max rental people=" + super.getMaxRentalPeople() +
                ", rental style=" + super.getRentalStyle() +
                "houseStandard='" + houseStandard + '\'' +
                ", floor=" + floor +
                '}';
    }

    @Override
    public String toStringToWrite() {
        return this.getFacilityId() + "," + this.getServiceName() + "," + this.getUseArea() + "," + this.getRentalPrice() +
                "," + this.getMaxRentalPeople() + "," + this.getRentalStyle() +
                "," + this.houseStandard + "," + this.floor;
    }
}
