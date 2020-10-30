package juegos.cartas.cartas.ordenar;

import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;

public interface OrdenacionCartas<T extends ICartaComparable> {

	
	List<T> ordenarCartas(List<T> cartas);
}
