package _00_case_study.utils;

import _00_case_study.model.House;
import _00_case_study.model.Room;
import _00_case_study.model.Villa;

import java.util.List;
import java.util.Scanner;

public class FacilityRegexAndException {
    static Scanner scanner = new Scanner(System.in);
    static String facilityPath = "src\\_00_case_study\\data\\facility.csv";
    public static final String REGEX_BONUS_SERVICE = "^[a-zA-Z\\s]*$";
    public static final String REGEX_ID_VILLA = "(SVVL)[-][\\d]{4}";
    public static final String REGEX_ID_HOUSE = "(SVHO)[-][\\d]{4}";
    public static final String REGEX_ID_ROOM = "(SVRO)[-][\\d]{4}";
    public static final String REGEX_RENTAL_PEOPLE = "[1-9]|[1][1-9]|[(20)]";
    public static final String REGEX_PRICE = "^([1-9][0-9])|([1-9][\\d]{2})$";
    public static final String REGEX_AREA = "^([3-9][0-9])|([1-9][0-9]{2,})$";
    public static final String REGEX_POOL_AREA = "^[1-2][0-9]$";
    public static final String REGEX_NAME = "^[a-zA-Z\\s]*$";

    public static Villa inputNewVilla() {
        List<String[]> list = ReadAndWrite.readListCsv(facilityPath);

        String villaId = inputVillaId(list);
        String serviceName = inputServiceName();
        double useArea = inputUseArea();
        int rentalPrice = inputRentalPrice();
        int maxRentalPeople = inputMaxRentalPeople();
        String rentalStyle = inputRentalStyle();
        String villaStandard = inputVillaStandard();
        double poolArea = inputPoolArea();
        int floor = inputFloor();

        Villa villa = new Villa(villaId, serviceName, useArea, rentalPrice,
                maxRentalPeople, rentalStyle, villaStandard, poolArea, floor);
        return villa;
    }

    public static House inputNewHouse() {
        List<String[]> list = ReadAndWrite.readListCsv(facilityPath);

        String houseId = inputHouseId(list);
        String serviceName = inputServiceName();
        double useArea = inputUseArea();
        int rentalPrice = inputRentalPrice();
        int maxRentalPeople = inputMaxRentalPeople();
        String rentalStyle = inputRentalStyle();
        String houseStandard = inputHouseStandard();
        int floor = inputFloor();

        House house = new House(houseId, serviceName, useArea, rentalPrice,
                maxRentalPeople, rentalStyle, houseStandard, floor);
        return house;
    }

    public static Room inputNewRoom() {
        List<String[]> list = ReadAndWrite.readListCsv(facilityPath);

        String roomId = inputRoomId(list);
        String serviceName = inputServiceName();
        double useArea = inputUseArea();
        int rentalPrice = inputRentalPrice();
        int maxRentalPeople = inputMaxRentalPeople();
        String rentalStyle = inputRentalStyle();
        String freeBonusService = inputFreeBonusService();

        Room room = new Room(roomId, serviceName, useArea, rentalPrice,
                maxRentalPeople, rentalStyle, freeBonusService);
        return room;
    }

    public static String inputVillaId(List<String[]> list) {
        String villaId;
        boolean check = true;
        do {
            System.out.println("Input villa id:");
            villaId = scanner.nextLine();
            if (!CheckId.checkId(villaId, list)) {
                System.err.println("The id that you just inputted was taken, please input a new one");
                continue;
            }
            if (villaId.matches(REGEX_ID_VILLA)) {
                check = false;
            } else {
                System.out.println("You inputted the wrong format, the right one must be SVVL-XXXX");
            }
        } while (check);
        return villaId;
    }

    public static String inputHouseId(List<String[]> list) {
        String houseId;
        boolean check = true;

        do {
            System.out.println("Input house id:");
            houseId = scanner.nextLine();
            if (!CheckId.checkId(houseId, list)) {
                System.err.println("The id that you just inputted was taken, please input a new one");
                continue;
            }
            if (houseId.matches(REGEX_ID_HOUSE)) {
                check = false;
            } else {
                System.out.println("You inputted the wrong format, the right one must be SVHO-XXXX");
                houseId = scanner.nextLine();
            }
        } while (check);
        return houseId;
    }

    public static String inputRoomId(List<String[]> list) {
        String roomId;
        boolean check = true;
        do {
            System.out.println("Input room id:");
            roomId = scanner.nextLine();
            if (!CheckId.checkId(roomId, list)) {
                System.err.println("The id that you just inputted was taken, please input a new one");
                continue;
            }

            if (roomId.matches(REGEX_ID_ROOM)) {
                check = false;
            } else {
                System.out.println("You inputted the wrong format, the right one must be SVRO-XXXX");
                roomId = scanner.nextLine();
            }
        } while (check);
        return roomId;
    }

