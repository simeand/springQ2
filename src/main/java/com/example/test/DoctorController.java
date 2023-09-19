package com.example.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DoctorController {
    @GetMapping("/doctor/{incarnationNumber}")
    public ResponseEntity<?> getDoctor(@PathVariable int incarnationNumber) {
        if (incarnationNumber >= 9 && incarnationNumber <= 13) {
            String name = "";
            switch (incarnationNumber) {
                case 9:
                    name = "Christopher Eccleston";
                    break;
                case 10:
                    name = "David Tennant";
                    break;
                case 11:
                    name = "Matt Smith";
                    break;
                case 12:
                    name = "Peter Capaldi";
                    break;
                case 13:
                    name = "Jodie Whittaker";
                    break;
            }
            return ResponseEntity.ok(new Doctor(incarnationNumber, name));
        } else if (incarnationNumber >= 1 && incarnationNumber <= 8) {
            return new ResponseEntity<>(HttpStatus.SEE_OTHER);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Impossible to retrieve the incarnation" + incarnationNumber);
        }
    }
}
