package function;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

public class CaptchaAnalysis {

	public static void download(String urlString, String filename)
			throws Exception {
		// 构造URL
		URL url = new URL(urlString);
		// 打开连接
		URLConnection con = url.openConnection();
		// 输入流
		InputStream is = con.getInputStream();
		// 1K的数据缓冲
		byte[] bs = new byte[1024];
		// 读取到的数据长度
		int len;
		// 输出的文件流
		OutputStream os = new FileOutputStream(filename);
		// 开始读取
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		// 完毕，关闭所有链接
		os.close();
		is.close();
	}

	public static void download(String urlString) throws Exception {
		// 构造URL
		URL url = new URL(urlString);
		// 打开连接
		URLConnection con = url.openConnection();
		// 输入流
		InputStream is = con.getInputStream();
		// 1K的数据缓冲
		byte[] bs = new byte[1024];
		// 读取到的数据长度
		int len;
		// 输出的文件流
		OutputStream os = new FileOutputStream("d:\\captcha.jpg");
		// 开始读取
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		// 完毕，关闭所有链接
		os.close();
		is.close();
	}

	public static void codeScreenShot() throws MalformedURLException,
			IOException, URISyntaxException, AWTException {
		Robot robot = new Robot();
		robot.delay(800);
		Image image = robot.createScreenCapture(new Rectangle(996, 452, 100, 40));
		BufferedImage bi = new BufferedImage(120, 54, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		g.drawImage(image, 0, 0, 120, 54, null);
		// 保存图片
		ImageIO.write(bi, "jpg", new File("d:\\captcha.jpg"));
	}

	public static void codeScreenShotAgain() throws MalformedURLException,
			IOException, URISyntaxException, AWTException {
		Robot robot = new Robot();
		robot.delay(800);
		Image image = robot
				.createScreenCapture(new Rectangle(996, 499, 100, 40));
		BufferedImage bi = new BufferedImage(120, 54, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		g.drawImage(image, 0, 0, 120, 54, null);
		// 保存图片
		ImageIO.write(bi, "jpg", new File("d:\\captcha.jpg"));
	}

	public void runbat(String batName) {
		try {
			// 执行命令
			Process ps = Runtime.getRuntime().exec(batName);
			// 取得命令结果的输出流
			InputStream in = ps.getInputStream();
			// 用一个读输出流类去读
			InputStreamReader isr = new InputStreamReader(in);
			// 用缓冲器读行
			BufferedReader br = new BufferedReader(isr);
			@SuppressWarnings("unused")
			String line = null;
			// 直到读完为止
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
			}
			in.close();
			ps.waitFor();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// System.out.println("child thread done");
	}

	public static void creatCode() {
		CaptchaAnalysis ca = new CaptchaAnalysis();
		String batName = "D:\\StartTesseract-ocr.bat";
		ca.runbat(batName);
	}

	public static void delCode() {
		CaptchaAnalysis ca = new CaptchaAnalysis();
		String batName = "D:\\DelFile.bat";
		ca.runbat(batName);
	}

	public static String readTxtFile(String filePath) {
		String encoding = "UTF-8";
		File file = new File(filePath);
		String lineTxt = "";
		StringBuilder sb = new StringBuilder();
		try {
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				while ((lineTxt = bufferedReader.readLine()) != null) {
					sb.append(lineTxt + "\n");
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		String str = sb.toString().trim().replaceAll(" ", "");
//		System.out.println(str);
		return str;
	}

	public static void loginPageCodeScreenShot() throws MalformedURLException,
			IOException, URISyntaxException, AWTException {
		Robot robot = new Robot();
		robot.delay(800);
		Image image = robot.createScreenCapture(new Rectangle(901, 492, 70, 37));
		BufferedImage bi = new BufferedImage(70, 37, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		g.drawImage(image, 0, 0, 70, 37, null);
		// 保存图片
		ImageIO.write(bi, "jpg", new File("d:\\captcha.jpg"));
	}

//	public static void main(String[] args) throws Exception {
//		download("http://www.colipu.com/account/getvryimggen?8680");
//		creatCode();
//		CaptchaAnalysis.readTxtFile("d:\\code.txt");
//		delCode();
//	}
}
