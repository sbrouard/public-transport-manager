package tec;

abstract class MonteeFatigue extends PassagerAbstrait {

    public MonteeFatigue(String nom, int destination, ComportementArret comp){
	super(nom,destination,comp);
    }

    
    protected void choixPlaceMontee(Vehicule v){
	if (v.aPlaceAssise())
	    v.monteeDemanderAssis(this);
    }
}
