
main:  build/Messages.class build/Passager.class  build/Vehicule.class build/FauxPassager.class build/FauxVehicule.class  build/Jauge.class   build/Position.class build/PassagerStandard.class build/Autobus.class  build/FabriqueTec.class   build/Simple.class  	
	java -cp build -ea Simple

build/Vegicule.class:
build/Passager.class:
	javac -d build -cp build src/Vehicule.java src/Passager.java

build/%.class: src/%.java
	javac -d build -cp build src/$*.java

build/%.class: tst/%.java
	javac -d build -cp build tst/$*.java

clear:
	rm -rf build/*
