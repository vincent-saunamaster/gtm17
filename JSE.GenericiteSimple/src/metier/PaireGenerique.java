package metier;

public class PaireGenerique<T> {
	private T premier, second;
	
	public PaireGenerique(T premier, T second) {
		super();
		this.premier = premier;
		this.second = second;
	}
	
	// getter et setter
	public void setPremier(T a){
		this.premier = a;
	}
	public void setSecond(T a){
		this.second = a;
	}
	public T getPremier(){
		return this.premier;
	}
	public T getSecond(){
		return this.second;
	}
	
}