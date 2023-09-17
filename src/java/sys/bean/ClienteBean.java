/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import sys.Implementar.ClienteDAOImplements;
import sys.dao.ClienteDAO;
import sys.modelo.Cliente;

/**
 *
 * @author jeffa
 */
//crear el manage bean
@ManagedBean //conrolador
@Named(value = "clienteBean")
@ViewScoped
public class ClienteBean {
    
    private Cliente cliente=null;
    private List<Cliente> clients=null;
    
    public void prepareCliente(){
        this.cliente=new Cliente();
    }
    
    public void insertCliente(){
        ClienteDAO datos= new ClienteDAOImplements();
        datos.insert(cliente);
                
    }
    
    public void UpdateCliente(){
        ClienteDAO datos= new ClienteDAOImplements();
        datos.update(cliente);
        this.cliente=new Cliente();
    }
    
    public void deleteCliente(){
        
        ClienteDAO datos= new ClienteDAOImplements();
        datos.delete(cliente);
        this.cliente= new Cliente();
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClients() {
        ClienteDAO datos=new ClienteDAOImplements();
        this.clients=datos.select();
        return clients;
    }

    public void setClients(List<Cliente> clients) {
        this.clients = clients;
    }
    

    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
    }
    
}
