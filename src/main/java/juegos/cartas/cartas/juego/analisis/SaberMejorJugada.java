package juegos.cartas.cartas.juego.analisis;

import java.util.ArrayList;
import java.util.List;

import juegos.cartas.cartas.cartas.Carta;
import juegos.cartas.cartas.mesas.Mano;
import juegos.cartas.cartas.utils.Combinaciones;


	/**
	 * 
	 * @author victor
	 * 
	 * implementacion del problema de la mochila de 2 niveles (elijo solo las 2 que no entran )
	 * sacar de 7 cartas 5 , que den la jugada mayor
	 *
	 */
	public class SaberMejorJugada {
		
		
		//private ArrayList<Carta> cartas;
		
		//private ArrayList<Carta> manoTemp;
		
		//private ArrayList<Carta> manoMejor;
		private Mano manoMejor;//cambiado
		
		private SaberJugada sj;
		
		
		//public EncontrarMejorJugada(ArrayList<Carta> cartas)
		public SaberMejorJugada(SaberJugada sj)
		{
			this.sj=sj;
				
			
		}
		
		/**
		 * Busco la mejor mano dado unas cartas
		 * @param cartas
		 */
		public void buscar(List<Carta> cartas)
		{
			//Combinaciones cmb = new Combinaciones(7, 5);
			Combinaciones cmb = new Combinaciones(cartas.size(), 5);
			
			ArrayList<ArrayList<Integer>> combinaciones = cmb.dameTodasLasCombinaciones();
			
			for(ArrayList<Integer> indices : combinaciones)
			{
				List<Carta> manoTemp = new  ArrayList<Carta >();
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
