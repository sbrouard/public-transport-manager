package tec;

import java.io.Writer;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CollecteFichier implements Collecte {

    private int numArret;
    private FileWriter fw;
    private int nbEntres;
    private int nbSortis;
    
    public CollecteFichier(String fichier){

	numArret = 0;
	nbEntres = 0;
	nbSortis = 0;
	try{
	    fw = new FileWriter(fichier);
	}catch(IOException e){
	    e.printStackTrace();
	}
    }
    
    private static void ecrire(Writer w, String s){

	PrintWriter p = new PrintWriter(w);

	p.println(s);
	p.flush();
    }

    public void uneEntree(){

	nbEntres++;
    }

    public void uneSortie(){

	nbSortis++;
    }

    public void changerArret(){

	ecrire(fw, "[Arret " + numArret + "] : " + nbEntres + " personnes rentrées, " + nbSortis + " personnes sorties");

	numArret++;
	nbEntres = 0;
	nbSortis = 0;
    }
}
