package juegos.cartas.cartas.mazos.fact;


import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartas;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartasEnum;
import juegos.cartas.cartas.cartas.palos.PaloEspaniol;
import juegos.cartas.cartas.cartas.palos.PaloFrances;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCartaIntegerPaloEspaniol;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCartaIntegerPaloFrances;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCartaIntegerString;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;
import juegos.cartas.cartas.mazos.impl.gen.MazoGenOptMatrizLista;

/**
 * Crea mazos concretos de barajas espaniola y francesa con palos enums
 * @author victor
 *
 */
public class FactMazoConcretoEnums 
{
	public MazoGen<CartaNumeroPalo<Integer, PaloEspaniol>, Integer, PaloEspaniol> crearBarajaEspaniola()
	{
		MazoGen<CartaNumeroPalo<Integer, PaloEspaniol>, Integer, PaloEspaniol> mazo;
		FactDominiosCartasEnum fDom= new FactDominiosCartasEnum();	
		
		Dominio<PaloEspaniol> domP = fDom.getDominioPalosCartasEspaniolas();
		Dominio<Integer> domV = fDom.getDominioNumericoCartasEspaniolas();
	
		SupplierNewCarta<CartaNumeroPalo<Integer,PaloEspaniol>, Integer, PaloEspaniol> supplier= new SupplierNewCartaIntegerPaloEspaniol();
		mazo= new MazoGenOptMatrizLista<CartaNumeroPalo<Integer, PaloEspaniol>, Integer, PaloEspaniol>(supplier, domP, domV);		
		
		return mazo;
	}
	
	public MazoGen<CartaNumeroPalo<Integer, PaloFrances>, Integer, PaloFrances> crearBarajaFrancesa()
	{
		MazoGen<CartaNumeroPalo<Integer, PaloFrances>, Integer, PaloFrances> mazo;
		FactDominiosCartasEnum fDom= new FactDominiosCartasEnum();
		
		Dominio<PaloFrances> domP = fDom.getDominioPalosCartasFrancesa();
		Dominio<Integer> domV = fDom.getDominioNumericoCartasFrancesa();
	
		SupplierNewCarta<CartaNumeroPalo<Integer,PaloFrances>, Integer, PaloFrances> supplier= new SupplierNewCartaIntegerPaloFrances();
		mazo= new MazoGenOptMatrizLista<CartaNumeroPalo<Integer, PaloFrances>, Integer, PaloFrances>(supplier, domP, domV);		
		
		return mazo;
	}

}
