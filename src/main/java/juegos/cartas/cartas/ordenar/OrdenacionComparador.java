package juegos.cartas.cartas.ordenar;

import java.util.Comparator;
import java.util.List;

import juegos.cartas.cartas.cartas.CartaFrancesaOld;

public class OrdenacionComparador implements OrdenacionCartas
{

	Comparator<CartaFrancesaOld> comp;
	
	
	
	public OrdenacionComparador(Comparator<CartaFrancesaOld> comp) {
		super();
		this.comp = comp;
	}



	@Override
	public List<CartaFrancesaOld> ordenarCartas(List<CartaFrancesaOld> cartas) {
		cartas.sort(comp);
		return cartas;
	}
	
	

}
