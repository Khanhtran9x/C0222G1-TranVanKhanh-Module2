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

        House house = FacilityRegexAndException.inputNewHouse();
        facilityIntegerMap.put(house, 0);

        ReadAndWrite.writeMapCsv(facilityIntegerMap, path);
        System.out.println("Added house successfully");
    }

    @Override
    public void addNewVilla() {
        facilityIntegerMap = readFile();

        Villa villa = FacilityRegexAndException.inputNewVilla();
        facilityIntegerMap.put(villa, 0);

        ReadAndWrite.writeMapCsv(facilityIntegerMap, path);
        System.out.println("Added villa successfully");
    }

    @Override
    public void addNewRoom() {
        facilityIntegerMap = readFile();

        Room room = FacilityRegexAndException.inputNewRoom();
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
}
