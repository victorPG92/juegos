package juegos.cartas.cartas.poker.manos;

import java.util.List;

import juegos.cartas.cartas.cartas.Carta;
import juegos.cartas.cartas.ordenar.OrdenarCartas;
import juegos.cartas.cartas.utils.ConstantesPR1;

/**
 * Mano Pareja
 * Una pareja esta formada por dos cartas iguales y 3 cartas diferentes
 * @author victor
 *
 */
public class Pareja extends Mano
{
	
	
	
	
	public Pareja(List<Carta> mano )
	{
		
			
			tipo=NombreMano.pair;
			List<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorIguales(mano);
			this.cartas=manoOrd;
			
		
	}

	@Override
	public NombreMano dameTipo() {
		
		return NombreMano.pair;
	}
	
	public String toString()
	{
		
		StringBuffer sb = new StringBuffer();
		sb.append(ConstantesPR1.PAREJA);
		sb.append(" of ");
		sb.append(cartas.get(0).dameNombre());
		sb.append("s");	//\n
		return sb.toString();
		
		
	}
	
	

}
