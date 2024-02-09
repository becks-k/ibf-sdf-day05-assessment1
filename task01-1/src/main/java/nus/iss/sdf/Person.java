package nus.iss.sdf;


public class Person {

    private String firstName;
    private String lastName;
    private String address;
    private String years;

    public Person(String firstName, String lastName, String address, String years) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.years = years;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getYears() {
        return years;
    }

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", years=" + years
                + "]";
    }

}
