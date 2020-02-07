/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generico;

import java.io.Serializable;

/**
 *
 * @author maicol
 */
public interface IGenericoEJB <Entity, K extends Serializable>{
    public Entity getById(K id);   
    
    public void crear(Entity entity);
    
    public void actualizar(Entity entity);

    public void eliminar(Entity entity);
}
