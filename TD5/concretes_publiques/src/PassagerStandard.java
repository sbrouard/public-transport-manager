package tec;

public class PassagerStandard extends PassagerAbstrait implements Usager{
    Position pos;
    String name;
    int dst;

    public PassagerStandard(String nom, int destination) {
	super(nom,destination);
    }
   
    
    void choixPlaceMontee(Vehicule v){
	if (t.aPlaceAssise()){
	    t.monteeDemanderAssis(this);
	}
	else if (t.aPlaceDebout()){
	    t.monteeDemanderDebout(this);
	    }
    }


    void choixChangerPlace(Vehicule v, int arret){}
    
    
    public String toString() {
	return name + pos.toString();
    }
}
