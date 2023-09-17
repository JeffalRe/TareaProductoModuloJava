/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.modelo.Cliente;

/**
 *
 * @author jeffa
 */
public interface ClienteDAO {
    
    public List<Cliente> select();
    public void insert (Cliente cliente);
    public void update (Cliente cliente);
    public void delete (Cliente cliente);
    
}
