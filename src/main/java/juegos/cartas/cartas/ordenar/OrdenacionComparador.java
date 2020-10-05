package juegos.cartas.cartas.ordenar;

import java.util.Comparator;
import java.util.List;

import juegos.cartas.cartas.cartas.Carta;

public class OrdenacionComparador implements OrdenacionCartas
{

	Comparator<Carta> comp;
	
	
	
	public OrdenacionComparador(Comparator<Carta> comp) {
		super();
		this.comp = comp;
	}



	@Override
	public List<Carta> ordenarCartas(List<Carta> cartas) {
		cartas.sort(comp);
		return cartas;
	}
	
	

}
