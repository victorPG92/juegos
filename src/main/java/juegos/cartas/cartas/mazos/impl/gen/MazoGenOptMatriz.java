package juegos.cartas.cartas.mazos.impl.gen;

import java.util.ArrayList;
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
 * matriz de cartas 
 * acceso constante
 * al pedir aleatoria, necesita 2 aleatorios
 * coste en espacio N*M
 * 
 * conteo , constante
 * saber si existe una carta, acceso constante
 * 
 * @author victor
 *
 */
//public class MazoOptMatrizGen<C extends CartaNumeroPalo<N, P>,N extends Enum<N>,P extends Enum<P>>  implements 
public class MazoGenOptMatriz<C extends ICartaNumeroPalo<N, P>,N,P> 
extends MazoGen<C, N, P>
implements
	MazoCartasSimple<C>,
	MazoCartasExtraccionConcreta<C>, 
	MazoConsulta<C>,
	MazoInsercion<C>
{
	
	private C mazo[][];
	private boolean seleccionada[][];
	private int cont;
	
	
	
	public MazoGenOptMatriz(SupplierNewCarta<C, N, P> s, Dominio<P> domP, Dominio<N> domN)
	{
		super(s,domP,domN);
		mazo =  s.creaMatriz(NUM_CARTAS, NUM_PALOS);
		
		
		seleccionada= new boolean[NUM_PALOS][NUM_CARTAS];
		cont = NUM_PALOS*NUM_CARTAS;
		for(P p : dominioPalos)
		{
			for(N n: dominioValores)//cambiado
				mazo[dominioPalos.indexOf(p)][dominioValores.indexOf(n)]= supplierNewCarta.creaNuevaCarta(n,p);//new Carta(i+1,p);
		}
	}
	
	
	
	
	/**
	 * Extrae una carta del mazo
	 * 2 aleatoriios y lugo acceso constante
	 * @return carta aleatoria
	 */
	public C dameCartaAleatoria()
	{
		if(cont==0){
			return null;
		}else{
		
			Random r = new Random(System.currentTimeMillis());
					
			int nPalo = r.nextInt(NUM_PALOS);
			int nCarta = r.nextInt(NUM_CARTAS);
			
			C c=null;
			do {
				
				P p =  dominioPalos.get(nPalo);
				N n =  dominioValores.get(nCarta);
				c = supplierNewCarta.creaNuevaCarta(n,p);
				
			}while(estaSeleccionada(c));
			
			
			cont--;
			seleccionarCarta(c);
			return c;
		}
		
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
	

	/**
	 * Coste cte
	 */
	@Override
	public void insertaCarta(C c) 
	{
		int p= dominioPalos.indexOf(c.getPalo());
		int n= dominioValores.indexOf(c.getNumero());//int p = c.getPalo().ordinal();// Palo.values()[nPalo];
		//int n= c.getNumero().ordinal();
		if(n==NUM_CARTAS)n=0;
		
		//si ya esta en el mazo, se inserta de nuevo, pero no repite
		seleccionada[p][n]=true;
		
	}




	/**
	 * coste lineal
	 */
	@Override
	public void insertaCartas(List<C> l) {

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
		return cont==0;//mazo.isEmpty();
	}
	
	
	/**
	 * Coste constante
	 * @return
	 */
	public int quedanNumCartas()
	{
		return cont;
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
			seleccionada[p][n]=true;
			cont--;
		}
		
	}
	
	/**
	 * Coste constante
	 */
	public boolean estaSeleccionada(C c)
	{
		if(c==null) return false;
		
		
		//int n= c.getNumero()-1;
		int n= dominioValores.indexOf(c.getNumero());
		if(n==13)n=1; // si es as
		int p= dominioPalos.indexOf(c.getPalo());
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
	public C dameCartaConcreta(C cartaConcreta) {
		if(cartaConcreta==null) 
			return null;
		
		
		//int n= cartaConcreta.getNumero()-1;
		int n= dominioValores.indexOf(cartaConcreta.getNumero());
		if(n==13)n=1; // si es as
		int p= dominioPalos.indexOf(cartaConcreta.getPalo());
		boolean b=false;
		try
		{
			b= this.seleccionada[p][n];
			
			
		}catch(Exception e)
		{
			System.err.println("mazo. esta seleccionada "+cartaConcreta + " "+ n +" "+ p );
			
			System.exit(-1);
		}
		if(!b)
			return mazo[p][n];
		else return null;
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
		
		return this.cont;
	}




	@Override
	public boolean isEmpty() {
		return size()==0;
	}




	




	
	
	
	
}
