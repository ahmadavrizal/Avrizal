package Server;

import java.sql.SQLException;
import org.apache.xmlrpc.WebServer;
public class Server {
    public static void main(string() args throws SQLException){
        WebServer = new WebServer(1999);
        ws.addHandler ("ServerRPC", new Crud());
        ws.start();
        System.out.println("SERVER RPC AKTIF");
    }
}
