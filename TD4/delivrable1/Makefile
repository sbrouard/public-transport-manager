all : position jauge passager_standard autobus simple

position: build/Position.class build/TestPosition.class
	java -ea -cp build tec.TestPosition

jauge: build/Jauge.class build/TestJauge.class
	java -ea -cp build tec.TestJauge

passager_standard: build/Messages.class build/Position.class build/Passager.class build/PassagerStandard.class build/Vehicule.class build/FauxVehicule.class build/TestPassagerStandard.class
	java -ea -cp build tec.TestPassagerStandard

autobus: build/Messages.class build/Passager.class build/FauxPassager.class build/Vehicule.class build/Jauge.class build/Autobus.class build/TestAutobus.class
	java -ea -cp build tec.TestAutobus

simple: build/Passager.class  build/Vehicule.class build/Jauge.class build/Position.class build/PassagerStandard.class build/Autobus.class  build/Simple.class
	java -ea -cp build Simple

build/Vehicule.class:
build/Passager.class:
	javac -d build -cp build src/Vehicule.java src/Passager.java

build/%.class: src/%.java
	javac -d build -cp build src/$*.java

build/%.class: tst/%.java
	javac -d build -cp build tst/$*.java

clear:
	rm -rf build/*
