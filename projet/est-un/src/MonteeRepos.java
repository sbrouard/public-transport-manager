package tec;

abstract class MonteeRepos extends PassagerAbstrait{
    
    public MonteeRepos(String nom, int destination, ComportementArret comp){
	super(nom,destination,comp);
    }


    protected void choixPlaceMontee(Vehicule v){
	if (v.aPlaceAssise())
	    v.monteeDemanderAssis(this);
	else if (v.aPlaceDebout())
	    v.monteeDemanderDebout(this);
    }
}
