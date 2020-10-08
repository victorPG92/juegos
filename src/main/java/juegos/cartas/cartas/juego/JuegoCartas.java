package juegos.cartas.cartas.juego;

public interface JuegoCartas <F>
{
	
	public void faseInicializacion();
	
	public void faseRondas();
	
	public void faseValoracionManos();
	
	public FaseJuego<F> getFase();

}
