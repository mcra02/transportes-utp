package Entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rutas.class)
public abstract class Rutas_ {

	public static volatile SingularAttribute<Rutas, Double> precio;
	public static volatile SingularAttribute<Rutas, Provincia> provinciaByPartida;
	public static volatile SingularAttribute<Rutas, Provincia> provinciaByDestino;
	public static volatile SetAttribute<Rutas, ?> pasajeses;
	public static volatile SingularAttribute<Rutas, Integer> idRuta;

}

