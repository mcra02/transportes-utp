package Entidad;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, String> apellidos;
	public static volatile SingularAttribute<Cliente, Distrito> distrito;
	public static volatile SingularAttribute<Cliente, Date> fechaNacimiento;
	public static volatile SingularAttribute<Cliente, String> direccion;
	public static volatile SingularAttribute<Cliente, Boolean> estadoCivil;
	public static volatile SingularAttribute<Cliente, Boolean> sexo;
	public static volatile SingularAttribute<Cliente, String> telefono;
	public static volatile SingularAttribute<Cliente, String> correoElectronico;
	public static volatile SingularAttribute<Cliente, String> dni;
	public static volatile SingularAttribute<Cliente, String> nombres;
	public static volatile SingularAttribute<Cliente, String> nacionalidad;

}

