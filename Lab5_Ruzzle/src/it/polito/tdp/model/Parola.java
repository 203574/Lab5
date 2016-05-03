package it.polito.tdp.model;

import java.util.List;

public class Parola  implements Comparable<Parola>
{
	private String parola;
	private List<Integer> posizioni;
	
	public List<Integer> getPosizioni() 
	{
		return posizioni;
	}


	public void setPosizioni(List<Integer> posizioni) 
	{
		this.posizioni = posizioni;
	}





	public Parola(String parola,List<Integer> posizioni) 
	{
		this.parola = parola;
		this.posizioni = posizioni;
	}





	public String getParola()
	{
		return parola;
	}


	public void setParola(String parola) 
	{
		this.parola = parola;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parola other = (Parola) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}





	@Override
	public String toString() {
		return posizioni + "-"+parola;
	}





	@Override
	public int compareTo(Parola o) {
		return this.posizioni.size()-o.getPosizioni().size();
	}


	
	
	
	
}
