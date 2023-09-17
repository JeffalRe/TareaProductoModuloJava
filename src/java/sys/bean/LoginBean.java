/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;


import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.PrimeFaces;
import sys.Implementar.UsuarioDAOImplementes;
import sys.dao.UsuarioDAO;
import sys.modelo.Usuario;


/**
 *
 * @author jeffal
 */
@ManagedBean
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{
    
    private Usuario usuario;
    private String nombreUsuario;
    private String password;
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        this.usuario=new Usuario();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
 
    
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
   
    public void login() {
        FacesMessage message = null;
        boolean loggedIn = false;
        String ruta="";
        //implementar la consulta 
        UsuarioDAO datos=new UsuarioDAOImplementes();
        this.usuario=datos.login(usuario);
        
        
        if(this.usuario != null ) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",this.usuario.getNombreUsuario());
            loggedIn = true;
             message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Loggin Correcto", this.usuario.getNombreUsuario());
            ruta="/FacturationReisb/faces/views/Bienvenido.xhtml";
            //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
           
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Loggin Error", "Contraseña o Usuario Erroneo");
            usuario=new Usuario();
        }
        
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
        PrimeFaces.current().ajax().addCallbackParam("ruta", ruta);
    
    }
    
    public String logout(){
        this.nombreUsuario=null;
        this.password=null;
        
        HttpSession httpsession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpsession.invalidate(); //borra la sesion
        return "/Login";
    }
}
