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
import sys.Implementar.ProductoDAOImplements;
import sys.dao.ProductoDAO;
import sys.modelo.Producto;

/**
 *
 * @author jeffa
 */
@ManagedBean
@Named(value = "productoBean")
@ViewScoped
public class ProductoBean {

    /**
     * Creates a new instance of ProductoBean
     */
    private Producto producto=null;
    private List<Producto> productos=null;
    
    public ProductoBean() {
    }
    
    //establecer acciones en vista como un select
     public List<Producto> getProductos() {
         ProductoDAO datos=new ProductoDAOImplements();
         this.productos=datos.select();
        return productos;
    }
     //---------------------------------
     //metodo creado para llamar a otros metodos de clase bean
     
     public void prepareProducto(){
         producto=new Producto();
     }
     //---------------------------------
     
     //---------------------------------
     
     //metodo creado insert, update, delete
     
     public void insertProducto(){
         ProductoDAO datos=new ProductoDAOImplements();
         datos.insert(producto);
     }
     
     public void updateProducto(){
         ProductoDAO datos=new ProductoDAOImplements();
         datos.update(producto);
     }
     
     public void deleteProducto(){
         ProductoDAO datos=new ProductoDAOImplements();
         datos.delete(producto);
     }     
     //---------------------------------

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

   

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
   
    
    
    
    
}
