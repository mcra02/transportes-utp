package Entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Distrito.class)
public abstract class Distrito_ {

	public static volatile SingularAttribute<Distrito, String> distritoNombre;
	public static volatile SingularAttribute<Distrito, Provincia> provincia;
	public static volatile SetAttribute<Distrito, ?> clientes;
	public static volatile SingularAttribute<Distrito, Integer> idDistrito;

}

