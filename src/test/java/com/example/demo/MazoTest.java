package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.cartas.palos.PaloFrances;
import juegos.cartas.cartas.mazos.fact.FactMazoConcretoEnums;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;

public class MazoTest 
{
	MazoGen mazo;
	
	//@BeforeAll
	@BeforeEach
	public void setUp() 
	{
		mazo= new FactMazoConcretoEnums().crearBarajaFrancesa();
	}
	
	
	
	@Test
	public void testDameCartaAleatoria() throws Exception 
	{
		try{
		 ICartaComparable carta = mazo.dameCartaAleatoria();
		
		Assert.assertNotNull(carta);
	
		}catch (Exception e) {
e.printStackTrace();		}
		
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
		ICartaComparable cartaConcreta= new CartaNumeroPalo<Integer,PaloFrances>(2,PaloFrances.CORAZONES);
		ICartaComparable carta=mazo.dameCartaConcreta(cartaConcreta);
		
		Assert.assertNotNull(carta);
	
		
		Assert.assertTrue(carta.equals(cartaConcreta));
		
	}
	
	
	@Test
	public void testDameNCartasConcretas() throws Exception 
	{
		int n=2;
		CartaNumeroPalo<Integer,PaloFrances> cartaConcreta1= new CartaNumeroPalo<Integer,PaloFrances>(1,PaloFrances.CORAZONES);

		CartaNumeroPalo<Integer,PaloFrances> cartaConcreta2= new CartaNumeroPalo<Integer,PaloFrances>(2,PaloFrances.CORAZONES);

		List<CartaNumeroPalo<Integer,PaloFrances>> cartasConcretas= new ArrayList<>();
		
		cartasConcretas.add(cartaConcreta1);
		cartasConcretas.add(cartaConcreta2);

		
		List<CartaNumeroPalo<Integer,PaloFrances>> cartas = mazo.dameNCartasConcretas(cartasConcretas);
		
		Assert.assertNotNull(cartas);
		
		Assert.assertTrue(!cartas.isEmpty());

		Assert.assertTrue(cartas.size()==cartasConcretas.size());
		
		for (int i = 0; i < cartas.size(); i++)
		{
			
			CartaNumeroPalo<Integer,PaloFrances> carta= cartas.get(i);
			CartaNumeroPalo<Integer,PaloFrances> cartaConcreta= cartasConcretas.get(i);
			Assert.assertTrue(carta.equals(cartaConcreta));

		}

	}
	

}