package edu.pro.springproject.model;

/*
 * @author JohnBuritto
 * @project SpringProject
 * @class Address
 * @version 1.0.0
 * @since 15.05.2022, 11:44
 * Software Engineering Department
 *
 * Copyright (c) 1993-1996 Sun Microsystems, Inc. All Rights Reserved.
 */

import java.util.Objects;

public class Address {
    private String country;
    private String district;
    private String settlement;
    private String street;
    private String houseNumber;
    private String apartmentNumber;

    public Address() {

    }

    public Address(String country, String district, String settlement, String street, String houseNumber,
                   String apartmentNumber) {
        this.country = country;
        this.district = district;
        this.settlement = settlement;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return country.equals(address.country) &&
                district.equals(address.district) &&
                settlement.equals(address.settlement) &&
                street.equals(address.street) &&
                houseNumber.equals(address.houseNumber) &&
                apartmentNumber.equals(address.apartmentNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, district, settlement, street, houseNumber, apartmentNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", district='" + district + '\'' +
                ", settlement='" + settlement + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                '}';
    }
}
