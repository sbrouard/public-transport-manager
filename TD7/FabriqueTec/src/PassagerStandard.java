package tec;

class PassagerStandard extends MonteeRepos implements Usager{    
    public PassagerStandard(String nom, int destination) {
	super(nom,destination, new ArretCalme());
    }        
}
