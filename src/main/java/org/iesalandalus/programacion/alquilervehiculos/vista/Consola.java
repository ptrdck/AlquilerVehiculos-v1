package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola
{
	//Declaración de patrones fecha y formato del cual se hará comparación entre ellos
	private static final String PATRON_FECHA = "dd/MM/yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Consola()
	{
		
	}
	
	public static void mostrarCabecera(String mensaje)
	{
		System.out.printf("%n%s%n", mensaje);
		String formatoCadena = "%0" + mensaje.length() + "d%n";
		System.out.println(String.format(formatoCadena, 0).replace("0", "-"));
	}
	
	public static void mostrarMenu()
	{
		//recorremos el array del menú con el for each
		for(Opcion opcion: Opcion.values())
		{
			System.out.println(opcion);
		}
		
	}

	private static String leerCadena (String mensaje)
	{
		System.out.print(mensaje);
		
		return Entrada.cadena();
	}
	
	private static int leerEntero(String mensaje)
	{
		
		System.out.print(mensaje);
		
		return Entrada.entero();
	}
	
	private static LocalDate leerFecha(String mensaje)
	{
		LocalDate fecha = null;
	    do {
	        try {
	            System.out.print(mensaje);
	            String fechaStr = Entrada.cadena();
	            fecha = LocalDate.parse(fechaStr, FORMATO_FECHA);
	        } catch (DateTimeParseException e) {
	            System.out.println("La fecha introducida no tiene el formato válido (" + PATRON_FECHA + ")");
	        }
	    } while (fecha == null);
	    return fecha;
	}
	
	public static Opcion elegirOpcion()
	{
		int opcion = 0;
		boolean verificador =false;
		do 
		{
			try 
			{
				opcion = leerEntero("\nPor favor, seleccione una Opción: ");
				Opcion.get(opcion);
				verificador = true;
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				verificador = false;
			}
			
		}while (!verificador);
		
		return Opcion.get(opcion);
	}
	
	public static Cliente leerCliente()
	{
		String dni = leerCadena("\nIntroduzca el dni: ");
		String nombre = leerNombre();
		String telefono = leerTelefono();
		
		return new Cliente(nombre, dni, telefono);
		
	}
	
	public static Cliente leerClienteDni()
	{
		System.out.print("Introduzca el DNI del cliente: ");
		String dni = leerCadena("DNI: ");
		
		return new Cliente("Pedro Cardenas", dni, "644493658");
		
			
	}
	
	public static String leerNombre()
	{
		System.out.print("\nIntroduzca el nombre del cliente: ");
		String nombre = leerCadena("\nNombre: ");
		return nombre;
	}
	
	public static String leerTelefono()
	{
		System.out.print("\nIntroduzca el número de teléfono del cliente");
		String telefono = leerCadena("\nTelefono: ");
		return telefono;
	}
	
	public static Vehiculo leerVehiculo()
	{
		String marca = leerCadena("\nMarca " + "(Seat|Land Rover|KIA|Rolls-Royce|SsangYong):\n");
		String modelo = leerCadena("\nModelo: ");
		int cilindrada = leerEntero("\nCilindrada: ");
		String matricula = leerCadena("\nMatrícula: ");
		
		return new Vehiculo(marca, modelo, cilindrada, matricula);
	}
	
	public static Vehiculo leerVehiculooMatricula()
	{
		String matricula = leerCadena("Introduce la matrícula del turismo: ");
	    return new Vehiculo("Seat", "Cordoba", 1500, matricula);
	}
	
	public static Alquiler leerAlquiler()
	{
		Cliente cliente = leerClienteDni();
		Vehiculo turismo = leerVehiculoMatricula();
		LocalDate fechaAlquiler = leerFecha("Fecha alquiler: ");
		
		return new Alquiler(cliente, turismo, fechaAlquiler);
	}
	
	public static LocalDate leerFechaDevolucion()
	{
		LocalDate fechaDevolucion = leerFecha("Fecha devolucion: ");
		
		return fechaDevolucion;
	}

}
