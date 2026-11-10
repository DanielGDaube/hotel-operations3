package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        bookedSuites = 0;
        bookedBasicRooms = 0;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    public int getAvailableSuites(){
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableRooms(){
        return  numberOfRooms - bookedBasicRooms;
    }

    public boolean bookRoom(int roomCount, boolean suite){
        int available;
        if (suite){
            available = getAvailableSuites();
            if (roomCount > available){
                return false;
            }
            else {
                bookedSuites += roomCount;
                return true;
            }
        }
        else {
            available = getAvailableRooms();
            if (roomCount > available){
                return false;
            }
            else {
                bookedBasicRooms += roomCount;
                return true;
            }
        }
    }

}