    public static String inputServiceName() {
        System.out.println("Input service name:");
        String serviceName = scanner.nextLine();
        boolean check = true;
        do {
            if (serviceName.matches(REGEX_NAME)) {
                check = false;
            } else {
                System.out.println("You inputted the wrong format, first character of service name must be in upper case");
                serviceName = scanner.nextLine();
            }
        } while (check);
        return serviceName;
    }

    public static double inputUseArea() {
        System.out.println("Input use area:");
        String useArea = scanner.nextLine();
        boolean check = true;
        do {
            if (useArea.matches(REGEX_AREA)) {
                check = false;
            } else {
                System.out.println("You inputted the wrong one, the area must be over 30m2");
                useArea = scanner.nextLine();
            }
        } while (check);
        return Double.parseDouble(useArea);
    }

    public static int inputRentalPrice() {
        System.out.println("Input rental price:");
        String rentalPrice = scanner.nextLine();
        boolean check = true;
        do {
            if (rentalPrice.matches(REGEX_PRICE)) {
                check = false;
            } else {
                System.out.println("You inputted the wrong one, the price must be over 10$");
                rentalPrice = scanner.nextLine();
            }
        } while (check);
        return Integer.parseInt(rentalPrice);
    }

    public static int inputMaxRentalPeople() {
        System.out.println("Input max rental people:");
        String maxRentalPeople = scanner.nextLine();
        boolean check = true;
        do {
            if (maxRentalPeople.matches(REGEX_RENTAL_PEOPLE)) {
                check = false;
            } else {
                System.out.println("You inputted the wrong one, the amount must be over 0 and less then 20");
                maxRentalPeople = scanner.nextLine();
            }
        } while (check);
        return Integer.parseInt(maxRentalPeople);
    }

    public static String inputRentalStyle() {
        String rentalStyle = "";
        int choice;
        while (true) {
            System.out.println("Select customer type: ");
            System.out.println("1. Annually");
            System.out.println("2. Monthly");
            System.out.println("3. Daily");
            System.out.println("4. Hourly");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        rentalStyle = "Annually";
                        return rentalStyle;
                    case 2:
                        rentalStyle = "Monthly";
                        return rentalStyle;
                    case 3:
                        rentalStyle = "Daily";
                        return rentalStyle;
                    case 4:
                        rentalStyle = "Hourly";
                        return rentalStyle;
                    default:
                        System.out.println("Your choice does not match our options");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input a number which matches our options");
            }
        }
    }

    public static String inputVillaStandard() {
        String villaStandard = "";
        int choice;
        while (true) {
            System.out.println("Select villa standard: ");
            System.out.println("1. Luxury");
            System.out.println("2. High");
            System.out.println("3. Standard");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        villaStandard = "Luxury";
                        return villaStandard;
                    case 2:
                        villaStandard = "High";
                        return villaStandard;
                    case 3:
                        villaStandard = "Standard";
                        return villaStandard;
                    default:
                        System.out.println("Your choice does not match our options");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input a number which matches our options");
            }
        }
    }

    public static String inputHouseStandard() {
        String houseStandard = "";
        int choice;
        while (true) {
            System.out.println("Select house standard: ");
            System.out.println("1. 4 bedroom");
            System.out.println("2. 2 bedroom");
            System.out.println("3. Standard");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        houseStandard = "4 bedroom";
                        return houseStandard;
                    case 2:
                        houseStandard = "2 bedroom";
                        return houseStandard;
                    case 3:
                        houseStandard = "Standard";
                        return houseStandard;
                    default:
                        System.out.println("Your choice does not match our options");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input a number which matches our options");
            }
        }
    }

    public static double inputPoolArea() {
        System.out.println("Input pool area:");
        String poolArea = scanner.nextLine();
        boolean check = true;
        do {
            if (poolArea.matches(REGEX_POOL_AREA)) {
                check = false;
            } else {
                System.out.println("You inputted the wrong one, the pool area must be over 10m2 and less than 30m2");
                poolArea = scanner.nextLine();
            }
        } while (check);
        return Double.parseDouble(poolArea);
    }

    public static int inputFloor() {
        int floor;
        while (true) {
            try {
                System.out.println("Input number of floor:");
                floor = Integer.parseInt(scanner.nextLine());
                if (floor > 0 && floor < 5) {
                    return floor;
                } else {
                    System.err.println("Please input a number less than 5");
                    ;
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input a number less than 5");
            }
        }

    }

    public static String inputFreeBonusService() {
        System.out.println("Input free bonus service:");
        String freeBonusService = scanner.nextLine();
        boolean check = true;
        do {
            if (freeBonusService.matches(REGEX_BONUS_SERVICE)) {
                check = false;
            } else {
                System.out.println("You inputted the wrong one, the pool area must be over 30m2");
                freeBonusService = scanner.nextLine();
            }
        } while (check);
        return freeBonusService;
    }


}
