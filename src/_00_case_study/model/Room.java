package _00_case_study.model;

public class Room extends Facility{
   private String freeBonusService;

    public Room(String facilityId, String serviceName, double useArea,
                int rentalPrice, int maxRentalPeople, String rentalStyle, String freeBonusService) {
        super(facilityId, serviceName, useArea, rentalPrice, maxRentalPeople, rentalStyle);
        this.freeBonusService = freeBonusService;
    }

    @Override
    public String toString() {
        return "Room{" + "id facility=" + super.getFacilityId()+
                ", service name=" +super.getServiceName() +
                ", user area=" + super.getUseArea() +
                ", rental price=" + super.getRentalPrice() +
                ", max rental people=" + super.getMaxRentalPeople() +
                ", rental style=" + super.getRentalStyle() +
                ", free bonus service=" + freeBonusService +
                '}';
    }
}
