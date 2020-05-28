package dao;

import entities.Cliente;
import util.Conexion;

public class ClienteDao 
	extends Conexion<Cliente> 
	implements GenericDao<Cliente> {
	
	public ClienteDao() {
		super(Cliente.class);
	}
}