all : test

test : test_autobus test_passager simple

test_autobus : build/MessagesA.class build/Jauge.class build/AutobusMock.class build/TestAutobus.class
	java -ea -cp build-autobusTest:build tec.TestAutobus

test_passager : build/MessagesP.class build/Position.class build/PassagerStandardMock.class build/TestPassagerStandard.class
	java -ea -cp build-passagerTest:build tec.TestPassagerStandard

simple: build/MessagesA.class build/Jauge.class build/Poisiton.class build/AutobusPassagerStandard.class build/Simple.class
	java -ea -cp build:build-autobusTest Simple

build/AutobusMock.class:
	javac -d build -cp build src/Autobus.java src/faussaires/PassagerStandard.java

build/PassagerStandardMock.class:
	javac -d build -cp build src/PassagerStandard.java src/faussaires/Autobus.java

build/AutobusPassagerStandard.class:
	javac -d build -cp build src/Autobus.java src/PassagerStandard.java

build/MessagesA.class:
	javac -d build-autobusTest src/Messages.java

build/MessagesP.class:
	javac -d build-passagerTest src/Messages.java

build/TestAutobus.class:
	javac -d build-autobusTest -cp build-autobusTest:build tst/TestAutobus.class

build/TestPassagerStandard.class:
	javac -d build-passagerTest -cp build-passagerTest:build tst/TestPassagerStandard.class

build/%.class: src/%.java
	javac -d build src/$*.class

clear:
	rm build/*.class build-autobusTest/*.class build-passagerTest/*.class
