package com.oopBackend.oopBackend.Controller;

import com.oopBackend.oopBackend.Model.Vendor;
import com.oopBackend.oopBackend.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Vendor")
public class HomeController {

//    @GetMapping("/")
//    public String home() {
//        return "Welcome to Spring Boot Application!";

    @Autowired
    VendorRepository vendorRepo;
    @PostMapping("/Vendor")
    public void Vendor(@RequestBody Vendor vendor){
        vendorRepo.save(vendor);
    }
}

//@RestController
//@RequestMapping("/Vendor")  // This maps the class to the /Vendor endpoint
//public class HomeController {
//
//    @Autowired
//   VendorRepository vendorRepo;
//    @PostMapping  // This handles POST requests to /Vendor
//    public ResponseEntity<String> addVendor(@RequestBody Vendor vendor) {
//        // Logic to save vendor (mock response for now)
//        vendorRepo.save(vendor);
//        return null;
//    }
//}
