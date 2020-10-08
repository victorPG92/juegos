package juegos.cartas.cartas;

import java.util.List;

import org.junit.Assert;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.mazos.fact.FactMazoConcreto;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;
import juegos.cartas.cartas.mazos.modelos.MazoConsulta;

public class CrearMazosEspanioles 
{
	
	public static List<MazoGen<CartaNumeroPalo<Integer, String>,Integer,String>> creaListaMazosPruebas()
	{
		FactMazoConcreto fm= new FactMazoConcreto(); 

		return List.of
		(
				fm.crearBarajaEspaniola()
				
				
		);
	}
	
	public static void main(String[] args) 
	{
		
		
		
		for(MazoGen<CartaNumeroPalo<Integer, String>,Integer,String> mazo: creaListaMazosPruebas())
		{
			MazoConsulta<CartaNumeroPalo<Integer, String>> mazoSimple=(MazoConsulta<CartaNumeroPalo<Integer, String>>) mazo;
			
			Dominio<String> domP = mazo.getDominioPalos();
			Dominio<Integer> domV = mazo.getDominioValores();
			SupplierNewCarta<CartaNumeroPalo<Integer, String>, Integer, String> supplier = mazo.getSupplierNewCarta();
			for(String palo:domP.getValues())
			{
				for(Integer num: domV.getValues())
				{
					
					CartaNumeroPalo<Integer, String> carta=supplier.creaNuevaCarta(num, palo);
					boolean pertenece=mazoSimple.perteneceCartaAMazo(carta);
	
					System.out.println(carta + " " +pertenece  );
					Assert.assertTrue(pertenece);
				}
			}
		}
		
	}

}
