package juegos.cartas.cartas.mazos.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import juegos.cartas.cartas.cartas.Carta;
import juegos.cartas.cartas.cartas.Palo;
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
public class MazoOptListaMapa 
implements 
MazoCartasSimple<Carta>,
MazoCartasExtraccionConcreta<Carta>,
MazoConsulta<Carta>,
MazoInsercion<Carta>
{
	private LinkedList<Carta> mazo;
	
	
	private Map<Carta,Boolean> estaUsada;
	
	Random r= new Random(System.currentTimeMillis());


	
	public MazoOptListaMapa()
	{
		mazo = new LinkedList<>();
		estaUsada=  new HashMap<>();
		for(Palo p : Palo.values())
		{
			for(int i=1;i<14;i++)
			{
				Carta carta= new Carta(i,p);
				mazo.add(carta);
				estaUsada.put(carta, false);
			}
		}
	
	}
	
	
	/**
	 * Coste lineal 
	 */
	public Carta dameCartaAleatoria()
	{
		int n= r.nextInt(mazo.size());
		Carta carta = mazo.remove(n);
		estaUsada.put(carta,true);
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



	/**
	 * coste cte
	 */
	@Override
	public void insertaCarta(Carta c)
	{
		mazo.add(c);
		estaUsada.put(c, false);
		
	}



	/**
	 * coste lineal
	 */
	@Override
	public void insertaCartas(List<Carta> l)
	{
		for(Carta c: l)
			insertaCarta(c);
		
	}



	/**
	 * Coste n
	 * intentar coste log n - busqqueda binaria
	 */
	@Override
	public Carta dameCartaConcreta(Carta cartaConcreta)
	{
		
		mazo.remove(cartaConcreta);
		estaUsada.put(cartaConcreta, false);
		
		
		
		
		return cartaConcreta;
	}



	@Override
	public List<Carta> dameNCartasConcretas(List<Carta> cartasConcretas) {

		List<Carta> cartas= new ArrayList<>();
		for (Carta carta : cartasConcretas) {
			cartas.add(dameCartaConcreta(carta));
		}
		
		cartas.removeAll(cartasConcretas);
		
		
		return cartas;
	}



	
	



	@Override
	public boolean perteneceCartaAMazo(Carta c)
	{
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
