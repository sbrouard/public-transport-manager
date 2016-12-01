package tec;

public class PassagerStresse extends MonteeFatigue implements Usager{

    public PassagerStresse(String nom, int numArret)
    {
	super(nom,numArret,new ArretPrudent() );
    }

}
    
    
