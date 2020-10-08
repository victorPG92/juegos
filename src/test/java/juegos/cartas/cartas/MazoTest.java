package juegos.cartas.cartas;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.cartas.palos.PaloFrances;
import juegos.cartas.cartas.mazos.fact.FactMazoConcretoEnums;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;

public class MazoTest 
{
	MazoGen<CartaNumeroPalo<Integer, PaloFrances>, Integer, PaloFrances> mazo;
	
	//@BeforeAll
	@BeforeEach
	public void setUp() 
	{
		mazo = new FactMazoConcretoEnums().crearBarajaFrancesa();
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
		 List<CartaNumeroPalo<Integer, PaloFrances>> cartas = mazo.dameNCartasAleatoria(n);
		
		Assert.assertNotNull(cartas);
		
		Assert.assertTrue(!cartas.isEmpty());

	
		
	}
	
	
	@Test
	public void testDameCartaConcreta() throws Exception 
	{
		
		System.out.println("empezando el test carta concreta");
		CartaNumeroPalo<Integer,PaloFrances> cartaConcreta= new CartaNumeroPalo<Integer,PaloFrances>(2,PaloFrances.CORAZONES);
		CartaNumeroPalo<Integer,PaloFrances> carta = mazo.dameCartaConcreta(cartaConcreta);
		
		Assert.assertNotNull(carta);
	
		System.out.println(carta);
		
		Assert.assertTrue(carta.equals(cartaConcreta));
		
	}
	
	
	@Test
	public void testDameNCartasConcretas() throws Exception 
	{
		//int n=2;
		CartaNumeroPalo<Integer,PaloFrances> cartaConcreta1= new CartaNumeroPalo<Integer,PaloFrances>(1,PaloFrances.CORAZONES);

		CartaNumeroPalo<Integer,PaloFrances> cartaConcreta2= new CartaNumeroPalo<Integer,PaloFrances>(2,PaloFrances.CORAZONES);

		List<CartaNumeroPalo<Integer,PaloFrances>> cartasConcretas= new ArrayList<>();
		
		cartasConcretas.add(cartaConcreta1);
		cartasConcretas.add(cartaConcreta2);

		
		List<CartaNumeroPalo<Integer,PaloFrances>> cartas = mazo.dameNCartasConcretas(cartasConcretas);
		
		System.out.println("cartas nulas");
		Assert.assertNotNull(cartas);
		
		System.out.println("mazo vacio");
		Assert.assertTrue(!cartas.isEmpty());

		
		System.out.println("cartas tam");
		Assert.assertTrue(cartas.size()==cartasConcretas.size());
		
		for (int i = 0; i < cartas.size(); i++)
		{
			
			CartaNumeroPalo<Integer,PaloFrances> carta= cartas.get(i);
			CartaNumeroPalo<Integer,PaloFrances> cartaConcreta= cartasConcretas.get(i);
			
			System.out.println(carta + " == "+ cartaConcreta);
			Assert.assertTrue(carta.equals(cartaConcreta));

		}

	}
	

}