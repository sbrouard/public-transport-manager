package tec;

class PassagerIndecis extends PassagerAbstrait implements Usager{ 

	public PassagerIndecis(String nom, int numArret)
	{
		super(nom,numArret);
	}

	void choixPlaceMontee(Vehicule v)
	{
		v.monteeDemanderDebout(this);	
	}

	void choixChangerPlace(Vehicule v, int arret)
	{
		if(estAssis())
			v.arretDemanderDebout();
		else if(estDebout())
			v.arretDemanderAssis();
	}
}
