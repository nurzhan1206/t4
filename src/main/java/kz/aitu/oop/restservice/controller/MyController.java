package kz.aitu.oop.restservice.controller;

import kz.aitu.oop.restservice.Assignment2.Vehicle;
import kz.aitu.oop.restservice.Assignment2.Customer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/rental")
public class MyController {
    private final RentalService rentalService = new RentalService();

    @PostMapping("/addVehicle")
    public String addVehicle(@RequestBody Vehicle vehicle) {
        rentalService.addVehicle(vehicle);
        return "Vehicle added successfully!";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer) {
        rentalService.addCustomer(customer);
        return "Customer added successfully!";
    }

    @PostMapping("/rent/{vehicleId}/{customerId}")
    public String rentVehicle(@PathVariable String vehicleId, @PathVariable String customerId) {
        rentalService.rentVehicle(vehicleId, customerId);
        return "Vehicle rented!";
    }

    @PostMapping("/return/{vehicleId}")
    public String returnVehicle(@PathVariable String vehicleId) {
        rentalService.returnVehicle(vehicleId);
        return "Vehicle returned!";
    }

    @GetMapping("/availableVehicles")
    public List<Vehicle> displayAvailableVehicles() {
        return rentalService.getAvailableVehicles();
    }
}
