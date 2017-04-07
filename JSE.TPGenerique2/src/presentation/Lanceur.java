package presentation;

import metier.ClassG;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassG<String, Double, Float> a1 = new ClassG<String, Double, Float>("x", 2d, 5f);
		ClassG<Float, String, Float> a2 = new ClassG<Float, String, Float>(5f, "y", 5f);
		ClassG<String, String, Integer> a3 = new ClassG<String, String, Integer>("x", "y", 5);
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		a1.printTest(a1);

	}

}
