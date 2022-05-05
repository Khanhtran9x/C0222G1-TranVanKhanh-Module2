package _00_case_study.service.impl;

import _00_case_study.model.*;
import _00_case_study.service.itf.FacilityService;
import _00_case_study.utils.FacilityRegexAndException;
import _00_case_study.utils.ReadAndWrite;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    private Map<Facility, Integer> facilityIntegerMap;
    static List<String[]> stringList;
    static String path = "src\\_00_case_study\\data\\facility.csv";
    static Villa villa;
    static House house;
    static Room room;


    @Override
    public void display() {
        facilityIntegerMap = readFile();
        try {
            if (facilityIntegerMap.size() == 0){
                throw new NullPointerException();
            } else {
                for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
                    System.out.println("--SERVICE-- \n" + map.getKey().getInfo() + "RENT TIMES: " + map.getValue());
                    System.out.println("\n");
                }
            }
        } catch (NullPointerException e) {
            System.err.println("The facility list is empty, please input a new one");
        }
    }

    @Override
    public void displayMaintain() {
        facilityIntegerMap = readFile();
        int count = 0;

        System.out.println("List of facility needed to be maintained due to use of service more than 5 consecutive times");
        for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
            if (map.getValue() >= 5) {
                System.out.println(map.getKey().toString());
                count++;
            }
        }
        if (count == 0){
            System.err.println("Empty");
        }
    }

    @Override
    public void addNewHouse() {
        facilityIntegerMap = readFile();

        House house = inputNewHouse();
        facilityIntegerMap.put(house, 0);

        ReadAndWrite.writeMapCsv(facilityIntegerMap, path);
        System.out.println("Added house successfully");
    }

    @Override
    public void addNewVilla() {
        facilityIntegerMap = readFile();

        Villa villa = inputNewVilla();
        facilityIntegerMap.put(villa, 0);

        ReadAndWrite.writeMapCsv(facilityIntegerMap, path);
        System.out.println("Added villa successfully");
    }

    @Override
    public void addNewRoom() {
        facilityIntegerMap = readFile();

        Room room = inputNewRoom();
        facilityIntegerMap.put(room, 0);

        ReadAndWrite.writeMapCsv(facilityIntegerMap, path);
        System.out.println("Added room successfully");
    }

    public Map<Facility, Integer> readFile() {
        Map<Facility, Integer >facilityMap = new LinkedHashMap<>();
        stringList = ReadAndWrite.readListCsv(path);

        for (String[] strArr : stringList) {
            if (strArr[0].contains("SVVL")){
                villa = new Villa(strArr);
                facilityMap.put(villa, Integer.parseInt(strArr[9]));
            }

            if (strArr[0].contains("SVHO")){
                house = new House(strArr);
                facilityMap.put(house, Integer.parseInt(strArr[8]));
            }

            if (strArr[0].contains("SVRO")){
                room = new Room(strArr);
                facilityMap.put(room, Integer.parseInt(strArr[7]));
            }
        }
        return facilityMap;
    }

    public  Villa inputNewVilla() {
        List<String[]> list = ReadAndWrite.readListCsv(path);

        String villaId = FacilityRegexAndException.inputVillaId(list);
        String serviceName = FacilityRegexAndException.inputServiceName();
        double useArea = FacilityRegexAndException.inputUseArea();
        int rentalPrice = FacilityRegexAndException.inputRentalPrice();
        int maxRentalPeople = FacilityRegexAndException.inputMaxRentalPeople();
        String rentalStyle = FacilityRegexAndException.inputRentalStyle();
        String villaStandard = FacilityRegexAndException.inputVillaStandard();
        double poolArea = FacilityRegexAndException.inputPoolArea();
        int floor = FacilityRegexAndException.inputFloor();

        Villa villa = new Villa(villaId, serviceName, useArea, rentalPrice,
                maxRentalPeople, rentalStyle, villaStandard, poolArea, floor);
        return villa;
    }

    public House inputNewHouse() {
        List<String[]> list = ReadAndWrite.readListCsv(path);

        String houseId = FacilityRegexAndException.inputHouseId(list);
        String serviceName = FacilityRegexAndException.inputServiceName();
        double useArea = FacilityRegexAndException.inputUseArea();
        int rentalPrice = FacilityRegexAndException.inputRentalPrice();
        int maxRentalPeople = FacilityRegexAndException.inputMaxRentalPeople();
        String rentalStyle = FacilityRegexAndException.inputRentalStyle();
        String houseStandard = FacilityRegexAndException.inputHouseStandard();
        int floor = FacilityRegexAndException.inputFloor();

        House house = new House(houseId, serviceName, useArea, rentalPrice,
                maxRentalPeople, rentalStyle, houseStandard, floor);
        return house;
    }

    public Room inputNewRoom() {
        List<String[]> list = ReadAndWrite.readListCsv(path);

        String roomId = FacilityRegexAndException.inputRoomId(list);
        String serviceName = FacilityRegexAndException.inputServiceName();
        double useArea = FacilityRegexAndException.inputUseArea();
        int rentalPrice = FacilityRegexAndException.inputRentalPrice();
        int maxRentalPeople = FacilityRegexAndException.inputMaxRentalPeople();
        String rentalStyle = FacilityRegexAndException.inputRentalStyle();
        String freeBonusService = FacilityRegexAndException.inputFreeBonusService();

        Room room = new Room(roomId, serviceName, useArea, rentalPrice,
                maxRentalPeople, rentalStyle, freeBonusService);
        return room;
    }
}
