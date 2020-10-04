package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import juegos.cartas.cartas.mazos.fact.FactMazoConcretoEnums;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;

public class BarajaFrancesaFactTest
{
	
	@Test
	void testCrearBaraja() throws Exception {
		
		MazoGen mazo = new FactMazoConcretoEnums().crearBarajaFrancesa();
		
		Assert.assertNotNull(mazo);
	}

}
