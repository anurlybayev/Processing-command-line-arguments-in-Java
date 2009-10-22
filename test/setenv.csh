set LIBPATH = "${HOME}/jdev/mljdev/Options/v1.0/lib"

setenv CP ".:${LIBPATH}/options.jar"

setenv JAVA_HOME /usr/j2sdk1.5.0

alias java $JAVA_HOME/bin/java -classpath $CP
alias javac $JAVA_HOME/bin/javac -classpath $CP
alias javap $JAVA_HOME/bin/javap -classpath $CP

