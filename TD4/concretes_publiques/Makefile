
build/%.class: src/%.java
	javac -d build -cp build src/$*.java

build/%.class: tst/%.java
	javac -d build -cp build tst/$*.java

clear:
	rm -rf build/* build-autobusTest/* build-passagerTest/*
