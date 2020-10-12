package juegos.cartas.cartas.mazos.fact;

import java.util.EnumMap;

import org.yaml.snakeyaml.events.MappingEndEvent;

import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;
import juegos.cartas.cartas.cartas.dom.fact.FactDominioDobleVP;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartasEnumEsp;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartasEnumFr;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartasEsp;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartasFr;
import juegos.cartas.cartas.cartas.modelos.ICartaNumeroPaloEspaniola;
import juegos.cartas.cartas.cartas.modelos.ICartaNumeroPaloFrancesa;
import juegos.cartas.cartas.cartas.palos.PaloEspaniol;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;
import juegos.cartas.cartas.mazos.modelos.suppliers.SupplierMazo;
import juegos.cartas.cartas.mazos.modelos.suppliers.SupplierMazoGenMatrizLista;

/**
 * Fachada de factoria de mazos clasicos ya implementados
 * @author victor
 *
 */
public class FactMazoEspFr 
{
	
	SupplierNewCarta
	<ICartaNumeroPaloEspaniola
	<Integer, String>,
	Integer,String> supplierCartaES_IS;
	
	SupplierNewCarta
	<ICartaNumeroPaloEspaniola
	<Integer, PaloEspaniol>,
	Integer,PaloEspaniol> supplierCartaES_IE;
	
	SupplierNewCarta
	<ICartaNumeroPaloFrancesa
	<Integer, String>,
	Integer,String> supplierCartaFR_IS;
	
	SupplierNewCarta
	<ICartaNumeroPaloFrancesa
	<Integer, PaloEspaniol>,
	Integer,PaloEspaniol> supplierCartaFR_IE;
	
	EnumMap<TipoClasico,EnumMap<TipoParametrizacion,SupplierNewCarta>> 
	suppliersCarta= new EnumMap<>(TipoClasico.class);
	
	
	FactDominiosCartasFr fDomFr_FR_IS= new FactDominiosCartasFr();
	FactDominiosCartasEnumFr fDomFr_FR_IE= new FactDominiosCartasEnumFr();
	FactDominiosCartasEsp fDomFr_ES_IS= new FactDominiosCartasEsp();
	FactDominiosCartasEnumEsp fDomFr_ES_IE= new FactDominiosCartasEnumEsp();
	EnumMap<TipoClasico,EnumMap<TipoParametrizacion,FactDominioDobleVP>> 
	factsDom= new EnumMap<>(TipoClasico.class);
	
	EnumMap<TipoClasico,EnumMap<TipoParametrizacion,DominioValorPalo>> 
	dominiosVP= new EnumMap<>(TipoClasico.class);
	
	SupplierMazo supplierMazoML= new SupplierMazoGenMatrizLista<>();
	EnumMap<TipoImplementacionMazo,SupplierMazo> suppliersMazo= new EnumMap<>(TipoImplementacionMazo.class);
	
	/*
	SupplierMazo<ICartaNumeroPalo<N,P>, N, P> supplierMazoListaMatriz=
			new SupplierMazoGenMatrizLista<>();
	
	*/
	
	public FactMazoEspFr()
	{
		for(TipoClasico tipoClasico: TipoClasico.values())
		{
			dominiosVP.put(tipoClasico, new EnumMap<>(TipoParametrizacion.class));

		}
		
		inicializaFactDom();
		inicializaSuppliersCarta();
		
		suppliersMazo.put(TipoImplementacionMazo.listaMatriz,supplierMazoML);
		
		
		
		
		
		/*dominiosVP.put(TipoClasico.Espaniola, new EnumMap<>(TipoParametrizacion.class));
		dominiosVP.put(TipoClasico.Francesa, new EnumMap<>(TipoParametrizacion.class));*/
		
	}
	
	private void inicializaFactDom()
	{
		EnumMap<TipoParametrizacion,FactDominioDobleVP> mapaFr= new EnumMap<>(TipoParametrizacion.class);
		mapaFr.put(TipoParametrizacion.Int_Enum, fDomFr_FR_IE);
		mapaFr.put(TipoParametrizacion.Int_String, fDomFr_FR_IS);
		factsDom.put(TipoClasico.Francesa, mapaFr);
		
		
		EnumMap<TipoParametrizacion,FactDominioDobleVP> mapaEs= new EnumMap<>(TipoParametrizacion.class);
		mapaEs.put(TipoParametrizacion.Int_Enum, fDomFr_ES_IE);
		mapaEs.put(TipoParametrizacion.Int_String, fDomFr_ES_IS);
		factsDom.put(TipoClasico.Espaniola, mapaEs);
		
	}
	
