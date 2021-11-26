package com.mobileapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mobileapp.exceptions.EmptyCartException;
import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;
import com.mobileapp.service.CartDetails;
import com.mobileapp.service.ICartService;


@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class CartDetailsTest {
	
	@Mock
	ICartService cartService;
	
		
	@InjectMocks
	CartDetails cartDetails;
	Mobile mobile1, mobile2, mobile3, mobile4, mobile5, mobile6;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		mobile1 = new Mobile(1, "Samsung", "a53", 26000);
		mobile2 = new Mobile(2, "Xiaomi", "c3", 16000);
		mobile3 = new Mobile(3, "Realme", "b2", 32000);
		mobile4 = new Mobile(4, "iphone", "3s", 10000);
		mobile5 = new Mobile(5, "iphone", "4a", 10000);
		mobile6 = new Mobile(6, "Samsung", "S21", 53000);
		List<Mobile> mobileData = Arrays.asList(mobile1, mobile2, mobile3, mobile4, mobile5, mobile6);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddCart() throws MobileNotFoundException {
		doNothing().when(cartService).addToCart(mobile1);
		String actual = cartDetails.addToCart(mobile1);
		String expected = "added successfully";
		assertEquals(expected, actual, "invalid");
	}
	
	@Test 
	void testAddCartException() throws MobileNotFoundException{
		doThrow(new MobileNotFoundException("invalid")).when(cartService).addToCart(mobile1);
		
		assertThrows(MobileNotFoundException.class,()->cartDetails.addToCart(mobile1));
	}
	
	@Test 
	void testShowCart() throws EmptyCartException{
		List<Mobile> mobileList=Arrays.asList(mobile1,mobile3,mobile2);
		doReturn(Arrays.asList(mobile1,mobile2,mobile3)).when(cartService).showCart();
		List<Mobile> actualMobileList=cartDetails.showCart();
		assertEquals(mobileList,actualMobileList,"not equal");
		
	}
	@Test 
	void testShowCartEmpty() throws EmptyCartException{
		when(cartService.showCart()).thenThrow(new EmptyCartException());
		assertThrows(EmptyCartException.class, ()->cartDetails.showCart());
		
	}
	
	@Test
	void testShowCartNull() throws MobileNotFoundException, EmptyCartException  {
		doReturn(null).when(cartService).showCart();
	    assertNull(cartDetails.showCart());
	}
	
	
	

}
 