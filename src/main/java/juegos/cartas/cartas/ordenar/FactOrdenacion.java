package juegos.cartas.cartas.ordenar;

import juegos.cartas.cartas.ordenar.comp.CompCartaPorColor;
import juegos.cartas.cartas.ordenar.comp.CompCartaPorNumero;

public class FactOrdenacion {

	
	public OrdenacionCartas  getOrdenacion(TipoOrdenar tipoOrdenar)
	{
		
		if(TipoOrdenar.NUMERO.equals(tipoOrdenar))
			return new OrdenacionComparador(new CompCartaPorNumero());
		else if(TipoOrdenar.PALO.equals(tipoOrdenar))
			return new OrdenacionComparador(new CompCartaPorColor());
		else
			return null;
	}
}
