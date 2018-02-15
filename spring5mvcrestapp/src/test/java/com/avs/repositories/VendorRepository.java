package com.avs.repositories;

import com.avs.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor,Long> {

     Vendor findByName(String name);
}
