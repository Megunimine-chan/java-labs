package task2;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class CuratorRegisterNote {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phoneNumber;
    private String address;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {this.lastName = lastName;}

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {this.address = address;}

    @Override
    public String toString() {
        return "{\n" +
                "\tfirstName='" + firstName + "'\n" +
                "\tlastName='" + lastName + "'\n" +
                "\tbirthDate=" + birthDate + "\n" +
                "\tphoneNumber='" + phoneNumber + "'\n" +
                "\taddress='" + address + "'\n" +
                '}';
    }
}
