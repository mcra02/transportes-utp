package Entidad;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pasajes.class)
public abstract class Pasajes_ {

	public static volatile SingularAttribute<Pasajes, Bus> bus;
	public static volatile SingularAttribute<Pasajes, Double> total;
	public static volatile SingularAttribute<Pasajes, Date> fechaLlegada;
	public static volatile SingularAttribute<Pasajes, String> asiento;
	public static volatile SingularAttribute<Pasajes, Date> fechaPartida;
	public static volatile SingularAttribute<Pasajes, Rutas> rutas;
	public static volatile SingularAttribute<Pasajes, String> dni;
	public static volatile SingularAttribute<Pasajes, Integer> idPasaje;

}

