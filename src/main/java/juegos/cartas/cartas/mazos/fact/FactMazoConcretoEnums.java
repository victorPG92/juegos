package juegos.cartas.cartas.mazos.fact;


import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartasEnum;
import juegos.cartas.cartas.cartas.palos.PaloEspaniol;
import juegos.cartas.cartas.cartas.palos.PaloFrances;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCartaIntegerPaloEspaniol;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCartaIntegerPaloFrances;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;
import juegos.cartas.cartas.mazos.impl.gen.MazoGenOptMatrizLista;

/**
 * Crea mazos concretos de barajas espaniola y francesa con palos enums
 * @author victor
 *
 */
public class FactMazoConcretoEnums 
{
	public MazoGen<ICartaNumeroPalo<Integer, PaloEspaniol>, Integer, PaloEspaniol> crearBarajaEspaniola()
	{
		MazoGen<ICartaNumeroPalo<Integer, PaloEspaniol>, Integer, PaloEspaniol> mazo;
		FactDominiosCartasEnum fDom= new FactDominiosCartasEnum();	
		
		Dominio<PaloEspaniol> domP = fDom.getDominioPalosCartasEspaniolas();
		Dominio<Integer> domV = fDom.getDominioNumericoCartasEspaniolas();
	
		SupplierNewCarta<ICartaNumeroPalo<Integer,PaloEspaniol>, Integer, PaloEspaniol> supplier= new SupplierNewCartaIntegerPaloEspaniol();
		mazo= new MazoGenOptMatrizLista<ICartaNumeroPalo<Integer, PaloEspaniol>, Integer, PaloEspaniol>(supplier, domP, domV);		
		
		return mazo;
	}
	
	public MazoGen<ICartaNumeroPalo<Integer, PaloFrances>, Integer, PaloFrances> crearBarajaFrancesa()
	{
		MazoGen<ICartaNumeroPalo<Integer, PaloFrances>, Integer, PaloFrances> mazo;
		FactDominiosCartasEnum fDom= new FactDominiosCartasEnum();
		
		Dominio<PaloFrances> domP = fDom.getDominioPalosCartasFrancesa();
		Dominio<Integer> domV = fDom.getDominioNumericoCartasFrancesa();
	
		SupplierNewCarta<ICartaNumeroPalo<Integer,PaloFrances>, Integer, PaloFrances> supplier= new SupplierNewCartaIntegerPaloFrances();
		mazo= new MazoGenOptMatrizLista<ICartaNumeroPalo<Integer, PaloFrances>, Integer, PaloFrances>(supplier, domP, domV);		
		
		return mazo;
	}

}
