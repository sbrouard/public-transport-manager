package tec;

public class TestJauge {

    public void testExceptionCasLimite() {
	Jauge inverse = null;
	
	inverse = new Jauge(-42, -10);
	System.out.println("vert: " + inverse.estVert());
	System.out.println("rouge: " + inverse.estRouge());
    }

	public static void testDansIntervalle()
	{
		Jauge j = new Jauge(67899, 100);
		assert j.estVert() : "error";
		assert !j.estRouge() : "error";

	}

	public static void test2()
	{
		Jauge j = new Jauge(1,0);
		j.incrementer();
		assert j.estRouge() : "error";
	}

	static void test3()
	{
		Jauge j = new Jauge(1,1);
		assert j.estRouge() : "error";
		j.decrementer();
		assert j.estVert() : "error";
	}


	public static void main (String[] args)
	{
		boolean estMisAssertion = false;
		assert estMisAssertion = true;

		if (!estMisAssertion)
		{
			System.out.println("Execution impossible sans l'option -ea");
			return;
		}

		
	 	System.out.println(".");	
		TestJauge testJauge1 = new TestJauge();
		testJauge1.testDansIntervalle();
		
	 	System.out.println(".");	
		TestJauge testJauge2 = new TestJauge();
		testJauge2.test2();

	 	System.out.println(".");	
		TestJauge testJauge3 = new TestJauge();
		testJauge3.test3();

	 	System.out.println("OK");	
	}
}
