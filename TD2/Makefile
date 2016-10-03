
all: test

test:test_autobus_mock test_passager_mock

test_autobus_mock: build/Messages.class build/PassagerStandard.class build/Autobus.class build/TestAutobus.class
	java -ea -cp build tec.TestAutobus

test_passager_mock: build/Messages.class build/PassagerStandard.class build/Autobus.class build/TestAutobus.class
	java -ea -cp build tec.PassagerStandard

build/PassagerStandard.class:
	javac -d build -cp build tst/PassagerStandard.java src/Autobus.java

build/Autobus.class:
	javac -d build -cp build tst/PassagerStandard.java src/Autobus.java

build/%.class: tst/%.java
	javac -d build -cp build tst/$*.java

build/%.class: src/%.java
	javac -d build -cp build src/$*.java
