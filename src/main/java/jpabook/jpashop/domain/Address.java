package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
//@Setter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected  Address() {

    }
    protected  Address(String cityInput, String streetInput, String zipcodeInput) {
        city = cityInput;
        street = streetInput;
        zipcode = zipcodeInput;

    }

}
