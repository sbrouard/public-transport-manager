package tec;

class ArretNerveux implements ComportementArret{

    public void choixChangerPlace(int distDest, Vehicule v, Passager p){
	if(p.estAssis() && v.aPlaceDebout())
	    v.arretDemanderDebout(p);
	else if(p.estDebout() && v.aPlaceAssise())
	    v.arretDemanderAssis(p);
    }

}
