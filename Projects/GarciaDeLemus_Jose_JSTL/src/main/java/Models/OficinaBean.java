package Models;

import java.io.Serializable;

public class OficinaBean implements Serializable {
  private String codigo;
  private String ciudad;
  private String tlf;
  private String direccion1;
  private String direccion2;
  private String estado;
  private String pais;
  private String codigoPostal;
  private String territorio;

  public OficinaBean() {}

  public OficinaBean(
      String codigo,
      String ciudad,
      String tlf,
      String direccion1,
      String direccion2,
      String estado,
      String pais,
      String codigoPostal,
      String territorio) {
    this.codigo = codigo;
    this.ciudad = ciudad;
    this.tlf = tlf;
    this.direccion1 = direccion1;
    this.direccion2 = direccion2;
    this.estado = estado;
    this.pais = pais;
    this.codigoPostal = codigoPostal;
    this.territorio = territorio;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getTlf() {
    return tlf;
  }

  public void setTlf(String tlf) {
    this.tlf = tlf;
  }

  public String getDireccion1() {
    return direccion1;
  }

  public void setDireccion1(String direccion1) {
    this.direccion1 = direccion1;
  }

  public String getDireccion2() {
    return direccion2;
  }

  public void setDireccion2(String direccion2) {
    this.direccion2 = direccion2;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getCodigoPostal() {
    return codigoPostal;
  }

  public void setCodigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
  }

  public String getTerritorio() {
    return territorio;
  }

  public void setTerritorio(String territorio) {
    this.territorio = territorio;
  }

  @Override
  public String toString() {
    return "OficinaBean{" +
            "codigo='" + codigo + '\'' +
            ", ciudad='" + ciudad + '\'' +
            ", tlf='" + tlf + '\'' +
            ", direccion1='" + direccion1 + '\'' +
            ", direccion2='" + direccion2 + '\'' +
            ", estado='" + estado + '\'' +
            ", pais='" + pais + '\'' +
            ", codigoPostal='" + codigoPostal + '\'' +
            ", territorio='" + territorio + '\'' +
            '}';
  }
}
