package tec;

abstract class MonteeTendu extends PassagerAbstrait{

    public MonteeTendu(String nom, int destination, ComportementArret comp){
	super(nom,destination,comp);
    }

    
    protected void choixPlaceMontee(Vehicule v){
	    v.monteeDemanderDebout(this);
    }
}
