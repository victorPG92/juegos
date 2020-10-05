package juegos.cartas.cartas.mazos.impl.gen;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
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
MazoInsercion<C>
{

	protected Dominio<P> dominioPalos;
	protected Dominio<N> dominioValores;
	protected  int NUM_PALOS;//=  Palo.values().length;
	protected  int NUM_CARTAS;//= 13;
	
	protected SupplierNewCarta<C, N, P> supplierNewCarta;
	
	
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
	
	
}
