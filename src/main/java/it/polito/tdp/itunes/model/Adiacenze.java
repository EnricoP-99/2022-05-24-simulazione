package it.polito.tdp.itunes.model;

public class Adiacenze {

	Track t1;
	Track t2;
	double peso;
	
	public Adiacenze(Track t1, Track t2, double peso) {
		super();
		this.t1 = t1;
		this.t2 = t2;
		this.peso = peso;
	}

	public Track getT1() {
		return t1;
	}

	public void setT1(Track t1) {
		this.t1 = t1;
	}

	public Track getT2() {
		return t2;
	}

	public void setT2(Track t2) {
		this.t2 = t2;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((t1 == null) ? 0 : t1.hashCode());
		result = prime * result + ((t2 == null) ? 0 : t2.hashCode());
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
		Adiacenze other = (Adiacenze) obj;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (t1 == null) {
			if (other.t1 != null)
				return false;
		} else if (!t1.equals(other.t1))
			return false;
		if (t2 == null) {
			if (other.t2 != null)
				return false;
		} else if (!t2.equals(other.t2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Adiacenze [t1=" + t1 + ", t2=" + t2 + ", peso=" + peso + "]";
	}
	
	
	
	
}
