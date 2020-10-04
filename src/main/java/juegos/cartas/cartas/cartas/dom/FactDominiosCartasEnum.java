package juegos.cartas.cartas.cartas.dom;

import java.util.HashSet;
import java.util.Set;

import juegos.cartas.cartas.cartas.PaloFrances;

public class FactDominiosCartasEnum 
{
	
	public Dominio<Integer> getDominioNumericoCartasEspaniolas()
	{
		FactComparator<Integer> fComp= new FactComparator<>();
		Set<Integer> valores= new HashSet<>();
		for(int i=1;i<8;i++)
			valores.add(i);
		
		for(int i=10;i<13;i++)
			valores.add(i);
		
		Dominio<Integer> dom= new Dominio<>(valores, fComp.creaComparadorDeComparable());
		
		return dom;
	}
	
	public Dominio<Enum> getDominioPalosCartasEspaniolas()
	{
		return new Dominio(Set.of("oros","copas","espadas","bastos"),
				new FactComparator<String>().creaComparadorDeComparable());
		
	}

	public Dominio<PaloFrances> getDominioPalosCartasFrancesa() {
		return new Dominio<>(Set.of(PaloFrances.DIAMANTES,
				PaloFrances.PICAS,
				PaloFrances.CORAZONES,
				PaloFrances.TREBOLES),
				
				new FactComparator<PaloFrances>().creaComparadorDeComparable());
		
	}

	public Dominio<Integer> getDominioNumericoCartasFrancesa() {
		FactComparator<Integer> fComp= new FactComparator<>();
		Set<Integer> valores= new HashSet<>();
		for(int i=1;i<14;i++)
			valores.add(i);
		
		
			
		
		Dominio<Integer> dom= new Dominio<>(valores, fComp.creaComparadorDeComparable());
		
		return dom;
	}
}
