package com.sampson.design_patterns.repository;

import com.sampson.design_patterns.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository  extends JpaRepository<Address, String> {
}
