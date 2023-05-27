package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IFuenteDatos;
public class ModeloCascada extends Modelo {

	public ModeloCascada(IFuenteDatos fuenteDatos) {
		setFuenteDatos(fuenteDatos);
	}

	@Override
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		clientes.insertar(cliente);
	}

	@Override
	public void insertar(Vehiculo turismo) throws OperationNotSupportedException {
		vehiculos.insertar(turismo);
	}

	@Override
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}
		if (buscar(alquiler.getCliente()) == null) {
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}
		if (buscar(alquiler.getVehiculo()) == null) {
			throw new OperationNotSupportedException("ERROR: No existe el vehículo del alquiler.");
		}
		alquileres.insertar(alquiler);
	}

	@Override
	public Cliente buscar(Cliente cliente) {
		return clientes.buscar(cliente);
	}

	@Override
	public Vehiculo buscar(Vehiculo vehiculo) {
		return vehiculos.buscar(vehiculo);
	}

	@Override
	public Alquiler buscar(Alquiler alquiler) {
		return alquileres.buscar(alquiler);
	}

	@Override
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		clientes.modificar(cliente, nombre, telefono);
	}

	@Override
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		for (Alquiler alquiler : alquileres.get()) {
			if (alquiler.getCliente().equals(cliente)) {
				borrar(alquiler);
			}
		}
		clientes.borrar(cliente);
	}

	@Override
	public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException {
		for (Alquiler alquiler : alquileres.get()) {
			if (alquiler.getVehiculo().equals(vehiculo)) {
				borrar(alquiler);
			}
		}
		vehiculos.borrar(vehiculo);
	}

	@Override
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		alquileres.borrar(alquiler);
	}

	@Override
	public List<Cliente> getClientes() {
		return new LinkedList<>(clientes.get());
	}

	@Override
	public List<Vehiculo> getVehiculos() {
		return new LinkedList<>(vehiculos.get());
	}

	@Override
	public List<Alquiler> getAlquileres() {
		return new LinkedList<>(alquileres.get());
	}

	@Override
	public List<Alquiler> getAlquileres(Cliente cliente) {
		List<Alquiler> alquileresCliente = new LinkedList<>();
		for (Alquiler alquiler : alquileres.get()) {
			if (alquiler.getCliente().equals(cliente)) {
				alquileresCliente.add(alquiler);
			}
		}
		return alquileresCliente;
	}

	@Override
	public List<Alquiler> getAlquileres(Vehiculo vehiculo) {
		List<Alquiler> alquileresVehiculo = new LinkedList<>();
		for (Alquiler alquiler : alquileres.get()) {
			if (alquiler.getVehiculo().equals(vehiculo)) {
				alquileresVehiculo.add(alquiler);
			}
		}
		return alquileresVehiculo;
	}

	@Override
	public void devolver(Cliente cliente, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (buscar(cliente) == null) {
			throw new OperationNotSupportedException("ERROR: El cliente no tiene alquileres registrados.");
		}
		alquileres.devolver(cliente, fechaDevolucion);
	}

	@Override
	public void devolver(Vehiculo vehiculo, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (buscar(vehiculo) == null) {
			throw new OperationNotSupportedException("ERROR: El vehículo no tiene alquileres registrados.");
		}
		alquileres.devolver(vehiculo, fechaDevolucion);
	}
}


