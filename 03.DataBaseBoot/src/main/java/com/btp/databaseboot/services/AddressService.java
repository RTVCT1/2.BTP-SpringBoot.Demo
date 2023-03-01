package com.btp.databaseboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.btp.databaseboot.entities.Address;

@Component
public class AddressService {
	
	@Autowired
	IAddressPersistence address;
	
	public List<Address> getAddresses(){
		return address.findAll();
	}
	
	public Address createAddress(Address postBody) {
		return address.save(postBody);
	}
}
