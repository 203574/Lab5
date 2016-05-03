package it.polito.tdp.model;

import java.util.List;

public class Test
{
	public static void main(String[] args)
	{
		Ricerca r = new Ricerca();
		String lettere = "TESISROERASICOIP";
		r.doPermutazioni(lettere);
		List<Parola> soluzioni = r.getSoluzioni();
		for(Parola p : soluzioni)
			System.out.println(p.getPosizioni() + " - " + p.getParola());
	}
}
