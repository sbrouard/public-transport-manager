import tec.Autobus;
import tec.PassagerStandard;
import tec.Usager;
import tec.Transport;
import tec.TecInvalidException;
import tec.CollecteFichier;
import tec.Greffon;
import tec.CollecteCollection;
import tec.Collecte;

class Simple {
    
    public void testIntegration() throws TecInvalidException {
	Transport serenity = new Autobus(1, 2);
	
	Usager kaylee = new PassagerStandard("Kaylee", 4);
	Usager jayne = new PassagerStandard("Jayne", 4);
	Usager inara = new PassagerStandard("Inara", 5);
    
	//0
	System.out.println(serenity.toString());
	
	//1
	serenity.allerArretSuivant();
	kaylee.monterDans(serenity);
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	
	//2
	serenity.allerArretSuivant();
	jayne.monterDans(serenity);
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	System.out.println(jayne.toString());
	
	//3
	serenity.allerArretSuivant();
	inara.monterDans(serenity);
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	System.out.println(jayne.toString());
	System.out.println(inara.toString());

	//4
	serenity.allerArretSuivant();
	
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	System.out.println(jayne.toString());
	System.out.println(inara.toString());


	//5
	serenity.allerArretSuivant();
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	System.out.println(jayne.toString());
	System.out.println(inara.toString());
	
	/* Resulat de l'execution.
	   [arret 0] assis<1> debout<2>
	   [arret 1] assis<0> debout<2>
	   Kaylee <assis>
	   [arret 2] assis<0> debout<1>
	   Kaylee <assis>
	   Jayne <debout>
	   [arret 3] assis<0> debout<0>
	   Kaylee <assis>
	   Jayne <debout>
	   Inara <debout>
	   [arret 4] assis<1> debout<1>
	   Kaylee <endehors>
	   Jayne <endehors>
	   Inara <debout>
	   [arret 5] assis<1> debout<2>
	   Kaylee <endehors>
	   Jayne <endehors>
	   Inara <endehors>
	*/
    }

    public void testIntegrationCollecteFichier() throws TecInvalidException {
	Transport serenity = new Greffon(new Autobus(1, 2), new CollecteFichier("log.txt"));
	
	Usager kaylee = new PassagerStandard("Kaylee", 4);
	Usager jayne = new PassagerStandard("Jayne", 4);
	Usager inara = new PassagerStandard("Inara", 5);
    
	//0
	System.out.println(serenity.toString());
	
	//1
	serenity.allerArretSuivant();
	kaylee.monterDans(serenity);
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	
	//2
	serenity.allerArretSuivant();
	jayne.monterDans(serenity);
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	System.out.println(jayne.toString());
	
	//3
	serenity.allerArretSuivant();
	inara.monterDans(serenity);
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	System.out.println(jayne.toString());
	System.out.println(inara.toString());

	//4
	serenity.allerArretSuivant();
	
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	System.out.println(jayne.toString());
	System.out.println(inara.toString());


	//5
	serenity.allerArretSuivant();
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	System.out.println(jayne.toString());
	System.out.println(inara.toString());
	
	/* Resulat de l'execution.
	   [arret 0] assis<1> debout<2>
	   [arret 1] assis<0> debout<2>
	   Kaylee <assis>
	   [arret 2] assis<0> debout<1>
	   Kaylee <assis>
	   Jayne <debout>
	   [arret 3] assis<0> debout<0>
	   Kaylee <assis>
	   Jayne <debout>
	   Inara <debout>
	   [arret 4] assis<1> debout<1>
	   Kaylee <endehors>
	   Jayne <endehors>
	   Inara <debout>
	   [arret 5] assis<1> debout<2>
	   Kaylee <endehors>
	   Jayne <endehors>
	   Inara <endehors>
	*/
    }

    public void testIntegrationCollecteCollection() throws TecInvalidException {
    
	CollecteCollection c = new CollecteCollection();
	Transport serenity = new Greffon(new Autobus(1, 2), c);
	
	Usager kaylee = new PassagerStandard("Kaylee", 4);
	Usager jayne = new PassagerStandard("Jayne", 4);
	Usager inara = new PassagerStandard("Inara", 5);
    
	//0
	System.out.println(serenity.toString());
    
	//1
	serenity.allerArretSuivant();
	kaylee.monterDans(serenity);
    
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
    
	//2
	serenity.allerArretSuivant();
	jayne.monterDans(serenity);
    
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	System.out.println(jayne.toString());
    
	//3
	serenity.allerArretSuivant();
	inara.monterDans(serenity);
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	System.out.println(jayne.toString());
	System.out.println(inara.toString());

	//4
	serenity.allerArretSuivant();
	
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	System.out.println(jayne.toString());
	System.out.println(inara.toString());


	//5
	serenity.allerArretSuivant();
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	System.out.println(jayne.toString());
	System.out.println(inara.toString());
	System.out.println("");
	c.afficherCollecte();
	

	/* Resulat de l'execution.
	   [arret 0] assis<1> debout<2>
	   [arret 1] assis<0> debout<2>
	   Kaylee <assis>
	   [arret 2] assis<0> debout<1>
	   Kaylee <assis>
	   Jayne <debout>
	   [arret 3] assis<0> debout<0>
	   Kaylee <assis>
	   Jayne <debout>
	   Inara <debout>
	   [arret 4] assis<1> debout<1>
	   Kaylee <endehors>
	   Jayne <endehors>
	   Inara <debout>
	   [arret 5] assis<1> debout<2>
	   Kaylee <endehors>
	   Jayne <endehors>
	   Inara <endehors>
	*/
    }
    
    public static void main (String[] args) throws TecInvalidException {
  
	/*rappel pour ne pas oublier -ea */
	boolean estMisAssertion = false;
	assert estMisAssertion = true; 
	if (!estMisAssertion) { 
	    System.out.println("Execution impossible sans l'option -ea");
	    return; 
	}
	
	Simple test1 = new Simple();
	test1.testIntegration();

	Simple test2 = new Simple();
	test2.testIntegrationCollecteFichier();
	
	Simple test3 = new Simple();
	test3.testIntegrationCollecteCollection();
    }
}
