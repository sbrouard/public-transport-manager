package tec;

class ArretPrudent implements ComportementArret{
   
    public void choixChangerPlace(int distDestination, Vehicule v, Passager P){
	if (distDestination > 5)
	    v.arretDemanderAssis(P);
	else if (distDestination < 3)
	    v.arretDemanderDebout(P);
    }
}
