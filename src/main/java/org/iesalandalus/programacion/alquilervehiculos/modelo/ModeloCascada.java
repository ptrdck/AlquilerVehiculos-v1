package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IFuenteDatos;

public class ModeloCascada extends Modelo
{
	
	public ModeloCascada(IFuenteDatos fuenteDatos)
	{
		clientes = fuenteDatos.crearClientes();
		vehiculos = fuenteDatos.crearVehiculos();
		alquileres = fuenteDatos.crearAlquileres();
	}

	@Override
	public void insertar(Cliente cliente) throws OperationNotSupportedException 
	{
		
		clientes.insertar(cliente);
		
	}

	@Override
	public void insertar(Vehiculo turismo) throws OperationNotSupportedException 
	{
		vehiculos.insertar(turismo);
	}

	@Override
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException
	{

		//Declaraion de null
		if (alquiler == null)
		{
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}
		//Si el cliente no existe, no se puede insertar un alquiler
		if (buscar(alquiler.getCliente()) == null)
		{
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}
		//Si el turismo no existe, no puede insertarse el alquiler
		if (buscar(alquiler.getVehiculo()) == null)
		{
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		}
		/*
		else
			alquiler = new Alquiler(clientes.buscar(alquiler.getCliente()), turismos.buscar(alquiler.getTurismo()), alquiler.getFechaAlquiler());
		*/
		alquileres.insertar(alquiler);
	}

	@Override
	public Cliente buscar(Cliente cliente)
	{
		return clientes.buscar(cliente);
	}

	@Override
	public Vehiculo buscar(Vehiculo turismo)
	{
		return vehiculos.buscar(turismo);
	}

	@Override
	public Alquiler buscar(Alquiler alquiler)
	{
		return alquileres.buscar(alquiler);
	}

	@Override
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException
	{
		clientes.modificar(cliente, nombre, telefono);
	}

	@Override
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException
	{
		if (buscar(alquiler) == null)
		{
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		}
		alquileres.devolver(alquiler, fechaDevolucion);
	}

	@Override
	public void borrar(Cliente cliente) throws OperationNotSupportedException
	{
		for(Alquiler a : alquileres.get())
		{
			
			if (a.getCliente().equals(cliente))
			{
			borrar(a);
			}
		}	
		clientes.borrar(cliente);
		
	}

	@Override
	public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException
	{
		for(Alquiler a: alquileres.get())
		{
			if(a.getVehiculo().equals(vehiculo))
			{
				borrar(a);
			}
		}
		vehiculos.borrar(vehiculo);
	}
	
	@Override
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException 
	{
		alquileres.borrar(alquiler);
	}

	@Override
	public List<Cliente> getClientes() 
	{
		return new LinkedList<>(clientes.get());
	}

	@Override
	public List<Vehiculo> getVehiculos() 
	{
		return new LinkedList<>(vehiculos.get());
	}

	@Override
	public List<Alquiler> getAlquileres()
	{
		return new LinkedList<>(alquileres.get());
	}

	@Override
	public List<Alquiler> getAlquileres(Cliente cliente)
	{
		List<Alquiler> alquileresCliente = new LinkedList<Alquiler>();
		for (Alquiler alquiler: alquileres.get())
		{
			if (alquiler.getCliente().equals(cliente))
			{
				alquileresCliente.add(alquiler);
			}
		}
		return alquileresCliente;
		
	}

	@Override
	public List<Alquiler> getAlquileres(Vehiculo vehiculo)
	{
		List<Alquiler> alquileresVehiculos = new LinkedList<Alquiler>();
		for (Alquiler alquiler: alquileres.get())
		{
			if (alquiler.getVehiculo().equals(vehiculo))
			{
				alquileresVehiculos.add(alquiler);
			}
		}
		return alquileresVehiculos;
	}

}
