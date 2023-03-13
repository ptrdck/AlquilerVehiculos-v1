package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Furgoneta extends Vehiculo
{
	private final static int FACTOR_PMA = 100;
	private final static int FACTOR_PLAZAS = 1;
	private int pma;
	private int plazas;

	public Furgoneta(String marca, String modelo, int pma, int plazas, String matricula) {
		super(marca, modelo, matricula);
		setPma(pma);
		setPlazas(plazas);
		
	}
	
	public Furgoneta(Furgoneta furgoneta)
	{
		super(furgoneta);
		
		if (furgoneta == null)
		{
			throw new NullPointerException("ERROR: No se puede copiar una furgoneta nula");
		}
		
		setPma(furgoneta.getPma());
		setPlazas(furgoneta.getPlazas());
	}

	@Override
	protected int getFactorPrecio() 
	{
		return (plazas*FACTOR_PLAZAS)+(pma/FACTOR_PMA);
	}

	public int getPma() 
	{
		return pma;
	}

	private void setPma(int pma) 
	{
		if (pma <0)
			throw new IllegalArgumentException("ERROR: El peso máximo debe ser un entero positivo");
		this.pma = pma;
	}

	public int getPlazas() 
	{
		return plazas;
	}

	private void setPlazas(int plazas)

	{
		if (plazas < 0)
		{
			throw new IllegalArgumentException("ERROR: El número de plazas debe ser un entero positivo");
		}
		this.plazas = plazas;
	}
	@Override
	public String toString() 
	{
		return String.format("%s %s (%sCV) - %s", super.getMarca(), super.getModelo(), pma, plazas, super.getMatricula(), "disponible");
	}

	@Override
	public Vehiculo getVehiculoConMatricula(String matricula) {
		
		return new Furgoneta("Seat", "Cordoba", 0, 0, matricula);
	}

}
