package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.FactoriaFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ModeloCascada;
import org.iesalandalus.programacion.alquilervehiculos.vista.texto.VistaTexto;


/**
 * 
 * @author Pedro Patricio Cárdenas Figueroa
 * Github: https://github.com/ptrdck/AlquilerVehiculos-v1.git
 * Tarea Online 6
 * Programación DAM 2022/23
 */
public class MainApp {

	public static void main(String[] args) {
		ModeloCascada modelo = new ModeloCascada(FactoriaFuenteDatos.MEMORIA.crear());
		VistaTexto vista = new VistaTexto();
		Controlador controlador = new Controlador(modelo, vista);
		
		controlador.comenzar();
		controlador.terminar();
	}

}
