package _00_case_study.model;

public abstract class Facility {
    private String facilityId;
    private String serviceName;
    private double useArea;
    private int rentalPrice;
    private int maxRentalPeople;
    private String rentalStyle;

    public Facility(String facilityId, String serviceName, double useArea, int rentalPrice,
                    int maxRentalPeople, String rentalStyle) {
        this.facilityId = facilityId;
        this.serviceName = serviceName;
        this.useArea = useArea;
        this.rentalPrice = rentalPrice;
        this.maxRentalPeople = maxRentalPeople;
        this.rentalStyle = rentalStyle;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUseArea() {
        return useArea;
    }

    public void setUseArea(double useArea) {
        this.useArea = useArea;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getMaxRentalPeople() {
        return maxRentalPeople;
    }

    public void setMaxRentalPeople(int maxRentalPeople) {
        this.maxRentalPeople = maxRentalPeople;
    }

    public String getRentalStyle() {
        return rentalStyle;
    }

    public void setRentalStyle(String rentalStyle) {
        this.rentalStyle = rentalStyle;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "idFacility='" + facilityId + '\'' +
                ", nameService='" + serviceName + '\'' +
                ", areaUse=" + useArea +
                ", rentalPrice=" + rentalPrice +
                ", rentalPeopleMax=" + maxRentalPeople +
                ", styleRental='" + rentalStyle + '\'' +
                '}';
    }

    public abstract String getInfo();
}