	private void inicializaSuppliersCarta()
	{
		EnumMap<TipoParametrizacion,SupplierNewCarta> mapaFr= new EnumMap<>(TipoParametrizacion.class);
		mapaFr.put(TipoParametrizacion.Int_Enum, supplierCartaFR_IE);
		mapaFr.put(TipoParametrizacion.Int_String, supplierCartaFR_IS);
		suppliersCarta.put(TipoClasico.Francesa, mapaFr);
		
		
		EnumMap<TipoParametrizacion,SupplierNewCarta> mapaEs= new EnumMap<>(TipoParametrizacion.class);
		mapaEs.put(TipoParametrizacion.Int_Enum, supplierCartaES_IE);
		mapaEs.put(TipoParametrizacion.Int_String, supplierCartaES_IS);
		suppliersCarta.put(TipoClasico.Espaniola, mapaEs);
		
	}
	
	public MazoGen<ICartaNumeroPaloEspaniola<Integer, String>, Integer, String> crearBarajaEspaniolaIS()
	{
		return crearBaraja(TipoClasico.Espaniola, TipoParametrizacion.Int_String, TipoImplementacionMazo.listaMatriz);
		
		
	}
	public MazoGen<ICartaNumeroPaloEspaniola<Integer, String>, Integer, String> crearBarajaEspaniolaES()
	{
		return crearBaraja(TipoClasico.Espaniola, TipoParametrizacion.Int_Enum, TipoImplementacionMazo.listaMatriz);
		
		
	}
	public MazoGen<ICartaNumeroPaloEspaniola<Integer, String>, Integer, String> crearBarajaFrancesaIS()
	{
		return crearBaraja(TipoClasico.Francesa, TipoParametrizacion.Int_String, TipoImplementacionMazo.listaMatriz);
		
		
	}
	
	public MazoGen<ICartaNumeroPaloEspaniola<Integer, String>, Integer, String> crearBarajaFrancesaES()
	{
		return crearBaraja(TipoClasico.Francesa, TipoParametrizacion.Int_Enum, TipoImplementacionMazo.listaMatriz);
		
		
	}
	
	
	public MazoGen crearBaraja(TipoClasico tipoClasico,TipoParametrizacion tipoParam, TipoImplementacionMazo tipoImplMazo)
	{
		BuilderMazoClasicoComp<Integer, String, ICartaNumeroPaloEspaniola<Integer,String>> bMazo= 
				new
		BuilderMazoClasicoComp<>(
				dameDominio(tipoClasico, tipoParam),
				dameSuplierCarta(tipoClasico, tipoParam),
				dameSupplierMazo(tipoImplMazo)
				);
		
		return bMazo.crearBaraja();
	}
	 
	
	private DominioValorPalo/*<V, P, C extends ICartaNumeroPalo<V,P>>*/ dameDominio(TipoClasico tipoClasico,TipoParametrizacion tipoParam )
	{
		
		EnumMap<TipoParametrizacion, DominioValorPalo> mapaCl = dominiosVP.get(tipoClasico);//todos los tipos son insertados, no debe ser null
		if(mapaCl.containsKey(tipoParam))
		{
			return mapaCl.get(tipoParam);
		}
		else
		{
			DominioValorPalo dom = dameFactDom(tipoClasico, tipoParam).creaDominioVP();
			mapaCl.put(tipoParam,dom);
			
			return dom;
		}
	}
	
	private SupplierMazo/*<C extends ICartaNumeroPalo<N,P>, N, P>*/ dameSupplierMazo(TipoImplementacionMazo tipoImpl)
	{
		//if(TipoImplementacionMazo.lista.equals(tipoImpl))
			return new SupplierMazoGenMatrizLista();
		
		
		/*else
			return null;*/
			
	}
	
	private FactDominioDobleVP dameFactDom(TipoClasico tipoClasico,TipoParametrizacion tipoParam)
	{
		return factsDom.get(tipoClasico).get(tipoParam);
	}
	
	private SupplierNewCarta dameSuplierCarta(TipoClasico tipoClasico,TipoParametrizacion tipoParam)
	{
		return suppliersCarta.get(tipoClasico).get(tipoParam);
	}

}
