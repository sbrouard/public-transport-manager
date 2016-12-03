package tec;

public class GreffonTramway extends Tramway {

    
    private Collecte c;

    public GreffonTramway(int assis, int debout, Collecte c){
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
