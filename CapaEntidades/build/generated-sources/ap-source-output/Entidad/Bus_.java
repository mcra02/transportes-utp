package Entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bus.class)
public abstract class Bus_ {

	public static volatile SingularAttribute<Bus, Integer> idBus;
	public static volatile SingularAttribute<Bus, Integer> asientos;
	public static volatile SetAttribute<Bus, ?> pasajeses;
	public static volatile SingularAttribute<Bus, String> placa;

}

