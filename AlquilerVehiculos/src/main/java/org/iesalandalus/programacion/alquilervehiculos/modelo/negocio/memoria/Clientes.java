package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.util.LinkedList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;

public class Clientes implements IClientes 
{
	
	//Inicialización de lista (0..*)
	private List<Cliente> coleccionClientes;
	
	//Constructor por defecto, crea lista
	public Clientes()
	{
		coleccionClientes = new LinkedList<>();
	}
	
	//Creación de copia de clientes
	public List<Cliente> get()
	{
		// INiciamos una nueva lista
		List<Cliente> copiaClientes = new LinkedList<>();
		
		//iniciamos ciclo for each para recorrer toda la lista de clientes
		for (Cliente cliente : coleccionClientes)
		{
			//copiamos los clientes en la nueva lista
			copiaClientes.add(cliente);
		}
		
		return copiaClientes;
	}
	
	//a través de la herramienta .size() calculamos la cantidad de elementos en la lista coleccionClientes
	public int getCantidad()
	{
		return coleccionClientes.size();
	}
	
	//método para insertar cliente si y solo si este no existe o no es nulo.
	public void insertar(Cliente cliente) throws OperationNotSupportedException
	{
		if (cliente == null)
		{
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}
		else if (buscar(cliente) == null)
		{
			coleccionClientes.add(new Cliente(cliente));
		}
		else 
		{
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
		}
		
	}
	
	//Método que buscar un cliente ingresando por parámetro 
	public Cliente buscar(Cliente cliente)
	{
		if (cliente == null)
		{
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}
		//Condición que busca si el cliente existe en la colección.
		else if (coleccionClientes.contains(cliente))
		{
			return new Cliente(cliente);
		}
		//si no encuentra al cliente devuelve un null lo cual comunicará al insertar cliente
		else
			return null;
	}
	
	//método para borrar un cliente pasado por parámetro
	public void borrar(Cliente cliente) throws OperationNotSupportedException
	{
		if (cliente == null)
		{
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
		//usamos .remove para quitar al cliente de la lista
		else if (coleccionClientes.contains(cliente))
		{
			coleccionClientes.remove(cliente);
		}
		else
		{
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}
	}
	
	//método para modificar nombre y/o teléfono
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException
	{
		if (cliente == null)
		{
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}
		if (buscar(cliente) == null)
		{
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}
		if (cliente.getNombre() != null || cliente.getNombre().isEmpty())
		{
			cliente.setNombre(nombre);
		}
		if (cliente.getTelefono() != null || cliente.getTelefono().isEmpty())
		{
			cliente.setTelefono(telefono);
		}
	}
	

}
