package metier;

public class Paire {
	private Object premier, second;
	
	public Paire(Object premier, Object second) {
		super();
		this.premier = premier;
		this.second = second;
	}
	
	// getter et setter
	public void setPremier(Object a){
		this.premier = a;
	}
	public void setSecond(Object a){
		this.second = a;
	}
	public Object getPremier(){
		return this.premier;
	}
	public Object getSecond(){
		return this.second;
	}
	
}