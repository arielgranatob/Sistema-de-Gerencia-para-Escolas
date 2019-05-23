package escola;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Persistencia {
    private static Connection conn = null;
 
    private Persistencia (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/escola", "root", "sereia123");
        } catch (ClassNotFoundException e){
            System.out.println("Não foi possível encontrar o Driver especificado " + e);
        } catch (SQLException ex){
            System.out.println("Não foi possível conectar ao BD " + ex);
        }
    }
    
    public static Connection conexao(){
        if(conn == null)
            new Persistencia();
        return conn;
    }

}