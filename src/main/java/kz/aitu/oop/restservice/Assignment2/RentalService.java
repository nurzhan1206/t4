package kz.aitu.oop.restservice.Assignment2;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service  // ✅ Добавь эту аннотацию
public class RentalService {
    private final List<Vehicle> vehicles = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Optional<Vehicle> findVehicleById(String vehicleId) {
        return vehicles.stream()
                .filter(v -> v.getId().equals(vehicleId))
                .findFirst();
    }

    public Optional<Customer> findCustomerById(String customerId) {
        return customers.stream()
                .filter(c -> c.getId().equals(customerId))
                .findFirst();
    }

    public void rentVehicle(String vehicleId, String customerId) {
        Optional<Vehicle> vehicleOpt = findVehicleById(vehicleId);
        Optional<Customer> customerOpt = findCustomerById(customerId);

        if (vehicleOpt.isPresent() && customerOpt.isPresent()) {
            Vehicle vehicle = vehicleOpt.get();
            if (vehicle.isAvailable()) {
                vehicle.setAvailable(false);
                System.out.println("Vehicle rented to customer: " + customerId);
            } else {
                System.out.println("Vehicle is already rented.");
            }
        } else {
            System.out.println("Vehicle or Customer not found.");
        }
    }

    public void returnVehicle(String vehicleId) {
        findVehicleById(vehicleId).ifPresentOrElse(
                vehicle -> {
                    vehicle.setAvailable(true);
                    System.out.println("Vehicle returned: " + vehicleId);
                },
                () -> System.out.println("Vehicle not found.")
        );
    }

    public void displayAvailableVehicles() {
        System.out.println("Available Vehicles:");
        vehicles.stream()
                .filter(Vehicle::isAvailable)
                .forEach(System.out::println);
    }

    public void displaySortedVehiclesByBrand() {
        System.out.println("Vehicles sorted by brand:");
        vehicles.stream()
                .sorted(Comparator.comparing(Vehicle::getBrand))
                .forEach(System.out::println);
    }

    public void filterVehiclesByBrand(String brand) {
        System.out.println("Filtered vehicles by brand: " + brand);
        vehicles.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .forEach(System.out::println);
    }

    public List<Vehicle> getAvailableVehicles() {
        return vehicles.stream().filter(Vehicle::isAvailable).toList();
    }
}

