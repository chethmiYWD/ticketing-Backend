package com.oopBackend.oopBackend.Controller;

////package com.oopBackend.oopBackend.Controller;
////import com.oopBackend.oopBackend.Model.Vendor;
////import com.oopBackend.oopBackend.Repository.VendorRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////@RestController
////@RequestMapping("/Vendor")
////public class VendorController {
////
////    @Autowired
////    VendorRepository vendorRepo;
////    @PostMapping("/Vendor")
////    public void Vendor(@RequestBody Vendor vendor){
////        vendorRepo.save(vendor);
////    }
////
//////    @PostMapping
//////    public ResponseEntity<String> addVendor(@RequestBody Vendor vendor) {
//////        vendorRepo.save(vendor);
//////        return ResponseEntity.ok("Vendor saved successfully!");
//////    }
////
////
////}
//
//package com.oopBackend.oopBackend.Controller;
//
//import com.oopBackend.oopBackend.Model.Vendor;
//import com.oopBackend.oopBackend.Service.VendorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/vendors")
//public class VendorController {
//
//    private final VendorService vendorService;
//
//    @Autowired
//    public VendorController(VendorService vendorService) {
//        this.vendorService = vendorService;
//    }
//
//    @PostMapping
//    public Vendor addVendor(@RequestBody Vendor vendor) {
//        return vendorService.saveVendor(vendor);
//    }
//
//    @GetMapping("/{id}")
//    public Vendor getVendorById(@PathVariable String id) {
//        return vendorService.getVendorById(id)
//                .orElseThrow(() -> new RuntimeException("Vendor not found with id: " + id));
//    }
//
//    @GetMapping
//    public List<Vendor> getAllVendors() {
//        return vendorService.getAllVendors();
//    }
//
//    @PutMapping("/{id}")
//    public Vendor updateVendor(@PathVariable String id, @RequestBody Vendor vendorDetails) {
//        return vendorService.updateVendor(id, vendorDetails);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteVendor(@PathVariable String id) {
//        vendorService.deleteVendor(id);
//    }
//}

//package com.oopBackend.oopBackend.Controller;
//
//import com.oopBackend.oopBackend.Model.Vendor;
//import com.oopBackend.oopBackend.Service.VendorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/vendor")
//public class VendorController {
//
//    private final VendorService vendorService;
//
//    @Autowired
//    public VendorController(VendorService vendorService) {
//        this.vendorService = vendorService;
//    }
//
//    // Vendor Login
//    @PostMapping("/login")
//    public ResponseEntity<Map<String, String>> loginVendor(@RequestBody Map<String, String> loginDetails) {
//        String email = loginDetails.get("email");
//        String password = loginDetails.get("password");
//
//        // Authenticate vendor
//        Optional<Vendor> foundVendor = vendorService.loginVendor(email, password);
//
//        if (foundVendor.isPresent()) {
//            // Return success with role
//            return ResponseEntity.ok(Map.of(
//                    "email", email,
//                    "role", "Vendor"
//            ));
//        } else {
//            // Return error for invalid credentials
//            return ResponseEntity.status(401).body(Map.of(
//                    "message", "Invalid email or password"
//            ));
//        }
//    }
//}
//

//import java.util.Optional;
//import com.oopBackend.oopBackend.Model.Vendor;
//import com.oopBackend.oopBackend.Service.VendorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/vendors")
//public class VendorController {
//
//    @Autowired
//    private VendorService vendorService;
//
//    @GetMapping("/profile")
//    public ResponseEntity<Vendor> getVendorProfile(@RequestParam("email") String email) {
//        Optional<Vendor> vendor = vendorService.findByEmail(email);
//        if (vendor.isPresent()) {
//            return ResponseEntity.ok(vendor.get());
//        } else {
//            return ResponseEntity.status(404).body(null);  // Return 404 if vendor not found
//        }
//    }
//}
