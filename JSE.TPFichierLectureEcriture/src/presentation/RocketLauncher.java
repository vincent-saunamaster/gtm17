package presentation;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RocketLauncher {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Encodage
		// File(String pathname)
		File f = new File("fichier1.txt");
		// nécessite de gérer l'exception "fileNotFound"
		FileReader fr = new FileReader(f);

		File f2 = new File("fichier2.txt");
		// nécessite de gérer l'exception "IOException"
		FileWriter fencode = new FileWriter(f2);
	
		int c;
		// .read lit le caractère (sous forme de int) qu'on stocke dans la variable "c" et ce, tant qu'on est pas arrivé à la fin du fichier
		while ((c = fr.read()) != -1) {
			fencode.write(c+1);
		}
		fr.close();
		fencode.close();
		// décodage
		File f3 = new File("fichier2.txt");
		FileReader fcode = new FileReader(f3);
		
		File f4 = new File("fichier3.txt");
		FileWriter fdecode = new FileWriter(f4);
		
		int a;
		while ((a = fcode.read()) != -1) {
			fdecode.write(a-1);
		}
		
		fcode.close();
		fdecode.close();

	}

}