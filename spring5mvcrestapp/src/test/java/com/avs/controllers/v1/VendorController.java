package com.avs.controllers.v1;

import com.avs.api.v1.model.VendorDTO;
import com.avs.api.v1.model.VendorListDTO;
import com.avs.services.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(description = "This is my Vendor API")
@RestController
@RequestMapping(VendorController.BASE_URL)
public class VendorController {
    public static final String BASE_URL = "/api/v1/vendors/";

    public VendorService vendorService;


    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @ApiOperation(value = "View List of Vendors", notes="These are some API Notes")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO getAllVendors() {
        return new VendorListDTO(vendorService.getAllVendors());
    }

    @ApiOperation(value = "Get Vendor by Id")
    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendorByname(@PathVariable String name) {
        return vendorService.getVendorByName(name);
    }

    @ApiOperation(value = "Delete a Vendor")
    @DeleteMapping({"{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendorById(id);
    }

    @ApiOperation(value = "Create a new Vendor")
    @PostMapping
    public VendorDTO createNewVendor(@RequestBody VendorDTO vendorDTO) {
        return vendorService.createNewVendor(vendorDTO);
    }

    @ApiOperation(value = "Update an existing Vendor")
    @PutMapping({"{id}"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO updateVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return vendorService.saveVendorByDTO(id, vendorDTO);

    }

    @PatchMapping({"id"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO patchVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return vendorService.patchVendor(id, vendorDTO);
    }
}
