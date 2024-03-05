package modelos;

public class Customer {
    private int customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String adressLine1;
    private String adressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private int salesRepEmployeeNumber;
    private float creditLimit;


    /**
     * Constructor por defecto. Deja los atributos vacíos pero no nulos.
     */
    public Customer() {
        this.customerNumber = 0;
        this.customerName = "";
        this.contactLastName = "";
        this.contactFirstName = "";
        this.phone = "";
        this.adressLine1 = "";
        this.adressLine2 = "";
        this.city = "";
        this.state = "";
        this.postalCode = "";
    }

    /**
     * Constructor parametrizado
     *
     * @param customerNumber   id del cliente en cuestión
     * @param customerName     nombre del cliente
     * @param contactLastName  nombre del tlf contacto
     * @param contactFirstName apellido del tlf contacto
     * @param phone            numero de tlf
     * @param adressLine1      1ª línea de la dirección del cliente
     * @param adressLine2      2ª línea de dirección del cliente
     * @param city             ciudad del cliente
     * @param state            estado del cliente
     * @param postalCode       código postal del del cliente
     * @param country          país del cliente
     * @param salesRepEmployeeNumber            empleado que ha atendido al cliente
     * @param creditLimit       límite de crédito bancario del cliente
     */
    public Customer(int customerNumber, String customerName, String contactLastName, String contactFirstName,
                    String phone, String adressLine1, String adressLine2, String city, String state, String postalCode,
                    String country, int salesRepEmployeeNumber, float creditLimit) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.adressLine1 = adressLine1;
        this.adressLine2 = adressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
        this.creditLimit = creditLimit;
    }

    public Customer(Customer custo) {
        this.customerNumber = custo.customerNumber;
        this.customerName = custo.customerName;
        this.contactLastName = custo.contactLastName;
        this.contactFirstName = custo.contactFirstName;
        this.phone = custo.phone;
        this.adressLine1 = custo.adressLine1;
        this.adressLine2 = custo.adressLine2;
        this.city = custo.city;
        this.state = custo.state;
        this.postalCode = custo.postalCode;
        this.country = custo.country;
        this.salesRepEmployeeNumber = custo.salesRepEmployeeNumber;
        this.creditLimit = custo.creditLimit;
    }

    /**
     * @return customerNumber
     */
    public int getCustomerNumber() {
        return customerNumber;
    }

    /**
     * @param customerNumber
     */
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * @return customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return costumerLastName
     */
    public String getContactLastName() {
        return contactLastName;
    }

    /**
     * @param contactLastName
     */
    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    /**
     * @return contactFirstName
     */
    public String getContactFirstName() {
        return contactFirstName;
    }

    /**
     * @param contactFirstName
     */
    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return adressLine1
     */
    public String getAdressLine1() {
        return adressLine1;
    }

    /**
     * @param adressLine1
     */
    public void setAdressLine1(String adressLine1) {
        this.adressLine1 = adressLine1;
    }

    /**
     * @return adressLine2
     */
    public String getAdressLine2() {
        return adressLine2;
    }

    /**
     * @param adressLine2
     */
    public void setAdressLine2(String adressLine2) {
        this.adressLine2 = adressLine2;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     *
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return salesRepEmployeeNumber
     */
    public int getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    /**
     *
     * @param salesRepEmployeeNumber
     */
    public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    /**
     *
     * @return creditLimit
     */
    public float getCreditLimit() {
        return creditLimit;
    }

    /**
     *
     * @param creditLimit
     */
    public void setCreditLimit(float creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     *
     * @return String con una descripción del cliente
     */
    public String toString() {
        String string = "Nombre: " + this.customerName + "  .Contacto = " + this.contactFirstName + ", " + this.contactLastName + ".  Tlf: " + this.phone + ".  Dirección: " + this.adressLine1 + " " + this.adressLine2 + ", "
                + this.city + " (" + this.state + ") " + this.postalCode + ".";
        return string;
    }
}
