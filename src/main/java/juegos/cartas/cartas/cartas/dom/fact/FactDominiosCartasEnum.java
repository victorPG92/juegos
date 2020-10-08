package juegos.cartas.cartas.cartas.dom.fact;

import java.util.HashSet;
import java.util.Set;

import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.palos.PaloEspaniol;
import juegos.cartas.cartas.cartas.palos.PaloFrances;

/**
* Crea dominios concretos de valores y palos de las cartas espaniola y francesa
* con palos con tipo enumerados
* @author victor
*
*/
public class FactDominiosCartasEnum 
{
	
	public Dominio<Integer> getDominioNumericoCartasEspaniolas()
	{
		FactComparator fComp= new FactComparator();
		Set<Integer> valores= new HashSet<>();
		for(int i=1;i<8;i++)
			valores.add(i);
		
		for(int i=10;i<13;i++)
			valores.add(i);
		
		Dominio<Integer> dom= new Dominio<>(valores, fComp.creaComparadorDeComparable());
		
		return dom;
	}
	
	public Dominio<PaloEspaniol> getDominioPalosCartasEspaniolas()
	{
		return new Dominio<>(Set.of(PaloEspaniol.OROS, PaloEspaniol.COPAS, PaloEspaniol.ESPADAS, PaloEspaniol.BASTOS),
				new FactComparator().creaComparadorDeComparable());
		
	}

	public Dominio<PaloFrances> getDominioPalosCartasFrancesa() {
		return new Dominio<>(Set.of(PaloFrances.DIAMANTES,
				PaloFrances.PICAS,
				PaloFrances.CORAZONES,
				PaloFrances.TREBOLES),
				
				new FactComparator().creaComparadorDeComparable());
		
	}

	public Dominio<Integer> getDominioNumericoCartasFrancesa() {
		FactComparator fComp= new FactComparator();
		Set<Integer> valores= new HashSet<>();
		for(int i=1;i<14;i++)
			valores.add(i);
		
		
			
		
		Dominio<Integer> dom= new Dominio<>(valores, fComp.creaComparadorDeComparable());
		
		return dom;
	}
}
