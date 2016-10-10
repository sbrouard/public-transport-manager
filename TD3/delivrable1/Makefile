compil_all: autobus passager simple

test_all : test_jauge test_position test_passager test_simple test_autobus

test_passager:
	java -ea -cp build-passagerTest:build tec.TestPassagerStandard

test_autobus:
	java -ea -cp build-autobusTest:build tec.TestAutobus

test_simple:
	java -ea -cp build:build-autobusTest Simple

test_jauge:
	java -ea -cp build tec.TestJauge

test_position: 
	java -ea -cp build tec.TestPosition

autobus : build/MessagesA.class build/Jauge.class build/AutobusMock.class build/TestAutobus.class

passager : build/MessagesP.class build/Position.class build/PassagerStandardMock.class build/TestPassagerStandard.class

simple: build/MessagesA.class build/Jauge.class build/Position.class build/AutobusPassagerStandard.class build/Simple.class

position: build/Position.class build/TestPosition.class

jauge: build/Jauge.class build/TestJauge.class

build/AutobusMock.class:
	javac -d build -cp build-autobusTest:build src/Autobus.java src/faussaires/PassagerStandard.java && mv build/tec/PassagerStandard.class build-autobusTest/tec/

build/PassagerStandardMock.class:
	javac -d build -cp build-passagerTest:build src/PassagerStandard.java src/faussaires/Autobus.java && mv build/tec/Autobus.class build-passagerTest/tec/

build/AutobusPassagerStandard.class:
	javac -d build -cp build-autobusTest:build src/Autobus.java src/PassagerStandard.java

build/MessagesA.class:
	javac -d build-autobusTest src/Messages.java

build/MessagesP.class:
	javac -d build-passagerTest src/Messages.java

build/TestAutobus.class:
	javac -d build-autobusTest -cp build-autobusTest:build tst/TestAutobus.java

build/TestPassagerStandard.class:
	javac -d build-passagerTest -cp build-passagerTest:build tst/TestPassagerStandard.java

build/Simple.class:
	javac -d build -cp build:build-autobusTest src/Simple.java

build/%.class: src/%.java
	javac -d build src/$*.java

build/%.class: tst/%.java
	javac -d build -cp build tst/$*.java

clear:
	rm -rf build/* build-autobusTest/* build-passagerTest/*
