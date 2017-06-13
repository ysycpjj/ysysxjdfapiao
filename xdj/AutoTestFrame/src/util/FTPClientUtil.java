package util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;

/**
 * Created by QQ on 6/2/2016.
 */
public class FTPClientUtil {
    private FTPClient ftpClient = null;
    private String server;
    private int port;
    private String userName;
    private String userPassword;

    public FTPClientUtil(String server, int port, String userName,
                         String userPassword) {
        this.server = server;
        this.port = port;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    /**
     * 链接到服务器
     * @return
     * @throws Exception
     */
    public boolean open() {
        if (ftpClient != null && ftpClient.isConnected()) {
            return true;
        }
        try {
            ftpClient = new FTPClient();
            ftpClient.connect(this.server, this.port);
            ftpClient.login(this.userName, this.userPassword);
            // 检测连接是否成功
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                this.close();
                System.err.println("FTP server refused connection.");
                return false;
            }
            System.out.println("open FTP success:" + this.server+";port:"+this.port + ";name:"
                    + this.userName + ";pwd:" + this.userPassword);
            ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE); // 设置上传模式.binally
            return true;
        } catch (Exception ex) {
            this.close();
            ex.printStackTrace();
            return false;
        }

    }

    private boolean cd(String dir) throws IOException {
        if (ftpClient.changeWorkingDirectory(dir)) {
            return true;
        } else {
            return false;
        }
    }


    public boolean existFile(String filePath)throws IOException{
        FTPFile[] list = ftpClient.listFiles(filePath.replace("\\","/"));
        if(list != null && list.length > 0){
            return true;
        }
        return false;
    }


    public long getFileSize(String filePath)throws IOException{
        long size = 0;
        FTPFile[] list = ftpClient.listFiles(filePath.replace("\\", "/"));
        for(int i = 0;i < list.length; i ++){
            size += list[i].getSize();
        }
        return size;
    }




    /**
     * 关闭链接
     */
    public void close() {
        try {
            if (ftpClient != null && ftpClient.isConnected())
                ftpClient.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Close Server Success :"+this.server+";port:"+this.port);
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {

        this.ftpClient = ftpClient;
    }

}
