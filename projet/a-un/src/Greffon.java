package tec;

public class Greffon extends Vehicule implements Transport {

    private Vehicule v;
    private Collecte c;

    public Greffon(Transport t, Collecte c){
	v = (Vehicule) t;
	this.c = c;
    }

    void monteeDemanderAssis(Passager p){
	v.monteeDemanderAssis(p);
	c.uneEntree();
    }
 
    void monteeDemanderDebout(Passager p){
	v.monteeDemanderDebout(p);
	c.uneEntree();
    }
    
    void arretDemanderDebout(Passager p){
	v.arretDemanderDebout(p);
    }

    void arretDemanderAssis(Passager p){
	v.arretDemanderAssis(p);
    }

    void arretDemanderSortie(Passager p){
	v.arretDemanderSortie(p);
	c.uneSortie();
    }

    public void allerArretSuivant(){
	v.allerArretSuivant(this);
	c.changerArret();
    }
    
    public void allerArretSuivant(Greffon g){
    }
    
    public boolean aPlaceAssise(){
	return v.aPlaceAssise();
    }

    public boolean aPlaceDebout(){
	return v.aPlaceDebout();
    }

    public String toString(){
	return v.toString();
    }
}
