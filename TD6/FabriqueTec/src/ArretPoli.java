package tec;

class ArretPoli implements ComportementArret{
    public void choixChangerPlace(int disDestination, Vehicule v, Passager P){
	if ( !(v.aPlaceAssise()) )
	    P.changerEnDebout();
    }
}
