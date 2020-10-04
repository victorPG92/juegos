package juegos.cartas.cartas.mazos.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import juegos.cartas.cartas.cartas.Carta;
import juegos.cartas.cartas.cartas.palos.PaloFrances;
import juegos.cartas.cartas.mazos.modelos.MazoCartasExtraccionConcreta;
import juegos.cartas.cartas.mazos.modelos.MazoCartasSimple;
import juegos.cartas.cartas.mazos.modelos.MazoConsulta;
import juegos.cartas.cartas.mazos.modelos.MazoInsercion;

/**
 * Mazo peor.
 * bueno que una lista enlazada puede borrar en el medio sin reordenar las otras
 * pero el acceso indice no es constante
 * 
 * Lista enlazada, al borrar , quita del medio
 * @author victor
 *
 */
public class MazoOptListaEnlazadaOrdenada implements
MazoCartasSimple<Carta>,
MazoCartasExtraccionConcreta<Carta>, 
MazoConsulta<Carta>,
MazoInsercion<Carta>

{
	private LinkedList<Carta> mazo;
	
	private List<Carta> cartasUsadas;
	
	
	Random r= new Random(System.currentTimeMillis());


	
	public MazoOptListaEnlazadaOrdenada()
	{
		mazo = new LinkedList<>();
		cartasUsadas = new LinkedList<>();
		for(PaloFrances p : PaloFrances.values())
		{
			for(int i=1;i<14;i++)//cambiado
				mazo.add(new Carta(i,p));
		}
	
	}
	
	
	/**
	 * 
	 */
	public Carta dameCartaAleatoria()
	{
		int n= r.nextInt(mazo.size());
		Carta carta = mazo.remove(n);
		cartasUsadas.add(carta);
		return carta;
		
	}



	@Override
	public List<Carta> dameNCartasAleatoria(int n) 
	{
		
		 ArrayList<Carta> a = new  ArrayList<>();
		 for(int i=0;i<n;i++)
			 a.add(dameCartaAleatoria());
		
		 
		 return a;
	}



	@Override
	public void insertaCarta(Carta c)
	{
		mazo.add(c);
		
	}



	@Override
	public void insertaCartas(List<Carta> l)
	{
		mazo.addAll(l);
		/*
		for(Carta c: l)
			insertaCarta(c);
		*/
	}



	/**
	 * Coste n
	 * intentar coste log n - busqqueda binaria
	 */
	@Override
	public Carta dameCartaConcreta(Carta cartaConcreta)
	{		
		
		mazo.remove(cartaConcreta);
		return cartaConcreta;
		/*
		 * Palo palo = cartaConcreta.getPalo();
		int ord=palo.ordinal();
		
		
		Carta pivote= mazo.get(ord*10);// coste lineal
		
		
		Carta cartaBuscada= null;
		
		
		
		return cartaBuscada;
		*/
	}



	/**
	 * Suponer que las cartas existen 
	 */
	@Override
	public List<Carta> dameNCartasConcretas(List<Carta> cartasConcretas) {
		/*List<Carta> cartas= new ArrayList<>();
		for (Carta carta : cartasConcretas) {
			cartas.add(dameCartaConcreta(carta));
		}*/
		
		mazo.removeAll(cartasConcretas);

		
		
		return cartasConcretas;

	}



	
	



	@Override
	public boolean perteneceCartaAMazo(Carta c) {
		return mazo.contains(c);
	}
	
	
	@Override
	public int size() {
		
		return mazo.size();
	}


	@Override
	public boolean isEmpty() {
		return mazo.isEmpty();
	}

}
