/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector;
import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
        
public class Client {
    
    Vector<String> vector = null;
    XmlRpcClient client = null;
    String severUrl;
    
    public Client() throws MalformedURLException{
        severUrl = "http://localhost:1999/RPC2";
        client = new XmlRpcClient(severUrl);
        vector = new vector<>();
    }
    
  Void showData() throws IOException{
      String ar = "";
      try{
          ar = (String)client.execute("serverRPC.getData", vector);
      }catch (XmlRpcException ex){
          Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      }catch (IOException ex){
          Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      }
      StringTokenizer st = new stringTokenizer(ar, "-");
      
      while(st.hasMoreTokens()){
          System.out.println(st.nextToken());
      }
      
  }
  Private void insertData(){
      String ar = "";
      try{
          vector.addElement("p");
          vector.addElement("p");
          vector.addElement("p");
          ar = (String)client.execute("ServerRPC.insertData", vector);
          vector = new Vector<>();
      }catch (XmlRpcException | IOException ex){
          Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      }
      Sytem.out.println(ar);
  }
  public static void main (String() args){
      try{
          Client c = new Client();
          c.showData();
          c.insertData();
      }catch (IOException ex){
          Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
    
}
