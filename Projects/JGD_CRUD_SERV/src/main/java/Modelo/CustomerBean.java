package Modelo;

import java.io.Serializable;

public class CustomerBean implements Serializable {
    private int cusId;
    private String cusTaxCode;
    private String cusBusName;
    private String cusAddress;
    private String cusPhone;

    public CustomerBean(int cusId,
                        String cusTaxCode,
                        String cusBusName,
                        String cusAddress,
                        String cusPhone) {
        this.cusId = cusId;
        this.cusTaxCode = cusTaxCode;
        this.cusBusName = cusBusName;
        this.cusAddress = cusAddress;

        this.cusPhone = cusPhone;
    }

    public CustomerBean() {}

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getCusTaxCode() {
        return cusTaxCode;
    }

    public void setCusTaxCode(String cusTaxCode) {
        this.cusTaxCode = cusTaxCode;
    }

    public String getCusBusName() {
        return cusBusName;
    }

    public void setCusBusName(String cusBusName) {
        this.cusBusName = cusBusName;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    @Override
    public String toString() {
        return "CustomerBean{" +
                "cusId=" + cusId +
                ", cusTaxCode='" + cusTaxCode + '\'' +
                ", cusBusName='" + cusBusName + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                ", cusPhone='" + cusPhone + '\'' +
                '}';
    }
}
