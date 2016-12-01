package tec;

abstract class MonteeSportif extends PassagerAbstrait{
    
    public MonteeSportif(String nom, int destination, ComportementArret comp){
	super(nom,destination,comp);
    }

    protected void choixPlaceMontee(Vehicule v){
	if (v.aPlaceDebout())
	    v.monteeDemanderDebout(this);
    }
}
    
    
