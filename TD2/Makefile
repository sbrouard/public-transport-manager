

all: test

test:test_autobus test_passager

test_autobus: build/Messages.class build/PassagerStandard.class build/Autobus.class build/TestAutobus.class
	java -ea -cp build tec.TestAutobus

test_passager: build/Messages.class build/PassagerStandard.class build/Autobus.class build/TestAutobus.class
	java -ea -cp build tec.PassagerStandard

build/PassagerStandard.class:
	javac -d build -cp build tst/PassagerStandard.java src/Autobus.java

build/Autobus.class:
	javac -d build -cp build tst/PassagerStandard.java src/Autobus.java

build/%.class: tst/%.java
	javac -d build -cp build tst/$*.java

build/%.class: src/%.java
	javac -d build -cp build src/$*.java
