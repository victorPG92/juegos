package juegos.cartas.cartas.mazos.impl.gen;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.mazos.modelos.MazoCartasDeshacer;
import juegos.cartas.cartas.mazos.modelos.MazoCartasExtraccionConcreta;
import juegos.cartas.cartas.mazos.modelos.MazoCartasSimple;
import juegos.cartas.cartas.mazos.modelos.MazoConsulta;
import juegos.cartas.cartas.mazos.modelos.MazoInsercion;

/**
 * Mazo padre que tiene las partes necesarias para controlar los dominios de las cartas y creador de cartas
 * @author victor
 *
 * @param <C>
 * @param <N>
 * @param <P>
 */
public abstract class MazoGen<C extends CartaNumeroPalo<N, P>,N,P> 
implements
MazoCartasSimple<C>,
MazoCartasExtraccionConcreta<C>, 
MazoConsulta<C>,
MazoInsercion<C>,
MazoCartasDeshacer<C>
{

	protected Dominio<P> dominioPalos;
	protected Dominio<N> dominioValores;
	
	DominioValorPalo<N , P> dominioCompuesto;
	
	protected  int NUM_PALOS;//=  Palo.values().length;
	protected  int NUM_CARTAS;//= 13;
	
	protected SupplierNewCarta<C, N, P> supplierNewCarta;
	
	protected Deque<C> pilaCartasUsadas= new LinkedList<>();
	//protected Stack<C> pilaCartasUsadas= new Stack();
	
	
	public MazoGen(SupplierNewCarta<C, N, P> s, DominioValorPalo<N, P> domComp)
	{
		
		this(s, domComp.getDomPalo(),domComp.getDomValor());
		dominioCompuesto= domComp;
		
	}
	
	public MazoGen(SupplierNewCarta<C, N, P> s, Dominio<P> domP, Dominio<N> domN)
	{
		supplierNewCarta=s;
		dominioValores= domN;
		dominioPalos=domP;
		
		NUM_PALOS= dominioPalos.size();
		NUM_CARTAS= dominioValores.size();
		
	
	}


	public final Dominio<P> getDominioPalos() {
		return dominioPalos;
	}


	public final Dominio<N> getDominioValores() {
		return dominioValores;
	}


	public final int getNUM_PALOS() {
		return NUM_PALOS;
	}


	public final int getNUM_CARTAS() {
		return NUM_CARTAS;
	}


	public final SupplierNewCarta<C, N, P> getSupplierNewCarta() {
		return supplierNewCarta;
	}

	public final DominioValorPalo<N, P> getDominioCompuesto() {
		return dominioCompuesto;
	}
	
	/**
	 * Apila carta para deshacer el movimiento
	 * @param cartaRepartida
	 */
	public void apilaCartaRepartida(C cartaRepartida)
	{
		pilaCartasUsadas.push(cartaRepartida);
	}
	
	@Override
	public C ultimaCartaRepartida() {
		return pilaCartasUsadas.peek();
	}
	
	@Override
	public void deshacerReparto() {
		insertaCarta(ultimaCartaRepartida());
		
	}
	
}
