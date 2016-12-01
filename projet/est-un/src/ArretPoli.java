package tec;

class ArretPoli implements ComportementArret{
    public void choixChangerPlace(int disDestination, Vehicule v, Passager p){
	if ( !(v.aPlaceAssise()) && v.aPlaceDebout())
	    v.arretDemanderDebout(p);
    }
}
