package util;

import jcifs.smb.SmbFile;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Created by QQ on 5/16/2016.
 */
public class IOUtils {
    private static String videoTypes = "mp4,mpeg";
    public static boolean deleteAll(String path) {
        File file = new File(path);
        if(file.exists()){
            return deleteDir(file);
        }
        return true;
    }

    public static void deleteAllFiles(String path){
        if(StringUtils.isBlank(path)){
            return;
        }
        boolean flag = false;
        while (!flag) {
            flag = deleteAll(path);
        }
    }


    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     *                 If a deletion fails, the method stops attempting to
     *                 delete and returns "false".
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    public static boolean createDir(String path){
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        return true;
    }

    /**
     * 压缩文件-由于out要在递归调用外,所以封装一个方法用来
     * 调用ZipFiles(ZipOutputStream out,String path,File... srcFiles)
     * @param zip
     * @param path
     * @param srcFiles
     * @throws IOException
     */
    public static void ZipFiles(File zip,String path,File... srcFiles) throws IOException {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zip));
        ZipFiles(out, path, srcFiles);
        out.close();
        System.out.println("*****************zip end*******************");
    }

    /**
     * 压缩文件
     * @param out
     * @param path
     * @param srcFiles
     */
    public static void ZipFiles(ZipOutputStream out,String path,File... srcFiles){
        path = path.replaceAll("\\\\", "/");
        if(!path.endsWith("/")){
            path+="/";
        }
        byte[] buf = new byte[1024];
        try {
            for(int i=0;i<srcFiles.length;i++){
                if(srcFiles[i].isDirectory()){
                    File[] files = srcFiles[i].listFiles();
                    String srcPath = srcFiles[i].getName();
                    srcPath = srcPath.replaceAll("\\\\", "/");
                    if(!srcPath.endsWith("/")){
                        srcPath+="/";
                    }
                    out.putNextEntry(new ZipEntry(path+srcPath));
                    ZipFiles(out,path+srcPath,files);
                }
                else{
                    FileInputStream in = new FileInputStream(srcFiles[i]);
                    System.out.println(path + srcFiles[i].getName());
                    out.putNextEntry(new ZipEntry(path + srcFiles[i].getName()));
                    int len;
                    while((len=in.read(buf))>0){
                        out.write(buf,0,len);
                    }
                    out.closeEntry();
                    in.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解压到指定目录
     * @param zipPath
     * @param descDir
     */
    public static void unZipFiles(String zipPath,String descDir)throws IOException{
        unZipFiles(new File(zipPath), descDir);
    }

    /**
     * 解压文件到指定目录
     * @param zipFile
     * @param descDir
     */
    @SuppressWarnings("rawtypes")
    public static void unZipFiles(File zipFile,String descDir)throws IOException{
        System.out.println("******************unZip start********************");
        File pathFile = new File(descDir);
        if(!descDir.endsWith("\\")){
            descDir+="\\";
        }
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }
        ZipFile zip = new ZipFile(zipFile);
        for(Enumeration entries = zip.entries();entries.hasMoreElements();){
            ZipEntry entry = (ZipEntry)entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
            String outPath = (descDir+zipEntryName).replaceAll("\\\\", "/");
            //判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
            if(!file.exists()){
                file.mkdirs();
            }
            //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            if(new File(outPath).isDirectory()){
                continue;
            }
            //输出文件路径信息
            System.out.println(outPath);

            OutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while((len=in.read(buf1))>0){
                out.write(buf1,0,len);
            }
            in.close();
            out.close();
        }
        zip.close();
        System.out.println("******************unzip end********************");
    }

    //Get all files in dir and sub dirs
    public static List<File> getAllFiles(String path){
        List<File> files = new ArrayList<File>();
        File file = new File(path);
        File[] subFile = file.listFiles();
        for (int i = 0; i < subFile.length; i++) {
            if (subFile[i].isDirectory()) {
                files.addAll(getAllFiles(subFile[i].getAbsolutePath()));
            }else{
                files.add(subFile[i]);
            }
        }
        return files;
    }

    public static boolean isImage(File file){
        try {
            Image image = ImageIO.read(file);
            if (image == null) {
                return false;
            }else{
                return true;
            }
        } catch(IOException ex) {
            return false;
        }
    }


    public static  String getCreateTime(String filePath){
        String startTime = null;
        try {
            Process p = Runtime.getRuntime().exec("cmd /C dir "
                    + filePath
                    + "/tc");
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line = br.readLine()) != null){
                if(line.endsWith(".zip")){
                    startTime = line.substring(0,20);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("get createdTime failed !");
//            e.printStackTrace();
        }
        return startTime;
    }

    public static boolean  isExist(String fileExtension,String dir){
        List<File> children = getAllFiles(dir);
        for (int i=0; i<children.size(); i++) {
            System.out.println(i+" file type is "+children.get(i).getName());
            if(children.get(i).getName().contains(fileExtension))
                return true;
        }
        return false;

    }


    public static boolean isVideo(String type){
        String[] types = videoTypes.split(",");
        for(String t : types){
            if(t.equals(type)){
                return true;
            }
        }
        return false;
    }

    /**
     * 复制单个文件
     *
     * @param srcFileName
     *            待复制的文件名
     * @param destFileName
     *            目标文件名
     * @param overlay
     *            如果目标文件存在，是否覆盖
     * @return 如果复制成功返回true，否则返回false
     */
    public static boolean copyFile(String srcFileName, String destFileName,
                                   boolean overlay) {
        String msg = "";
        File srcFile = new File(srcFileName);
        if (!srcFile.exists()) {
            msg = "源文件：" + srcFileName + "不存在！";
            return false;
        } else if (!srcFile.isFile()) {
            msg = "复制文件失败，源文件：" + srcFileName + "不是一个文件！";
            return false;
        }

        File destFile = new File(destFileName);
        if (destFile.exists()) {
            if (overlay) {
                new File(destFileName).delete();
            }
        } else {
            if (!destFile.getParentFile().exists()) {
                if (!destFile.getParentFile().mkdirs()) {
                    return false;
                }
            }
        }

        int byteread = 0; // 读取的字节数
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(srcFile);
            out = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];

            while ((byteread = in.read(buffer)) != -1) {
                out.write(buffer, 0, byteread);
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        } finally {
            try {
                if (out != null)
                    out.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isExistFileOnFTP(String url,int port,String userName,String password,String fileName){
        FTPClientUtil client = new FTPClientUtil(url,21,userName,password);
        try{
            boolean flag = false;
            if(client.open()){
                flag = client.existFile(fileName);
                System.out.println(fileName);
            }
            client.close();
            return flag;
        }catch (Exception e){
            return false;
        }finally {
            client.close();
        }
    }

    private static long getFileSizeOnFTP(String url,int port,String userName,String password,String fileName){
        FTPClientUtil client = new FTPClientUtil(url,21,userName,password);
        try{
            long size = 0;
            if(client.open()){
                size = client.getFileSize(fileName);
                System.out.println(fileName);
            }
            client.close();
            return size;
        }catch (Exception e){
            return 0;
        }finally {
            client.close();
        }
    }


    private static boolean isExistSharedFile(String url,int port,String userName,String password,String fileName){
        try{
            url = "smb://"+userName+":"+
                    password+"@"+
                    (url.replace("\\\\", "").replace("\\","/")+"/"+
                            fileName+(fileName.contains(".") ? "" : "/")).replace("//","/");
            System.out.println("share dir: "+url);
            //url = "smb://Administrator:Innover123@192.168.200.13/scheduleexportshared/3VR_ScheduleExport_1464683734456/";
            SmbFile remoteFile = new SmbFile(url);
            remoteFile.connect();
            return remoteFile.exists();
        }catch (Exception e){
            return false;
        }
    }

    private static long getSharedFileSize(String url,int port,String userName,String password,String fileName){
        try{
            url = "smb://"+userName+":"+
                    password+"@"+
                    (url.replace("\\\\", "").replace("\\","/")+"/"+
                            fileName+(fileName.contains(".") ? "" : "/")).replace("//","/");
            System.out.println("share dir: "+url);
            //url = "smb://Administrator:Innover123@192.168.200.13/scheduleexportshared/3VR_ScheduleExport_1464683734456/";
            SmbFile remoteFile = new SmbFile(url);
            remoteFile.connect();
            long size = 0;
            if(remoteFile.isDirectory()){
                SmbFile[] files = remoteFile.listFiles();
                for(SmbFile file : files){
                    size += file.length();
                }
                return size;
            }else{
                return remoteFile.length();
            }
        }catch (Exception e){
            return 0;
        }
    }

    public static boolean existScheduleExportFile(String url,int port,String userName,String password,String fileName){
        if(url.substring(0,4).contains("ftp")){
            return isExistFileOnFTP(url.split("//")[1], port, userName, password, fileName);
        }else{
            return isExistSharedFile(url, port, userName, password, fileName);
        }
    }

    public static long getScheduleExportFileSize(String url,int port,String userName,String password,String fileName){
        if(url.substring(0,4).contains("ftp")){
            return getFileSizeOnFTP(url.split("//")[1], port, userName, password, fileName);
        }else{
            return getSharedFileSize(url, port, userName, password, fileName);
        }
    }



}
