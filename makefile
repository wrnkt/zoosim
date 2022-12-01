JC = javac

JFLAGS = -g -Wall

JCFLAGS = -g:vars,lines,source  -Xlint:unchecked
CLASSDIR = classes

default: Zoo.class Reptile.class Primate.class Pettable.class Mammal.class LoudSpeaker.class Logger.class Invertebrate.class Housable.class Enclosure.class Bird.class Animal.class Amphibian.class Exhibit.class Game.class LivingThing.class

rebuild:
	make clean
	make

Game.class: Game.Java Animal.java
	$(JC) $(JCFLAGS) -d $(CLASSDIR) Game.java
Exhibit.class: Exhibit.java LoudSpeaker.class Animal.class
	$(JC) $(JCFLAGS) -d $(CLASSDIR) Exhibit.java
LivingThing.class: LivingThing.java
	$(JC) $(JCFLAGS) -d $(CLASSDIR) LivingThing.java
Amphibian.class: Amphibian.java
	$(JC) $(JCFLAGS) -d $(CLASSDIR) Amphibian.java
Animal.class: Animal.java Housable.class LivingThing.class
	$(JC) $(JCFLAGS) -d $(CLASSDIR) Animal.java
Bird.class: Bird.java
	$(JC) $(JCFLAGS) -d $(CLASSDIR) Bird.java
Enclosure.class: Enclosure.java
	$(JC) $(JCFLAGS) -d $(CLASSDIR) Enclosure.java
Housable.class: Housable.java
	$(JC) $(JCFLAGS) -d $(CLASSDIR) Housable.java
Invertebrate.class: Invertebrate.java
	$(JC) $(JCFLAGS) -d $(CLASSDIR) Invertebrate.java
Logger.class: Logger.java
	$(JC) $(JCFLAGS) -d $(CLASSDIR) Logger.java
LoudSpeaker.class: LoudSpeaker.java
	$(JC) $(JCFLAGS) -d $(CLASSDIR) LoudSpeaker.java
Mammal.class: Mammal.java
	$(JC) $(JCFLAGS) -d $(CLASSDIR) Mammal.java
Pettable.class: Pettable.java
	$(JC) $(JCFLAGS) -d $(CLASSDIR) Pettable.java
Primate.class: Primate.java
	$(JC) $(JCFLAGS) -d $(CLASSDIR) Primate.java
Reptile.class: Reptile.java
	$(JC) $(JCFLAGS) -d $(CLASSDIR) Reptile.java
Zoo.class: Zoo.java
	$(JC) $(JCFLAGS) -d $(CLASSDIR) Zoo.java

run:
	java -cp $(CLASSDIR) Logger

clean:
	$(RM) $(CLASSDIR)/*.class
