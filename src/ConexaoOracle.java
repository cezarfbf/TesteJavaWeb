import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class ConexaoOracle {
	
	  private String host;
	    private String user;
	    private String pass;
	   
	    public Connection c;
	   
	    /**
	     * Construtor da classe
	     *
	     * @param host Host em que se deseja conectar
	     * @param user Nome do usuário
	     * @param pass Senha do usuário
	     */
	    public ConexaoOracle( String host, String user, String pass ) {
	        this.pass = pass;
	        this.user = user;
	        this.host = host;
	    }
	   
	    /**
	     * Método que estabelece a conexão com o banco de dados
	     *
	     * @return True se conseguir conectar, falso em caso contrário.
	     */
	    public boolean connect() {
	        boolean isConnected = false;
	        
	        String serverName = this.host;
	        String portNumber = "1521";
	        String servico    = "xe";
	        String userName   = this.user;
	        String passName   = this.pass;
	        String url = "jdbc:oracle:thin:@"+serverName + ":" + portNumber + ":" + servico; 
	             
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
	            this.c = DriverManager.getConnection(url,userName, passName);
	            isConnected = true;
	        } catch( SQLException e ) {
	            System.out.println(e.getMessage());
	            isConnected = false;
	        } catch ( ClassNotFoundException e ) {
	            System.out.println(e.getMessage());
	            isConnected = false;
	        } catch ( InstantiationException e ) {
	            System.out.println(e.getMessage());
	            isConnected = false;
	        } catch ( IllegalAccessException e ) {
	            System.out.println(e.getMessage());
	            isConnected = false;
	        }
	        return isConnected;
	    }
	    
	    


}
