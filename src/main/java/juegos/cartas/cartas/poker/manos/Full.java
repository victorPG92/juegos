package juegos.cartas.cartas.poker.manos;

import java.util.List;

import juegos.cartas.cartas.cartas.Carta;
import juegos.cartas.cartas.ordenar.OrdenarCartas;
import juegos.cartas.cartas.utils.ConstantesPR1;

/**
 * Mano Full
 * @author victor
 *
 */
public class Full extends Mano
{
	private int trio;
	private int pareja;
	
	public Full(List<Carta> mano )
	{
		
			
			tipo=NombreMano.full_house;
			List<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorIguales(mano);
			this.cartas=manoOrd;
			
			trio=cartas.get(2).getNumero();
			
			if(cartas.get(0).getNumero()==trio)
				pareja= cartas.get(4).getNumero();
			else
				pareja= cartas.get(0).getNumero();
			
		
	}
	
	@Override
		public int compareTo(Mano m2) {
			int retorno=super.compareTo(m2);
			if(retorno!=0)
				return retorno;
			Full full2= (Full) m2;
			retorno= Integer.compare(trio, full2.trio);
			if(retorno!=0)
				return retorno;
			
			retorno= Integer.compare(pareja, full2.pareja);
			
			return retorno;
		}
	
	
	public String toString()
	{
		
		StringBuffer sb = new StringBuffer();
		sb.append(ConstantesPR1.FULL);
		sb.append(" of ");
		sb.append(trio);
		sb.append("s and ");
		sb.append(pareja);
		sb.append("s");	//\n
		
	
		return sb.toString();
	}

	
	
	
}
