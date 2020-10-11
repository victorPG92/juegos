package juegos.cartas.cartas.mazos.fact;

import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartas;
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
	public MazoGen<ICartaNumeroPalo<Integer, String>, Integer, String> crearBarajaEspaniola()
	{
		MazoGen<ICartaNumeroPalo<Integer, String>, Integer, String> mazo;
		FactDominiosCartas fDom= new FactDominiosCartas();
		
		Dominio<String> domP = fDom.getDominioPalosCartasEspaniolas();
		Dominio<Integer> domV = fDom.getDominioNumericoCartasEspaniolas();
	
		SupplierNewCarta<ICartaNumeroPalo<Integer,String>, Integer, String> supplier= new SupplierNewCartaIntegerString();
		mazo= new MazoGenOptMatrizLista<ICartaNumeroPalo<Integer, String>, Integer, String>(supplier, domP, domV);		
		
		return mazo;
	}
	
	public MazoGen<ICartaNumeroPalo<Integer, String>, Integer, String> crearBarajaFrancesa()
	{
		MazoGen<ICartaNumeroPalo<Integer, String>, Integer, String> mazo;
		FactDominiosCartas fDom= new FactDominiosCartas();
		
		Dominio<String> domP = fDom.getDominioPalosCartasFrancesa();
		Dominio<Integer> domV = fDom.getDominioNumericoCartasFrancesa();
	
		SupplierNewCarta<ICartaNumeroPalo<Integer,String>, Integer, String> supplier= new SupplierNewCartaIntegerString();
		mazo= new MazoGenOptMatrizLista<ICartaNumeroPalo<Integer, String>, Integer, String>(supplier, domP, domV);		
		
		return mazo;
	}

}
