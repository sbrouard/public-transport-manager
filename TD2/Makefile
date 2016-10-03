
all: test

test:test_autobus_mock test_passager_mock test_autobus test_passager simple

test_autobus_mock: build/Messages.class build/AutobusMock.class build/TestAutobus.class
	java -ea -cp build tec.TestAutobus

test_passager_mock: build/Messages.class build/PassagerStandardMock.class build/TestPassagerStandard.class
	java -ea -cp build tec.TestPassagerStandard

test_autobus: build/Messages.class build/Autobus.class build/TestAutobus.class
	java -ea -cp build tec.TestAutobus

test_passager: build/Messages.class build/Position.class build/PassagerStandard.class build/TestPassagerStandard.class
	java -ea -cp build tec.TestPassagerStandard

simple: build/Messages.class build/Position.class build/AutobusPassagerStandard.class build/Simple.class
	java -ea -cp build tec.Simple

build/PassagerStandardMock.class:
	javac -d build -cp build tst/PassagerStandard.java src/Autobus.java

build/AutobusMock.class:
	javac -d build -cp build tst/PassagerStandard.java src/Autobus.java

build/Autobus.class:
	javac -d build -cp build src_autobus/Autobus.java tst/PassagerStandard.java

build/PassagerStandard.class:
	javac -d build -cp build src_passager/PassagerStandard.java src/Autobus.java

build/AutobusPassagerStandard.class:
	javac -d build -cp build src_passager/PassagerStandard.java src_autobus/Autobus.java

build/%.class: tst/%.java
	javac -d build -cp build tst/$*.java

build/%.class: src/%.java
	javac -d build -cp build src/$*.java
