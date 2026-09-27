package com.scc.model;

public class Passenger {
    private String passengerName;
    private String destination;
    private double distance;
    private String category;
    private double fare;

    public Passenger(String passengerName, String destination, double distance, String category, double fare) {
        this.passengerName = passengerName;
        this.destination = destination;
        this.distance = distance;
        this.category = category;
        this.fare = fare;
    }

    public String getPassengerName() { return passengerName; }
    public String getDestination() { return destination; }
    public double getDistance() { return distance; }
    public String getCategory() { return category; }
    public double getFare() { return fare; }
}