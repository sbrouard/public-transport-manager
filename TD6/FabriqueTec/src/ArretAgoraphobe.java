package tec;

class ArretAgoraphobe implements ComportementArret{
    
    void choixChangerPlace(int distDestination, Vehicule v, Passager P){
	if ( !(v.aPlaceDebout()) && !(v.aPlaceAssise()) )
	     P.changerEnDehors();
    }


}
