package presentation;

import java.io.File;

public class RocketLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rep = "C:/";
		// File(String pathname)
		File f = new File(rep);

		// Tests whether the file or directory denoted by this abstract pathname exists.
		if (f.exists()) {
			String[] contenu = f.list();
			for (int i = 0; i < contenu.length; i++) {

				// File(File parent, String child)
				File f2 = new File(rep, contenu[i]);
				if (f2.isDirectory()) {
					System.out.println("REPERTOIRE" + contenu[i]);
				} else {
					System.out.println("FICHIER" + contenu[i] + " Taille :" + f2.length() + " octets");
				}
			}
		} else {
			System.out.println(rep + " n'existe pas");
		}

	}

}
