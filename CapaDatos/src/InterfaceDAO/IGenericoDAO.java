/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDAO;

import java.io.Serializable;

/**
 *
 * @author maico
 */
public interface IGenericoDAO <Entity, PK extends Serializable> {
    public Entity getById(PK id);

    public void crear(Entity entity);

    public void actualizar(Entity entity);

    public void eliminar(Entity entity);
}
