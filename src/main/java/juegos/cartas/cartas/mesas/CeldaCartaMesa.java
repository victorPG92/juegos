package juegos.cartas.cartas.mesas;

import juegos.cartas.cartas.cartas.ICartaComparable;

/**
 * En una mesa, es el lugar donde va una carta
 * indica si la carta esta boca arriba o boca abajo
 * @author victor
 *
 */
public class CeldaCartaMesa 
{
	
	private ICartaComparable carta;
	private boolean bocaArriba;
	
	public CeldaCartaMesa(ICartaComparable carta, boolean bocaArriba) {
		super();
		this.carta = carta;
		this.bocaArriba = bocaArriba;
	}

	public final ICartaComparable getCarta() {
		return carta;
	}

	public final void setCarta(ICartaComparable carta) {
		this.carta = carta;
	}

	public final boolean isBocaArriba() {
		return bocaArriba;
	}

	public final void setBocaArriba(boolean bocaArriba) {
		this.bocaArriba = bocaArriba;
	}
	
	
	

}
