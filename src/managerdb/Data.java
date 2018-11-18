package managerdb;

public class Data {
    /**
     * Generic data class to abstract the values from data base;
     */

    // Table Contacts
    int contact_id;
    String phone;
    String email;

    // Table City
    int city_id;
    String name;
    String state;
    String country;


    // Table Address
    int address_id;
    String street;
    String neighborhood;
    String cep;

    Data(int contact_id, String phone, String email) {
        this.contact_id = contact_id;
        this.phone = phone;
        this.email = email;
    }

    Data(int city_id, String name, String state, String country) {
        this.city_id = city_id;
        this.name = name;
        this.state = state;
        this.country = country;
    }

    Data(int address_id, String street, String neighborhood, String cep, int city_id) {
        this.address_id = address_id;
        this.neighborhood = neighborhood;
        this.cep = cep;
        this.city_id = city_id;
    }
}
