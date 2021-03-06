package juegos.cartas.cartas.mazos.impl.gen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasExtraccionConcreta;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasSimple;
import juegos.cartas.cartas.mazos.modelos.func.MazoConsulta;
import juegos.cartas.cartas.mazos.modelos.func.MazoInsercion;
import juegos.cartas.cartas.ordenar.comp.CompCartaPorColorYNumero;

/**
 * matriz de cartas acceso constante al pedir aleatoria, necesita 2 aleatorios
 * coste en espacio N*M
 * 
 * conteo , constante saber si existe una carta, acceso constante
 * 
 * Clase mixta donde las cartas ya las tengo ordenadas
 * 
 * @author victor
 *
 */
public class MazoGenOptLista<C extends ICartaNumeroPalo<N, P>, N, P> extends MazoGen<C, N, P>
		implements MazoCartasSimple<C>, MazoCartasExtraccionConcreta<C>, MazoConsulta<C>, MazoInsercion<C>

{

	List<C> cartasOrdenadas;

	Random r = new Random(System.currentTimeMillis());

	int indices[] = new int[4];

	boolean shuffle = true;

	private Comparator<C> comp;

	public MazoGenOptLista(SupplierNewCarta<C, N, P> s, DominioValorPalo<N, P, C> domVP)
	{
		this(s, domVP.getDomPalo(), domVP.getDomValor());
	}

	public MazoGenOptLista(SupplierNewCarta<C, N, P> s, Dominio<P> domP, Dominio<N> domV)
	{
		super(s, domP, domV);
		cartasOrdenadas = new LinkedList<>();
		for (P p : dominioPalos)
		{
			int indicePalo = dominioPalos.indexOf(p);

			for (int i = 0; i < NUM_CARTAS; i++)// cambiado
			{
				// System.out.println(indicePalo+" "+ i);
				C carta = supplierNewCarta.creaNuevaCarta(dominioValores.get(i), p);// new Carta(i+1,p);

				// System.out.println(""+carta.getNumero() + carta.getPalo());

				cartasOrdenadas.add(carta);
			}
			indices[indicePalo] = NUM_CARTAS * indicePalo;
		}

		if (shuffle)
			Collections.shuffle(cartasOrdenadas);
	}

	/**
	 * Extrae una carta del mazo 2 aleatoriios y lugo acceso constante
	 * 
	 * @return carta aleatoria
	 */
	public C dameCartaAleatoria()
	{
		C cartaElegida = cartasOrdenadas.get(r.nextInt(cartasOrdenadas.size()));

		// -1
		if (!shuffle)
			desplazarIndices(cartaElegida.getPalo(), -1);

		return cartaElegida;

		/*
		 * if(cont==0){ return null; }else{
		 * 
		 * 
		 * int nPalo = r.nextInt(NUM_PALOS); int nCarta = r.nextInt(NUM_CARTAS);
		 * 
		 * Palo p = Palo.values()[nPalo]; Carta c = new Carta(nCarta+1,p);
		 * 
		 * while(estaSeleccionada(c)) { nPalo = r.nextInt(NUM_PALOS); nCarta =
		 * r.nextInt(NUM_CARTAS);
		 * 
		 * p = Palo.values()[nPalo]; c = new Carta(nCarta+1,p); }
		 * 
		 * //cont--; seleccionarCarta(c); return c; }
		 */

	}

	/**
	 * desplaza los indices desde ese palo, es decir, los siguientes
	 * 
	 * @param palo
	 */
	private void desplazarIndices(P palo, int inc)
	{
		// int i=palo.ordinal()+1;
		// for(int i=palo.ordinal()+1;i< Palo.values().length;i++)

		for (int i = dominioPalos.indexOf(palo) + 1; i < dominioPalos.size(); i++)
			indices[i] = indices[i] + inc;

	}

	/**
	 * Extrae n cartas del mazo
	 * 
	 * @return cartas aleatorias
	 */
	public List<C> dameNCartasAleatoria(int n)
	{
		ArrayList<C> a = new ArrayList<>();
		for (int i = 0; i < n; i++)
			a.add(dameCartaAleatoria());

		return a;
	}

	@Override
	public void insertaCarta(C c)
	{
		P palo = c.getPalo();
		int p = dominioPalos.indexOf(palo);// Palo.values()[nPalo];
		int n = dominioValores.indexOf(c.getNumero());
		if (n == NUM_CARTAS)
			n = 0;

		// si ya esta en el mazo, se inserta de nuevo, pero no repite

		if (shuffle)
			cartasOrdenadas.add(c);
		else
		{
			int pos= indices[p];
			C cartaSig= cartasOrdenadas.get(pos);
			while(comp.compare(c, cartaSig)<0)//mientras no la alcance
			{
				pos++;
				cartaSig= cartasOrdenadas.get(pos);
			}
			
			cartasOrdenadas.add(pos,c);
			desplazarIndices(palo, 1);

		}
	}

	@Override
	public void insertaCartas(List<C> l)
	{
		//for (C c : l)
		//	insertaCarta(c);
		
		cartasOrdenadas.addAll(l);
		Collections.sort(cartasOrdenadas, comp);
	}

	/**
	 * Devuelve si hay cartas en el mazo Coste constante
	 * 
	 * @return
	 */
	public boolean estaVacio()
	{
		return cartasOrdenadas.isEmpty();
	}

	/**
	 * Coste constante
	 * 
	 * @return
	 */
	public int quedanNumCartas()
	{
		return cartasOrdenadas.size();
	}

	/**
	 * Devuelve si la carta c , est� en el mazo
	 * 
	 * @param c
	 * @return
	 */
	public boolean perteneceCartaAMazo(C c)
	{
		return !estaSeleccionada(c);// mazo.contains(c);
	}

	
	/**
	 * Coste constante
	 */
	public boolean estaSeleccionada(C c)
	{
		if(shuffle)
			return cartasOrdenadas.contains(c);
		else return busquedaBinaria(c)!=-1;
	}

	@Override
	/**
	 * Coste constante
	 */
	public C dameCartaConcreta(C cartaConcreta)
	{
		if (cartaConcreta == null)
			return null;

		if (!shuffle)
		{
			int indiceEncontrado = busquedaBinaria(cartaConcreta);

			if (indiceEncontrado != -1)
			{
				cartasOrdenadas.remove(indiceEncontrado);
				return cartaConcreta;
			}else
				return null;
		} else
		{
			boolean borrada = cartasOrdenadas.remove(cartaConcreta);

			return (borrada ? cartaConcreta : null);

		}
	}

	private int busquedaBinaria(C cartaConcreta)
	{
		P palo = cartaConcreta.getPalo();
		int ipalo = dominioPalos.indexOf(palo);

		int limiteInf = indices[ipalo];
		int limiteSup = ipalo == dominioPalos.size() ? cartasOrdenadas.size() - 1 : indices[ipalo + 1];

		return busquedaBinaria(cartaConcreta, limiteInf, limiteSup);
	}

	/**
	 * Se busca la carta dentro del mismo palo
	 * 
	 * @param cartaConcreta
	 * @param limiteInf
	 * @param limiteSup
	 * @return
	 */
	private int busquedaBinaria(C cartaConcreta, int limiteInf, int limiteSup)
	{

		if (limiteSup < limiteInf)
			return -1;

		int posMedia = (limiteSup + limiteInf) / 2;
		C cartaMedia = cartasOrdenadas.get(posMedia);
		N numCartaMedia = cartaMedia.getNumero();
		N numCartaBuscado = cartaConcreta.getNumero();
		int comparacion = dominioValores.getComparator().compare(numCartaMedia, numCartaBuscado);
		if (cartaConcreta.equals(cartaMedia))
		{
			return posMedia;
		} else if (comparacion == 1)
		{
			N numLimInf = cartasOrdenadas.get(limiteInf).getNumero();
			if (numLimInf.equals(numCartaBuscado))
				return limiteInf;
			return busquedaBinaria(cartaConcreta, limiteInf, posMedia - 1);

		} else
		{
			N numLimSup = cartasOrdenadas.get(limiteSup).getNumero();
			if (numLimSup.equals(numCartaBuscado))
				return limiteSup;
			return busquedaBinaria(cartaConcreta, posMedia + 1, limiteSup);

		}

		// return 0;
	}

	@Override
	/**
	 * Coste lineal
	 */
	public List<C> dameNCartasConcretas(List<C> cartasConcretas)
	{

		List<C> cartas = new ArrayList<>();
		for (C carta : cartasConcretas)
		{
			cartas.add(dameCartaConcreta(carta));
		}
		return cartas;
	}

	@Override
	public int size()
	{

		return cartasOrdenadas.size();
	}

	@Override
	public boolean isEmpty()
	{
		return cartasOrdenadas.isEmpty();
	}

}
