import java.io.File;
import java.io.IOException;

/**
 * Created by xiaokun on 2019/8/28.
 *
 * @author xiaokun
 * @date 2019/8/28
 */
public class CleanModuleBuild {

    static String commomlastFileStr = "\\build\\intermediates\\classes\\release\\com\\yuntongxun";

    public static void main(String[] args) {
        File directory = new File(System.getProperty("user.dir"));
        try {
            //输出F\:\\Android\\AndroidSDK
            System.out.println(directory.getCanonicalPath());//获取标准的路径
            System.out.println(directory.getAbsolutePath());//获取绝对路径
            String rootPath = directory.getParentFile().getCanonicalPath();
            //1.删除mymodule1中的make后的文件夹
            String mymodule1Path = rootPath + "\\mymodule1" + commomlastFileStr;//"\\build\\intermediates\\classes\\commen_\\release\\com\\barnettwong";
            System.out.println(mymodule1Path);
            File mymodule1File = new File(mymodule1Path);
            clearPluginFile(mymodule1File, true);

            //2.删除mymodule2中的make后的文件
            String mymodule2Path = rootPath + "\\mymodule2" + commomlastFileStr;
            File mymodule2File = new File(mymodule2Path);
            clearPluginFile(mymodule2File, false);

            //3.删除mymodule3中make后的文件
            String mymodule3Path = rootPath + "\\mymodule3" + commomlastFileStr;
            File mymodule3File = new File(mymodule3Path);
            clearPluginFile(mymodule3File, false);

            //4.删除mymodule4中make后的文件
            String mymodule4Path = rootPath + "\\mymodule4" + commomlastFileStr;
            File mymodule4File = new File(mymodule4Path);
            clearPluginFile(mymodule4File, false);

            //5.删除mymodule5
            String mymodule5Path = rootPath + "\\mymodule5" + commomlastFileStr;
            File mymodule5File = new File(mymodule5Path);
            clearPluginFile(mymodule5File, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 清楚plugin文件夹
     *
     * @param file     文件夹
     * @param isCommon 是否是common模块
     */
    private static void clearPluginFile(File file, boolean isCommon) {
        if (file == null) {
            System.out.println("file == null");
            return;
        }
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        for (File file1 : files) {
            String name = file1.getName();
            if (isEmpty(name)) {
                continue;
            }
            if (name.startsWith("mymodule")) {
                file1.setWritable(true);
                deleteDir(file1);
            }

        }
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     * If a deletion fails, the method stops attempting to
     * delete and returns "false".
     */
    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

    private static void clearServiceFile(File file) {
        if (file == null) {
            System.out.println("file == null");
            return;
        }
        System.out.println(file.getName());
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1 != null && "service".equals(file1.getName())) {
                System.out.println(file1.getName());
                System.out.println(deleteDir(file1));
                break;
            }
        }
    }

    private static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

}
