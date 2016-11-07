package tec;

class MonterTendu extends PassagerAbstrait{


    protected void choixPlaceMontee(Vehicule v){
	    v.monteeDemanderDebout(this);
    }
}
