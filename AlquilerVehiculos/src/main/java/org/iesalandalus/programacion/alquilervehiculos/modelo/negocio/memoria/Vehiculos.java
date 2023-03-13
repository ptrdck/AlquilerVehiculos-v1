package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.util.LinkedList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IVehiculos;

public class Vehiculos implements IVehiculos 
{
	//inicialización de lista (0..*)
	private List<Vehiculo> coleccionVehiculos;
	
	//Constructor por defecto, crea lista
	public Vehiculos()
	{
		coleccionVehiculos = new LinkedList<>();
	}
	
	//método get para una nueva lista con los mismos elementos
	public List<Vehiculo> get()
	{
		//Iniciamos una nueva lista para dejar la copia
		List<Vehiculo> copiaVehiculos = new LinkedList<>();
		
		//For each para recorrer toda la lista de turismos
		for (Vehiculo vehiculo: coleccionVehiculos)
		{
			//copiamos cada turismo en la nueva lista
			copiaVehiculos.add(vehiculo);
		}
		return copiaVehiculos;
		
	}
	
	//Método para extraer la cantidad de turismos en la lista coleccionTurismos
	public int getCantidad()
	{
		return coleccionVehiculos.size();
	}
	
	//método para insertar un turismo si y solo si este existe y no es nulo
	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException
	{
		if (vehiculo == null)
		{
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		}
		else if (buscar(vehiculo) == null)
		{
			coleccionVehiculos.add(vehiculo);
		}
		else
		{
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		}
	}
	
	//Método para buscar un turismo si y solo este existe y no es nulo
	public Vehiculo buscar(Vehiculo vehiculo)
	{
		if (vehiculo == null)
		{
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		}
		else if (coleccionVehiculos.contains(vehiculo))
		{
			return coleccionVehiculos.get(coleccionVehiculos.indexOf(vehiculo));
		}
		else
			return null;
	}
	
	public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException
	{
		if (vehiculo == null)
		{
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		}
		else if (coleccionVehiculos.contains(vehiculo))
		{
			coleccionVehiculos.remove(vehiculo);
		}
		else
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
	}

}
