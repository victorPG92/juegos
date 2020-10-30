package juegos.cartas.cartas.ordenar;

import java.util.Comparator;
import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;

public class OrdenacionComparador<T extends ICartaComparable> implements OrdenacionCartas<T>//<CartaFrancesaOld>
{

	Comparator<T> comp;
	
	
	
	public OrdenacionComparador(Comparator<T> comp) {
		super();
		this.comp = comp;
	}



	@Override
	public List<T> ordenarCartas(List<T> cartas) {
		cartas.sort(comp);
		return cartas;
	}
	
	

}
