package tec;

class MonteeFatigue extends PassagerAbstrait {
	
    protected void choixPlaceMontee(Vehicule v){
	if (v.aPlaceAssise())
	    v.monteeDemanderAssis(this);
    }
}
