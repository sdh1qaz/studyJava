package 输入输出.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * @ClassName： FileOperation
 * @Author: dhSu
 * @Description:文件操作类
 * @Date:Created in 2018年2月25日
 */
public class FileOperation {

	/**  
	* @Description: TODO(创建文件)  
	* @param  File
	* @return 
	* @throws  
	*/ 
	public static boolean createFile(File fileName) throws Exception {
		boolean flag = false;
		try {
			if (!fileName.exists()) {
				fileName.createNewFile();
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * ÿ��һ�м�һ������
	 * 
	 * @param rFileName
	 * @return
	 * @throws Exception
	 */
	public static void addBlankLine(String rFileName) throws Exception {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		StringBuffer stringBuffer = new StringBuffer();
		try {
			fileReader = new FileReader(rFileName);
			bufferedReader = new BufferedReader(fileReader);
			try {
				String read = null;
				while ((read = bufferedReader.readLine()) != null) {
					/********* �޸Ĳ��� ***********/
					stringBuffer.append(read + "\n\n");
					/********* �޸Ĳ��� ***********/
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
			if (fileReader != null) {
				fileReader.close();
			}
		}
		System.out.println("��ȡ�������ļ������ǣ�" + "\r\n" + stringBuffer);
		// addContentToTxt(wFileName, stringBuffer.toString().substring(0,
		// stringBuffer.toString().length()-2));
		writeTxtFile(stringBuffer.toString(), new File(rFileName));
		System.out.println("д�����");
	}

	/**
	 * 逐行从rFilename中读，做更改后写入wFileName中,一组字符串加上引号
	 * 
	 * @param rFileName
	 * @param wFileName
	 * @return
	 * @throws Exception
	 */
	public static void rwsByLine(String rFileName, String wFileName) throws Exception {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		StringBuffer stringBuffer = new StringBuffer();
		File file = new File(rFileName);
		InputStreamReader inStream = new InputStreamReader(new FileInputStream(file), "GBK");//防止读写的时候中文乱码
		try {
			fileReader = new FileReader(rFileName);
			bufferedReader = new BufferedReader(inStream);
			try {
				String read = null;
				while ((read = bufferedReader.readLine()) != null) {
					/* 对每一行做更改 */
					stringBuffer.append("\"" + read.trim() + "\",\n");
					/* 对每一行做更改 */
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
			if (fileReader != null) {
				fileReader.close();
			}
		}
		System.out.println("更改后" + "\r\n" + stringBuffer);
		// addContentToTxt(wFileName, stringBuffer.toString().substring(0,
		// stringBuffer.toString().length()-2));
		writeTxtFile(stringBuffer.toString().substring(0, stringBuffer.toString().length() - 2), new File(wFileName));
		System.out.println("写入" + wFileName + " 完毕！！！！！！！！");
	}

	public static void main(String[] args) throws Exception {
		String rFileName = "D:\\read000.txt";
		String wFileName = "D:\\write000.txt";
		rwsByLine(rFileName, wFileName);

		// addBlankLine(rFileName);
	}

	/**
	 * ��TXT�ļ�����
	 * 
	 * @param fileName
	 * @return
	 */
	public static String readTxtFile(File fileName) throws Exception {
		String result = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			try {
				String read = null;
				while ((read = bufferedReader.readLine()) != null) {
					result = result + read + "\r\n";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
			if (fileReader != null) {
				fileReader.close();
			}
		}
		System.out.println("��ȡ�������ļ������ǣ�" + "\r\n" + result);
		return result;
	}

	/**
	 * д���ݵ�txt�У����ǵ�ԭ�ļ�����
	 * 
	 * @param fileName
	 * @param content
	 * @return
	 */
	public static boolean writeTxtFile(String content, File fileName) throws Exception {
		boolean flag = false;
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(fileName);
			out.write(content.getBytes("GBK"));
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return flag;
	}

	// �ļ��������
	public static void addContentToTxt(String filePath, String content) {
		String str = new String(); // ԭ��txt����
		String s1 = new String();// ���ݸ���
		try {
			File f = new File(filePath);
			if (f.exists()) {
				System.out.print(filePath + " �ļ�����!!!!");
			} else {
				System.out.print("�ļ�������");
				f.createNewFile();// �������򴴽�
			}
			BufferedReader input = new BufferedReader(new FileReader(f));

			while ((str = input.readLine()) != null) {
				s1 += str + "\n";
			}
			System.out.println(s1);
			input.close();
			s1 += content;

			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}