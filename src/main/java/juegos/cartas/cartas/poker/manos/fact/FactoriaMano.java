package juegos.cartas.cartas.poker.manos.fact;

import java.util.List;

import juegos.cartas.cartas.cartas.Carta;
import juegos.cartas.cartas.mesas.Mano;
import juegos.cartas.cartas.poker.manos.CartaMasAlta;
import juegos.cartas.cartas.poker.manos.Color;
import juegos.cartas.cartas.poker.manos.DoblesParejas;
import juegos.cartas.cartas.poker.manos.Escalera;
import juegos.cartas.cartas.poker.manos.EscaleraColor;
import juegos.cartas.cartas.poker.manos.Full;
import juegos.cartas.cartas.poker.manos.NombreMano;
import juegos.cartas.cartas.poker.manos.Pareja;
import juegos.cartas.cartas.poker.manos.Poker;
import juegos.cartas.cartas.poker.manos.Trio;


/**
 * 
 * @author victor
 * Segun unos parametros ya calculados, devuelve una mano
 * dentro de las clases no se deberia reordenar, deberia recibir las cartas ordenadas
 *
 */
public class FactoriaMano 
{
	
	
	/*public Mano creaMano(ManoEnum me,int hc1, int hc2)
	{
		//System.out.println("fabricar "+ me.getEsp() +" con  de "+hc1+" y "+ hc2) ;
		
		Mano m = null;
		
		if	   (me.equals(ManoEnum.pair)) 			 m = new Pareja(me,hc1, null, null, null);
		else if(me.equals(ManoEnum.three_of_a_kind)) m = new Trio(me,hc1, null, null);
		else if(me.equals(ManoEnum.two_pair)) 		 m = new DoblesParejas(me,hc1,hc2, null);
		else if(me.equals(ManoEnum.straight)) 		 m = new Escalera(me,hc1);
		else if(me.equals(ManoEnum.flush)) 			 m = new Color(me,hc1);
		else if(me.equals(ManoEnum.full_house)) 	 m = new Full(me,hc1,hc2);
		else if(me.equals(ManoEnum.four_of_a_kind))  m = new Poker(me,hc1,null);
		else if(me.equals(ManoEnum.straight_flush))  m = new EscaleraColor(me,hc1);
		else if(me.equals(ManoEnum.high_card)) 		 m = new CartaMasAlta(me,hc1,null,null,null,null);
		
		
		
		return 	m;
	}
	*/
	
	public Mano creaMano(List<Carta> cartas,NombreMano me)
	{
		//System.out.println("fabricar "+ me.getEsp() +" con  de "+hc1+" y "+ hc2) ;
		
		Mano mano = null;
		
		if	   (me.equals(NombreMano.pair)) 			 mano = new Pareja			(cartas);
		else if(me.equals(NombreMano.three_of_a_kind)) mano = new Trio			(cartas);
		else if(me.equals(NombreMano.two_pair)) 		 mano = new DoblesParejas	(cartas);
		else if(me.equals(NombreMano.straight)) 		 mano = new Escalera		(cartas);
		else if(me.equals(NombreMano.flush)) 			 mano = new Color			(cartas);
		else if(me.equals(NombreMano.full_house)) 	 mano = new Full			(cartas);
		else if(me.equals(NombreMano.four_of_a_kind))  mano = new Poker			(cartas);
		else if(me.equals(NombreMano.straight_flush))  mano = new EscaleraColor	(cartas);
		else if(me.equals(NombreMano.high_card)) 		 mano = new CartaMasAlta	(cartas);
		
		
		
		return 	mano;
	}

}
