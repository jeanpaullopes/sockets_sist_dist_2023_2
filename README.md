Para criar o .JAR

Entre na pasta do fonte ./src

    cd src

compile o projeto Java com 

    javac Server.java

depois crie o .jar com 

    jar cmvf MANIFEST.MF Server.jar *.class

para executar use 

    java -jar Server.jar
