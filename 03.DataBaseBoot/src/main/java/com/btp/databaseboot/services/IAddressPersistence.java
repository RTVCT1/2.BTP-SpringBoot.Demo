package com.btp.databaseboot.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.btp.databaseboot.entities.Address;

public interface IAddressPersistence extends JpaRepository<Address, Long> {

}
