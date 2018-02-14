package com.avs.services;

import com.avs.api.v1.mapper.VendorMapper;
import com.avs.api.v1.model.VendorDTO;
import com.avs.repositories.VendorRepository;

import java.util.List;

public interface VendorService {


    List< VendorDTO> getAllVendors();

    VendorDTO getVendorByName(String name);

    void deleteVendorById(Long id);

    VendorDTO createNewVendor(VendorDTO vendorDTO);

    VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO);

    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);


}
