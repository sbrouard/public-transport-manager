package tec;

class PassagerIndecis extends PassagerAbstrait implements Passager, Usager{ 

	public PassagerIndecis(String nom, int numArret)
	{
		super(nom,numArret);
	}

	protected void choixPlaceMontee(Vehicule v)
	{
	    if (v.aPlaceDebout())
		v.monteeDemanderDebout(this);	
	}

	protected void choixChangerPlace(Vehicule v, int arret)
	{
		if(estAssis())
			v.arretDemanderDebout(this);
		else if(estDebout())
			v.arretDemanderAssis(this);
	}
}
