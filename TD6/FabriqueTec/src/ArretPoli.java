package tec;

class ArretPoli implements ComportementArret{
    void choixChangerPlace(int disDestination, Vehicule v, Passager P){
	if ( !(v.aPlaceAssise()) )
	    P.changerEnDebout();
    }
}
