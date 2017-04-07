package presentation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RocketLauncher {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Encodage
		// File(String pathname)
		File f = new File("img.jpg");
		// nécessite de gérer l'exception "fileNotFound"
		FileInputStream fr = new FileInputStream(f);

		File f2 = new File("img2.jpg");
		// nécessite de gérer l'exception "IOException"
		FileOutputStream fencode = new FileOutputStream(f2);
	
		int c;
		// .read lit le binaire (sous forme de int) qu'on stocke dans la variable "c" et ce, tant qu'on est pas arrivé à la fin du fichier
		while ((c = fr.read()) != -1) {
			fencode.write(c+1);
		}
		fr.close();
		fencode.close();
		// décodage
		File f3 = new File("img2.jpg");
		FileInputStream fcode = new FileInputStream(f3);
		
		File f4 = new File("img3.jpg");
		FileOutputStream fdecode = new FileOutputStream(f4);
		
		int a;
		while ((a = fcode.read()) != -1) {
			fdecode.write(a-1);
		}
		
		fcode.close();
		fdecode.close();
	}

}
