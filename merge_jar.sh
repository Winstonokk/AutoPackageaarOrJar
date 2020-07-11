#!/usr/bin/env bash
 ./gradlew :mymodule1:assembleRelease
 ./gradlew :mymodule2:assembleRelease
 ./gradlew :mymodule3:assembleRelease
 ./gradlew :mymodule4:assembleRelease
 ./gradlew :mymodule5:assembleRelease
cd merged_jar
javac -encoding utf-8 CleanModuleBuild.java
java CleanModuleBuild
./package_script1.sh