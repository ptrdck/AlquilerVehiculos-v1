package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public abstract class Vehiculo {

	//Declaración de expresión regular para validar la marca del turismo.
	private final static String ER_MARCA = "^(Seat|Land Rover|KIA|Rolls-Royce|SsangYong)$";
	
	//Declaración de expresión regular para validar matrícula.
	private final static String ER_MATRICULA = "^[0-9]{1,4}(?!.*(LL|CH))[BCDFGHJKLMNPRSTVWXYZ]{3}";
			
	//Declaración de atributos
	private String marca;
	private String modelo;
	private String matricula;
	
	//Constructor con parámetros
	protected Vehiculo(String marca, String modelo, String matricula)
	{
		setMarca(marca);
		setModelo(modelo);
		setMatricula(matricula);
		
	}
	
	//Constructor copia
	protected Vehiculo (Vehiculo vehiculo)
	{
		if (vehiculo == null)
		{
			throw new NullPointerException("ERROR: No es posible copiar un vehículo nulo.");
		}
		
		setMarca(vehiculo.getMarca());
		setModelo(vehiculo.getModelo());
		setMatricula(vehiculo.getMatricula());
	}
	
	public Vehiculo copiar(Vehiculo vehiculo)
	{
		if (vehiculo == null)
		{
			throw new NullPointerException("ERROR: No es posible copiar un vehículo nulo.");
		}
		if (vehiculo instanceof Turismo)
		{
			return new Turismo((Turismo) vehiculo);
		}
		else if (vehiculo instanceof Autobus)
		{
			return new Autobus((Autobus) vehiculo);
		}
		else if (vehiculo instanceof Furgoneta)
		{
			return new Furgoneta((Furgoneta) vehiculo);
		}
		else
			throw new IllegalArgumentException("ERROR: El tipo vehículo no corresponde.");
	}
	
	
	public abstract Vehiculo getVehiculoConMatricula(String matricula);

	protected abstract int getFactorPrecio();

	
	//getters
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	
	//Setter que valida marca solo si no es nulo y si cumple el patrón establecido como expresion regular
	protected void setMarca(String marca) 
	{
		
		if (marca == null)
		{
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		}
		
		if (!marca.matches(ER_MARCA))
		{
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		}
		this.marca = marca;
	}
	
	//setter para validar el modelo a ingresar. Valida solo si no está vacío. 
	protected void setModelo(String modelo) 
	{
		if (modelo == null)
		{
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		}
		if (modelo.isEmpty())
		{
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
		}
		
		this.modelo = modelo;
	}
	
	
	//valida Matricula si y solo si no es nula y si cumple el patrón establecido en la expresion regular
	protected void setMatricula(String matricula) 
	{
		if (matricula == null)
		{
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		if (!matricula.matches(ER_MATRICULA))
		{
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
		}
		this.matricula = matricula;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	/**
	 * Método equals implementado con el método instanceOf para comparar
	 * si el objeto recibido no es un vehículo. 
	 */
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null || !(obj instanceof Vehiculo))
	        return false;
	    Vehiculo other = (Vehiculo) obj;
	    return Objects.equals(matricula, other.matricula);
	}	
	
	
}

