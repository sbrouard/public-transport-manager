TST=tec.TestJauge\
	tec.TestPosition\
	tec.TestAutobus\
	tec.TestPassagerStandard

all: clear
	javac -d build src/*.java tst/*.java
	java -ea -cp build tec.LancerTests $(TST)
	java -ea -cp build Simple
#java -ea -cp build TestTecInvalidException

debug: clear
	javac -g -d build src/*.java tst/*.java
	java -ea -cp build tec.LancerTests $(TST)
	jdb -ea -cp build Simple

clear:
	rm -rf build*/*
	rm -rf src/#* src/*~
	rm -rf tst/#* tst/*~
