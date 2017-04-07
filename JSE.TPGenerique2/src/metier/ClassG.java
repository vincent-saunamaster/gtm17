package metier;

public class ClassG<T, U, V> {
	private T x;
	private U y;
	private V z;
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public U getY() {
		return y;
	}
	public void setY(U y) {
		this.y = y;
	}
	public V getZ() {
		return z;
	}
	public void setZ(V z) {
		this.z = z;
	}
	public ClassG(T x, U y, V z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public String toString() {
		return "ClassG [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	public void printTest(ClassG<T, U, V> a){
		System.out.println(a);
		
	}

	
}
