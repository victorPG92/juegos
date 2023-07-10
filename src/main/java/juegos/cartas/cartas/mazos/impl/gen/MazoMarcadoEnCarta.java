package juegos.cartas.cartas.mazos.impl.gen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.ICartaNumeroPaloMarcada;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.mazos.modelos.func.MazoBarajear;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasDeshacer;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasExtraccionConcreta;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasSimple;
import juegos.cartas.cartas.mazos.modelos.func.MazoConsulta;
import juegos.cartas.cartas.mazos.modelos.func.MazoInsercion;

public class MazoMarcadoEnCarta<C extends ICartaNumeroPaloMarcada<N, P>,N,P> 
extends MazoGen<C, N, P>
implements
MazoCartasSimple<C>,
MazoCartasExtraccionConcreta<C>, 
MazoConsulta<C>,
MazoInsercion<C>,
MazoBarajear


{
	
	private C mazo[][];

	List<C> cartasOrdenadas;
		
	Random r = new Random(System.currentTimeMillis());

	
	boolean shuffle=true;
	private Comparator<C> comp;
	
	public MazoMarcadoEnCarta(SupplierNewCarta<C, N, P> s, DominioValorPalo<N, P, C> domVP)
	{
		this(s, domVP.getDomPalo(),domVP.getDomValor());
	}
	
	public MazoMarcadoEnCarta(SupplierNewCarta<C, N, P> s, Dominio<P> domP, Dominio<N> domV)
	{
		super(s,domP,domV);
		mazo =  supplierNewCarta.creaMatriz(NUM_PALOS,NUM_CARTAS);
		cartasOrdenadas= new LinkedList<>();
		for(P p : dominioPalos)
		{
			int indicePalo= dominioPalos.indexOf(p);
			
			for(int i=0;i<NUM_CARTAS;i++)//cambiado
			{
				//System.out.println(indicePalo+" "+ i);
				C carta=supplierNewCarta.creaNuevaCarta(dominioValores.get(i), p);//new Carta(i+1,p);
				
				//System.out.println(""+carta.getNumero() + carta.getPalo());
				
				mazo[indicePalo][i]= carta;
				cartasOrdenadas.add(carta);
			}
		}
		
		if(shuffle)
			barajear();
	}
	
	
	
	
	/**
	 * Extrae una carta del mazo
	 * 2 aleatoriios y lugo acceso constante
	 * @return carta aleatoria
	 */
	public C dameCartaAleatoria()
	{
		
		C cartaElegida=null;
		if(isEmpty())
			return cartaElegida;
		
		//porque si ya esta shuffle, se debe coger la cima, y no se recolocan indices
		 if(shuffle)
			 cartaElegida=   cartasOrdenadas.get(0);
		 else
			 cartaElegida=   cartasOrdenadas.get(r.nextInt(cartasOrdenadas.size()));
		 
		 if(cartaElegida.isMarcada())
			 return dameCartaAleatoria();
		 
		 cartaElegida.setMarcada(true);		 //-1
		 
		
		 return cartaElegida;
		 
		 
		
		
	}
	
	
	
	




	/**
	 * Extrae n cartas del mazo
	 * @return cartas aleatorias
	 */
	public List<C> dameNCartasAleatoria(int n)
	{
		 ArrayList<C> a = new  ArrayList<>();
		 for(int i=0;i<n;i++)
		 {
			 C carta = dameCartaAleatoria();
			 if(carta!=null)
			 a.add(carta);
		 }
		 
		 return a;
	}
	
	
	private C obtenerCartaInterna(C c)
	{
		if(c==null)
			return null;
		

		P palo = c.getPalo();
		int p = dominioPalos.indexOf(palo);// Palo.values()[nPalo];
		int n= dominioValores.indexOf(c.getNumero());
		if(n==NUM_CARTAS)n=0;
		
		
		C cartaObtenida =null;
		try {
			cartaObtenida= mazo[p][n];
		}catch(ArrayIndexOutOfBoundsException e)
		{
			return null;
		}
		return cartaObtenida;
	}

	@Override
	public void insertaCarta(C c) 
	{
		C cartaObtenida= obtenerCartaInterna(c);
		//si ya esta en el mazo, se inserta de nuevo, pero no repite
		// da igual el shuffle, se mete en el mazo, de una posicion aleatoria.

		if(cartaObtenida!=null && cartaObtenida.isMarcada())//!cartasOrdenadas.contains(c)
		{
			cartaObtenida.setMarcada(false);	
			cartasOrdenadas.add(r.nextInt(cartasOrdenadas.size()), cartaObtenida);
		}
		
	
		
		
				
	}




	@Override
	public void insertaCartas(List<C> l) 
	{
		for(C c: l)
			insertaCarta(c);
	}
	
	/**
	 * Devuelve si hay cartas en el mazo
	 * Coste constante
	 * @return
	 */
	public boolean estaVacio()
	{
		return cartasOrdenadas.isEmpty();
	}
	
	
	/**
	 * Coste constante
	 * @return
	 */
	public int quedanNumCartas()
	{
		return cartasOrdenadas.size();
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Devuelve si la carta c , est� en el mazo
	 * @param c
	 * @return
	 */
	public boolean perteneceCartaAMazo(C c)
	{
		return !estaSeleccionada(c);//mazo.contains(c);
	}
	
	

	
	/**
	 * Coste constante
	 */
	public void seleccionarCarta(C c )
	{
		C cartaObtenida= obtenerCartaInterna(c);
		if(cartaObtenida!=null) 
		{		
			cartaObtenida.setMarcada(true);
		}
	}
	
	/**
	 * Coste constante
	 */
	public boolean estaSeleccionada(C c)
	{
		C cartaObtenida= obtenerCartaInterna(c);
		if(cartaObtenida!=null) 
		{	
			return cartaObtenida.isMarcada();
		}
		return false;
	}




	@Override
/**
 * Coste constante
 */
	public C dameCartaConcreta(C cartaConcreta)
	{
		C cartaObtenida= obtenerCartaInterna(cartaConcreta);
		if(cartaObtenida!=null)
		{
			cartaObtenida.setMarcada(true);		
		}
		return cartaObtenida;		
		
	}
	









	@Override
	/**
	 * Coste lineal
	 */
	public List<C> dameNCartasConcretas(List<C> cartasConcretas) {
		
		List<C> cartas= new ArrayList<>();
		for (C carta : cartasConcretas) 
		{
			C c= dameCartaConcreta(carta);
			if(c!=null) {
				cartas.add(c);
			}
		}
		return cartas;
	}




	
	@Override
	public int size() {
		
		return cartasOrdenadas.size();
	}


	@Override
	public boolean isEmpty() {
		return cartasOrdenadas.isEmpty();
	}

	@Override
	public void barajear()
	{
		if(shuffle)
			Collections.shuffle(cartasOrdenadas);	
		else
			r = new Random(System.currentTimeMillis());
	}

	
}
