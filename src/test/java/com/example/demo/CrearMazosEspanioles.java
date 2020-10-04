package com.example.demo;

import java.util.List;

import org.junit.Assert;

import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.cartas.dom.Dominio;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.mazos.fact.impl.FactMazoConcreto;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;
import juegos.cartas.cartas.mazos.modelos.MazoConsulta;

public class CrearMazosEspanioles 
{
	
	public static List<MazoGen> creaListaMazosPruebas()
	{
		FactMazoConcreto fm= new FactMazoConcreto(); 

		return List.of
		(
				fm.crearBarajaEspaniola()
				
				
		);
	}
	
	public static void main(String[] args) 
	{
		
		
		
		for(MazoGen mazo: creaListaMazosPruebas())
		{
			MazoConsulta mazoSimple=(MazoConsulta) mazo;
			
			Dominio domP = mazo.getDominioPalos();
			Dominio domV = mazo.getDominioValores();
			SupplierNewCarta supplier = mazo.getSupplierNewCarta();
			for(Object palo:domP.getValues())
			{
				for(Object num: domV.getValues())
				{
					
					ICartaComparable carta=supplier.creaNuevaCarta(num, palo);
					boolean pertenece=mazoSimple.perteneceCartaAMazo(carta);
	
					System.out.println(carta + " " +pertenece  );
					Assert.assertTrue(pertenece);
				}
			}
		}
		
	}

}
