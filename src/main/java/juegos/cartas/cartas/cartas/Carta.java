package juegos.cartas.cartas.cartas;

import juegos.cartas.cartas.cartas.palos.PaloFrances;

/**
 * Estructura carta con palo y numero
 * @author victor
 *
 */
public class Carta extends CartaNumeroPalo<Integer,PaloFrances> implements Comparable<Carta>
{
	private PaloFrances palo;
	private int num;

	public Carta(int n , PaloFrances p)
	{
		super(n,p);
	}
	



	public String toString()
	{
		return NumCarta.nombreCarta(num) + " of " +palo.ing();//.name();
	}

	@Override
	public int compareTo(Carta o) 
	{
		//Carta o= (Carta) i;
		int n1=num;
		int n2=o.num;
		if(n1==1)n1 = 15;
		if(n2==1)n2 = 15;
		
		int r= Integer.compare(n1, n2);
		if(r==0)r=0;//tienen el mismo valor
		
		return r;
		
	}
	
	
	public String dameNombre()
	{
		return NumCarta.nombreCarta(num);
	}
	
	public String dameLetras()
	{
		return NumCarta.letraCarta(num)+ Character.toLowerCase(palo.letr());
	}
	
	
	/**
	 * Suponiendo que juego con una unica baraja;(si no, pone un atributo idBaraja)
	 * POr lo que una carta sera igual a otra  si sus numeros y palos son coinciden
	 */
	public boolean equals(Object o)
	{
		try
		{
			Carta c = (Carta)o;
			return this.num == c.num && this.palo.equals(c.palo);
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
}
