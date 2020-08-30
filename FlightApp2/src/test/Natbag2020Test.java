package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import natabag2020.*;

public class Natbag2020Test {

	LandingFlights flight1 = new LandingFlights("el al", "normandy", "Israel", "20:20", "1944-06-06");
	LandingFlights flight2 = new LandingFlights("lufthansa", "monte cassino", "Israel", "22:20", "2020-06-06");
	LandingFlights flight3 = new LandingFlights("Arkia", "kursk", "Israel", "20:25", "2001-04-06");
	TakingOffFlights flight4 = new TakingOffFlights("Air France", "Israel", "verdun", "20:30", "1999-02-06");
	TakingOffFlights flight5 = new TakingOffFlights("Air Canada", "Israel", "el alamein", "20:35", "2011-01-06");
	TakingOffFlights flight6 = new TakingOffFlights("Turkish Airlines", "Israel", "Gallipoli", "20:45", "2000-06-06");
	ManagingClass Managing = new ManagingClass();

	// check input of company
	@Test
	public void test0() {
		if (!(flight1.getCompanyName().equals("el al"))) {
			fail("not the same");
		}
		if (!(flight2.getCompanyName().equals("lufthansa"))) {
			fail("not the same");
		}
		if (!(flight3.getCompanyName().equals("Arkia"))) {
			fail("not the same");
		}
		if (!(flight4.getCompanyName().equals("Air France"))) {
			fail("not the same");
		}
		if (!(flight5.getCompanyName().equals("Air Canada"))) {
			fail("not the same");
		}
		if (!(flight6.getCompanyName().equals("Turkish Airlines"))) {
			fail("not the same");
		}
		assertTrue(true);
	}

	// check input of landingSite
	@Test
	public void test1() {
		if (!(flight1.getLanding().equals("Israel"))) {
			fail("not the same");
		}
		if (!(flight2.getLanding().equals("Israel"))) {
			fail("not the same");
		}
		if (!(flight3.getLanding().equals("Israel"))) {
			fail("not the same");
		}
		if (!(flight4.getLanding().equals("verdun"))) {
			fail("not the same");
		}
		if (!(flight5.getLanding().equals("el alamein"))) {
			fail("not the same");
		}
		if (!(flight6.getLanding().equals("Gallipoli"))) {
			fail("not the same");
		}
		assertTrue(true);
	}

	// check input of takeOffSite
	@Test
	public void test2() {
		if (!(flight1.getTakeOff().equals("normandy"))) {
			fail("not the same");
		}
		if (!(flight2.getTakeOff().equals("monte cassino"))) {
			fail("not the same");
		}
		if (!(flight3.getTakeOff().equals("kursk"))) {
			fail("not the same");
		}
		if (!(flight4.getTakeOff().equals("Israel"))) {
			fail("not the same");
		}
		if (!(flight5.getTakeOff().equals("Israel"))) {
			fail("not the same");
		}
		if (!(flight6.getTakeOff().equals("Israel"))) {
			fail("not the same");
		}
		assertTrue(true);
	}

	// check input of Time
	@Test
	public void test3() {
		if (!(flight1.getTime().equals("20:20"))) {
			fail("not the same");
		}
		if (!(flight2.getTime().equals("22:20"))) {
			fail("not the same");
		}
		if (!(flight3.getTime().equals("20:25"))) {
			fail("not the same");
		}
		if (!(flight4.getTime().equals("20:30"))) {
			fail("not the same");
		}
		if (!(flight5.getTime().equals("20:35"))) {
			fail("not the same");
		}
		if (!(flight6.getTime().equals("20:45"))) {
			fail("not the same");
		}
		assertTrue(true);
	}

	// check input of date
	@Test
	public void test4() {
		if (!(flight1.getDate().equals("1944-06-06"))) {
			fail("not the same");
		}
		if (!(flight2.getDate().equals("2020-06-06"))) {
			fail("not the same");
		}
		if (!(flight3.getDate().equals("2001-04-06"))) {
			fail("not the same");
		}
		if (!(flight4.getDate().equals("1999-02-06"))) {
			fail("not the same");
		}
		if (!(flight5.getDate().equals("2011-01-06"))) {
			fail("not the same");
		}
		if (!(flight6.getDate().equals("2000-06-06"))) {
			fail("not the same");
		}
		assertTrue(true);
	}
	
	//check if the same object
	@Test
	public void test5() {
	this.Managing.addToLandingArray(flight1);
	this.Managing.addToLandingArray(flight2);
	this.Managing.addToLandingArray(flight3);
	this.Managing.addToTakingOfArray(flight4);
	this.Managing.addToTakingOfArray(flight5);
	this.Managing.addToTakingOfArray(flight6);
	
	if(Managing.landingFlights.get(0)!=flight1) {
		fail("not the same");
	}
	if(Managing.landingFlights.get(1)!=flight2) {
		fail("not the same");
	}
	if(Managing.landingFlights.get(2)!=flight3) {
		fail("not the same");
	}
	if(Managing.takingOfFlights.get(0)!=flight4) {
		fail("not the same");
	}
	if(Managing.takingOfFlights.get(1)!=flight5) {
		fail("not the same");
	}
	if(Managing.takingOfFlights.get(2)!=flight6) {
		fail("not the same");
	}
	assertTrue(true);
	}
	
	//check if isLater Function work 
	
	@Test
	public void test6() {
	assertFalse(this.flight2.isItLater(flight1));
	assertFalse(this.flight3.isItLater(flight4));
	assertFalse(this.flight5.isItLater(flight6));
	}
	
	//check if sort Function work 
	@Test
	public void test7() {
		
		ManagingClass.landingFlights=new ArrayList<>();
		ManagingClass.takingOfFlights=new ArrayList<>();
		this.Managing.numOflandingFlights=0;
		this.Managing.numOfTakeOffFlights=0;
		this.Managing.addToLandingArray(flight1);
		this.Managing.addToLandingArray(flight2);
		this.Managing.addToLandingArray(flight3);
		this.Managing.addToTakingOfArray(flight4);
		this.Managing.addToTakingOfArray(flight5);
		this.Managing.addToTakingOfArray(flight6);
		ManagingClass.sortLandingFlights();
		ManagingClass.sortTakingOfFlights();
		
		if(Managing.landingFlights.get(0)!=flight1) {
			fail("not the same");
		}
		if(Managing.landingFlights.get(1)!=flight3) {
			fail("not the same");
		}
		if(Managing.landingFlights.get(2)!=flight2) {
			fail("not the same");
		}
		if(Managing.takingOfFlights.get(0)!=flight4) {
			fail("not the same");
		}
		if(Managing.takingOfFlights.get(1)!=flight6) {
			fail("not the same");
		}
		if(Managing.takingOfFlights.get(2)!=flight5) {
			fail("not the same");
		}
		assertTrue(true);
		}
	
	//check how much flights
	@Test
	public void test8() {
		if(this.Managing.numOflandingFlights!=3) {
			fail("not the same");
		}
		assertTrue(true);
		}
	
	@Test
	public void test9() {
		if(this.Managing.numOfTakeOffFlights!=3) {
			fail("not the same");
		}
		assertTrue(true);
		}
	
		
	}
	
	


