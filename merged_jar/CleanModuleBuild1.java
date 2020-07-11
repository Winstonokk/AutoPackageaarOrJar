import java.io.File;
import java.io.IOException;

/**
 * Created by xiaokun on 2019/8/28.
 *
 * @author xiaokun
 * @date 2019/8/28
 */
public class CleanModuleBuild1 {

    static String commomlastFileStr = "/build/intermediates/classes/release/com/yuntongxun";
    static String share = "/yuntx_plugin_sharemeeting";

    public static void main(String[] args) {
        File directory = new File(System.getProperty("user.dir"));
        try {
            //输出E:\android\ProjectSpaces\StudioProjects\IMPlusAndroidSDK
            System.out.println(directory.getCanonicalPath());//获取标准的路径
            System.out.println(directory.getAbsolutePath());//获取绝对路径
            String rootPath = directory.getParentFile().getCanonicalPath();
            //1.删除common中的make后的文件夹
            String commonPath = rootPath + "/yuntx_plugin_common" + commomlastFileStr;//"/build/intermediates/classes/commen_/release/com/yuntongxun";
            System.out.println("--------------------------------------------------------------------");
            System.out.println(commonPath);
            File commonFile = new File(commonPath);
            clearPluginFile(commonFile, true);

            //2.删除im中的make后的文件
            String imPath = rootPath + "/yuntx_plugin_im" + commomlastFileStr;
            System.out.println("--------------------------------------------------------------------");
            System.out.println(imPath);
            File imFile = new File(imPath);
            clearPluginFile(imFile, false);

            //3.删除voip中make后的文件
            String voipPath = rootPath + "/yuntx_plugin_voip" + commomlastFileStr;
            System.out.println("--------------------------------------------------------------------");
            System.out.println(voipPath);
            File voipFile = new File(voipPath);
            clearPluginFile(voipFile, false);

            //4.删除ShareMeeting中make后的文件
            String sharePath = rootPath + share + commomlastFileStr;
            System.out.println("--------------------------------------------------------------------");
            System.out.println(sharePath);
            File shareFile = new File(sharePath);
            clearPluginFile(shareFile, false);

            //5.删除LiveChatRoom
            String liveChatRoomPath = rootPath + "/yuntx_plugin_livechatroom" + commomlastFileStr;
            File liveChatRoomFile = new File(liveChatRoomPath);
            clearPluginFile(liveChatRoomFile, false);

            //6.删除Live
            String livePath = rootPath + "/yuntx_plugin_live" + commomlastFileStr;
            File liveFile = new File(livePath);
            clearPluginFile(liveFile, false);

            //7.删除meeting
            String meetingPath = rootPath + "/yuntx_plugin_meeting" + commomlastFileStr;
            File meetingFile = new File(meetingPath);
            clearPluginFile(meetingFile, false);
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
            if (name.startsWith("yuntx_plugin_")) {
                file1.setWritable(true);
                deleteDir(file1);
            }

            if ("ecsdk".equals(file1.getName())) {
                clearPluginFile(file1, false);
                if (isCommon) {
                    File[] listFiles = file1.listFiles();
                    for (File listFile : listFiles) {
                        if (listFile != null && "core".equals(listFile.getName())) {
                            clearServiceFile(listFile);
                            break;
                        }
                    }
                }
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
