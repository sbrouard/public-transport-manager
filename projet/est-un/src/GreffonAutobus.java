package tec;

public class GreffonAutobus extends Autobus {

    
    Collecte c;

    public GreffonAutobus(int assis, int debout, Collecte c){
	super(assis, debout);
	this.c = c;
    }


 

    void monteeDemanderAssis(Passager p){
	super.monteeDemanderAssis(p);
	c.uneEntree();
    }
 
    void monteeDemanderDebout(Passager p){
	super.monteeDemanderDebout(p);
	c.uneEntree();
    }
    

    void arretDemanderSortie(Passager p){
	super.arretDemanderSortie(p);
	c.uneSortie();
    }

    public void allerArretSuivant(){
	super.allerArretSuivant();
	c.changerArret();
    }
    
    

}
