package com.avs.api.v1.mapper;

import com.avs.api.v1.model.VendorDTO;
import com.avs.domain.Vendor;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-01-16T21:02:57-0500",
    comments = "version: 1.2.0.CR2, compiler: javac, environment: Java 1.8.0_121 (Oracle Corporation)"
)
@Component
public class VendorMapperImpl implements VendorMapper {

    @Override
    public VendorDTO vendorToVendorDTO(Vendor vendor) {
        if ( vendor == null ) {
            return null;
        }

        VendorDTO vendorDTO = new VendorDTO();

        vendorDTO.setId( vendor.getId() );
        vendorDTO.setName( vendor.getName() );
        vendorDTO.setVendorUrl( vendor.getVendorUrl() );

        return vendorDTO;
    }

    @Override
    public Vendor vendorDtoToVendor(VendorDTO vendorDTO) {
        if ( vendorDTO == null ) {
            return null;
        }

        Vendor vendor = new Vendor();

        vendor.setId( vendorDTO.getId() );
        vendor.setName( vendorDTO.getName() );
        vendor.setVendorUrl( vendorDTO.getVendorUrl() );

        return vendor;
    }
}
