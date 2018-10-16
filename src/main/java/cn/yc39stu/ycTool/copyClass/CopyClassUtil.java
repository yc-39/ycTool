package cn.yc39stu.ycTool.copyClass;

import cn.yc39stu.ycTool.util.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyClassUtil {

    private static final String JAVA_HOME = System.getProperties().getProperty("java.home");

    // 精简jdk主要是精简rt.jar和charsets.jar包
    // 使用 -verbose 运行jar包，获取jar包运行所需依赖的第三方jar包
    // 复制-verbose打印信息，保存至一个文件里，读取该文件，获取文本数据
    // 根据规则获取jar包下的class文件路径
    // 复制文件

    public static String cmdJar(String jarPath) {
        StringBuffer sb = new StringBuffer();
        try {
            // 调用系统cmd执行
            Process process = Runtime.getRuntime().exec("java -jar -verbose " + jarPath);

            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String temp = br.readLine();
            while (temp != null) {
                sb.append(temp + "\r\n");
                System.out.println(temp);
                temp = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static List<String> getClassFile(String verboseFilePath) {
        String verboseStr = FileUtil.readTxtFile(new File(verboseFilePath));
        return dealVerboseStrs(verboseStr);
    }

    public static List<String> dealVerboseStrs(String verboseStr) {
        List<String> classPathList = new ArrayList<>();
        Map<String, String> classPathMap = new HashMap<>();

        String[] verboseStrs = verboseStr.split("\r\n");
        for (String tempStr : verboseStrs) {
            if (tempStr.indexOf("[Loaded") == -1) {
                continue;
            }
            tempStr = tempStr.substring(8, tempStr.length()-5);
            String[] tempStrs2 = tempStr.split(" from ");
            classPathMap.put(tempStrs2[0].replace(".", File.separator), tempStrs2[1] + File.separator);
        }

        for (String key : classPathMap.keySet()) {
            String classFilePath = classPathMap.get(key) + key + ".class";
//            File file = new File(classFilePath);
//            if (!file.exists()) {
//                System.out.println(classFilePath);
//                continue;
//            }
            classPathList.add(classFilePath);
        }

        return classPathList;
    }

    public static void copyFile(List<String> sourcePathList, String destPath) {
        for (String sourcePath : sourcePathList) {
            FileUtil.copy(new File(sourcePath), new File(sourcePath.replace(JAVA_HOME, destPath)));
        }
    }

    public static void main(String[] args) {
//        String verboseFilePath = "D:\\yc\\abcd";
//        CopyClassUtil.getClassFile(verboseFilePath);

        String cmdJar = "D:\\yc\\YCUtilTest\\out\\artifacts\\YCUtilTest_jar\\YCUtilTest.jar";
        String destPath = "d:\\yc\\test\\YCUtilTest";

        String verboseStr = CopyClassUtil.cmdJar(cmdJar);
        List<String> sourcePathList = dealVerboseStrs(verboseStr);
        copyFile(sourcePathList, destPath);
        System.out.println("+++++++++++++++++==============");
    }
}


