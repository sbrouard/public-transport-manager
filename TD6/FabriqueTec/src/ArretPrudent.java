package tec;

class ArretPrudent implements ComportementArret{
   
    public void choixChangerPlace(int distDestination, Vehicule v, Passager P){
	if (distDestination > 5)
	    P.changerEnAssis();
	else if (distDestination < 3)
	    P.changerEnDebout();
    }
}
