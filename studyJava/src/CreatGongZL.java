import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

/**
 * @ClassName： CreatGongZL
 * 
 * @Author: dhSu
 * @Description: 宋永量5条工作量生成
 * @Date:Created in 2018年10月25日
 */

public class CreatGongZL {
	/**
	 * 设置单元格内容
	 * 
	 * @param int
	 *            rowNum
	 * @param int
	 *            colNum
	 * @return String
	 * @throws IOException
	 */
	public static boolean setCell(int rowNum, int colNum, String cont) throws Exception {
		boolean status = false;
		String fileName = "D:\\rest.xls";
		File file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("创建了rest.xls");
		}
		try {
			FileInputStream io = new FileInputStream(new File(fileName));
			HSSFWorkbook book = new HSSFWorkbook(io); // 读取的文件
			HSSFSheet sheet = book.getSheetAt(0);
			HSSFRow row = sheet.getRow(rowNum);
			Cell cell = row.createCell(colNum);
			cell.setCellValue(cont);
			FileOutputStream fo = new FileOutputStream(fileName); // 输出到文件
			book.write(fo);
			book.close();
			fo.close();
			io.close();
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
			return status;
		}
		return status;
	}
    //1个单元格5条，n列20行
	public static void creat5() throws Exception {
		// 1.从D:/rest.txt中读取接口名
		BufferedReader bufferedReader = null;
		StringBuffer stringBuffer = new StringBuffer();
		File file = new File("D:\\rest.txt");
		if (!file.exists())
			file.createNewFile();

		InputStreamReader inStream = new InputStreamReader(new FileInputStream(file), "GBK");// 防止读写的时候中文乱码
		try {
			bufferedReader = new BufferedReader(inStream);
			try {
				String read = null;
				// 读取一个接口名后，生成一个人的工作量
				int count = 0;
				int countRow = 0;//行
				int countCol = 0;//列
				
				while ((read = bufferedReader.readLine()) != null) {
					// 2.一个接口组5条
					stringBuffer.append((count % 4 + 1) + "." + read.trim() + "；\n");
					count += 1;
					if (count % 4 == 0) {
						// 组好的5条工作量写入rest.xlsx中的A1单元格
						boolean result = setCell(countRow, countCol, stringBuffer.toString());
						System.out.println(stringBuffer.toString());
						// 如果插入成功
						if (result) {
							stringBuffer.setLength(0);//清空上个人的工作量
							countRow += 1;// 开始生成第2个人的工作量
							if (countRow >= 20) {
								System.out.println((countCol+1)+"周20人的工作量插入rest.xls完成");
								countCol += 1;
								countRow = 0;
							}
							continue;
						} else {
							System.out.println("插入rest.xls时出错");
							break;
						}
					}else
						continue;
					
				}
				System.out.println("程序结束");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
	}
	
	//1条，n列20行
	public static void creat1() throws Exception {
		// 1.从D:/rest.txt中读取接口名
		BufferedReader bufferedReader = null;
		StringBuffer stringBuffer = new StringBuffer();
		File file = new File("D:\\rest.txt");
		if (!file.exists())
			file.createNewFile();

		InputStreamReader inStream = new InputStreamReader(new FileInputStream(file), "GBK");// 防止读写的时候中文乱码
		try {
			bufferedReader = new BufferedReader(inStream);
			try {
				String read = null;
				// 读取一个接口名后，生成一个人的工作量
				int countRow = 0;//行
				int countCol = 0;//列
				
				while ((read = bufferedReader.readLine()) != null) {
					// 2.一个接口组5条
					stringBuffer.append(read.trim() + "；\n");
						// 组好的5条工作量写入rest.xlsx中的A1单元格
						boolean result = setCell(countRow, countCol, stringBuffer.toString());
						System.out.println(stringBuffer.toString());
						// 如果插入成功
						if (result) {
							stringBuffer.setLength(0);//清空上个人的工作量
							countRow += 1;// 开始生成第2个人的工作量
							if (countRow >= 20) {
								System.out.println((countCol+1)+"周20人的工作量插入rest.xls完成");
								countCol += 1;
								countRow = 0;
							}
							continue;
						} else {
							System.out.println("插入rest.xls时出错");
							break;
						}
				}
				System.out.println("程序结束");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		creat1();
	}
}
