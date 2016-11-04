package tec;

public class FabriqueTec{
	
	public static Passager fairePassagerStd(String nom, int destination)
	{
		return new PassagerStandard(nom,destination);
	}

	public static Vehicule faireBus(int assis, int debout)
	{
		return new Autobus(assis,debout);
	}
}
