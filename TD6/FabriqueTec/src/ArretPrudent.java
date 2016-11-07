package tec;

class ArretPrudent implements ComportementArret{
   
    void choixChangerPlace(int distDestination, Vehicule v, Passager P){
	if (distDestination > 5)
	    changerEnAssis();
	else if (distDestination < 3)
	    changerEnDebout();
    }
}
