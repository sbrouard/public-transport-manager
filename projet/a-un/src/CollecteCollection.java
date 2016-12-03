package tec;
import java.util.ArrayList; 
import java.util.Iterator; 

public class CollecteCollection implements Collecte {

    private ArrayList<String> c;
    private int numArret, nbEntres, nbSortis;

    public CollecteCollection(){
	c = new ArrayList();
	numArret = 0; 
	nbEntres = 0; 
	nbSortis = 0;
    }
    
    private void ajouter(String s){
	c.add(s);
    }

    public void uneEntree(){
	nbEntres++;
    }

    public void uneSortie(){

	nbSortis++;
    }

    public void changerArret(){

	ajouter("[Arret " + numArret + "] : " + nbEntres + " personnes rentrées, " + nbSortis + " personnes sorties");
	
	numArret++;
	nbEntres = 0;
	nbSortis = 0;
    }

    public void afficherCollecte(){
	for(Iterator<String> it = c.iterator(); it.hasNext(); )
	    {
		System.out.println(it.next());
	    }
    }
}
