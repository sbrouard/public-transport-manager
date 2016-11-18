TST=tec.TestJauge\
	tec.TestPosition\
	tec.TestAutobus\
	tec.TestPassagerStandard

all: clear
	javac -d build src/*.java tst/*.java
	java -ea -cp build tec.LancerTests $(TST)
	java -ea -cp build Simple
	java -ea -cp build TestTecInvalidException

clear:
	rm -rf build*/*
	rm -rf src/#* src/*~
	rm -rf tst/#* tst/*~

