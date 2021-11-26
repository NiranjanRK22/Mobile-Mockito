package com.mobileapp.service;

import java.util.List;

import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public interface IMobileService {


	List<Mobile> getByBrand(String brand) throws MobileNotFoundException;


	Mobile getById(int mobileId) throws MobileNotFoundException;

}
