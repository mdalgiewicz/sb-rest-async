package com.dalgim.example.sb.rest.async.dto;

/**
 * Created by Mateusz Dalgiewicz on 06.06.2017.
 */
public class UserDto {

    private long id;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
