package edu.pro.springproject.model;

/*
 * @author JohnBuritto
 * @project SpringProject
 * @class ContactPerson
 * @version 1.0.0
 * @since 15.05.2022, 11:50
 * Software Engineering Department
 *
 * Copyright (c) 1993-1996 Sun Microsystems, Inc. All Rights Reserved.
 */

import java.util.Objects;

public class ContactPerson {
    private String firstName;
    private String middleName;
    private String lastName;
    private String telephoneNumber;
    private String eMail;

    public ContactPerson() {

    }

    public ContactPerson(String firstName, String middleName, String lastName, String telephoneNumber, String eMail) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.eMail = eMail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactPerson that = (ContactPerson) o;
        return firstName.equals(that.firstName) && middleName.equals(that.middleName) && lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);
    }

    @Override
    public String toString() {
        return "ContactPerson{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
