package juegos.cartas.cartas.mesas.crupier;

import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasSimple;

/**
 * Crupier que tiene un mazo de cartas
 * 
 * Implementa reparteCarta con dameCartaAleatoria
 * @author victor
 *
 * @param <C>
 */
public class CrupierMazoAleatoria<C extends ICartaComparable> extends CrupierMazo<C>
{
	
	

	public CrupierMazoAleatoria(MazoCartasSimple<C> mazo)
	{
		
		super(mazo);
		
	}

	@Override
	public C reparteCarta()
	{
		
		return mazo.dameCartaAleatoria();
	}
	

}
