package com.avs.services;

import com.avs.api.v1.mapper.VendorMapper;
import com.avs.api.v1.model.VendorDTO;
import com.avs.controllers.v1.VendorController;
import com.avs.domain.Vendor;
import com.avs.repositories.VendorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VendorServiceImpl implements VendorService {

    public final VendorRepository vendorRepository;
    public final VendorMapper vendorMapper;

    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository
                .findAll()
                .stream()
                .map(vendor -> {
                    VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
                    vendorDTO.setVendorUrl(VendorController.BASE_URL);
                    return vendorDTO;
                }).collect(Collectors.toList());
    }



    @Override
    public VendorDTO getVendorByName(String name) {

        return vendorMapper.vendorToVendorDTO( vendorRepository.findByName(name));
    }

    @Override
    public void deleteVendorById(Long id) {

        log.debug("Deleting Vendor: " + id);

        Optional<Vendor> vendorOptional = vendorRepository.findById(id);

        if (vendorOptional.isPresent()) {

            vendorRepository.deleteById(id);
        } else {
            log.debug("Vendor Id Not found. Id:" + id);
        }

    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {

      Vendor vendor=  vendorMapper.vendorDtoToVendor(vendorDTO);

        return saveAndReturnVendorDTO(vendorMapper.vendorDtoToVendor(vendorDTO));
    }


    public VendorDTO saveAndReturnVendorDTO(Vendor vendor) {

        Vendor savedVendor = vendorRepository.save(vendor);

        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(savedVendor);

        vendorDTO.setVendorUrl(VendorController.BASE_URL + vendorDTO.getId());
        return vendorDTO;

    }


    @Override
    public VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDTO);
        vendor.setId(id);

        return saveAndReturnVendorDTO(vendor);
    }

    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
     Vendor vendor=   vendorRepository.findById(id).get();

     if (vendorDTO.getName()!=null){
         vendor.setName(vendorDTO.getName());
     }
        VendorDTO vdto=   vendorMapper.vendorToVendorDTO(vendorRepository.save(vendor));
        vdto.setVendorUrl(VendorController.BASE_URL+ id);
        return vdto;
    }
}
