package com.scc.dao;

import com.scc.model.Passenger;
import java.util.ArrayList;
import java.util.List;

public class PassengerDao {
    private List<Passenger> passengerList = new ArrayList<>();

    public void addPassenger(Passenger passenger) {
        passengerList.add(passenger);
    }

    public List<Passenger> getAllPassengers() {
        return passengerList;
    }

    public double getTotalFareRevenue() {
        double total = 0;
        for (Passenger p : passengerList) {
            total += p.getFare();
        }
        return total;
    }
}