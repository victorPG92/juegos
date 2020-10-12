package juegos.cartas.cartas.mazos.fact;

import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;
import juegos.cartas.cartas.cartas.dom.fact.FactDominioDoble;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;
import juegos.cartas.cartas.mazos.modelos.suppliers.SupplierMazo;

/**
 * Crea mazos concretos de barajas espaniola y francesa con palos string
 * @author victor
 *
 */
public class BuilderMazoClasicoComp <V,P, C extends ICartaNumeroPalo<V,P>>
{
	
	FactDominioDoble<V, P, C> fDom;	
	SupplierNewCarta<C,V,P> supplierCarta;
	SupplierMazo<C,V,P> supplierMazo;
	DominioValorPalo<V, P, C> domVP;
	
	
	
	public BuilderMazoClasicoComp(FactDominioDoble<V, P, C> fDom, SupplierNewCarta<C, V, P> supplierCarta,
			SupplierMazo<C, V, P> supplierMazo) {
		super();
		this.fDom = fDom;
		this.supplierCarta = supplierCarta;
		this.supplierMazo = supplierMazo;
	}
	
	public BuilderMazoClasicoComp(DominioValorPalo<V, P, C> domVP , SupplierNewCarta<C, V, P> supplierCarta,
			SupplierMazo<C, V, P> supplierMazo) {
		super();
		this.domVP = domVP;
		this.supplierCarta = supplierCarta;
		this.supplierMazo = supplierMazo;
	}



	public MazoGen<C,V,P> crearBaraja()
	{
		MazoGen<C,V,P> mazo;
		
		if(domVP==null && fDom!=null)
			domVP = fDom.creaDominioVP();
		
		mazo= supplierMazo.creaMazo(supplierCarta, domVP);		
		
		return mazo;
	}



	public FactDominioDoble<V, P, C> getfDom() {
		return fDom;
	}



	public void setfDom(FactDominioDoble<V, P, C> fDom) {
		this.fDom = fDom;
	}



	public SupplierNewCarta<C, V, P> getSupplier() {
		return supplierCarta;
	}



	public void setSupplier(SupplierNewCarta<C, V, P> supplier) {
		this.supplierCarta = supplier;
	}



	public SupplierMazo<C, V, P> getSupplierMazo() {
		return supplierMazo;
	}



	public void setSupplierMazo(SupplierMazo<C, V, P> supplierMazo) {
		this.supplierMazo = supplierMazo;
	}
	
	

}
