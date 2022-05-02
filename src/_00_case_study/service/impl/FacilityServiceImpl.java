package _00_case_study.service.impl;

import _00_case_study.model.*;
import _00_case_study.service.itf.FacilityService;
import _00_case_study.utils.FacilityRegexAndException;
import _00_case_study.utils.ReadAndWrite;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    private Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    static List<House> houseList = new LinkedList<>();
    static List<Villa> villaList = new LinkedList<>();
    static List<Room> roomList = new LinkedList<>();
    String housePath = "src\\_00_case_study\\data\\house.csv";
    String villaPath = "src\\_00_case_study\\data\\villa.csv";
    String roomPath = "src\\_00_case_study\\data\\room.csv";
    String facilityPath = "src\\_00_case_study\\data\\facility.csv";


    @Override
    public void display() {
        facilityIntegerMap = ReadAndWrite.readFacilityCsv(facilityPath);
        try {
            if (facilityIntegerMap.size() == 0){
                throw new NullPointerException();
            } else {
                for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
                    System.out.println("Service name = " + map.getKey().getFacilityId() + " , rent times = " + map.getValue());
                }
            }
        } catch (NullPointerException e) {
            System.err.println("The facility list is empty, please input a new one");
        }
    }

    @Override
    public void displayMaintain() {
        facilityIntegerMap = ReadAndWrite.readFacilityCsv(facilityPath);
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
        facilityIntegerMap = ReadAndWrite.readFacilityCsv(facilityPath);
        houseList = ReadAndWrite.readHouseCsv(housePath);
        House house = FacilityRegexAndException.inputNewHouse();
        houseList.add(house);
        facilityIntegerMap.put(house, 0);
        ReadAndWrite.writeHouseCsv(houseList, housePath);
        ReadAndWrite.writeFacilityCsv(facilityIntegerMap, facilityPath);
        System.out.println("Added house successfully");
    }

    @Override
    public void addNewVilla() {
        facilityIntegerMap = ReadAndWrite.readFacilityCsv(facilityPath);
        villaList = ReadAndWrite.readVillaCsv(villaPath);

        Villa villa = FacilityRegexAndException.inputNewVilla();
        villaList.add(villa);
        facilityIntegerMap.put(villa, 0);

        ReadAndWrite.writeVillaCsv(villaList, villaPath);
        ReadAndWrite.writeFacilityCsv(facilityIntegerMap, facilityPath);
        System.out.println("Added villa successfully");
    }

    @Override
    public void addNewRoom() {
        facilityIntegerMap = ReadAndWrite.readFacilityCsv(facilityPath);
        roomList = ReadAndWrite.readRoomCsv(roomPath);

        Room room = FacilityRegexAndException.inputNewRoom();
        roomList.add(room);
        facilityIntegerMap.put(room, 0);

        ReadAndWrite.writeRoomCsv(roomList, roomPath);
        ReadAndWrite.writeFacilityCsv(facilityIntegerMap, facilityPath);
        System.out.println("Added room successfully");
    }
}
