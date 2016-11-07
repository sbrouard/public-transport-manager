package tec;

class ArretNerveux implements ComportementArret{

    public void choixChangerPlace(int distDest, Vehicule v, Passager p){
	if(p.estAssis() && v.aPlaceDebout())
	    p.changerEnDebout();
	else if(p.estDebout() && v.aPlaceAssise())
	    p.changerEnAssis();
    }

}
