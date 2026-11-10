package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numberOfBeds, double price) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = false;
        this.isDirty = false;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    // Derived getter: clean and empty
    public boolean isAvailable() {
        return !isOccupied && !isDirty;
    }

    // Only an available room can take a guest; otherwise nothing happens
    public void checkIn() {
        if (isAvailable()) {
            isOccupied = true;
            isDirty = true;
        }
    }

    // checkOut: lowerCamelCase, two words, capital O
    // The room stays dirty: cleaning is housekeeping's job, not the guest's
    public void checkOut() {
        isOccupied = false;
    }

    // Housekeeping cannot clean while a guest is still inside
    public void cleanRoom() {
        if (!isOccupied) {
            isDirty = false;
        }
    }
}
