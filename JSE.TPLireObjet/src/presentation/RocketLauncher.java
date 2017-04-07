package presentation;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import metier.Compte;

public class RocketLauncher {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		File f = new File("banque.txt");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);

		Compte c;
		try {
			while (true) {
				c = (Compte) ois.readObject();
				System.out.println(c);
			}
		} catch (EOFException e) {
		}
		;

		ois.close();
		fis.close();
	}
}
