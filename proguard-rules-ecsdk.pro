#引入混淆配置文件
-include './mymodule1/proguard-rules.pro'
-include './mymodule2/proguard-rules.pro'
-include './mymodule3/proguard-rules.pro'
-include './mymodule4/proguard-rules.pro'
-include './mymodule5/proguard-rules.pro'


#原始jar包的位置和jar包名
-injars './merged_jar/mymodule1.jar'(!META-INF/MANIFEST.MF)
-injars './merged_jar/mymodule2.jar'(!META-INF/MANIFEST.MF)
-injars './merged_jar/mymodule3.jar'(!META-INF/MANIFEST.MF)
-injars './merged_jar/mymodule4.jar'(!META-INF/MANIFEST.MF)
-injars './merged_jar/mymodule5.jar'(!META-INF/MANIFEST.MF)


#混淆后的导出jar包的位置和jar包名
-outjars './merged_jar/myAllModule.jar'

#混淆日志保存
-dump './merged_jar/dump.txt'
-printseeds './merged_jar/seeds.txt'
-printusage './merged_jar/usage.txt'
-printmapping './merged_jar/mapping.txt'



#jar包依赖的其他库的位置和名称
#The location and name of the library depends on the other
# 注意这两个路径是需要改成你本机路径(每个人都不一样)
-libraryjars './merged_jar/rt.jar'
-libraryjars './merged_jar/android.jar'

-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService



-keepclasseswithmembers class * {
    native <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context,android.util.AttributeSet);
}


-keepclasseswithmembers class * {
    public <init>(android.content.Context,android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keepclassmembers enum  * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

-keep  class net.sqlcipher.** {*;}
-keep  class net.sqlcipher.database.** {*;}

#-keep class com.ecarx.**{*;}
#-keep class com.melink.**{*;}
#-keep class com.thirdparty.**{*;}

#下面的类将不会被混淆，这样的类是需要被jar包使用者直接调用的
# keep 泛型
#-ignorewarnings
-keepattributes Signature,Deprecated,InnerClasses
