package Entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Provincia.class)
public abstract class Provincia_ {

	public static volatile SingularAttribute<Provincia, Integer> idProvincia;
	public static volatile SetAttribute<Provincia, ?> rutasesForPartida;
	public static volatile SetAttribute<Provincia, ?> distritos;
	public static volatile SetAttribute<Provincia, ?> rutasesForDestino;
	public static volatile SingularAttribute<Provincia, Departamento> departamento;
	public static volatile SingularAttribute<Provincia, String> provinciaNombre;

}

