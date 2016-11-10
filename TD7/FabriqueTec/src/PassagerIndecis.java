package tec;

class PassagerIndecis extends MonteeSportif implements Usager{ 

	public PassagerIndecis(String nom, int numArret)
	{
	    super(nom,numArret,new ArretNerveux());
	}
}
