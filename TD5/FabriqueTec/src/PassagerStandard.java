package tec;

class PassagerStandard extends PassagerAbstrait implements Passager, Usager{
    Position pos;
    String name;
    int dst;

    public PassagerStandard(String nom, int destination) {
	super(nom,destination);
    }
    
    protected void choixPlaceMontee(Vehicule v){
	if (v.aPlaceAssise()){
	    v.monteeDemanderAssis(this);
	}
	else if (v.aPlaceDebout()){
	    v.monteeDemanderDebout(this);
	    }
    }


    protected void choixChangerPlace(Vehicule v, int arret){}
}
