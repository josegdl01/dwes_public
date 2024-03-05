package sql;

import java.sql.*;

/**
 * @author José
 */
public class ConexionBBDD {
  private static Connection conex = null;
  private String user;
  private String pswd;
  private String url;

  private ConexionBBDD() {
    try {
      this.url = "jdbc:mysql://localhost:3336/classicmodels";
      this.user = "root";
      this.pswd = "XXXXX";

      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
      conex = DriverManager.getConnection(this.url, this.user, this.pswd);
      System.out.println("Conexión realizada con éxito");
    } catch (SQLException
        | ClassNotFoundException
        | InstantiationException
        | IllegalAccessException e) {
      System.out.println(e + " ERROR EN LA CONEXIÓN A LA BASE DE DATOS");
    }
  }

  public static Connection getConex() {

    if (conex == null) {
      new ConexionBBDD();
    }
    return conex;
  }

  public static void closeConex() {
    if (conex != null) {
      try {
        conex.close();
        conex = null;
      } catch (SQLException e) {
        System.out.println(e);
        ;
      }
    }
  }
}
