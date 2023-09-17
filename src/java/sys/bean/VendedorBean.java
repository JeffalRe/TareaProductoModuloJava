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
import sys.Implementar.VendedorDAOImplements;
import sys.dao.VendedorDAO;
import sys.modelo.Vendedor;

/**
 *
 * @author jeffa
 */
@ManagedBean
@Named(value = "vendedorBean")
@ViewScoped
public class VendedorBean {

    /**
     * Creates a new instance of VendedorBean
     */
    private Vendedor vendedor=null;
    private List<Vendedor> vendedores=null;
    
    public VendedorBean() {  
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Vendedor> getVendedores() {
        VendedorDAO datos=new VendedorDAOImplements();
        vendedores=datos.select();
        return vendedores;
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }
    
    public void prepareVendedor(){
        vendedor= new Vendedor();
    }
    
    public void insertVendedor(){
        VendedorDAO datos = new VendedorDAOImplements();
        datos.insert(vendedor);
    }
    
    public void updateVendedor(){
        VendedorDAO datos = new VendedorDAOImplements();
        datos.update(vendedor);
        vendedor = new Vendedor();
    }
    
    public void deleteVendedor(){
        VendedorDAO datos= new VendedorDAOImplements();
        datos.delete(vendedor);
        vendedor = new Vendedor();
    }
    
    
    
}
