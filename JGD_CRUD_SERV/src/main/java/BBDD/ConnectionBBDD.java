package BBDD;



import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Enumeration;
import java.util.Properties;


public class ConnectionBBDD {
    final static Logger log = LoggerFactory.getLogger(ConnectionBBDD.class);
    private static Connection connection = null;

    private static String server = null;
    private static String port = null;
    private static String bd = null;
    private static String user = null;
    private static String pswd = null;

    public static Connection getConnection(){
        if(server == null && port == null && user == null && pswd == null ){
            try {
                Properties properties = new Properties();
                InputStream inputStream = ConnectionBBDD.class.getClassLoader().getResourceAsStream("bd.properties");
                properties.load(inputStream);

                Class.forName("org.mariadb.jdbc.Driver").newInstance();
                for(Enumeration keys = properties.keys(); keys.hasMoreElements();){
                    String propiedad = (String)keys.nextElement();

                    switch (propiedad) {
                        case "server":
                            server = properties.getProperty(propiedad);
                            break;
                        case "port":
                            port = properties.getProperty(propiedad);
                            break;
                        case "db":
                            bd = properties.getProperty(propiedad);
                            break;
                        case "user":
                            user = properties.getProperty(propiedad);
                            break;
                        case "password":
                            pswd = properties.getProperty(propiedad);
                            break;
                        default:
                            log.error("No se han recogido los valores correctamente.");
                    }
                }


            } catch (ClassNotFoundException |
                     InstantiationException |
                     IllegalAccessException |
                     IOException e) {
                log.error(e + " HA HABIDO UN FALLO EN EL PROCESO DE CONEXION A LA BASE DE DATOS");
            }
            try{
                if(connection == null || connection.isClosed()){
                    String connectionString = "jdbc:mariadb://"+server+":"+port+"/"+bd+"?user="+user+"&password="+pswd;
                    connection = DriverManager.getConnection(connectionString);
                    log.info("CONEXIÓN REALIZADA CON ÉXITO");
                }
            } catch (SQLException s) {
                log.error(s.toString());
            }
        }

        return connection;
    }

    public static void closeConnection(){
        if(connection != null){
            try{
                connection.close();
                log.info("CONEXIÓN CERRADA CON ÉXITO");
            } catch(SQLException s) {
                log.error("ERROR AL CERRAR LA CONEXIÓN A LA BBDD");
            }
        }
    }
}
