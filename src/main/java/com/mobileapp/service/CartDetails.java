package com.mobileapp.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.mobileapp.exceptions.EmptyCartException;
import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public class CartDetails {
	  
	ICartService cartService;
	
	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}
	public List<Mobile> showCart() throws EmptyCartException {
		List<Mobile> mobileList=cartService.showCart();
		if (mobileList != null)  {
			return mobileList.stream().sorted(Comparator.comparing(Mobile::getBrand)).collect(Collectors.toList());
		}
		else {
		return mobileList;
		}
		
		
	}
      
      public String addToCart(Mobile mobile) throws MobileNotFoundException {
    	  cartService.addToCart(mobile);
    	  return "added successfully";
      }
      
      public boolean removeFromCart(Mobile mobile) throws MobileNotFoundException {
  		return false;
  	}
}
