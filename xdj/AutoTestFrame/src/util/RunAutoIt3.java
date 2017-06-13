package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by QQ on 5/3/2016.
 */
public class RunAutoIt3 {
    /**
     * RunAutoIt3.runAu3("RunMATAutomation.exe","C:/Users/QQ/Desktop/MAT Automation_5Languages_7.2.5/english",7);
     * @param filename
     *            au3的文件名，必须编译成exe
     * @param filepath
     *            au3的文件的路径
     * @param timeout
     *            超时时间（秒）
     * @param args
     *            au3的参数
     */
    public static void runAu3(String filename, String filepath, int timeout,
                              String... args) {
        try {
            // 如果发现进程，先杀了
            if (findProcess(filename)) {
                killProcess(filename);
            }
            // 拼装命令
            String cmd = filename;
            for (String arg : args) {
                cmd += " " + arg;
            }

            // 执行au3脚本
            Process process =Runtime.getRuntime()
                    .exec("cmd /C " + cmd, null, new File(filepath));
            process.waitFor();
            int count = 0;
            while (findProcess(filename) && count < timeout) {
                System.out.println(count);
                Thread.sleep(1000 * 60);
                count++;
            }
            // 如果进程未结束，杀了
            if (findProcess(filename)) {
                killProcess(filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 查找进程
     * @param processname
     * @return
     */
    public static boolean findProcess(String processname) {
        BufferedReader bufferedreader = null;
        try {
            Process proc = Runtime.getRuntime().exec(
                    "tasklist /fi \" imagename eq " + processname + " \" ");
            bufferedreader = new BufferedReader(new InputStreamReader(proc
                    .getInputStream()));
            String line = null;
            while ((line = bufferedreader.readLine()) != null) {
                if (line.contains(processname)) {
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (bufferedreader != null) {
                try {
                    bufferedreader.close();
                } catch (Exception ex) {
                }
            }
        }
    }

    /**
     * 杀进程
     * @param processname
     */
    public static void killProcess(String processname) {
        BufferedReader bufferedreader = null;
        try {
            Process proc = Runtime.getRuntime().exec(
                    "taskkill /F /IM " + processname);
            bufferedreader = new BufferedReader(new InputStreamReader(proc
                    .getInputStream()));
            String line = null;
            while ((line = bufferedreader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (bufferedreader != null) {
                try {
                    bufferedreader.close();
                } catch (Exception ex) {
                }
            }
        }
    }
}
