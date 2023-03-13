package org.ies.alandalus.programacion.alquilervehiculos.modelo;

import org.ies.alandalus.programacion.alquilervehiculos.modelo.dominio.AlquilerTest;
import org.ies.alandalus.programacion.alquilervehiculos.modelo.dominio.ClienteTest;
import org.ies.alandalus.programacion.alquilervehiculos.modelo.negocio.AlquileresTest;
import org.ies.alandalus.programacion.alquilervehiculos.modelo.negocio.ClientesTest;
import org.ies.alandalus.programacion.alquilervehiculos.modelo.negocio.VehiculosTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ ClienteTest.class, ClientesTest.class, org.ies.alandalus.programacion.alquilervehiculos.modelo.dominio.VehiculoTest.class, VehiculosTest.class, 
	AlquilerTest.class, AlquileresTest.class, ModeloTest.class })
public class AllTests { }
