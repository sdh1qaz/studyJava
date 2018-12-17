package com.dhsu.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @ClassName： CanBuExport
 * @Author: dhSu
 * @Description: TPS餐补统计导出为报销专用格式
 * @Date:Created in 2018年12月17日
 */

public class CanBuExport {
	//原始餐补文件地址
	private static final String sDir = "E:\\canbu\\TPS，质检 8，9,10,11月份加班餐补明细.xlsx";
	//生成的标准餐补文件存放目录
	private static final String dDir = "E:\\canbu\\";
	//存储参与人姓名和参与域账号的映射
	private static final Map<String, String> hmap = new HashedMap<String,String>();
	
	//静态块，加载类的时候执行
	static {
		hmap.put("王建宇", "jywang15");
		hmap.put("节少威", "swjie");
		hmap.put("段福燕", "fyduan");
		hmap.put("陈宏斌", "hbchen7");
		hmap.put("何海东", "hdhe");
		hmap.put("曹英豪", "yhcao2");
		hmap.put("杨生", "shengyang3");
		hmap.put("刘建伟", "jwliu7");
		hmap.put("侯君艳", "jyhou2");
		hmap.put("刘帅鹏", "spliu4");
		hmap.put("归彬", "bingui");
		hmap.put("苏登辉", "dhsu2");
		hmap.put("王粉", "fenwang3");
		hmap.put("荆自宽", "zkjing");
		hmap.put("李海峰", "hfli");
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//导出8月的
		export(sDir,dDir,4,21,5,21);
		//导出9月的
		export(sDir,dDir,4,21,23,39);
		//导出10月的
		export(sDir,dDir,4,18,41,51);
		//导出11月的
		export(sDir,dDir,4,21,52,62);
	}
	
	/**
	* @Description:将原始餐补统计文件导出为标准的可导入到餐补系统中的文件
	* @param fDir 原始餐补统计文件
	* @param dDir 生成的标准餐补文件存放目录
	* @param c_begin 列开始
	* @param c_end   列结束
	* @param r_begin 行开始
	* @param r_end   行结束
	* @throws FileNotFoundException
	* @throws IOException 
	* @return void 
	 */
	public static void export(String sDir,String dDir,int c_begin,int c_end,int r_begin,int r_end) 
			throws FileNotFoundException, IOException {
		File file = new File(sDir);
		//读取加班餐补统计文件
		XSSFWorkbook  book = new XSSFWorkbook(new FileInputStream(file));
		//选择第1个sheet
		XSSFSheet sheet = book.getSheetAt(0);
		//输出8月份的
		XSSFWorkbook tbk;
		XSSFSheet sht;
		for(int c=c_begin;c<c_end;c++) {//列
			//一列生成一个book
			tbk = new XSSFWorkbook();
			//book的名字
			String nm = "未命名";
			sht = tbk.createSheet();
			XSSFRow row = sht.createRow(0);
			row.createCell(0).setCellValue("参与人姓名");
			row.createCell(1).setCellValue("参与人域账号");
			int nowR = 1;
			for(int r=r_begin;r<r_end;r++) {//行
				XSSFRow row_ = sheet.getRow(r);
				XSSFCell cell = row_.getCell(c);
				//读取单元格的值
				String cont = cell.toString();
				if(r == r_begin) {
					nm = cont; 
				}else if (!("".equals(cont) || cont == null)) {
					row = sht.createRow(nowR);
					//获取参与人姓名
					String s = row_.getCell(2).toString();
					//获取参与人域账号
					String y = hmap.get(s);
					//向输出表中写参与人姓名
					row.createCell(0).setCellValue(s);
					//向输出表中写参与人域账号
					row.createCell(1).setCellValue(y);
					nowR += 1;
				}else {
					continue;
				}
			}
			File file2 = new File(dDir + nm + ".xlsx");
			if (file2.exists()) {
				file2.delete();
				file2.createNewFile();
			}
			FileOutputStream fo = new FileOutputStream(file2);
			tbk.write(fo);
			tbk.close();
			fo.close();
			System.out.println("成功导出" + nm + ".xlsx");
		}
	}
}
