package com.shoppingApp.demo.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
@Table(name= "address")
public class Address {
    @Id
    private int id;
   @ManyToOne()
   @JoinColumn(name = "user_id")
    private Users user;

    @NotNull
    private String flatNo;
    @NotNull
    private String addressLine;
    @NotBlank
    private String landmark;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @NotNull
    private String country;
    @NotNull
    @Min(10000)
    private Long zipCode;

    public Address(int id, Users user, String flatNo, String addressLine, String landmark,
                   String city, String state, String country, Long zipCode) {
        this.id = id;
        this.user = user;
        this.flatNo = flatNo;
        this.addressLine = addressLine;
        this.landmark = landmark;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }
    public Address (){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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
        return "Address{" +
                "id=" + id +
                ", user=" + user +
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
