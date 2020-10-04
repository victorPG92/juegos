package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import juegos.cartas.cartas.cartas.Carta;
import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.cartas.PaloFrances;
import juegos.cartas.cartas.mazos.fact.FactMazoConcreto;
import juegos.cartas.cartas.mazos.fact.FactMazoConcretoEnums;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;

public class MazoTest 
{
	MazoGen mazo;
	
	@Before
	public void setUp() 
	{
		mazo= new FactMazoConcretoEnums().crearBarajaFrancesa();
	}
	
	
	
	@Test
	public void testDameCartaAleatoria() throws Exception 
	{
		 ICartaComparable carta = mazo.dameCartaAleatoria();
		
		Assert.assertNotNull(carta);
	
		
	}
	
	
	@Test
	public void testDameNCartaAleatoria() throws Exception 
	{
		int n=2;
		List<ICartaComparable> cartas = mazo.dameNCartasAleatoria(n);
		
		Assert.assertNotNull(cartas);
		
		Assert.assertTrue(!cartas.isEmpty());

	
		
	}
	
	
	@Test
	public void testDameCartaConcreta() throws Exception 
	{
		ICartaComparable cartaConcreta= new Carta(2,PaloFrances.CORAZONES);
		ICartaComparable carta=mazo.dameCartaConcreta(cartaConcreta);
		
		Assert.assertNotNull(carta);
	
		
		Assert.assertTrue(carta.equals(cartaConcreta));
		
	}
	
	
	@Test
	public void testDameNCartasConcretas() throws Exception 
	{
		int n=2;
		Carta cartaConcreta1= new Carta(1,PaloFrances.CORAZONES);

		Carta cartaConcreta2= new Carta(2,PaloFrances.CORAZONES);

		List<Carta> cartasConcretas= new ArrayList<>();
		
		cartasConcretas.add(cartaConcreta1);
		cartasConcretas.add(cartaConcreta2);

		
		List<Carta> cartas = mazo.dameNCartasConcretas(cartasConcretas);
		
		Assert.assertNotNull(cartas);
		
		Assert.assertTrue(!cartas.isEmpty());

		Assert.assertTrue(cartas.size()==cartasConcretas.size());
		
		for (int i = 0; i < cartas.size(); i++)
		{
			
			Carta carta= cartas.get(i);
			Carta cartaConcreta= cartasConcretas.get(i);
			Assert.assertTrue(carta.compareTo(cartaConcreta)==0);

		}

	}
	

}