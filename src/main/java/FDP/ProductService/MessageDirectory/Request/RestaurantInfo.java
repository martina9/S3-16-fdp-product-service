package FDP.ProductService.MessageDirectory.Request;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

public class RestaurantInfo implements Serializable {
    public String email;
    public String phoneNumber;
    private String address;
    private String zipCode;
    private String city;
    private String code;
    private String name;

    private int id;

    /**
     * Constructor
     *
     * @param email
     * @param phoneNumber
     * @param address
     * @param zipCode
     * @param city
     * @param code
     * @param id
     * @param name
     */

    public RestaurantInfo(String email, String phoneNumber, String address, String zipCode, String city, String code, int id, String name) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.code = code;
        this.id = id;
        this.name = name;
    }

    public RestaurantInfo() {

    }

    /**
     * Return an String from getEmail.
     *
     */

    public String getEmail() {
        return email;
    }

    /**
     * Return an void from setId.
     *
     * @param email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return an String from getPhoneNumber.
     *
     */

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Return an void from setPhoneNumber.
     *
     * @param phoneNumber
     */

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Return an String from getAddress.
     *
     */

    public String getAddress() {
        return address;
    }

    /**
     * Return an void from setAddress.
     *
     * @param address
     */

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Return an String from getZipCode.
     *
     */

    public String getZipCode() {
        return zipCode;
    }

    /**
     * Return an void from setZipCode.
     *
     * @param zipCode
     */

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Return an String from getCity.
     *
     */

    public String getCity() {
        return city;
    }

    /**
     * Return an void from setCity.
     *
     * @param city
     */

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Return an String from getCode.
     *
     */

    public String getCode() {
        return code;
    }

    /**
     * Return an void from setCode.
     *
     * @param code
     */

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Return an int from getId.
     *
     */

    public int getId() {
        return id;
    }

    /**
     * Return an void from setId.
     *
     * @param id
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return an String from getName.
     *
     */

    public String getName() {
        return name;
    }

    /**
     * Return an void from setName.
     *
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }
}