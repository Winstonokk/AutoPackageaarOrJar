call gradlew :mymodule1:assembleRelease
call gradlew :mymodule2:assembleRelease
call gradlew :mymodule3:assembleRelease
call gradlew :mymodule4:assembleRelease
call gradlew :mymodule5:assembleRelease
cd .\merged_jar
javac -encoding utf-8 CleanModuleBuild.java
java CleanModuleBuild
package_script.bat