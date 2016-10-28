package tec;

public class FabriqueTec{
	
	public static Usager fairePassagerStd(String nom, int destination)
	{
		return new PassagerStandard(nom,destination);
	}

	public static Transport faireBus(int assis, int debout)
	{
		return new Autobus(assis,debout);
	}
}
