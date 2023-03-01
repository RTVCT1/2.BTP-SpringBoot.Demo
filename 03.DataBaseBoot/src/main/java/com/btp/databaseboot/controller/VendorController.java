package com.btp.databaseboot.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btp.databaseboot.entities.Vendor;
import com.btp.databaseboot.services.VendorService;

@RestController
//Controller interacts with Services

public class VendorController {
	
	@Autowired
	VendorService vendorService;
	
	@RequestMapping("/vendor")
	public List<Vendor> getVendors(){
		return vendorService.readAllVendors();
	}
	
	@RequestMapping("/vendor/{vendorCode}")
	public Vendor getVendorById(@PathVariable("vendorCode") Long code) {
		Optional<Vendor> searchResult = vendorService.getSingleVendor(code);
		if(!searchResult.isPresent()) {
			return new Vendor((long)0,"","","","","","",null );
		}
		return searchResult.get();
	}
	
	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor vendor) {
		return vendorService.createVendor(vendor);
	}
	
//	localhost:8080/vendor/search?company=RaviTeja
	@RequestMapping("/vendor/search")
	public List<Vendor> searchByCompany(@RequestParam String company){
		return vendorService.searchByCompanyName(company);
	}
	
//	localhost:8080/vendor/lookup/GST765342	
	@RequestMapping("/vendor/lookup/{gstNo}")
	public List<Vendor> searchVendorByGST(@PathVariable("gstNo") String GSTNo){
		return vendorService.lookupVendorByGST(GSTNo);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/vendor")
	public Vendor updateVendor(@RequestBody Vendor vendor ) {
		return vendorService.changeVendor(vendor);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/vendor/{id}")
	public String removeVendor(@PathVariable("id") Long id) {
		return vendorService.deleteVendor(id);
	}

}
