package juegos.cartas.cartas.mazos.impl.gen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasExtraccionConcreta;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasSimple;
import juegos.cartas.cartas.mazos.modelos.func.MazoConsulta;
import juegos.cartas.cartas.mazos.modelos.func.MazoInsercion;

/**
 * MAZO MULTIPLE
 * Lleva varios mazos dentro con implementacion de 
 * matriz de cartas 
 * matriz de int para saber cuantas quedan de cada carta
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
public class MazoMultipleGenOptMatrizLista<C extends ICartaNumeroPalo<N, P>,N,P> 
extends MazoGen<C, N, P>
implements 
MazoCartasSimple<C>,
MazoCartasExtraccionConcreta<C>, 
MazoConsulta<C>,
MazoInsercion<C>

{
	private C mazo[][];
	private int numCartasIguales[][];

	List<C> cartasOrdenadas;
	
	int numMazos;
		
	Random r = new Random(System.currentTimeMillis());

	int indices[][];//= new int[4];
	
	boolean shuffle=true;
	
	public MazoMultipleGenOptMatrizLista(SupplierNewCarta<C, N, P> s, Dominio<P> domP, Dominio<N> domV, int numMazos)
	{
		super(s,domP,domV);
		
		this.numMazos=numMazos;
		
		mazo =  supplierNewCarta.creaMatriz(NUM_PALOS,NUM_CARTAS);
		numCartasIguales= new int[NUM_PALOS][NUM_CARTAS];
		cartasOrdenadas= new LinkedList<>();
		
		indices= new int [numMazos][domP.size()];
		
		for(int m=0;m<numMazos;m++)
		{
			for(P p : dominioPalos)
			{
				int indicePalo= dominioPalos.indexOf(p);
				
				for(int i=0;i<NUM_CARTAS;i++)//cambiado
				{
					System.out.println(indicePalo+" "+ i);
					C carta=supplierNewCarta.creaNuevaCarta(dominioValores.get(i), p);//new Carta(i+1,p);
					
					//System.out.println(""+carta.getNumero() + carta.getPalo());
					
					mazo[indicePalo][i]= carta;
					cartasOrdenadas.add(carta);
					numCartasIguales[indicePalo][i]++;
				}
				indices[m][indicePalo]=(m*NUM_CARTAS*NUM_PALOS)+NUM_CARTAS*indicePalo;
			}
		}
		
		if(shuffle)
			Collections.shuffle(cartasOrdenadas);
	}
	
	
	
	
	/**
	 * Extrae una carta del mazo
	 * 2 aleatoriios y lugo acceso constante
	 * @return carta aleatoria
	 */
	public C dameCartaAleatoria()
	{
		 C cartaElegida=cartasOrdenadas.get(r.nextInt(cartasOrdenadas.size()));
		 
		 numCartasIguales[dominioPalos.indexOf(cartaElegida.getPalo())-1][dominioValores.indexOf(cartaElegida.getNumero())-1]--;
		 
		 if(!shuffle)
			 desplazarIndices(cartaElegida.getPalo(),-1);
		 
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
	 * desplaza los indices desde ese palo, es decir, los siguientes
	 * @param palo
	 */
	private void desplazarIndices(P palo, int inc)
	{
		
		/*
		for(int i=dominioPalos.indexOf(palo)+1;i< dominioPalos.size();i++)
			indices[i]=indices[i]+inc;
		*/
	}




	/**
	 * Extrae n cartas del mazo
	 * @return cartas aleatorias
	 */
	public List<C> dameNCartasAleatoria(int n)
	{
		 ArrayList<C> a = new  ArrayList<>();
		 for(int i=0;i<n;i++)
			 a.add(dameCartaAleatoria());
		
		 
		 return a;
	}
	

	@Override
	public void insertaCarta(C c) 
	{
		P palo = c.getPalo();
		int p = dominioPalos.indexOf(palo);// Palo.values()[nPalo];
		int n= dominioValores.indexOf(c.getNumero());
		if(n==NUM_CARTAS)n=0;
		
		//si ya esta en el mazo, se inserta de nuevo, pero no repite
		numCartasIguales[p][n]++;
		
		if(!shuffle)
			desplazarIndices(palo, 1);
		
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
		if(c==null) return ;
		int n= dominioValores.indexOf(c.getNumero());
		if(n==13)n=1; // si es as
		int p= dominioPalos.indexOf(c.getPalo());
		if(!estaSeleccionada(c))
		{
			numCartasIguales[p][n]--;
			cartasOrdenadas.remove(c);
		}
		
	}
	
	/**
	 * Coste constante
	 */
	public boolean estaSeleccionada(C c)
	{
		if(c==null) return false;
		
		
		int n= dominioValores.indexOf(c.getNumero());
		if(n==13)n=1; // si es as
		int p= dominioPalos.indexOf(c.getPalo());
		boolean b=false;
		try
		{
			b= this.numCartasIguales[p][n]>0;
		}catch(Exception e)
		{
			System.err.println("mazo. esta seleccionada "+c + " "+ n +" "+ p );
			
			
		}
		return b;
	}




	@Override
/**
 * Coste constante
 */
	public C dameCartaConcreta(C cartaConcreta) {
		if(cartaConcreta==null) 
			return null;
		
		
		int n= dominioValores.indexOf(cartaConcreta.getNumero());//-1;
		if(n==13)n=1; // si es as
		int p= dominioPalos.indexOf(cartaConcreta.getPalo());
		boolean b=false;
		try
		{
			b= this.numCartasIguales[p][n]>0;
			
			
		}catch(Exception e)
		{
			System.err.println("mazo. esta seleccionada "+cartaConcreta + " "+ n +" "+ p );
			
		}
		if(b)
		{
			if(shuffle)
			{
				int indiceEncontrado=busquedaBinaria(cartaConcreta);
				
				if(indiceEncontrado!=-1)
					cartasOrdenadas.remove(indiceEncontrado);
			}else {
				cartasOrdenadas.remove(cartaConcreta);
			}
			return mazo[p][n];
		
			
		}
		else return null;
	}
	




	private int busquedaBinaria(C cartaConcreta) 
	{
		/*
		P palo= cartaConcreta.getPalo();
		int ipalo= dominioPalos.indexOf(palo);
		
		int limiteInf=indices[ipalo];
		int limiteSup=ipalo==dominioPalos.size()?cartasOrdenadas.size()-1:indices[ipalo+1];

		return busquedaBinaria(cartaConcreta,limiteInf,limiteSup);
		*/
		
		return  -1;
	}



/**
 * Se busca la carta dentro del mismo palo
 * @param cartaConcreta
 * @param limiteInf
 * @param limiteSup
 * @return
 */
	private int busquedaBinaria(C cartaConcreta, int limiteInf, int limiteSup) {
		
		if(limiteSup< limiteInf)
			return -1;
		
		int posMedia=(limiteSup+limiteInf)/2;
		C cartaMedia= cartasOrdenadas.get(posMedia);
		N numCartaMedia= cartaMedia.getNumero();
		N numCartaBuscado=cartaConcreta.getNumero();
		int comparacion=dominioValores.getComparator().compare(numCartaMedia,numCartaBuscado);
		if(cartaConcreta.equals(cartaMedia))
		{
			return posMedia;
		}
		else if(comparacion==1) 
		{
			N numLimInf= cartasOrdenadas.get(limiteInf).getNumero();
			if(numLimInf.equals(numCartaBuscado))
				return limiteInf;
			return busquedaBinaria(cartaConcreta,limiteInf,posMedia-1);
			
		}
		else
		{
			N numLimSup= cartasOrdenadas.get(limiteSup).getNumero();
			if(numLimSup.equals(numCartaBuscado))
				return limiteSup;
			return busquedaBinaria(cartaConcreta,posMedia+1,limiteSup);
			
		}
		
		//return 0;
	}




	@Override
	/**
	 * Coste lineal
	 */
	public List<C> dameNCartasConcretas(List<C> cartasConcretas) {
		
		List<C> cartas= new ArrayList<>();
		for (C carta : cartasConcretas) {
			cartas.add(dameCartaConcreta(carta));
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

	
	
}
