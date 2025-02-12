package kz.aitu.oop.restservice.Assignment2;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
        import java.util.List;

@RestController
@Service
@RequestMapping("/rental")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/available")
    public List<Vehicle> getAvailableVehicles() {
        return rentalService.getAvailableVehicles();
    }
}
