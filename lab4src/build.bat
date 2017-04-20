@echo off
REM Build file for C-Minus compiler
echo Compiling yacc parser specification
yacc -d -J cminus.y

echo Compiling JFlex scanner specification
call jflex -q cminus.flex

echo Compiling main program
javac ParseMain.java Parser.java Yylex.java

echo Done