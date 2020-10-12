package juegos.cartas.cartas.mazos.impl.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasSimple;
import juegos.cartas.cartas.mazos.modelos.func.MazoMultiple;

/**
 * mazo compuesto por multiples mazos
 * es mas costoso que otras implementaciones
 * porque almacena los diferentes mazos
 * @author victor
 *
 * @param <C>
 */
public class MazoMultipleGenCompuesto<C extends ICartaComparable> implements MazoMultiple<C> {

	
	List<MazoCartasSimple<C>> mazos;
	Random r= new Random();
	
	public MazoMultipleGenCompuesto(List<MazoCartasSimple<C>> mazos) 
	{
		super();
		this.mazos = mazos;
	}

	@Override
	public C dameCartaAleatoria() {
		
		int pos=r.nextInt(mazos.size());
		MazoCartasSimple<C> mazo= mazos.get(pos);
		C carta= mazo.dameCartaAleatoria();
		if(mazo.isEmpty())
			mazos.remove(pos);
		
		return carta;
	}

	@Override
	public List<C> dameNCartasAleatoria(int n) {
		List<C> cartas= new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			cartas.add(dameCartaAleatoria());
		}
		return cartas;
	}

	@Override
	public int size()
	{
		//mazos.stream().flatMapToInt(m->m.size()).reduce(Integer::add);
		int sizeMult=mazos.stream().mapToInt(m->m.size()).reduce((i1,i2)-> i1+i2).getAsInt();

		return sizeMult;
	}

	@Override
	public boolean isEmpty() {
		return mazos.isEmpty();
	}

	
	
}
