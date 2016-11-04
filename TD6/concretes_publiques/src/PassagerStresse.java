package tec;

class PassagerStresse extends PassagerAbstrait implements Usager{

    public PassagerStresse(String nom, int numArret)
    {
	super(nom,numArret);
    }

    protected void choixPlaceMontee(Vehicule v){
	if (v.aPlaceAssise())
	    v.monteeDemanderAssis(this);
	else if (v.aPlaceDebout())
	    v.monteeDemanderDebout(this);
    }

    protected void choixChangerPlace(Vehicule v,int arret){
	if (super.getDestination() <= arret + 3){
	    if (v.aPlaceDebout())
		v.arretDemanderDebout(this);
	}
    }
}
    
    
