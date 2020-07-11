echo =======================begin=======================
call jar cvf Yuntx_Plugin_Common_SDK_1.3.jar -C ..\yuntx_plugin_common\build\intermediates\classes\release .

echo =======================commen end=======================
choice /t 1 /d y /n >nul

call jar cvf Yuntx_Plugin_IM_SDK_1.0.jar -C ..\yuntx_plugin_im\build\intermediates\classes\release .
echo =======================im end=======================
choice /t 1 /d y /n >nul

call jar cvf Yuntx_Plugin_VoIP_SDK_1.0.jar -C ..\yuntx_plugin_voip\build\intermediates\classes\release .
echo =======================voip end=======================
choice /t 1 /d y /n >nul

call jar cvf Yuntx_Plugin_ShareMeeting_SDK_1.0.jar -C ..\yuntx_plugin_sharemeeting\build\intermediates\classes\release .
echo =======================shareMeeting end=======================
choice /t 1 /d y /n >nul

call jar cvf Yuntx_Plugin_Livechatroom_SDK_1.0.jar -C ..\yuntx_plugin_livechatroom\build\intermediates\classes\release .
echo =======================liveChatRoom end=======================
choice /t 1 /d y /n >nul

call jar cvf Yuntx_Plugin_Live_SDK_1.3.jar -C ..\yuntx_plugin_live\build\intermediates\classes\release .
echo =======================live end=======================
choice /t 1 /d y /n >nul

call jar cvf Yuntx_Plugin_Meeting_SDK_1.0.jar -C ..\yuntx_plugin_meeting\build\intermediates\classes\release .
echo =======================meeting end=======================
choice /t 1 /d y /n >nul

call java -jar .\proguard.jar @..\proguard-rules-ecsdk.pro
echo =======================proguard and merge end=======================