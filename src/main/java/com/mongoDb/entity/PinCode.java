package com.mongoDb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "pincodeMaster")
public class PinCode {

    @Id
    private String id ;

    @Field(name="Pincode")
    private Double pincode ;

    @Field(name="RegionName")
    private String city ;

@Field(name="CircleName")
    private String state ;

    public PinCode() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPincode() {
        return pincode;
    }

    public void setPincode(Double pincode) {
        this.pincode = pincode;
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

    public PinCode(String id, Double pincode, String city, String state) {
        this.id = id;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return "PinCode{" +
                "id='" + id + '\'' +
                ", pincode=" + pincode +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
