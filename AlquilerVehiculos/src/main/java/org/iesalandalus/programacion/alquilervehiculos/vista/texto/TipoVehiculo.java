package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public enum TipoVehiculo
{
	TURISMO("Turismo"),
	AUTOBUS("Autobus"),
	FURGONETA("Furgoneta");
	
	private String nombre;
	
	private TipoVehiculo(String nombre)
	{
		this.nombre = nombre;
	}
	
	private static boolean esOrdinalValido(int ordinal)
	{
		return ordinal >= 0 && ordinal <= values().length-1;
	}
	
	public static TipoVehiculo get(int ordinal)
	{
		if(esOrdinalValido(ordinal))
		{
			return values()[ordinal];
		}
		else
			throw new IllegalArgumentException("ERROR: Ordinal no válido.");
	}
	
	public static TipoVehiculo get(Vehiculo vehiculo)
	{
		if(vehiculo instanceof Turismo)
		{
			return TURISMO;
		}
		else if(vehiculo instanceof Autobus)
		{
			return AUTOBUS;
		}
		else 
			
			return FURGONETA;
		
			
	}
	
	public String toString()
	{
		return String.format("&d.-%s", ordinal(), nombre);
	}

}
