/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.componentes;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author jeffa
 */
@FacesValidator("vlogin")
public class ValidacionesLogin implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String nombreUsuario = value.toString().trim();

        if (nombreUsuario.length() == 0) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "ingrese un usuario"));

        } else {
            String expresionesLetras="^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$";
            boolean aceptable=Pattern.matches(expresionesLetras,nombreUsuario);
            if(!aceptable){
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "ingrese solo letras"));
            }
            
        }

    }

}
