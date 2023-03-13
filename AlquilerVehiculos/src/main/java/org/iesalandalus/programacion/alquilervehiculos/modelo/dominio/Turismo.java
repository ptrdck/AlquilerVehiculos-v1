package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Turismo extends Vehiculo
{
	
	private final static int FACTOR_CILINDRADA = 10;
	private int cilindrada;
	
	
	//Constructor con parámetros
	public Turismo(String marca, String modelo, int cilindrada, String matricula)
	{
		super(marca, modelo, matricula);
		
		setCilindrada(cilindrada);
		
	}
	
	//Constructor copia
	public Turismo (Turismo turismo)
	{
		super(turismo);
		
		if (turismo == null)
		{
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		}
		setCilindrada(turismo.getCilindrada());
		
	}
	public int getCilindrada() {
		
		return this.cilindrada;
	}
	
	private void setCilindrada(int cilindrada)
	{
		if (cilindrada<0 || cilindrada>5000)
		{
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
		}
		this.cilindrada = cilindrada;
	}
	
	

	@Override
	protected int getFactorPrecio() 
	{
		
		return cilindrada/FACTOR_CILINDRADA;
	}
	

	@Override
	public String toString() 
	{
		return String.format("%s %s (%sCV) - %s", super.getMarca(), super.getModelo(), cilindrada, super.getMatricula(), "disponible");
	}

	@Override
	public Vehiculo getVehiculoConMatricula(String matricula) {
		
		return new Turismo("Seat", "Cordoba", 1900, matricula);
	}

}
