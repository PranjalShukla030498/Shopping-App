package com.shoppingApp.demo.Dto;

import com.shoppingApp.demo.domain.Users;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddressDto {
    private int id;
    private int userId;
    private String flatNo;
    private String addressLine;
    private String landmark;
    private String city;
    private String state;
    private String country;
    private Long zipCode;

    public AddressDto(int id, int userId, String flatNo, String addressLine, String landmark, String city,
                      String state, String country, Long zipCode) {
        this.id = id;
        this.userId = userId;
        this.flatNo = flatNo;
        this.addressLine = addressLine;
        this.landmark = landmark;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public AddressDto(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", flatNo='" + flatNo + '\'' +
                ", addressLine='" + addressLine + '\'' +
                ", landmark='" + landmark + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
