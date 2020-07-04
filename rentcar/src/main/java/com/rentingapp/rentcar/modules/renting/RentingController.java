package com.rentingapp.rentcar.modules.renting;

import com.rentingapp.rentcar.modules.renting.entity.Renting;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/renting")
public class RentingController {

    private final RentingService rentingService;

    @PostMapping("/add")
    ResponseEntity<String> addRenting(@RequestBody Map<String, String> rent) {
        return rentingService.addRenting(rent);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getRenting(@PathVariable int id) {
        return rentingService.getRenting(id);
    }

    @GetMapping("/get-all")
    Iterable<Renting> getAllRentings() {
        return rentingService.getAllRentings();
    }
    @DeleteMapping("/delete/{id}") // endpoint responsible for giving away a car, isRented and isRenting become false
    ResponseEntity<String> deleteRenting(@PathVariable int id)
    {
        return rentingService.deleteRenting(id);
    }
}
