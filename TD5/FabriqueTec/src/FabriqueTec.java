package tec;

public class FabriqueTec{
    
    public static Usager fairePassagerStd(String nom, int destination)
    {
	return new PassagerStandard(nom,destination);
    }
    
    public static Usager fairePassagerStresse(String nom, int destination)
    {
	    return new PassagerStresse(nom,destination);
    }
    
    public static Usager fairePassagerIndecis(String nom, int destination)
    {
	return new PassagerIndecis(nom,destination);
    }
    
    public static Transport faireBus(int assis, int debout)
    {
	return new Autobus(assis,debout);
    }
}
