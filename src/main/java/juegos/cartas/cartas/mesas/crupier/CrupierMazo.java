package juegos.cartas.cartas.mesas.crupier;

import java.util.ArrayList;
import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasSimple;

/**
 * Crupier que tiene un mazo de cartas
 * 
 * Deja sin Implementar reparteCarta
 * Para repartir N cartas , reutliza la funcion reparteCarta N veces
 * @author victor
 *
 * @param <C>
 */
public abstract class CrupierMazo<C extends ICartaComparable> implements Crupier<C>
{
	
	MazoCartasSimple<C> mazo;

	public CrupierMazo(MazoCartasSimple<C> mazo) {
		super();
		this.mazo = mazo;
		
		if(mazo==null)
			throw new NullPointerException();
	}

	

	@Override
	public List<C> reparteNCartas(int numCartas) {
		
		List<C> list= new ArrayList<>();
		
		for (int i = 0; i < numCartas; i++) {
			list.add(reparteCarta());
		}
		
		return list;
	}

	@Override
	public void quemarCarta() {
		reparteCarta();
	}
	
	

}
