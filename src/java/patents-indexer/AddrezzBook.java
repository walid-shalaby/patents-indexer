import java.util.List;

class Addrezz {
	protected String address1 = "";
	protected String address2 = "";
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @return the address3
	 */
	public String getAddress3() {
		return address3;
	}

	/**
	 * @return the mailcode
	 */
	public String getMailcode() {
		return mailcode;
	}

	/**
	 * @return the pobox
	 */
	public String getPobox() {
		return pobox;
	}

	/**
	 * @return the room
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * @return the addressFloor
	 */
	public String getAddressFloor() {
		return addressFloor;
	}

	/**
	 * @return the building
	 */
	public String getBuilding() {
		return building;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the county
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	protected String address3 = "";
	protected String mailcode = "";
	protected String pobox = "";
	protected String room = "";
	protected String addressFloor = "";
	protected String building = "";
	protected String street = "";
	protected String city = "";
	protected String county = "";
	protected String state = "";
	protected String postcode = "";
	protected String country = "";
	protected String text = "";
	
	Addrezz(xml.us.patent.grant.v45.Address address) {
		List<Object> lst = address.getAddress1OrAddress2OrAddress3OrMailcodeOrPoboxOrRoomOrAddressFloorOrBuildingOrStreetOrCityOrCountyOrStateOrPostcodeOrCountryOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v45.Address1.class) {
				address1 = ((xml.us.patent.grant.v45.Address1)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Address2.class) {
				address1 = ((xml.us.patent.grant.v45.Address2)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Address3.class) {
				address3 = ((xml.us.patent.grant.v45.Address3)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Mailcode.class) {
				mailcode = ((xml.us.patent.grant.v45.Mailcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Pobox.class) {
				pobox = ((xml.us.patent.grant.v45.Pobox)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Room.class) {
				room = ((xml.us.patent.grant.v45.Room)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.AddressFloor.class) {
				addressFloor = ((xml.us.patent.grant.v45.AddressFloor)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Building.class) {
				building = ((xml.us.patent.grant.v45.Building)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Street.class) {
				street = ((xml.us.patent.grant.v45.Street)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.City.class) {
				city = ((xml.us.patent.grant.v45.City)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.County.class) {
				county = ((xml.us.patent.grant.v45.County)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.State.class) {
				state = ((xml.us.patent.grant.v45.State)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Postcode.class) {
				postcode = ((xml.us.patent.grant.v45.Postcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Country.class) {
				country = ((xml.us.patent.grant.v45.Country)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Text.class) {
				text = ((xml.us.patent.grant.v45.Text)elem).getvalue();
			}
		}
	}
	
	Addrezz(xml.us.patent.grant.v44.Address address) {
		List<Object> lst = address.getAddress1OrAddress2OrAddress3OrMailcodeOrPoboxOrRoomOrAddressFloorOrBuildingOrStreetOrCityOrCountyOrStateOrPostcodeOrCountryOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v44.Address1.class) {
				address1 = ((xml.us.patent.grant.v44.Address1)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Address2.class) {
				address1 = ((xml.us.patent.grant.v44.Address2)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Address3.class) {
				address3 = ((xml.us.patent.grant.v44.Address3)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Mailcode.class) {
				mailcode = ((xml.us.patent.grant.v44.Mailcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Pobox.class) {
				pobox = ((xml.us.patent.grant.v44.Pobox)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Room.class) {
				room = ((xml.us.patent.grant.v44.Room)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.AddressFloor.class) {
				addressFloor = ((xml.us.patent.grant.v44.AddressFloor)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Building.class) {
				building = ((xml.us.patent.grant.v44.Building)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Street.class) {
				street = ((xml.us.patent.grant.v44.Street)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.City.class) {
				city = ((xml.us.patent.grant.v44.City)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.County.class) {
				county = ((xml.us.patent.grant.v44.County)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.State.class) {
				state = ((xml.us.patent.grant.v44.State)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Postcode.class) {
				postcode = ((xml.us.patent.grant.v44.Postcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Country.class) {
				country = ((xml.us.patent.grant.v44.Country)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Text.class) {
				text = ((xml.us.patent.grant.v44.Text)elem).getvalue();
			}
		}
	}
	
	Addrezz(xml.us.patent.grant.v43.Address address) {
		List<Object> lst = address.getAddress1OrAddress2OrAddress3OrMailcodeOrPoboxOrRoomOrAddressFloorOrBuildingOrStreetOrCityOrCountyOrStateOrPostcodeOrCountryOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v43.Address1.class) {
				address1 = ((xml.us.patent.grant.v43.Address1)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Address2.class) {
				address1 = ((xml.us.patent.grant.v43.Address2)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Address3.class) {
				address3 = ((xml.us.patent.grant.v43.Address3)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Mailcode.class) {
				mailcode = ((xml.us.patent.grant.v43.Mailcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Pobox.class) {
				pobox = ((xml.us.patent.grant.v43.Pobox)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Room.class) {
				room = ((xml.us.patent.grant.v43.Room)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.AddressFloor.class) {
				addressFloor = ((xml.us.patent.grant.v43.AddressFloor)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Building.class) {
				building = ((xml.us.patent.grant.v43.Building)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Street.class) {
				street = ((xml.us.patent.grant.v43.Street)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.City.class) {
				city = ((xml.us.patent.grant.v43.City)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.County.class) {
				county = ((xml.us.patent.grant.v43.County)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.State.class) {
				state = ((xml.us.patent.grant.v43.State)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Postcode.class) {
				postcode = ((xml.us.patent.grant.v43.Postcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Country.class) {
				country = ((xml.us.patent.grant.v43.Country)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Text.class) {
				text = ((xml.us.patent.grant.v43.Text)elem).getvalue();
			}
		}
	}
	
	Addrezz(xml.us.patent.grant.v42.Address address) {
		List<Object> lst = address.getAddress1OrAddress2OrAddress3OrMailcodeOrPoboxOrRoomOrAddressFloorOrBuildingOrStreetOrCityOrCountyOrStateOrPostcodeOrCountryOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v42.Address1.class) {
				address1 = ((xml.us.patent.grant.v42.Address1)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Address2.class) {
				address1 = ((xml.us.patent.grant.v42.Address2)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Address3.class) {
				address3 = ((xml.us.patent.grant.v42.Address3)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Mailcode.class) {
				mailcode = ((xml.us.patent.grant.v42.Mailcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Pobox.class) {
				pobox = ((xml.us.patent.grant.v42.Pobox)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Room.class) {
				room = ((xml.us.patent.grant.v42.Room)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.AddressFloor.class) {
				addressFloor = ((xml.us.patent.grant.v42.AddressFloor)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Building.class) {
				building = ((xml.us.patent.grant.v42.Building)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Street.class) {
				street = ((xml.us.patent.grant.v42.Street)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.City.class) {
				city = ((xml.us.patent.grant.v42.City)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.County.class) {
				county = ((xml.us.patent.grant.v42.County)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.State.class) {
				state = ((xml.us.patent.grant.v42.State)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Postcode.class) {
				postcode = ((xml.us.patent.grant.v42.Postcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Country.class) {
				country = ((xml.us.patent.grant.v42.Country)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Text.class) {
				text = ((xml.us.patent.grant.v42.Text)elem).getvalue();
			}
		}
	}
	
	Addrezz(xml.us.patent.grant.v41.Address address) {
		List<Object> lst = address.getAddress1OrAddress2OrAddress3OrMailcodeOrPoboxOrRoomOrAddressFloorOrBuildingOrStreetOrCityOrCountyOrStateOrPostcodeOrCountryOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v41.Address1.class) {
				address1 = ((xml.us.patent.grant.v41.Address1)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Address2.class) {
				address1 = ((xml.us.patent.grant.v41.Address2)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Address3.class) {
				address3 = ((xml.us.patent.grant.v41.Address3)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Mailcode.class) {
				mailcode = ((xml.us.patent.grant.v41.Mailcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Pobox.class) {
				pobox = ((xml.us.patent.grant.v41.Pobox)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Room.class) {
				room = ((xml.us.patent.grant.v41.Room)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.AddressFloor.class) {
				addressFloor = ((xml.us.patent.grant.v41.AddressFloor)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Building.class) {
				building = ((xml.us.patent.grant.v41.Building)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Street.class) {
				street = ((xml.us.patent.grant.v41.Street)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.City.class) {
				city = ((xml.us.patent.grant.v41.City)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.County.class) {
				county = ((xml.us.patent.grant.v41.County)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.State.class) {
				state = ((xml.us.patent.grant.v41.State)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Postcode.class) {
				postcode = ((xml.us.patent.grant.v41.Postcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Country.class) {
				country = ((xml.us.patent.grant.v41.Country)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Text.class) {
				text = ((xml.us.patent.grant.v41.Text)elem).getvalue();
			}
		}
	}
	
	Addrezz(xml.us.patent.grant.v40_041202.Address address) {
		List<Object> lst = address.getAddress1OrAddress2OrAddress3OrMailcodeOrPoboxOrRoomOrAddressFloorOrBuildingOrStreetOrCityOrCountyOrStateOrPostcodeOrCountryOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v40_041202.Address1.class) {
				address1 = ((xml.us.patent.grant.v40_041202.Address1)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Address2.class) {
				address1 = ((xml.us.patent.grant.v40_041202.Address2)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Address3.class) {
				address3 = ((xml.us.patent.grant.v40_041202.Address3)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Mailcode.class) {
				mailcode = ((xml.us.patent.grant.v40_041202.Mailcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Pobox.class) {
				pobox = ((xml.us.patent.grant.v40_041202.Pobox)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Room.class) {
				room = ((xml.us.patent.grant.v40_041202.Room)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.AddressFloor.class) {
				addressFloor = ((xml.us.patent.grant.v40_041202.AddressFloor)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Building.class) {
				building = ((xml.us.patent.grant.v40_041202.Building)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Street.class) {
				street = ((xml.us.patent.grant.v40_041202.Street)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.City.class) {
				city = ((xml.us.patent.grant.v40_041202.City)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.County.class) {
				county = ((xml.us.patent.grant.v40_041202.County)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.State.class) {
				state = ((xml.us.patent.grant.v40_041202.State)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Postcode.class) {
				postcode = ((xml.us.patent.grant.v40_041202.Postcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Country.class) {
				country = ((xml.us.patent.grant.v40_041202.Country)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Text.class) {
				text = ((xml.us.patent.grant.v40_041202.Text)elem).getvalue();
			}
		}
	}
	
	Addrezz(xml.us.patent.application.v44.Address address) {
		List<Object> lst = address.getAddress1OrAddress2OrAddress3OrMailcodeOrPoboxOrRoomOrAddressFloorOrBuildingOrStreetOrCityOrCountyOrStateOrPostcodeOrCountryOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v44.Address1.class) {
				address1 = ((xml.us.patent.application.v44.Address1)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Address2.class) {
				address1 = ((xml.us.patent.application.v44.Address2)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Address3.class) {
				address3 = ((xml.us.patent.application.v44.Address3)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Mailcode.class) {
				mailcode = ((xml.us.patent.application.v44.Mailcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Pobox.class) {
				pobox = ((xml.us.patent.application.v44.Pobox)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Room.class) {
				room = ((xml.us.patent.application.v44.Room)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.AddressFloor.class) {
				addressFloor = ((xml.us.patent.application.v44.AddressFloor)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Building.class) {
				building = ((xml.us.patent.application.v44.Building)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Street.class) {
				street = ((xml.us.patent.application.v44.Street)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.City.class) {
				city = ((xml.us.patent.application.v44.City)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.County.class) {
				county = ((xml.us.patent.application.v44.County)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.State.class) {
				state = ((xml.us.patent.application.v44.State)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Postcode.class) {
				postcode = ((xml.us.patent.application.v44.Postcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Country.class) {
				country = ((xml.us.patent.application.v44.Country)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Text.class) {
				text = ((xml.us.patent.application.v44.Text)elem).getvalue();
			}
		}
	}
	
	Addrezz(xml.us.patent.application.v43.Address address) {
		List<Object> lst = address.getAddress1OrAddress2OrAddress3OrMailcodeOrPoboxOrRoomOrAddressFloorOrBuildingOrStreetOrCityOrCountyOrStateOrPostcodeOrCountryOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v43.Address1.class) {
				address1 = ((xml.us.patent.application.v43.Address1)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Address2.class) {
				address1 = ((xml.us.patent.application.v43.Address2)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Address3.class) {
				address3 = ((xml.us.patent.application.v43.Address3)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Mailcode.class) {
				mailcode = ((xml.us.patent.application.v43.Mailcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Pobox.class) {
				pobox = ((xml.us.patent.application.v43.Pobox)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Room.class) {
				room = ((xml.us.patent.application.v43.Room)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.AddressFloor.class) {
				addressFloor = ((xml.us.patent.application.v43.AddressFloor)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Building.class) {
				building = ((xml.us.patent.application.v43.Building)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Street.class) {
				street = ((xml.us.patent.application.v43.Street)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.City.class) {
				city = ((xml.us.patent.application.v43.City)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.County.class) {
				county = ((xml.us.patent.application.v43.County)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.State.class) {
				state = ((xml.us.patent.application.v43.State)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Postcode.class) {
				postcode = ((xml.us.patent.application.v43.Postcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Country.class) {
				country = ((xml.us.patent.application.v43.Country)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Text.class) {
				text = ((xml.us.patent.application.v43.Text)elem).getvalue();
			}
		}
	}
	
	Addrezz(xml.us.patent.application.v42.Address address) {
		List<Object> lst = address.getAddress1OrAddress2OrAddress3OrMailcodeOrPoboxOrRoomOrAddressFloorOrBuildingOrStreetOrCityOrCountyOrStateOrPostcodeOrCountryOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v42.Address1.class) {
				address1 = ((xml.us.patent.application.v42.Address1)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Address2.class) {
				address1 = ((xml.us.patent.application.v42.Address2)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Address3.class) {
				address3 = ((xml.us.patent.application.v42.Address3)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Mailcode.class) {
				mailcode = ((xml.us.patent.application.v42.Mailcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Pobox.class) {
				pobox = ((xml.us.patent.application.v42.Pobox)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Room.class) {
				room = ((xml.us.patent.application.v42.Room)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.AddressFloor.class) {
				addressFloor = ((xml.us.patent.application.v42.AddressFloor)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Building.class) {
				building = ((xml.us.patent.application.v42.Building)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Street.class) {
				street = ((xml.us.patent.application.v42.Street)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.City.class) {
				city = ((xml.us.patent.application.v42.City)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.County.class) {
				county = ((xml.us.patent.application.v42.County)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.State.class) {
				state = ((xml.us.patent.application.v42.State)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Postcode.class) {
				postcode = ((xml.us.patent.application.v42.Postcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Country.class) {
				country = ((xml.us.patent.application.v42.Country)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Text.class) {
				text = ((xml.us.patent.application.v42.Text)elem).getvalue();
			}
		}
	}
	
	Addrezz(xml.us.patent.application.v41.Address address) {
		List<Object> lst = address.getAddress1OrAddress2OrAddress3OrMailcodeOrPoboxOrRoomOrAddressFloorOrBuildingOrStreetOrCityOrCountyOrStateOrPostcodeOrCountryOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v41.Address1.class) {
				address1 = ((xml.us.patent.application.v41.Address1)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Address2.class) {
				address1 = ((xml.us.patent.application.v41.Address2)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Address3.class) {
				address3 = ((xml.us.patent.application.v41.Address3)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Mailcode.class) {
				mailcode = ((xml.us.patent.application.v41.Mailcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Pobox.class) {
				pobox = ((xml.us.patent.application.v41.Pobox)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Room.class) {
				room = ((xml.us.patent.application.v41.Room)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.AddressFloor.class) {
				addressFloor = ((xml.us.patent.application.v41.AddressFloor)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Building.class) {
				building = ((xml.us.patent.application.v41.Building)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Street.class) {
				street = ((xml.us.patent.application.v41.Street)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.City.class) {
				city = ((xml.us.patent.application.v41.City)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.County.class) {
				county = ((xml.us.patent.application.v41.County)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.State.class) {
				state = ((xml.us.patent.application.v41.State)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Postcode.class) {
				postcode = ((xml.us.patent.application.v41.Postcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Country.class) {
				country = ((xml.us.patent.application.v41.Country)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Text.class) {
				text = ((xml.us.patent.application.v41.Text)elem).getvalue();
			}
		}
	}
	
	Addrezz(xml.us.patent.application.v40_041202.Address address) {
		List<Object> lst = address.getAddress1OrAddress2OrAddress3OrMailcodeOrPoboxOrRoomOrAddressFloorOrBuildingOrStreetOrCityOrCountyOrStateOrPostcodeOrCountryOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v40_041202.Address1.class) {
				address1 = ((xml.us.patent.application.v40_041202.Address1)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Address2.class) {
				address1 = ((xml.us.patent.application.v40_041202.Address2)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Address3.class) {
				address3 = ((xml.us.patent.application.v40_041202.Address3)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Mailcode.class) {
				mailcode = ((xml.us.patent.application.v40_041202.Mailcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Pobox.class) {
				pobox = ((xml.us.patent.application.v40_041202.Pobox)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Room.class) {
				room = ((xml.us.patent.application.v40_041202.Room)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.AddressFloor.class) {
				addressFloor = ((xml.us.patent.application.v40_041202.AddressFloor)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Building.class) {
				building = ((xml.us.patent.application.v40_041202.Building)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Street.class) {
				street = ((xml.us.patent.application.v40_041202.Street)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.City.class) {
				city = ((xml.us.patent.application.v40_041202.City)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.County.class) {
				county = ((xml.us.patent.application.v40_041202.County)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.State.class) {
				state = ((xml.us.patent.application.v40_041202.State)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Postcode.class) {
				postcode = ((xml.us.patent.application.v40_041202.Postcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Country.class) {
				country = ((xml.us.patent.application.v40_041202.Country)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Text.class) {
				text = ((xml.us.patent.application.v40_041202.Text)elem).getvalue();
			}
		}
	}
	
	Addrezz(xml.us.patent.application.v40_041028.Address address) {
		List<Object> lst = address.getAddress1OrAddress2OrAddress3OrMailcodeOrPoboxOrRoomOrAddressFloorOrBuildingOrStreetOrCityOrCountyOrStateOrPostcodeOrCountryOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v40_041028.Address1.class) {
				address1 = ((xml.us.patent.application.v40_041028.Address1)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Address2.class) {
				address1 = ((xml.us.patent.application.v40_041028.Address2)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Address3.class) {
				address3 = ((xml.us.patent.application.v40_041028.Address3)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Mailcode.class) {
				mailcode = ((xml.us.patent.application.v40_041028.Mailcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Pobox.class) {
				pobox = ((xml.us.patent.application.v40_041028.Pobox)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Room.class) {
				room = ((xml.us.patent.application.v40_041028.Room)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.AddressFloor.class) {
				addressFloor = ((xml.us.patent.application.v40_041028.AddressFloor)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Building.class) {
				building = ((xml.us.patent.application.v40_041028.Building)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Street.class) {
				street = ((xml.us.patent.application.v40_041028.Street)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.City.class) {
				city = ((xml.us.patent.application.v40_041028.City)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.County.class) {
				county = ((xml.us.patent.application.v40_041028.County)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.State.class) {
				state = ((xml.us.patent.application.v40_041028.State)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Postcode.class) {
				postcode = ((xml.us.patent.application.v40_041028.Postcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Country.class) {
				country = ((xml.us.patent.application.v40_041028.Country)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Text.class) {
				text = ((xml.us.patent.application.v40_041028.Text)elem).getvalue();
			}
		}
	}
	
	Addrezz(xml.us.patent.application.v40_040927.Address address) {
		List<Object> lst = address.getAddress1OrAddress2OrAddress3OrMailcodeOrPoboxOrRoomOrAddressFloorOrBuildingOrStreetOrCityOrCountyOrStateOrPostcodeOrCountryOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v40_040927.Address1.class) {
				address1 = ((xml.us.patent.application.v40_040927.Address1)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Address2.class) {
				address1 = ((xml.us.patent.application.v40_040927.Address2)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Address3.class) {
				address3 = ((xml.us.patent.application.v40_040927.Address3)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Mailcode.class) {
				mailcode = ((xml.us.patent.application.v40_040927.Mailcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Pobox.class) {
				pobox = ((xml.us.patent.application.v40_040927.Pobox)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Room.class) {
				room = ((xml.us.patent.application.v40_040927.Room)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.AddressFloor.class) {
				addressFloor = ((xml.us.patent.application.v40_040927.AddressFloor)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Building.class) {
				building = ((xml.us.patent.application.v40_040927.Building)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Street.class) {
				street = ((xml.us.patent.application.v40_040927.Street)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.City.class) {
				city = ((xml.us.patent.application.v40_040927.City)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.County.class) {
				county = ((xml.us.patent.application.v40_040927.County)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.State.class) {
				state = ((xml.us.patent.application.v40_040927.State)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Postcode.class) {
				postcode = ((xml.us.patent.application.v40_040927.Postcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Country.class) {
				country = ((xml.us.patent.application.v40_040927.Country)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Text.class) {
				text = ((xml.us.patent.application.v40_040927.Text)elem).getvalue();
			}
		}
	}
	
	Addrezz(xml.us.patent.application.v40_040908.Address address) {
		List<Object> lst = address.getAddress1OrAddress2OrAddress3OrMailcodeOrPoboxOrRoomOrAddressFloorOrBuildingOrStreetOrCityOrCountyOrStateOrPostcodeOrCountryOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v40_040908.Address1.class) {
				address1 = ((xml.us.patent.application.v40_040908.Address1)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Address2.class) {
				address1 = ((xml.us.patent.application.v40_040908.Address2)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Address3.class) {
				address3 = ((xml.us.patent.application.v40_040908.Address3)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Mailcode.class) {
				mailcode = ((xml.us.patent.application.v40_040908.Mailcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Pobox.class) {
				pobox = ((xml.us.patent.application.v40_040908.Pobox)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Room.class) {
				room = ((xml.us.patent.application.v40_040908.Room)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.AddressFloor.class) {
				addressFloor = ((xml.us.patent.application.v40_040908.AddressFloor)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Building.class) {
				building = ((xml.us.patent.application.v40_040908.Building)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Street.class) {
				street = ((xml.us.patent.application.v40_040908.Street)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.City.class) {
				city = ((xml.us.patent.application.v40_040908.City)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.County.class) {
				county = ((xml.us.patent.application.v40_040908.County)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.State.class) {
				state = ((xml.us.patent.application.v40_040908.State)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Postcode.class) {
				postcode = ((xml.us.patent.application.v40_040908.Postcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Country.class) {
				country = ((xml.us.patent.application.v40_040908.Country)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Text.class) {
				text = ((xml.us.patent.application.v40_040908.Text)elem).getvalue();
			}
		}
	}
	
	Addrezz(xml.us.patent.application.v40_040415.Address address) {
		List<Object> lst = address.getAddress1OrAddress2OrAddress3OrMailcodeOrPoboxOrRoomOrAddressFloorOrBuildingOrStreetOrCityOrCountyOrStateOrPostcodeOrCountryOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v40_040415.Address1.class) {
				address1 = ((xml.us.patent.application.v40_040415.Address1)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Address2.class) {
				address1 = ((xml.us.patent.application.v40_040415.Address2)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Address3.class) {
				address3 = ((xml.us.patent.application.v40_040415.Address3)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Mailcode.class) {
				mailcode = ((xml.us.patent.application.v40_040415.Mailcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Pobox.class) {
				pobox = ((xml.us.patent.application.v40_040415.Pobox)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Room.class) {
				room = ((xml.us.patent.application.v40_040415.Room)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.AddressFloor.class) {
				addressFloor = ((xml.us.patent.application.v40_040415.AddressFloor)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Building.class) {
				building = ((xml.us.patent.application.v40_040415.Building)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Street.class) {
				street = ((xml.us.patent.application.v40_040415.Street)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.City.class) {
				city = ((xml.us.patent.application.v40_040415.City)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.County.class) {
				county = ((xml.us.patent.application.v40_040415.County)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.State.class) {
				state = ((xml.us.patent.application.v40_040415.State)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Postcode.class) {
				postcode = ((xml.us.patent.application.v40_040415.Postcode)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Country.class) {
				country = ((xml.us.patent.application.v40_040415.Country)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Text.class) {
				text = ((xml.us.patent.application.v40_040415.Text)elem).getvalue();
			}
		}
	}

	public Addrezz(xml.us.patent.grant.vST32_025xml.ADR addr) {
		// TODO Auto-generated constructor stub
		xml.us.patent.grant.vST32_025xml.CITY city = addr.getCITY();
		if(city!=null)
			this.city = city.getPDAT().getvalue();
		
		xml.us.patent.grant.vST32_025xml.CNTY county = addr.getCNTY();
		if(county!=null)
			this.county = county.getPDAT().getvalue();
		
		xml.us.patent.grant.vST32_025xml.CTRY country = addr.getCTRY();
		if(country!=null)
			this.country = country.getPDAT().getvalue();
		
		xml.us.patent.grant.vST32_025xml.STATE state = addr.getSTATE();
		if(state!=null)
			this.state = state.getPDAT().getvalue();

		xml.us.patent.grant.vST32_025xml.PCODE pcode = addr.getPCODE();
		if(pcode!=null)
			this.postcode = pcode.getPDAT().getvalue();
	}

	public Addrezz(xml.us.patent.grant.vST32_024.ADR addr) {
		// TODO Auto-generated constructor stub
		xml.us.patent.grant.vST32_024.CITY city = addr.getCITY();
		if(city!=null)
			this.city = city.getPDAT().getvalue();
		
		xml.us.patent.grant.vST32_024.CNTY county = addr.getCNTY();
		if(county!=null)
			this.county = county.getPDAT().getvalue();
		
		xml.us.patent.grant.vST32_024.CTRY country = addr.getCTRY();
		if(country!=null)
			this.country = country.getPDAT().getvalue();
		
		xml.us.patent.grant.vST32_024.STATE state = addr.getSTATE();
		if(state!=null)
			this.state = state.getPDAT().getvalue();

		xml.us.patent.grant.vST32_024.PCODE pcode = addr.getPCODE();
		if(pcode!=null)
			this.postcode = pcode.getPDAT().getvalue();
	}

	public Addrezz(xml.us.patent.application.v16.Address address) {
		// TODO Auto-generated constructor stub
		address1 = address.getAddress1();
		address2 = address.getAddress2();
		city = address.getCity();
		if(address.getCountry()!=null)
			country = address.getCountry().getCountryCode().getvalue();
		
		postcode = address.getPostalcode();
		
		state = address.getState();
	}
}

public class AddrezzBook {
	protected String name = "";
	protected String prefix = "";
	protected String lastName = "";
	protected String orgname = "";
	protected String firstName = "";
	protected String middleName = "";
	protected String suffix = "";
	protected String iid = "";
	protected String role = "";
	protected String department = "";
	protected String synonym = "";
	protected String registeredNumber = "";
	protected String phone = "";
	protected String fax = "";
	protected String email = "";
	protected String url = "";
	protected String ead = "";
	protected String dtext = "";
	protected String text = "";
	protected Addrezz addrezz = null;
	protected AddrezzBook addrezzbook = null;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the orgname
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * @return the iid
	 */
	public String getIid() {
		return iid;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @return the synonym
	 */
	public String getSynonym() {
		return synonym;
	}

	/**
	 * @return the registeredNumber
	 */
	public String getRegisteredNumber() {
		return registeredNumber;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the ead
	 */
	public String getEad() {
		return ead;
	}

	/**
	 * @return the dtext
	 */
	public String getDtext() {
		return dtext;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the address
	 */
	public Addrezz getAddrezz() {
		return addrezz;
	}

	AddrezzBook(xml.us.patent.grant.v45.Addressbook inventorAddressbookDet) {
		List<Object> lst = inventorAddressbookDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressOrPhoneOrFaxOrEmailOrUrlOrEadOrDtextOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v45.Name.class) {
				name = ((xml.us.patent.grant.v45.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Prefix.class) {
				prefix = ((xml.us.patent.grant.v45.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.LastName.class) {
				lastName = ((xml.us.patent.grant.v45.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.FirstName.class) {
				firstName = ((xml.us.patent.grant.v45.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Orgname.class) {
				orgname = ((xml.us.patent.grant.v45.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.MiddleName.class) {
				middleName = ((xml.us.patent.grant.v45.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Suffix.class) {
				suffix = ((xml.us.patent.grant.v45.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Iid.class) {
				iid = ((xml.us.patent.grant.v45.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Role.class) {
				role = ((xml.us.patent.grant.v45.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Department.class) {
				department = ((xml.us.patent.grant.v45.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Synonym.class) {
				synonym = ((xml.us.patent.grant.v45.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.grant.v45.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Address.class) {
				addrezz = new Addrezz((xml.us.patent.grant.v45.Address)elem);
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Phone.class) {
				phone = ((xml.us.patent.grant.v45.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Fax.class) {
				fax = ((xml.us.patent.grant.v45.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Email.class) {
				email = ((xml.us.patent.grant.v45.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Url.class) {
				url = ((xml.us.patent.grant.v45.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Ead.class) {
				ead = ((xml.us.patent.grant.v45.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Dtext.class) {
				dtext = ((xml.us.patent.grant.v45.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Text.class) {
				text = ((xml.us.patent.grant.v45.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.grant.v44.Addressbook inventorAddressbookDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = inventorAddressbookDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressOrPhoneOrFaxOrEmailOrUrlOrEadOrDtextOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v44.Name.class) {
				name = ((xml.us.patent.grant.v44.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Prefix.class) {
				prefix = ((xml.us.patent.grant.v44.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.LastName.class) {
				lastName = ((xml.us.patent.grant.v44.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.FirstName.class) {
				firstName = ((xml.us.patent.grant.v44.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Orgname.class) {
				orgname = ((xml.us.patent.grant.v44.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.MiddleName.class) {
				middleName = ((xml.us.patent.grant.v44.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Suffix.class) {
				suffix = ((xml.us.patent.grant.v44.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Iid.class) {
				iid = ((xml.us.patent.grant.v44.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Role.class) {
				role = ((xml.us.patent.grant.v44.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Department.class) {
				department = ((xml.us.patent.grant.v44.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Synonym.class) {
				synonym = ((xml.us.patent.grant.v44.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.grant.v44.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Address.class) {
				addrezz = new Addrezz((xml.us.patent.grant.v44.Address)elem);
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Phone.class) {
				phone = ((xml.us.patent.grant.v44.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Fax.class) {
				fax = ((xml.us.patent.grant.v44.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Email.class) {
				email = ((xml.us.patent.grant.v44.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Url.class) {
				url = ((xml.us.patent.grant.v44.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Ead.class) {
				ead = ((xml.us.patent.grant.v44.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Dtext.class) {
				dtext = ((xml.us.patent.grant.v44.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Text.class) {
				text = ((xml.us.patent.grant.v44.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.grant.v43.Addressbook inventorAddressbookDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = inventorAddressbookDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressOrPhoneOrFaxOrEmailOrUrlOrEadOrDtextOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v43.Name.class) {
				name = ((xml.us.patent.grant.v43.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Prefix.class) {
				prefix = ((xml.us.patent.grant.v43.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.LastName.class) {
				lastName = ((xml.us.patent.grant.v43.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.FirstName.class) {
				firstName = ((xml.us.patent.grant.v43.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Orgname.class) {
				orgname = ((xml.us.patent.grant.v43.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.MiddleName.class) {
				middleName = ((xml.us.patent.grant.v43.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Suffix.class) {
				suffix = ((xml.us.patent.grant.v43.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Iid.class) {
				iid = ((xml.us.patent.grant.v43.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Role.class) {
				role = ((xml.us.patent.grant.v43.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Department.class) {
				department = ((xml.us.patent.grant.v43.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Synonym.class) {
				synonym = ((xml.us.patent.grant.v43.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.grant.v43.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Address.class) {
				addrezz = new Addrezz((xml.us.patent.grant.v43.Address)elem);
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Phone.class) {
				phone = ((xml.us.patent.grant.v43.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Fax.class) {
				fax = ((xml.us.patent.grant.v43.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Email.class) {
				email = ((xml.us.patent.grant.v43.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Url.class) {
				url = ((xml.us.patent.grant.v43.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Ead.class) {
				ead = ((xml.us.patent.grant.v43.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Dtext.class) {
				dtext = ((xml.us.patent.grant.v43.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Text.class) {
				text = ((xml.us.patent.grant.v43.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.grant.v42.Addressbook inventorAddressbookDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = inventorAddressbookDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressOrPhoneOrFaxOrEmailOrUrlOrEadOrDtextOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v42.Name.class) {
				name = ((xml.us.patent.grant.v42.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Prefix.class) {
				prefix = ((xml.us.patent.grant.v42.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.LastName.class) {
				lastName = ((xml.us.patent.grant.v42.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.FirstName.class) {
				firstName = ((xml.us.patent.grant.v42.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Orgname.class) {
				orgname = ((xml.us.patent.grant.v42.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.MiddleName.class) {
				middleName = ((xml.us.patent.grant.v42.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Suffix.class) {
				suffix = ((xml.us.patent.grant.v42.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Iid.class) {
				iid = ((xml.us.patent.grant.v42.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Role.class) {
				role = ((xml.us.patent.grant.v42.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Department.class) {
				department = ((xml.us.patent.grant.v42.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Synonym.class) {
				synonym = ((xml.us.patent.grant.v42.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.grant.v42.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Address.class) {
				addrezz = new Addrezz((xml.us.patent.grant.v42.Address)elem);
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Phone.class) {
				phone = ((xml.us.patent.grant.v42.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Fax.class) {
				fax = ((xml.us.patent.grant.v42.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Email.class) {
				email = ((xml.us.patent.grant.v42.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Url.class) {
				url = ((xml.us.patent.grant.v42.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Ead.class) {
				ead = ((xml.us.patent.grant.v42.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Dtext.class) {
				dtext = ((xml.us.patent.grant.v42.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Text.class) {
				text = ((xml.us.patent.grant.v42.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.grant.v41.Addressbook inventorAddressbookDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = inventorAddressbookDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressOrPhoneOrFaxOrEmailOrUrlOrEadOrDtextOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v41.Name.class) {
				name = ((xml.us.patent.grant.v41.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Prefix.class) {
				prefix = ((xml.us.patent.grant.v41.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.LastName.class) {
				lastName = ((xml.us.patent.grant.v41.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.FirstName.class) {
				firstName = ((xml.us.patent.grant.v41.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Orgname.class) {
				orgname = ((xml.us.patent.grant.v41.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.MiddleName.class) {
				middleName = ((xml.us.patent.grant.v41.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Suffix.class) {
				suffix = ((xml.us.patent.grant.v41.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Iid.class) {
				iid = ((xml.us.patent.grant.v41.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Role.class) {
				role = ((xml.us.patent.grant.v41.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Department.class) {
				department = ((xml.us.patent.grant.v41.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Synonym.class) {
				synonym = ((xml.us.patent.grant.v41.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.grant.v41.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Address.class) {
				addrezz = new Addrezz((xml.us.patent.grant.v41.Address)elem);
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Phone.class) {
				phone = ((xml.us.patent.grant.v41.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Fax.class) {
				fax = ((xml.us.patent.grant.v41.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Email.class) {
				email = ((xml.us.patent.grant.v41.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Url.class) {
				url = ((xml.us.patent.grant.v41.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Ead.class) {
				ead = ((xml.us.patent.grant.v41.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Dtext.class) {
				dtext = ((xml.us.patent.grant.v41.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Text.class) {
				text = ((xml.us.patent.grant.v41.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.grant.v40_041202.Addressbook inventorAddressbookDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = inventorAddressbookDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressOrPhoneOrFaxOrEmailOrUrlOrEadOrDtextOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v40_041202.Name.class) {
				name = ((xml.us.patent.grant.v40_041202.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Prefix.class) {
				prefix = ((xml.us.patent.grant.v40_041202.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.LastName.class) {
				lastName = ((xml.us.patent.grant.v40_041202.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.FirstName.class) {
				firstName = ((xml.us.patent.grant.v40_041202.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Orgname.class) {
				orgname = ((xml.us.patent.grant.v40_041202.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.MiddleName.class) {
				middleName = ((xml.us.patent.grant.v40_041202.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Suffix.class) {
				suffix = ((xml.us.patent.grant.v40_041202.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Iid.class) {
				iid = ((xml.us.patent.grant.v40_041202.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Role.class) {
				role = ((xml.us.patent.grant.v40_041202.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Department.class) {
				department = ((xml.us.patent.grant.v40_041202.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Synonym.class) {
				synonym = ((xml.us.patent.grant.v40_041202.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.grant.v40_041202.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Address.class) {
				addrezz = new Addrezz((xml.us.patent.grant.v40_041202.Address)elem);
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Phone.class) {
				phone = ((xml.us.patent.grant.v40_041202.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Fax.class) {
				fax = ((xml.us.patent.grant.v40_041202.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Email.class) {
				email = ((xml.us.patent.grant.v40_041202.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Url.class) {
				url = ((xml.us.patent.grant.v40_041202.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Ead.class) {
				ead = ((xml.us.patent.grant.v40_041202.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Dtext.class) {
				dtext = ((xml.us.patent.grant.v40_041202.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Text.class) {
				text = ((xml.us.patent.grant.v40_041202.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v44.Addressbook inventorAddressbookDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = inventorAddressbookDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressOrPhoneOrFaxOrEmailOrUrlOrEadOrDtextOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v44.Name.class) {
				name = ((xml.us.patent.application.v44.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Prefix.class) {
				prefix = ((xml.us.patent.application.v44.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.LastName.class) {
				lastName = ((xml.us.patent.application.v44.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.FirstName.class) {
				firstName = ((xml.us.patent.application.v44.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Orgname.class) {
				orgname = ((xml.us.patent.application.v44.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.MiddleName.class) {
				middleName = ((xml.us.patent.application.v44.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Suffix.class) {
				suffix = ((xml.us.patent.application.v44.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Iid.class) {
				iid = ((xml.us.patent.application.v44.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Role.class) {
				role = ((xml.us.patent.application.v44.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Department.class) {
				department = ((xml.us.patent.application.v44.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Synonym.class) {
				synonym = ((xml.us.patent.application.v44.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v44.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Address.class) {
				addrezz = new Addrezz((xml.us.patent.application.v44.Address)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Phone.class) {
				phone = ((xml.us.patent.application.v44.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Fax.class) {
				fax = ((xml.us.patent.application.v44.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Email.class) {
				email = ((xml.us.patent.application.v44.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Url.class) {
				url = ((xml.us.patent.application.v44.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Ead.class) {
				ead = ((xml.us.patent.application.v44.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Dtext.class) {
				dtext = ((xml.us.patent.application.v44.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Text.class) {
				text = ((xml.us.patent.application.v44.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v43.Addressbook inventorAddressbookDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = inventorAddressbookDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressOrPhoneOrFaxOrEmailOrUrlOrEadOrDtextOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v43.Name.class) {
				name = ((xml.us.patent.application.v43.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Prefix.class) {
				prefix = ((xml.us.patent.application.v43.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.LastName.class) {
				lastName = ((xml.us.patent.application.v43.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.FirstName.class) {
				firstName = ((xml.us.patent.application.v43.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Orgname.class) {
				orgname = ((xml.us.patent.application.v43.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.MiddleName.class) {
				middleName = ((xml.us.patent.application.v43.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Suffix.class) {
				suffix = ((xml.us.patent.application.v43.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Iid.class) {
				iid = ((xml.us.patent.application.v43.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Role.class) {
				role = ((xml.us.patent.application.v43.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Department.class) {
				department = ((xml.us.patent.application.v43.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Synonym.class) {
				synonym = ((xml.us.patent.application.v43.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v43.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Address.class) {
				addrezz = new Addrezz((xml.us.patent.application.v43.Address)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Phone.class) {
				phone = ((xml.us.patent.application.v43.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Fax.class) {
				fax = ((xml.us.patent.application.v43.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Email.class) {
				email = ((xml.us.patent.application.v43.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Url.class) {
				url = ((xml.us.patent.application.v43.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Ead.class) {
				ead = ((xml.us.patent.application.v43.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Dtext.class) {
				dtext = ((xml.us.patent.application.v43.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Text.class) {
				text = ((xml.us.patent.application.v43.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v42.Addressbook inventorAddressbookDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = inventorAddressbookDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressOrPhoneOrFaxOrEmailOrUrlOrEadOrDtextOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v42.Name.class) {
				name = ((xml.us.patent.application.v42.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Prefix.class) {
				prefix = ((xml.us.patent.application.v42.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.LastName.class) {
				lastName = ((xml.us.patent.application.v42.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.FirstName.class) {
				firstName = ((xml.us.patent.application.v42.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Orgname.class) {
				orgname = ((xml.us.patent.application.v42.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.MiddleName.class) {
				middleName = ((xml.us.patent.application.v42.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Suffix.class) {
				suffix = ((xml.us.patent.application.v42.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Iid.class) {
				iid = ((xml.us.patent.application.v42.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Role.class) {
				role = ((xml.us.patent.application.v42.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Department.class) {
				department = ((xml.us.patent.application.v42.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Synonym.class) {
				synonym = ((xml.us.patent.application.v42.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v42.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Address.class) {
				addrezz = new Addrezz((xml.us.patent.application.v42.Address)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Phone.class) {
				phone = ((xml.us.patent.application.v42.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Fax.class) {
				fax = ((xml.us.patent.application.v42.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Email.class) {
				email = ((xml.us.patent.application.v42.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Url.class) {
				url = ((xml.us.patent.application.v42.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Ead.class) {
				ead = ((xml.us.patent.application.v42.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Dtext.class) {
				dtext = ((xml.us.patent.application.v42.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Text.class) {
				text = ((xml.us.patent.application.v42.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v41.Addressbook inventorAddressbookDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = inventorAddressbookDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressOrPhoneOrFaxOrEmailOrUrlOrEadOrDtextOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v41.Name.class) {
				name = ((xml.us.patent.application.v41.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Prefix.class) {
				prefix = ((xml.us.patent.application.v41.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.LastName.class) {
				lastName = ((xml.us.patent.application.v41.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.FirstName.class) {
				firstName = ((xml.us.patent.application.v41.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Orgname.class) {
				orgname = ((xml.us.patent.application.v41.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.MiddleName.class) {
				middleName = ((xml.us.patent.application.v41.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Suffix.class) {
				suffix = ((xml.us.patent.application.v41.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Iid.class) {
				iid = ((xml.us.patent.application.v41.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Role.class) {
				role = ((xml.us.patent.application.v41.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Department.class) {
				department = ((xml.us.patent.application.v41.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Synonym.class) {
				synonym = ((xml.us.patent.application.v41.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v41.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Address.class) {
				addrezz = new Addrezz((xml.us.patent.application.v41.Address)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Phone.class) {
				phone = ((xml.us.patent.application.v41.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Fax.class) {
				fax = ((xml.us.patent.application.v41.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Email.class) {
				email = ((xml.us.patent.application.v41.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Url.class) {
				url = ((xml.us.patent.application.v41.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Ead.class) {
				ead = ((xml.us.patent.application.v41.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Dtext.class) {
				dtext = ((xml.us.patent.application.v41.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Text.class) {
				text = ((xml.us.patent.application.v41.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v40_041202.Addressbook inventorAddressbookDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = inventorAddressbookDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressOrPhoneOrFaxOrEmailOrUrlOrEadOrDtextOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v40_041202.Name.class) {
				name = ((xml.us.patent.application.v40_041202.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Prefix.class) {
				prefix = ((xml.us.patent.application.v40_041202.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.LastName.class) {
				lastName = ((xml.us.patent.application.v40_041202.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.FirstName.class) {
				firstName = ((xml.us.patent.application.v40_041202.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Orgname.class) {
				orgname = ((xml.us.patent.application.v40_041202.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.MiddleName.class) {
				middleName = ((xml.us.patent.application.v40_041202.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Suffix.class) {
				suffix = ((xml.us.patent.application.v40_041202.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Iid.class) {
				iid = ((xml.us.patent.application.v40_041202.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Role.class) {
				role = ((xml.us.patent.application.v40_041202.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Department.class) {
				department = ((xml.us.patent.application.v40_041202.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Synonym.class) {
				synonym = ((xml.us.patent.application.v40_041202.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v40_041202.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Address.class) {
				addrezz = new Addrezz((xml.us.patent.application.v40_041202.Address)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Phone.class) {
				phone = ((xml.us.patent.application.v40_041202.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Fax.class) {
				fax = ((xml.us.patent.application.v40_041202.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Email.class) {
				email = ((xml.us.patent.application.v40_041202.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Url.class) {
				url = ((xml.us.patent.application.v40_041202.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Ead.class) {
				ead = ((xml.us.patent.application.v40_041202.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Dtext.class) {
				dtext = ((xml.us.patent.application.v40_041202.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Text.class) {
				text = ((xml.us.patent.application.v40_041202.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v40_040908.Addressbook inventorAddressbookDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = inventorAddressbookDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressOrPhoneOrFaxOrEmailOrUrlOrEadOrDtextOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v40_040908.Name.class) {
				name = ((xml.us.patent.application.v40_040908.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Prefix.class) {
				prefix = ((xml.us.patent.application.v40_040908.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.LastName.class) {
				lastName = ((xml.us.patent.application.v40_040908.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.FirstName.class) {
				firstName = ((xml.us.patent.application.v40_040908.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Orgname.class) {
				orgname = ((xml.us.patent.application.v40_040908.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.MiddleName.class) {
				middleName = ((xml.us.patent.application.v40_040908.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Suffix.class) {
				suffix = ((xml.us.patent.application.v40_040908.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Iid.class) {
				iid = ((xml.us.patent.application.v40_040908.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Role.class) {
				role = ((xml.us.patent.application.v40_040908.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Department.class) {
				department = ((xml.us.patent.application.v40_040908.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Synonym.class) {
				synonym = ((xml.us.patent.application.v40_040908.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v40_040908.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Address.class) {
				addrezz = new Addrezz((xml.us.patent.application.v40_040908.Address)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Phone.class) {
				phone = ((xml.us.patent.application.v40_040908.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Fax.class) {
				fax = ((xml.us.patent.application.v40_040908.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Email.class) {
				email = ((xml.us.patent.application.v40_040908.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Url.class) {
				url = ((xml.us.patent.application.v40_040908.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Ead.class) {
				ead = ((xml.us.patent.application.v40_040908.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Dtext.class) {
				dtext = ((xml.us.patent.application.v40_040908.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Text.class) {
				text = ((xml.us.patent.application.v40_040908.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v40_040927.Addressbook inventorAddressbookDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = inventorAddressbookDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressOrPhoneOrFaxOrEmailOrUrlOrEadOrDtextOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v40_040927.Name.class) {
				name = ((xml.us.patent.application.v40_040927.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Prefix.class) {
				prefix = ((xml.us.patent.application.v40_040927.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.LastName.class) {
				lastName = ((xml.us.patent.application.v40_040927.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.FirstName.class) {
				firstName = ((xml.us.patent.application.v40_040927.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Orgname.class) {
				orgname = ((xml.us.patent.application.v40_040927.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.MiddleName.class) {
				middleName = ((xml.us.patent.application.v40_040927.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Suffix.class) {
				suffix = ((xml.us.patent.application.v40_040927.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Iid.class) {
				iid = ((xml.us.patent.application.v40_040927.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Role.class) {
				role = ((xml.us.patent.application.v40_040927.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Department.class) {
				department = ((xml.us.patent.application.v40_040927.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Synonym.class) {
				synonym = ((xml.us.patent.application.v40_040927.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v40_040927.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Address.class) {
				addrezz = new Addrezz((xml.us.patent.application.v40_040927.Address)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Phone.class) {
				phone = ((xml.us.patent.application.v40_040927.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Fax.class) {
				fax = ((xml.us.patent.application.v40_040927.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Email.class) {
				email = ((xml.us.patent.application.v40_040927.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Url.class) {
				url = ((xml.us.patent.application.v40_040927.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Ead.class) {
				ead = ((xml.us.patent.application.v40_040927.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Dtext.class) {
				dtext = ((xml.us.patent.application.v40_040927.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Text.class) {
				text = ((xml.us.patent.application.v40_040927.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v40_041028.Addressbook inventorAddressbookDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = inventorAddressbookDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressOrPhoneOrFaxOrEmailOrUrlOrEadOrDtextOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v40_041028.Name.class) {
				name = ((xml.us.patent.application.v40_041028.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Prefix.class) {
				prefix = ((xml.us.patent.application.v40_041028.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.LastName.class) {
				lastName = ((xml.us.patent.application.v40_041028.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.FirstName.class) {
				firstName = ((xml.us.patent.application.v40_041028.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Orgname.class) {
				orgname = ((xml.us.patent.application.v40_041028.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.MiddleName.class) {
				middleName = ((xml.us.patent.application.v40_041028.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Suffix.class) {
				suffix = ((xml.us.patent.application.v40_041028.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Iid.class) {
				iid = ((xml.us.patent.application.v40_041028.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Role.class) {
				role = ((xml.us.patent.application.v40_041028.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Department.class) {
				department = ((xml.us.patent.application.v40_041028.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Synonym.class) {
				synonym = ((xml.us.patent.application.v40_041028.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v40_041028.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Address.class) {
				addrezz = new Addrezz((xml.us.patent.application.v40_041028.Address)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Phone.class) {
				phone = ((xml.us.patent.application.v40_041028.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Fax.class) {
				fax = ((xml.us.patent.application.v40_041028.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Email.class) {
				email = ((xml.us.patent.application.v40_041028.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Url.class) {
				url = ((xml.us.patent.application.v40_041028.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Ead.class) {
				ead = ((xml.us.patent.application.v40_041028.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Dtext.class) {
				dtext = ((xml.us.patent.application.v40_041028.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Text.class) {
				text = ((xml.us.patent.application.v40_041028.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v40_040415.Addressbook inventorAddressbookDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = inventorAddressbookDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressOrPhoneOrFaxOrEmailOrUrlOrEadOrDtextOrText();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v40_040415.Name.class) {
				name = ((xml.us.patent.application.v40_040415.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Prefix.class) {
				prefix = ((xml.us.patent.application.v40_040415.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.LastName.class) {
				lastName = ((xml.us.patent.application.v40_040415.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.FirstName.class) {
				firstName = ((xml.us.patent.application.v40_040415.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Orgname.class) {
				orgname = ((xml.us.patent.application.v40_040415.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.MiddleName.class) {
				middleName = ((xml.us.patent.application.v40_040415.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Suffix.class) {
				suffix = ((xml.us.patent.application.v40_040415.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Iid.class) {
				iid = ((xml.us.patent.application.v40_040415.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Role.class) {
				role = ((xml.us.patent.application.v40_040415.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Department.class) {
				department = ((xml.us.patent.application.v40_040415.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Synonym.class) {
				synonym = ((xml.us.patent.application.v40_040415.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v40_040415.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Address.class) {
				addrezz = new Addrezz((xml.us.patent.application.v40_040415.Address)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Phone.class) {
				phone = ((xml.us.patent.application.v40_040415.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Fax.class) {
				fax = ((xml.us.patent.application.v40_040415.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Email.class) {
				email = ((xml.us.patent.application.v40_040415.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Url.class) {
				url = ((xml.us.patent.application.v40_040415.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Ead.class) {
				ead = ((xml.us.patent.application.v40_040415.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Dtext.class) {
				dtext = ((xml.us.patent.application.v40_040415.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Text.class) {
				text = ((xml.us.patent.application.v40_040415.Text)elem).getvalue();
			}
		}
	}

	AddrezzBook(xml.us.patent.grant.v45.Assignee assigneeDet) {
		List<Object> lst = assigneeDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressbook();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v45.Name.class) {
				name = ((xml.us.patent.grant.v45.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Prefix.class) {
				prefix = ((xml.us.patent.grant.v45.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.LastName.class) {
				lastName = ((xml.us.patent.grant.v45.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.FirstName.class) {
				firstName = ((xml.us.patent.grant.v45.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Orgname.class) {
				orgname = ((xml.us.patent.grant.v45.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.MiddleName.class) {
				middleName = ((xml.us.patent.grant.v45.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Suffix.class) {
				suffix = ((xml.us.patent.grant.v45.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Iid.class) {
				iid = ((xml.us.patent.grant.v45.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Role.class) {
				role = ((xml.us.patent.grant.v45.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Department.class) {
				department = ((xml.us.patent.grant.v45.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Synonym.class) {
				synonym = ((xml.us.patent.grant.v45.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.grant.v45.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Addressbook.class) {
				addrezzbook = new AddrezzBook((xml.us.patent.grant.v45.Addressbook)elem);
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Phone.class) {
				phone = ((xml.us.patent.grant.v45.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Fax.class) {
				fax = ((xml.us.patent.grant.v45.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Email.class) {
				email = ((xml.us.patent.grant.v45.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Url.class) {
				url = ((xml.us.patent.grant.v45.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Ead.class) {
				ead = ((xml.us.patent.grant.v45.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Dtext.class) {
				dtext = ((xml.us.patent.grant.v45.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v45.Text.class) {
				text = ((xml.us.patent.grant.v45.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.grant.v44.Assignee assigneeDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = assigneeDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressbook();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v44.Name.class) {
				name = ((xml.us.patent.grant.v44.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Prefix.class) {
				prefix = ((xml.us.patent.grant.v44.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.LastName.class) {
				lastName = ((xml.us.patent.grant.v44.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.FirstName.class) {
				firstName = ((xml.us.patent.grant.v44.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Orgname.class) {
				orgname = ((xml.us.patent.grant.v44.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.MiddleName.class) {
				middleName = ((xml.us.patent.grant.v44.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Suffix.class) {
				suffix = ((xml.us.patent.grant.v44.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Iid.class) {
				iid = ((xml.us.patent.grant.v44.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Role.class) {
				role = ((xml.us.patent.grant.v44.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Department.class) {
				department = ((xml.us.patent.grant.v44.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Synonym.class) {
				synonym = ((xml.us.patent.grant.v44.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.grant.v44.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Addressbook.class) {
				addrezzbook = new AddrezzBook((xml.us.patent.grant.v44.Addressbook)elem);
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Phone.class) {
				phone = ((xml.us.patent.grant.v44.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Fax.class) {
				fax = ((xml.us.patent.grant.v44.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Email.class) {
				email = ((xml.us.patent.grant.v44.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Url.class) {
				url = ((xml.us.patent.grant.v44.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Ead.class) {
				ead = ((xml.us.patent.grant.v44.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Dtext.class) {
				dtext = ((xml.us.patent.grant.v44.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v44.Text.class) {
				text = ((xml.us.patent.grant.v44.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.grant.v43.Assignee assigneeDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = assigneeDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressbook();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v43.Name.class) {
				name = ((xml.us.patent.grant.v43.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Prefix.class) {
				prefix = ((xml.us.patent.grant.v43.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.LastName.class) {
				lastName = ((xml.us.patent.grant.v43.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.FirstName.class) {
				firstName = ((xml.us.patent.grant.v43.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Orgname.class) {
				orgname = ((xml.us.patent.grant.v43.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.MiddleName.class) {
				middleName = ((xml.us.patent.grant.v43.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Suffix.class) {
				suffix = ((xml.us.patent.grant.v43.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Iid.class) {
				iid = ((xml.us.patent.grant.v43.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Role.class) {
				role = ((xml.us.patent.grant.v43.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Department.class) {
				department = ((xml.us.patent.grant.v43.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Synonym.class) {
				synonym = ((xml.us.patent.grant.v43.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.grant.v43.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Addressbook.class) {
				addrezzbook = new AddrezzBook((xml.us.patent.grant.v43.Addressbook)elem);
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Phone.class) {
				phone = ((xml.us.patent.grant.v43.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Fax.class) {
				fax = ((xml.us.patent.grant.v43.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Email.class) {
				email = ((xml.us.patent.grant.v43.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Url.class) {
				url = ((xml.us.patent.grant.v43.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Ead.class) {
				ead = ((xml.us.patent.grant.v43.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Dtext.class) {
				dtext = ((xml.us.patent.grant.v43.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v43.Text.class) {
				text = ((xml.us.patent.grant.v43.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.grant.v42.Assignee assigneeDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = assigneeDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressbook();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v42.Name.class) {
				name = ((xml.us.patent.grant.v42.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Prefix.class) {
				prefix = ((xml.us.patent.grant.v42.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.LastName.class) {
				lastName = ((xml.us.patent.grant.v42.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.FirstName.class) {
				firstName = ((xml.us.patent.grant.v42.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Orgname.class) {
				orgname = ((xml.us.patent.grant.v42.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.MiddleName.class) {
				middleName = ((xml.us.patent.grant.v42.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Suffix.class) {
				suffix = ((xml.us.patent.grant.v42.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Iid.class) {
				iid = ((xml.us.patent.grant.v42.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Role.class) {
				role = ((xml.us.patent.grant.v42.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Department.class) {
				department = ((xml.us.patent.grant.v42.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Synonym.class) {
				synonym = ((xml.us.patent.grant.v42.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.grant.v42.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Addressbook.class) {
				addrezzbook = new AddrezzBook((xml.us.patent.grant.v42.Addressbook)elem);
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Phone.class) {
				phone = ((xml.us.patent.grant.v42.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Fax.class) {
				fax = ((xml.us.patent.grant.v42.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Email.class) {
				email = ((xml.us.patent.grant.v42.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Url.class) {
				url = ((xml.us.patent.grant.v42.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Ead.class) {
				ead = ((xml.us.patent.grant.v42.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Dtext.class) {
				dtext = ((xml.us.patent.grant.v42.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v42.Text.class) {
				text = ((xml.us.patent.grant.v42.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.grant.v41.Assignee assigneeDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = assigneeDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressbook();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v41.Name.class) {
				name = ((xml.us.patent.grant.v41.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Prefix.class) {
				prefix = ((xml.us.patent.grant.v41.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.LastName.class) {
				lastName = ((xml.us.patent.grant.v41.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.FirstName.class) {
				firstName = ((xml.us.patent.grant.v41.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Orgname.class) {
				orgname = ((xml.us.patent.grant.v41.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.MiddleName.class) {
				middleName = ((xml.us.patent.grant.v41.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Suffix.class) {
				suffix = ((xml.us.patent.grant.v41.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Iid.class) {
				iid = ((xml.us.patent.grant.v41.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Role.class) {
				role = ((xml.us.patent.grant.v41.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Department.class) {
				department = ((xml.us.patent.grant.v41.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Synonym.class) {
				synonym = ((xml.us.patent.grant.v41.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.grant.v41.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Addressbook.class) {
				addrezzbook = new AddrezzBook((xml.us.patent.grant.v41.Addressbook)elem);
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Phone.class) {
				phone = ((xml.us.patent.grant.v41.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Fax.class) {
				fax = ((xml.us.patent.grant.v41.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Email.class) {
				email = ((xml.us.patent.grant.v41.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Url.class) {
				url = ((xml.us.patent.grant.v41.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Ead.class) {
				ead = ((xml.us.patent.grant.v41.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Dtext.class) {
				dtext = ((xml.us.patent.grant.v41.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v41.Text.class) {
				text = ((xml.us.patent.grant.v41.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.grant.v40_041202.Assignee assigneeDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = assigneeDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressbook();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.v40_041202.Name.class) {
				name = ((xml.us.patent.grant.v40_041202.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Prefix.class) {
				prefix = ((xml.us.patent.grant.v40_041202.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.LastName.class) {
				lastName = ((xml.us.patent.grant.v40_041202.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.FirstName.class) {
				firstName = ((xml.us.patent.grant.v40_041202.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Orgname.class) {
				orgname = ((xml.us.patent.grant.v40_041202.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.MiddleName.class) {
				middleName = ((xml.us.patent.grant.v40_041202.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Suffix.class) {
				suffix = ((xml.us.patent.grant.v40_041202.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Iid.class) {
				iid = ((xml.us.patent.grant.v40_041202.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Role.class) {
				role = ((xml.us.patent.grant.v40_041202.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Department.class) {
				department = ((xml.us.patent.grant.v40_041202.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Synonym.class) {
				synonym = ((xml.us.patent.grant.v40_041202.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.grant.v40_041202.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Addressbook.class) {
				addrezzbook = new AddrezzBook((xml.us.patent.grant.v40_041202.Addressbook)elem);
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Phone.class) {
				phone = ((xml.us.patent.grant.v40_041202.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Fax.class) {
				fax = ((xml.us.patent.grant.v40_041202.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Email.class) {
				email = ((xml.us.patent.grant.v40_041202.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Url.class) {
				url = ((xml.us.patent.grant.v40_041202.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Ead.class) {
				ead = ((xml.us.patent.grant.v40_041202.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Dtext.class) {
				dtext = ((xml.us.patent.grant.v40_041202.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.v40_041202.Text.class) {
				text = ((xml.us.patent.grant.v40_041202.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v44.Assignee assigneeDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = assigneeDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressbook();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v44.Name.class) {
				name = ((xml.us.patent.application.v44.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Prefix.class) {
				prefix = ((xml.us.patent.application.v44.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.LastName.class) {
				lastName = ((xml.us.patent.application.v44.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.FirstName.class) {
				firstName = ((xml.us.patent.application.v44.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Orgname.class) {
				orgname = ((xml.us.patent.application.v44.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.MiddleName.class) {
				middleName = ((xml.us.patent.application.v44.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Suffix.class) {
				suffix = ((xml.us.patent.application.v44.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Iid.class) {
				iid = ((xml.us.patent.application.v44.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Role.class) {
				role = ((xml.us.patent.application.v44.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Department.class) {
				department = ((xml.us.patent.application.v44.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Synonym.class) {
				synonym = ((xml.us.patent.application.v44.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v44.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Addressbook.class) {
				addrezzbook = new AddrezzBook((xml.us.patent.application.v44.Addressbook)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Phone.class) {
				phone = ((xml.us.patent.application.v44.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Fax.class) {
				fax = ((xml.us.patent.application.v44.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Email.class) {
				email = ((xml.us.patent.application.v44.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Url.class) {
				url = ((xml.us.patent.application.v44.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Ead.class) {
				ead = ((xml.us.patent.application.v44.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Dtext.class) {
				dtext = ((xml.us.patent.application.v44.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v44.Text.class) {
				text = ((xml.us.patent.application.v44.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v43.Assignee assigneeDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = assigneeDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressbook();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v43.Name.class) {
				name = ((xml.us.patent.application.v43.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Prefix.class) {
				prefix = ((xml.us.patent.application.v43.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.LastName.class) {
				lastName = ((xml.us.patent.application.v43.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.FirstName.class) {
				firstName = ((xml.us.patent.application.v43.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Orgname.class) {
				orgname = ((xml.us.patent.application.v43.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.MiddleName.class) {
				middleName = ((xml.us.patent.application.v43.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Suffix.class) {
				suffix = ((xml.us.patent.application.v43.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Iid.class) {
				iid = ((xml.us.patent.application.v43.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Role.class) {
				role = ((xml.us.patent.application.v43.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Department.class) {
				department = ((xml.us.patent.application.v43.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Synonym.class) {
				synonym = ((xml.us.patent.application.v43.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v43.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Addressbook.class) {
				addrezzbook = new AddrezzBook((xml.us.patent.application.v43.Addressbook)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Phone.class) {
				phone = ((xml.us.patent.application.v43.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Fax.class) {
				fax = ((xml.us.patent.application.v43.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Email.class) {
				email = ((xml.us.patent.application.v43.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Url.class) {
				url = ((xml.us.patent.application.v43.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Ead.class) {
				ead = ((xml.us.patent.application.v43.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Dtext.class) {
				dtext = ((xml.us.patent.application.v43.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v43.Text.class) {
				text = ((xml.us.patent.application.v43.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v42.Assignee assigneeDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = assigneeDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressbook();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v42.Name.class) {
				name = ((xml.us.patent.application.v42.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Prefix.class) {
				prefix = ((xml.us.patent.application.v42.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.LastName.class) {
				lastName = ((xml.us.patent.application.v42.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.FirstName.class) {
				firstName = ((xml.us.patent.application.v42.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Orgname.class) {
				orgname = ((xml.us.patent.application.v42.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.MiddleName.class) {
				middleName = ((xml.us.patent.application.v42.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Suffix.class) {
				suffix = ((xml.us.patent.application.v42.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Iid.class) {
				iid = ((xml.us.patent.application.v42.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Role.class) {
				role = ((xml.us.patent.application.v42.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Department.class) {
				department = ((xml.us.patent.application.v42.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Synonym.class) {
				synonym = ((xml.us.patent.application.v42.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v42.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Addressbook.class) {
				addrezzbook = new AddrezzBook((xml.us.patent.application.v42.Addressbook)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Phone.class) {
				phone = ((xml.us.patent.application.v42.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Fax.class) {
				fax = ((xml.us.patent.application.v42.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Email.class) {
				email = ((xml.us.patent.application.v42.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Url.class) {
				url = ((xml.us.patent.application.v42.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Ead.class) {
				ead = ((xml.us.patent.application.v42.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Dtext.class) {
				dtext = ((xml.us.patent.application.v42.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v42.Text.class) {
				text = ((xml.us.patent.application.v42.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v41.Assignee assigneeDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = assigneeDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressbook();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v41.Name.class) {
				name = ((xml.us.patent.application.v41.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Prefix.class) {
				prefix = ((xml.us.patent.application.v41.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.LastName.class) {
				lastName = ((xml.us.patent.application.v41.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.FirstName.class) {
				firstName = ((xml.us.patent.application.v41.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Orgname.class) {
				orgname = ((xml.us.patent.application.v41.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.MiddleName.class) {
				middleName = ((xml.us.patent.application.v41.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Suffix.class) {
				suffix = ((xml.us.patent.application.v41.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Iid.class) {
				iid = ((xml.us.patent.application.v41.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Role.class) {
				role = ((xml.us.patent.application.v41.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Department.class) {
				department = ((xml.us.patent.application.v41.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Synonym.class) {
				synonym = ((xml.us.patent.application.v41.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v41.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Addressbook.class) {
				addrezzbook = new AddrezzBook((xml.us.patent.application.v41.Addressbook)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Phone.class) {
				phone = ((xml.us.patent.application.v41.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Fax.class) {
				fax = ((xml.us.patent.application.v41.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Email.class) {
				email = ((xml.us.patent.application.v41.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Url.class) {
				url = ((xml.us.patent.application.v41.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Ead.class) {
				ead = ((xml.us.patent.application.v41.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Dtext.class) {
				dtext = ((xml.us.patent.application.v41.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v41.Text.class) {
				text = ((xml.us.patent.application.v41.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v40_041202.Assignee assigneeDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = assigneeDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressbook();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v40_041202.Name.class) {
				name = ((xml.us.patent.application.v40_041202.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Prefix.class) {
				prefix = ((xml.us.patent.application.v40_041202.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.LastName.class) {
				lastName = ((xml.us.patent.application.v40_041202.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.FirstName.class) {
				firstName = ((xml.us.patent.application.v40_041202.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Orgname.class) {
				orgname = ((xml.us.patent.application.v40_041202.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.MiddleName.class) {
				middleName = ((xml.us.patent.application.v40_041202.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Suffix.class) {
				suffix = ((xml.us.patent.application.v40_041202.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Iid.class) {
				iid = ((xml.us.patent.application.v40_041202.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Role.class) {
				role = ((xml.us.patent.application.v40_041202.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Department.class) {
				department = ((xml.us.patent.application.v40_041202.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Synonym.class) {
				synonym = ((xml.us.patent.application.v40_041202.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v40_041202.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Addressbook.class) {
				addrezzbook = new AddrezzBook((xml.us.patent.application.v40_041202.Addressbook)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Phone.class) {
				phone = ((xml.us.patent.application.v40_041202.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Fax.class) {
				fax = ((xml.us.patent.application.v40_041202.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Email.class) {
				email = ((xml.us.patent.application.v40_041202.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Url.class) {
				url = ((xml.us.patent.application.v40_041202.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Ead.class) {
				ead = ((xml.us.patent.application.v40_041202.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Dtext.class) {
				dtext = ((xml.us.patent.application.v40_041202.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041202.Text.class) {
				text = ((xml.us.patent.application.v40_041202.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v40_040908.Assignee assigneeDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = assigneeDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressbook();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v40_040908.Name.class) {
				name = ((xml.us.patent.application.v40_040908.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Prefix.class) {
				prefix = ((xml.us.patent.application.v40_040908.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.LastName.class) {
				lastName = ((xml.us.patent.application.v40_040908.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.FirstName.class) {
				firstName = ((xml.us.patent.application.v40_040908.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Orgname.class) {
				orgname = ((xml.us.patent.application.v40_040908.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.MiddleName.class) {
				middleName = ((xml.us.patent.application.v40_040908.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Suffix.class) {
				suffix = ((xml.us.patent.application.v40_040908.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Iid.class) {
				iid = ((xml.us.patent.application.v40_040908.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Role.class) {
				role = ((xml.us.patent.application.v40_040908.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Department.class) {
				department = ((xml.us.patent.application.v40_040908.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Synonym.class) {
				synonym = ((xml.us.patent.application.v40_040908.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v40_040908.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Addressbook.class) {
				addrezzbook = new AddrezzBook((xml.us.patent.application.v40_040908.Addressbook)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Phone.class) {
				phone = ((xml.us.patent.application.v40_040908.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Fax.class) {
				fax = ((xml.us.patent.application.v40_040908.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Email.class) {
				email = ((xml.us.patent.application.v40_040908.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Url.class) {
				url = ((xml.us.patent.application.v40_040908.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Ead.class) {
				ead = ((xml.us.patent.application.v40_040908.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Dtext.class) {
				dtext = ((xml.us.patent.application.v40_040908.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040908.Text.class) {
				text = ((xml.us.patent.application.v40_040908.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v40_040927.Assignee assigneeDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = assigneeDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressbook();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v40_040927.Name.class) {
				name = ((xml.us.patent.application.v40_040927.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Prefix.class) {
				prefix = ((xml.us.patent.application.v40_040927.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.LastName.class) {
				lastName = ((xml.us.patent.application.v40_040927.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.FirstName.class) {
				firstName = ((xml.us.patent.application.v40_040927.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Orgname.class) {
				orgname = ((xml.us.patent.application.v40_040927.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.MiddleName.class) {
				middleName = ((xml.us.patent.application.v40_040927.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Suffix.class) {
				suffix = ((xml.us.patent.application.v40_040927.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Iid.class) {
				iid = ((xml.us.patent.application.v40_040927.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Role.class) {
				role = ((xml.us.patent.application.v40_040927.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Department.class) {
				department = ((xml.us.patent.application.v40_040927.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Synonym.class) {
				synonym = ((xml.us.patent.application.v40_040927.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v40_040927.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Addressbook.class) {
				addrezzbook = new AddrezzBook((xml.us.patent.application.v40_040927.Addressbook)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Phone.class) {
				phone = ((xml.us.patent.application.v40_040927.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Fax.class) {
				fax = ((xml.us.patent.application.v40_040927.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Email.class) {
				email = ((xml.us.patent.application.v40_040927.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Url.class) {
				url = ((xml.us.patent.application.v40_040927.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Ead.class) {
				ead = ((xml.us.patent.application.v40_040927.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Dtext.class) {
				dtext = ((xml.us.patent.application.v40_040927.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040927.Text.class) {
				text = ((xml.us.patent.application.v40_040927.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v40_041028.Assignee assigneeDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = assigneeDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressbook();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v40_041028.Name.class) {
				name = ((xml.us.patent.application.v40_041028.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Prefix.class) {
				prefix = ((xml.us.patent.application.v40_041028.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.LastName.class) {
				lastName = ((xml.us.patent.application.v40_041028.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.FirstName.class) {
				firstName = ((xml.us.patent.application.v40_041028.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Orgname.class) {
				orgname = ((xml.us.patent.application.v40_041028.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.MiddleName.class) {
				middleName = ((xml.us.patent.application.v40_041028.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Suffix.class) {
				suffix = ((xml.us.patent.application.v40_041028.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Iid.class) {
				iid = ((xml.us.patent.application.v40_041028.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Role.class) {
				role = ((xml.us.patent.application.v40_041028.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Department.class) {
				department = ((xml.us.patent.application.v40_041028.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Synonym.class) {
				synonym = ((xml.us.patent.application.v40_041028.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v40_041028.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Addressbook.class) {
				addrezzbook = new AddrezzBook((xml.us.patent.application.v40_041028.Addressbook)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Phone.class) {
				phone = ((xml.us.patent.application.v40_041028.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Fax.class) {
				fax = ((xml.us.patent.application.v40_041028.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Email.class) {
				email = ((xml.us.patent.application.v40_041028.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Url.class) {
				url = ((xml.us.patent.application.v40_041028.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Ead.class) {
				ead = ((xml.us.patent.application.v40_041028.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Dtext.class) {
				dtext = ((xml.us.patent.application.v40_041028.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_041028.Text.class) {
				text = ((xml.us.patent.application.v40_041028.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(
			xml.us.patent.application.v40_040415.Assignee assigneeDet) {
		// TODO Auto-generated constructor stub
		List<Object> lst = assigneeDet.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressbook();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.application.v40_040415.Name.class) {
				name = ((xml.us.patent.application.v40_040415.Name)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Prefix.class) {
				prefix = ((xml.us.patent.application.v40_040415.Prefix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.LastName.class) {
				lastName = ((xml.us.patent.application.v40_040415.LastName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.FirstName.class) {
				firstName = ((xml.us.patent.application.v40_040415.FirstName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Orgname.class) {
				orgname = ((xml.us.patent.application.v40_040415.Orgname)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.MiddleName.class) {
				middleName = ((xml.us.patent.application.v40_040415.MiddleName)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Suffix.class) {
				suffix = ((xml.us.patent.application.v40_040415.Suffix)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Iid.class) {
				iid = ((xml.us.patent.application.v40_040415.Iid)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Role.class) {
				role = ((xml.us.patent.application.v40_040415.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Department.class) {
				department = ((xml.us.patent.application.v40_040415.Role)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Synonym.class) {
				synonym = ((xml.us.patent.application.v40_040415.Synonym)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.RegisteredNumber.class) {
				registeredNumber = ((xml.us.patent.application.v40_040415.RegisteredNumber)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Addressbook.class) {
				addrezzbook = new AddrezzBook((xml.us.patent.application.v40_040415.Addressbook)elem);
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Phone.class) {
				phone = ((xml.us.patent.application.v40_040415.Phone)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Fax.class) {
				fax = ((xml.us.patent.application.v40_040415.Fax)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Email.class) {
				email = ((xml.us.patent.application.v40_040415.Email)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Url.class) {
				url = ((xml.us.patent.application.v40_040415.Url)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Ead.class) {
				ead = ((xml.us.patent.application.v40_040415.Ead)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Dtext.class) {
				dtext = ((xml.us.patent.application.v40_040415.Dtext)elem).getvalue();
			}
			else if(elem.getClass()==xml.us.patent.application.v40_040415.Text.class) {
				text = ((xml.us.patent.application.v40_040415.Text)elem).getvalue();
			}
		}
	}

	public AddrezzBook(xml.us.patent.grant.vST32_025xml.PARTYUS inventor) {
		// TODO Auto-generated constructor stub
		List<Object> lst = inventor.getNAM().getTTLOrFNMOrSNMOrSFXOrIIDOrIRFOrONMOrSYNOrOIDOrODVOrDID();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.vST32_025xml.FNM.class) {
				firstName = ((xml.us.patent.grant.vST32_025xml.FNM)elem).getPDAT().getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.vST32_025xml.SNM.class) {
				List<Object> s = ((xml.us.patent.grant.vST32_025xml.SNM)elem).getSTEXT().get(0).getPDATOrFOrFOROrIMGOrHILOrCWU();
				for(Object e : s) {
					if(e.getClass()==xml.us.patent.grant.vST32_025xml.PDAT.class)
						lastName = ((xml.us.patent.grant.vST32_025xml.PDAT)e).getvalue();
				}
			}
			else if(elem.getClass()==xml.us.patent.grant.vST32_025xml.SYN.class) {
				synonym = ((xml.us.patent.grant.vST32_025xml.SYN)elem).getPDAT().getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.vST32_025xml.SFX.class) {
				suffix = ((xml.us.patent.grant.vST32_025xml.SFX)elem).getPDAT().getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.vST32_025xml.IID.class) {
				iid = ((xml.us.patent.grant.vST32_025xml.IID)elem).getPDAT().getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.vST32_025xml.ONM.class) {
				List<Object> s = ((xml.us.patent.grant.vST32_025xml.ONM)elem).getSTEXT().get(0).getPDATOrFOrFOROrIMGOrHILOrCWU();
				for(Object e : s) {
					if(e.getClass()==xml.us.patent.grant.vST32_025xml.PDAT.class)
						orgname = ((xml.us.patent.grant.vST32_025xml.PDAT)e).getvalue();
				}
			}
		}
		
		xml.us.patent.grant.vST32_025xml.DTXT dtext = inventor.getDTXT();
		if(dtext!=null) {
			List<Object> s = dtext.getSTEXT().get(0).getPDATOrFOrFOROrIMGOrHILOrCWU();
			for(Object e : s) {
				if(e.getClass()==xml.us.patent.grant.vST32_025xml.PDAT.class)
					this.dtext = ((xml.us.patent.grant.vST32_025xml.PDAT)e).getvalue();
			}
		}
		
		xml.us.patent.grant.vST32_025xml.ADR addr = inventor.getADR();
		if(addr!=null) {
			addrezz = new Addrezz(addr);
		}
	}

	public AddrezzBook(xml.us.patent.grant.vST32_024.PARTYUS inventor) {
		// TODO Auto-generated constructor stub
		List<Object> lst = inventor.getNAM().getTTLOrFNMOrSNMOrSFXOrIIDOrIRFOrONMOrSYNOrOIDOrODVOrDID();
		for(Object elem : lst) {
			if(elem.getClass()==xml.us.patent.grant.vST32_024.FNM.class) {
				firstName = ((xml.us.patent.grant.vST32_024.FNM)elem).getPDAT().getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.vST32_024.SNM.class) {
				List<Object> s = ((xml.us.patent.grant.vST32_024.SNM)elem).getSTEXT().get(0).getPDATOrFOrFOROrIMGOrHILOrCWU();
				for(Object e : s) {
					if(e.getClass()==xml.us.patent.grant.vST32_024.PDAT.class)
						lastName = ((xml.us.patent.grant.vST32_024.PDAT)e).getvalue();
				}
			}
			else if(elem.getClass()==xml.us.patent.grant.vST32_024.SYN.class) {
				synonym = ((xml.us.patent.grant.vST32_024.SYN)elem).getPDAT().getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.vST32_024.SFX.class) {
				suffix = ((xml.us.patent.grant.vST32_024.SFX)elem).getPDAT().getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.vST32_024.IID.class) {
				iid = ((xml.us.patent.grant.vST32_024.IID)elem).getPDAT().getvalue();
			}
			else if(elem.getClass()==xml.us.patent.grant.vST32_024.ONM.class) {
				List<Object> s = ((xml.us.patent.grant.vST32_024.ONM)elem).getSTEXT().get(0).getPDATOrFOrFOROrIMGOrHILOrCWU();
				for(Object e : s) {
					if(e.getClass()==xml.us.patent.grant.vST32_024.PDAT.class)
						orgname = ((xml.us.patent.grant.vST32_024.PDAT)e).getvalue();
				}
			}
		}
		
		xml.us.patent.grant.vST32_024.DTXT dtext = inventor.getDTXT();
		if(dtext!=null) {
			List<Object> s = dtext.getSTEXT().get(0).getPDATOrFOrFOROrIMGOrHILOrCWU();
			for(Object e : s) {
				if(e.getClass()==xml.us.patent.grant.vST32_024.PDAT.class)
					this.dtext = ((xml.us.patent.grant.vST32_024.PDAT)e).getvalue();
			}
		}
		
		xml.us.patent.grant.vST32_024.ADR addr = inventor.getADR();
		if(addr!=null) {
			addrezz = new Addrezz(addr);
		}
	}

	public AddrezzBook(xml.us.patent.application.v16.FirstNamedInventor firstinventor) {
		// TODO Auto-generated constructor stub
		xml.us.patent.application.v16.Name n = firstinventor.getName();
		if(n!=null) {
			if(n.getGivenName()!=null)
				firstName = n.getGivenName().getvalue();
			if(n.getFamilyName()!=null)
				lastName = n.getFamilyName().getvalue();
			if(n.getMiddleName()!=null)
				middleName = n.getMiddleName().getvalue();
			if(n.getNamePrefix()!=null)
				prefix = n.getNamePrefix().getvalue();
			if(n.getNameSuffix()!=null)
				suffix = n.getNameSuffix().getvalue();
		}
		xml.us.patent.application.v16.Address address = firstinventor.getAddress();
		if(address!=null) {
			addrezz = new Addrezz(address);
			List<xml.us.patent.application.v16.Email> emails = address.getEmail();
			if(emails!=null && emails.size()>0) {
				email = emails.get(0).getvalue();
			}
			List<xml.us.patent.application.v16.Fax> faxes = address.getFax();
			if(faxes!=null && faxes.size()>0) {
				fax = faxes.get(0).getvalue();
			}
			
			List<xml.us.patent.application.v16.Telephone> telephones = address.getTelephone();
			if(telephones!=null && telephones.size()>0) {
				phone = telephones.get(0).getvalue();
			}			
		}
	}
	
	public AddrezzBook(xml.us.patent.application.v16.Inventor inventor) {
		// TODO Auto-generated constructor stub
		xml.us.patent.application.v16.Name n = inventor.getName();
		if(n!=null) {
			if(n.getGivenName()!=null)
				firstName = n.getGivenName().getvalue();
			if(n.getFamilyName()!=null)
				lastName = n.getFamilyName().getvalue();
			if(n.getMiddleName()!=null)
				middleName = n.getMiddleName().getvalue();
			if(n.getNamePrefix()!=null)
				prefix = n.getNamePrefix().getvalue();
			if(n.getNameSuffix()!=null)
				suffix = n.getNameSuffix().getvalue();
		}
		
		xml.us.patent.application.v16.Address address = inventor.getAddress();
		if(address!=null) {
			addrezz = new Addrezz(address);
			List<xml.us.patent.application.v16.Email> emails = address.getEmail();
			if(emails!=null && emails.size()>0) {
				email = emails.get(0).getvalue();
			}
			List<xml.us.patent.application.v16.Fax> faxes = address.getFax();
			if(faxes!=null && faxes.size()>0) {
				fax = faxes.get(0).getvalue();
			}
			
			List<xml.us.patent.application.v16.Telephone> telephones = address.getTelephone();
			if(telephones!=null && telephones.size()>0) {
				phone = telephones.get(0).getvalue();
			}			
		}
	}

	public AddrezzBook(xml.us.patent.application.v16.Assignee assignee) {
		// TODO Auto-generated constructor stub
		xml.us.patent.application.v16.Name n = assignee.getName();
		if(n!=null) {
			if(n.getGivenName()!=null)
				firstName = n.getGivenName().getvalue();
			if(n.getFamilyName()!=null)
				lastName = n.getFamilyName().getvalue();
			if(n.getMiddleName()!=null)
				middleName = n.getMiddleName().getvalue();
			if(n.getNamePrefix()!=null)
				prefix = n.getNamePrefix().getvalue();
			if(n.getNameSuffix()!=null)
				suffix = n.getNameSuffix().getvalue();
		}
		if(assignee.getOrganizationName()!=null)
			orgname = assignee.getOrganizationName().getvalue();
		
		xml.us.patent.application.v16.Address address = assignee.getAddress();
		if(address!=null) {
			addrezz = new Addrezz(address);
			List<xml.us.patent.application.v16.Email> emails = address.getEmail();
			if(emails!=null && emails.size()>0) {
				email = emails.get(0).getvalue();
			}
			List<xml.us.patent.application.v16.Fax> faxes = address.getFax();
			if(faxes!=null && faxes.size()>0) {
				fax = faxes.get(0).getvalue();
			}
			
			List<xml.us.patent.application.v16.Telephone> telephones = address.getTelephone();
			if(telephones!=null && telephones.size()>0) {
				phone = telephones.get(0).getvalue();
			}			
		}
	}
}
