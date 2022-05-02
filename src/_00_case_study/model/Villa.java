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

    @Override
    public String toString() {
        return "Villa{" + "id facility=" + super.getFacilityId()+
                ", service name=" +super.getServiceName() +
                ", user area=" + super.getUseArea() +
                ", rental price=" + super.getRentalPrice() +
                ", max rental people=" + super.getMaxRentalPeople() +
                ", rental style=" + super.getRentalStyle() +
                ", villa Standard=" + villaStandard +
                ", pool Area=" + poolArea +
                ", floor=" + floor +
                '}';
    }

    @Override
    public String toStringToWrite() {
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
}
