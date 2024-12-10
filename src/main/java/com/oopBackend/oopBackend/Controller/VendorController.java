//package com.oopBackend.oopBackend.Controller;
//
//import com.oopBackend.oopBackend.Model.Vendor;
//import com.oopBackend.oopBackend.Repository.VendorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/Vendor")
//public class VendorController {
//
//    @Autowired
//    VendorRepository vendorRepo;
//    @PostMapping("/Vendor")
//    public void Vendor(@RequestBody Vendor vendor){
//        vendorRepo.save(vendor);
//    }
//
////    @PostMapping
////    public ResponseEntity<String> addVendor(@RequestBody Vendor vendor) {
////        vendorRepo.save(vendor);
////        return ResponseEntity.ok("Vendor saved successfully!");
////    }
//
//
//}

package com.oopBackend.oopBackend.Controller;

import com.oopBackend.oopBackend.Model.Vendor;
import com.oopBackend.oopBackend.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping
    public Vendor addVendor(@RequestBody Vendor vendor) {
        return vendorService.saveVendor(vendor);
    }

    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable String id) {
        return vendorService.getVendorById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found with id: " + id));
    }

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @PutMapping("/{id}")
    public Vendor updateVendor(@PathVariable String id, @RequestBody Vendor vendorDetails) {
        return vendorService.updateVendor(id, vendorDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable String id) {
        vendorService.deleteVendor(id);
    }
}
