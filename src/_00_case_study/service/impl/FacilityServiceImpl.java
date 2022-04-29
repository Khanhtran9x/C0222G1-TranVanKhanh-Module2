package _00_case_study.service.impl;

import _00_case_study.model.*;
import _00_case_study.service.FacilityService;
import _00_case_study.utils.ReadAndWrite;
import _00_case_study.utils.RegexData;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    public static final String REGEX_STR = "[A-Z][a-z]+";
    public static final String REGEX_ID_VILLA = "(SVVL)[-][\\d]{4}";
    public static final String REGEX_ID_HOUSE = "(SVHO)[-][\\d]{4}";
    public static final String REGEX_ID_ROOM = "(SVRO)[-][\\d]{4}";
    public static final String REGEX_AMOUNT = "^[1-9]|([1][1-9])|(20)$";
    public static final String REGEX_INT = "^[1-9]|([1][0-9])$";
    public static final String REGEX_AREA = "^([3-9][0-9])|([1-9][0-9]{2,})$";
    public static final String REGEX_FLOOR = "^[1-9]|([1-9][0-9])$";

    private Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    Scanner scanner = new Scanner(System.in);
    static List<House> houseList = new LinkedList<>();
    String housePath = "src\\_00_case_study\\data\\house.csv";


    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
            System.out.println("Service name = " + map.getKey() + " , rent times = " + map.getValue());
        }
    }

    @Override
    public void displayMaintain() {

    }

    @Override
    public void addNewHouse() {
        try {
            String facilityId = inputHouseId();
            String serviceName = inputName();
            double areaUse = Double.parseDouble(inputArea());
            int rentalPrice = Integer.parseInt(inputPrice());
            int maxRentalPeople = Integer.parseInt(inputMaxRentalPeople());
            String rentalStyle = inputHouseRentalStyle();
            String houseStandard = inputHouseStandard();
            int floor = Integer.parseInt(inputFloor());
            House house = new House(facilityId, serviceName, areaUse, rentalPrice,
                    maxRentalPeople, rentalStyle, houseStandard, floor);
            facilityIntegerMap.put(house, 0);
            houseList.add(house);
            ReadAndWrite.writeHouseCsv(houseList, housePath);
            System.out.println("Add house successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addNewVilla() {
        try {
            String facilityId = inputVillaId();
            String serviceName = inputName();
            double areaUse = Double.parseDouble(inputArea());
            int rentalPrice = Integer.parseInt(inputPrice());
            int maxRentalPeople = Integer.parseInt(inputMaxRentalPeople());
            String rentalStyle = inputVillaRentalStyle();
            String villaStandard = inputVillaStandard();
            double poolArea = Double.parseDouble(inputPoolArea());
            int floor = Integer.parseInt(inputFloor());

            Villa villa = new Villa(facilityId, serviceName, areaUse, rentalPrice,
                    maxRentalPeople, rentalStyle, villaStandard, poolArea, floor);

            facilityIntegerMap.put(villa, 0);
            System.out.println("Add Villa successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewRoom() {
        try {
            String facilityId = inputRoomId();
            String serviceName = inputName();
            double areaUse = Double.parseDouble(inputArea());
            int rentalPrice = Integer.parseInt(inputPrice());
            int maxRentalPeople = Integer.parseInt(inputMaxRentalPeople());
            String rentalStyle = inputRoomRentalStyle();
            String freeBonusService = inputBonusService();

            Room room = new Room(facilityId, serviceName, areaUse, rentalPrice,
                    maxRentalPeople, rentalStyle, freeBonusService);

            facilityIntegerMap.put(room, 0);
            System.out.println("Add Room successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String inputVillaId() {
        System.out.println("Please input the villa id:");
        return RegexData.regexStr(scanner.nextLine(), REGEX_ID_VILLA,
                "You inputted the wrong format, the right one must be SVVL-XXXX");
    }

    private String inputName() {
        System.out.println("Please input the service name:");
        return RegexData.regexStr(scanner.nextLine(), REGEX_STR,
                "You inputted the wrong format, first character of name service must be in upper case");
    }

    private String inputArea() {
        System.out.println("Please input the villa area:");
        return RegexData.regexStr(scanner.nextLine(), REGEX_AREA,
                "You inputted the wrong one, the villa area must be over 30m2");
    }

    private String inputPrice() {
        System.out.println("Please input the rental price:");
        return RegexData.regexStr(scanner.nextLine(), REGEX_INT,
                "You inputted the wrong one, the price must be over 10$");
    }

    private String inputMaxRentalPeople() {
        System.out.println("Please input max rental people:");
        return RegexData.regexStr(scanner.nextLine(), REGEX_AMOUNT,
                "You inputted the wrong one, the amount must be over 0 and less then 20");
    }

    private String inputFloor() {
        System.out.println("Please input the floor:");
        return RegexData.regexStr(scanner.nextLine(), REGEX_FLOOR,
                "You inputted the wrong one, the floor must be a positive number");
    }

    private String inputVillaRentalStyle() {
        System.out.println("Please input the rental style:");
        return RegexData.regexStr(scanner.nextLine(), REGEX_ID_VILLA,
                "You inputted the wrong one, the right one must be SVVL-XXXX");
    }

    private String inputVillaStandard() {
        System.out.println("Please input the villa standard:");
        return RegexData.regexStr(scanner.nextLine(), REGEX_ID_VILLA,
                "You inputted the wrong one, the right one must be SVVL-XXXX");
    }

    private String inputPoolArea() {
        System.out.println("Please input the pool area:");
        return RegexData.regexStr(scanner.nextLine(), REGEX_AREA,
                "You inputted the wrong one, the pool area must be over 30m2");
    }

    private String inputHouseId() {
        System.out.println("Please input the house id:");
        return RegexData.regexStr(scanner.nextLine(), REGEX_ID_HOUSE,
                "You inputted the wrong format, the right one must be SVHO-XXXX");
    }

    private String inputHouseStandard() {
        System.out.println("Please input the house standard:");
        return RegexData.regexStr(scanner.nextLine(), REGEX_ID_HOUSE,
                "You inputted the wrong one, the right one must be SVHO-XXXX");
    }

    private String inputHouseRentalStyle() {
        System.out.println("Please input the rental style:");
        return RegexData.regexStr(scanner.nextLine(), REGEX_ID_HOUSE,
                "You inputted the wrong one, the right one must be SVHO-XXXX");
    }

    private String inputRoomId() {
        System.out.println("Please input the room id:");
        return RegexData.regexStr(scanner.nextLine(), REGEX_ID_ROOM,
                "You inputted the wrong format, the right one must be SVRO-XXXX");
    }

    private String inputRoomStandard() {
        System.out.println("Please input the room standard:");
        return RegexData.regexStr(scanner.nextLine(), REGEX_ID_ROOM,
                "You inputted the wrong one, the right one must be SVRO-XXXX");
    }

    private String inputRoomRentalStyle() {
        System.out.println("Please input the rental style:");
        return RegexData.regexStr(scanner.nextLine(), REGEX_ID_ROOM,
                "You inputted the wrong one, the right one must be SVRO-XXXX");
    }

    private String inputBonusService() {
        System.out.println("Please input the bonus service:");
        return RegexData.regexStr(scanner.nextLine(), REGEX_STR,
                "You inputted the wrong one, first character of name service must be in upper case");
    }

}
