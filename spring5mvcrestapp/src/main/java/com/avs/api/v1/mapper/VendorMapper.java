package com.avs.api.v1.mapper;

import com.avs.api.v1.model.CustomerDTO;
import com.avs.api.v1.model.VendorDTO;
import com.avs.domain.Customer;
import com.avs.domain.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendorMapper {


    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    VendorDTO vendorToVendorDTO(Vendor vendor);

    Vendor vendorDtoToVendor(VendorDTO vendorDTO);
}
