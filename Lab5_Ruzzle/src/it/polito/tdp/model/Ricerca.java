package it.polito.tdp.model;

import java.util.*;

import it.polito.tdo.db.ParolaDAO;

public class Ricerca
{
	private int pos;
	private List<Parola> soluzioni = new ArrayList<Parola>();
	
	
	public List<Parola> getSoluzioni()
	{
		Collections.sort(soluzioni);
		return soluzioni;
	}

	public void doPermutazioni(String lettere)
	{	
		soluzioni.clear();
		pos = 0;
		cerca(0,0,lettere.toCharArray(), new ArrayList<Integer>());
	}
	
	private void cerca(int pos, int cell, char[] lettere, List<Integer> tentativo)
	{
		if(pos == lettere.length)
		{
			return;
		}
		if(tentativo.contains(cell))
			return;
		tentativo.add(cell);
		if(tentativo.size()>1)
		{
			String parola =getString(tentativo, lettere);
			String result = checkParola(parola);
			//esiste nel vocabolario?
			if(result == null)
			{
				tentativo.remove(tentativo.size()-1);
				return;
			}
			else
			{
				if(result.compareToIgnoreCase(parola)==0)
				{
					Parola p = new Parola(parola,new ArrayList<Integer>(tentativo));
					if(!soluzioni.contains(p))
						soluzioni.add(p);
				}
			}
		}
		List<Integer> adiacenti = getPosizioniAdiacenti(cell, lettere);
		for (int i = 0; i < adiacenti.size(); i++) 
		{
			cerca(pos,adiacenti.get(i), lettere, tentativo);
			
		}
		tentativo.remove(tentativo.size()-1);

		if (pos==cell){
			tentativo.clear();
			cerca(pos+1,pos+1, lettere, tentativo);	
		}
//		;
			
		
		
	}

	private String getString(List<Integer> tentativo, char[] lettere) {
		String s="";
		for(Integer i: tentativo)
		{
			s+=lettere[i];
		}
		return s;
	}

	private String checkParola(String string) 
	{
		ParolaDAO pdao = new ParolaDAO();
		return pdao.findParola(string);
	}
	
	private List<Integer> getPosizioniAdiacenti(int pos, char[] lettere)
	{
		List<Integer> ad = new ArrayList<Integer>();
		int r = getRow(pos);
		int c =getColumn(pos);
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				if(i==r && c==j)
					continue;
				else
				{
					if(Math.abs(r-i)<=1 && Math.abs(c-j)<=1 )
					{
						ad.add(new Integer(i*4+j));
					}
				}
			}
		}
		return ad;
	}
	private int getRow(int pos)
	{
		return pos/4;
	}
	private int getColumn(int pos)
	{
		return pos%4;
	}
}
