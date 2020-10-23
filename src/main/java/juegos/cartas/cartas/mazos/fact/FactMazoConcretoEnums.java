package juegos.cartas.cartas.mazos.fact;


import juegos.cartas.cartas.cartas.CartaFrancesaOld;
import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartasEnumEsp;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartasEnumFr;
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
	FactDominiosCartasEnumFr<CartaFrancesaOld> fDomFr= new FactDominiosCartasEnumFr<>();	

	FactDominiosCartasEnumEsp fDomEs= new FactDominiosCartasEnumEsp();	

	public MazoGen<ICartaNumeroPalo<Integer, PaloEspaniol>, Integer, PaloEspaniol> crearBarajaEspaniola()
	{
		MazoGen<ICartaNumeroPalo<Integer, PaloEspaniol>, Integer, PaloEspaniol> mazo;
		
		Dominio<PaloEspaniol> domP = fDomEs.getDominioPalosCartasEspaniolas();
		Dominio<Integer> domV = fDomEs.getDominioNumericoCartasEspaniolas();
	
		SupplierNewCarta<ICartaNumeroPalo<Integer,PaloEspaniol>, Integer, PaloEspaniol> supplier= new SupplierNewCartaIntegerPaloEspaniol();
		mazo= new MazoGenOptMatrizLista<ICartaNumeroPalo<Integer, PaloEspaniol>, Integer, PaloEspaniol>(supplier, domP, domV);		
		
		return mazo;
	}
	
	public MazoGen<CartaFrancesaOld, Integer, PaloFrances> crearBarajaFrancesa()
	{
		MazoGen<CartaFrancesaOld, Integer, PaloFrances> mazo;
		
		Dominio<PaloFrances> domP = fDomFr.getDominioPalosCartasFrancesa();
		Dominio<Integer> domV = fDomFr.getDominioNumericoCartasFrancesa();
	
		SupplierNewCarta<CartaFrancesaOld, Integer, PaloFrances> supplier= new SupplierNewCartaIntegerPaloFrances();
		mazo= new MazoGenOptMatrizLista<CartaFrancesaOld, Integer, PaloFrances>(supplier, domP, domV);		
		
		return mazo;
	}

}
