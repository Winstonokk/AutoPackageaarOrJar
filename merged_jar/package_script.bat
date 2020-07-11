echo =======================begin=======================

call jar cvf mymodule1.jar -C ..\mymodule1\build\intermediates\classes\release .
echo =======================mymodule1 end=======================
choice /t 1 /d y /n >nul

call jar cvf mymodule2.jar -C ..\mymodule2\build\intermediates\classes\release .
echo =======================mymodule2 end=======================
choice /t 1 /d y /n >nul

call jar cvf mymodule3.jar -C ..\mymodule3\build\intermediates\classes\release .
echo =======================mymodule3 end=======================
choice /t 1 /d y /n >nul

call jar cvf mymodule4.jar -C ..\mymodule4\build\intermediates\classes\release .
echo =======================mymodule4 end=======================
choice /t 1 /d y /n >nul

call jar cvf mymodule5.jar -C ..\mymodule5\build\intermediates\classes\release .
echo =======================mymodule5 end=======================
choice /t 1 /d y /n >nul


call java -jar .\proguard.jar @..\proguard-rules-ecsdk.pro
echo =======================proguard and merge end=======================