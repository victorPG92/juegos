package juegos.cartas.cartas.mazos.fact;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.Dominio;
import juegos.cartas.cartas.cartas.dom.FactDominiosCartas;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCartaIntegerString;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;
import juegos.cartas.cartas.mazos.impl.gen.MazoGenOptMatrizLista;

/**
 * Crea mazos concretos de barajas espaniola y francesa con palos string
 * @author victor
 *
 */
public class FactMazoConcreto 
{
	public MazoGen crearBarajaEspaniola()
	{
		MazoGen<CartaNumeroPalo<Integer, String>, Integer, String> mazo;
		FactDominiosCartas fDom= new FactDominiosCartas();
		
		Dominio<String> domP = fDom.getDominioPalosCartasEspaniolas();
		Dominio<Integer> domV = fDom.getDominioNumericoCartasEspaniolas();
	
		SupplierNewCarta<CartaNumeroPalo<Integer,String>, Integer, String> supplier= new SupplierNewCartaIntegerString();
		mazo= new MazoGenOptMatrizLista<CartaNumeroPalo<Integer, String>, Integer, String>(supplier, domP, domV);		
		
		return mazo;
	}
	
	public MazoGen crearBarajaFrancesa()
	{
		MazoGen<CartaNumeroPalo<Integer, String>, Integer, String> mazo;
		FactDominiosCartas fDom= new FactDominiosCartas();
		
		Dominio<String> domP = fDom.getDominioPalosCartasFrancesa();
		Dominio<Integer> domV = fDom.getDominioNumericoCartasFrancesa();
	
		SupplierNewCarta<CartaNumeroPalo<Integer,String>, Integer, String> supplier= new SupplierNewCartaIntegerString();
		mazo= new MazoGenOptMatrizLista<CartaNumeroPalo<Integer, String>, Integer, String>(supplier, domP, domV);		
		
		return mazo;
	}

}
