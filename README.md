Memory usage of Java objects
============================

Download artifacts
------------------

 http://sourceforge.net/projects/sizeof/files/sizeof/0.2.2/SizeOf_0_2_2.zip/download

  http://www.javamex.com/classmexer/classmexer-0_03.zip

Install artifacts into local repo
---------------------------------

  mvn install:install-file -Dfile=SizeOf.jar -DgroupId=net.sourceforge.sizeof -DartifactId=sizeof -Dversion=0.2.2 -Dpackaging=jar

  mvn install:install-file -Dfile=classmexer.jar -DgroupId=com.javamex.classmexer -DartifactId=classmexer -Dversion=0.0.3 -Dpackaging=jar

Run the test
------------

  mvn clean test

Inspect results
---------------

  target/sizeof.txt

  target/classmexer.txt

Links
-----

* http://marxsoftware.blogspot.cz/2011/12/estimating-java-object-sizes-with.html
* http://www.javaspecialists.co.za/archive/Issue142.html
* http://sizeof.sourceforge.net/
* http://www.javamex.com/classmexer/
* http://sourceforge.net/p/sizeof/code/HEAD/tree/trunk/src/net/sourceforge/sizeof/SizeOf.java
