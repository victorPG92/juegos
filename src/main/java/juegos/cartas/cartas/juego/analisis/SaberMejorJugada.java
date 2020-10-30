package juegos.cartas.cartas.juego.analisis;

import java.util.ArrayList;
import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.juego.Mano;
import juegos.cartas.cartas.utils.Combinaciones;


	/**
	 * 
	 * @author victor
	 * 
	 * implementacion del problema de la mochila de 2 niveles (elijo solo las 2 que no entran )
	 * sacar de 7 cartas 5 , que den la jugada mayor
	 *
	 */
	public class SaberMejorJugada<C extends ICartaComparable> 
	{
		
		private int tamMano;
		
		
		//private ArrayList<Carta> cartas;
		
		//private ArrayList<Carta> manoTemp;
		
		//private ArrayList<Carta> manoMejor;
		private Mano manoMejor;//cambiado
		
		private SaberJugada sj;
		
		
		//public EncontrarMejorJugada(ArrayList<Carta> cartas)
		public SaberMejorJugada(SaberJugada sj, int tam)
		{
			this.sj=sj;
			tamMano=tam;
				
			
		}
		
		/**
		 * Busco la mejor mano dado unas cartas
		 * @param cartas
		 */
		public void buscar(List<C> cartas)
		{
			//Combinaciones cmb = new Combinaciones(7, 5);
			Combinaciones cmb = new Combinaciones(cartas.size(), tamMano);
			
			List<List<Integer>> combinaciones = cmb.dameTodasLasCombinaciones();
			
			for(List<Integer> indices : combinaciones)
			{
				List<C> manoTemp = new  ArrayList<>();
				for(Integer i : indices)
					manoTemp.add(cartas.get(i));

				//SaberJugada sj = new SaberJugada(manoTemp);
				Mano m= sj.dameMano(manoTemp);
				
				
				if (manoMejor==null) manoMejor=m;
				else
				{
					if(manoMejor.compareTo(m)==-1)
					{
						manoMejor=m;
					}
				}
				
				/*
				valor = sj.dameMano().dameTipo().getValor();
				
				if(valor > valorMejor) 
				{
					valorMejor = valor;
					manoMejor =  sj.dameMano();
				}*/
				
			}
		}

		
		//cambiado
		public Mano getManoMejor() 
		{
			return manoMejor;
		}


}
