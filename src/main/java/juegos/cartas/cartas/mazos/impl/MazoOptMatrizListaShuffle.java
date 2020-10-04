package juegos.cartas.cartas.mazos.impl;

import java.util.ArrayList;
import java.util.Collections;
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
 * matriz de cartas 
 * acceso constante
 * al pedir aleatoria, necesita 2 aleatorios
 * coste en espacio N*M
 * 
 * conteo , constante
 * saber si existe una carta, acceso constante
 * 
 * Clase mixta donde las cartas ya las tengo ordenadas
 * 
 * @author victor
 *
 */
public class MazoOptMatrizListaShuffle 
implements 
MazoCartasSimple<Carta>,
MazoCartasExtraccionConcreta<Carta>, 
MazoConsulta<Carta>,
MazoInsercion<Carta>

{
	private Carta mazo[][];
	private boolean seleccionada[][];

	List<Carta> cartasDesordenadas;
	
	private static final  int NUM_PALOS=  PaloFrances.values().length;
	private static final  int NUM_CARTAS= 13;
	
	Random r = new Random(System.currentTimeMillis());

	
	public MazoOptMatrizListaShuffle()
	{
		mazo =  new Carta[NUM_PALOS][NUM_CARTAS];
		seleccionada= new boolean[NUM_PALOS][NUM_CARTAS];
		cartasDesordenadas= new LinkedList<>();
		for(PaloFrances p : PaloFrances.values())
		{
			for(int i=0;i<NUM_CARTAS;i++)//cambiado
			{
				Carta carta=new Carta(i+1,p);
				mazo[p.ordinal()][i]= carta;
				cartasDesordenadas.add(carta);
			}
		}
		
		Collections.shuffle(cartasDesordenadas);
	}
	
	
	
	
	/**
	 * Extrae una carta del mazo
	 * 2 aleatoriios y lugo acceso constante
	 * @return carta aleatoria
	 */
	public Carta dameCartaAleatoria()
	{
		 Carta cartaElegida=cartasDesordenadas.get(cartasDesordenadas.size()-1);
		 cartasDesordenadas.remove(cartasDesordenadas.size()-1);
		 
		 seleccionada[cartaElegida.getPalo().ordinal()-1][cartaElegida.getNumero()-1]=true;
		 
		 return cartaElegida;
		 
		 
		/*
		if(cont==0){
			return null;
		}else{
		
					
			int nPalo = r.nextInt(NUM_PALOS);
			int nCarta = r.nextInt(NUM_CARTAS);
			
			Palo p =  Palo.values()[nPalo];
			Carta c = new Carta(nCarta+1,p);
			
			while(estaSeleccionada(c))
			{
				nPalo = r.nextInt(NUM_PALOS);
				nCarta = r.nextInt(NUM_CARTAS);
				
				p =  Palo.values()[nPalo];
				c = new Carta(nCarta+1,p);
			}
			
			//cont--;
			seleccionarCarta(c);
			return c;
		}*/
		
	}
	
	
	
	
	/**
	 * Extrae n cartas del mazo
	 * @return cartas aleatorias
	 */
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
		int p = c.getPalo().ordinal();// Palo.values()[nPalo];
		int n= c.getNumero()-1;
		if(n==NUM_CARTAS)n=0;
		
		//si ya esta en el mazo, se inserta de nuevo, pero no repite
		seleccionada[p][n]=true;
		
	}




	@Override
	public void insertaCartas(List<Carta> l) {

		for(Carta c: l)
			insertaCarta(c);
	}
	
	/**
	 * Devuelve si hay cartas en el mazo
	 * Coste constante
	 * @return
	 */
	public boolean estaVacio()
	{
		return cartasDesordenadas.isEmpty();
	}
	
	
	/**
	 * Coste constante
	 * @return
	 */
	public int quedanNumCartas()
	{
		return cartasDesordenadas.size();
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Devuelve si la carta c , est� en el mazo
	 * @param c
	 * @return
	 */
	public boolean perteneceCartaAMazo(Carta c)
	{
		return !estaSeleccionada(c);//mazo.contains(c);
	}
	
	
	
	
	/**
	 * Coste constante
	 */
	public void seleccionarCarta(Carta c )
	{
		if(c==null) return ;
		int n= c.getNumero()-1;
		if(n==13)n=1; // si es as
		int p= c.getPalo().ordinal();
		if(!estaSeleccionada(c))
		{
			seleccionada[p][n]=true;
			cartasDesordenadas.remove(c);
		}
		
	}
	
	/**
	 * Coste constante
	 */
	public boolean estaSeleccionada(Carta c)
	{
		if(c==null) return false;
		
		
		int n= c.getNumero()-1;
		if(n==13)n=1; // si es as
		int p= c.getPalo().ordinal();
		boolean b=false;
		try
		{
			b= this.seleccionada[p][n];
		}catch(Exception e)
		{
			System.err.println("mazo. esta seleccionada "+c + " "+ n +" "+ p );
			
			System.exit(-1);
		}
		return b;
	}




	@Override
/**
 * Coste constante
 */
	public Carta dameCartaConcreta(Carta cartaConcreta) {
		if(cartaConcreta==null) 
			return null;
		
		
		int n= cartaConcreta.getNumero()-1;
		if(n==13)n=1; // si es as
		int p= cartaConcreta.getPalo().ordinal();
		boolean b=false;
		try
		{
			b= this.seleccionada[p][n];
			
			
		}catch(Exception e)
		{
			System.err.println("mazo. esta seleccionada "+cartaConcreta + " "+ n +" "+ p );
			
			System.exit(-1);
		}
		if(b)
		{
			cartasDesordenadas.remove(cartaConcreta);
			return mazo[p][n];
		
			
		}
		else return null;
	}
	




	@Override
	/**
	 * Coste lineal
	 */
	public List<Carta> dameNCartasConcretas(List<Carta> cartasConcretas) {
		
		List<Carta> cartas= new ArrayList<>();
		for (Carta carta : cartasConcretas) {
			cartas.add(dameCartaConcreta(carta));
		}
		return null;
	}




	
	@Override
	public int size() {
		
		return cartasDesordenadas.size();
	}


	@Override
	public boolean isEmpty() {
		return cartasDesordenadas.isEmpty();
	}

	
	
}
