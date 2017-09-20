package com.cmsz.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.cmsz.domain.Employee;
/*
 * 考虑做成工厂类，负责生产各种excel
 * 
 */
public class PoiExcel {

	/*
	 * 考勤表导出
	 * 1、传入所有的工作日（字符串，逗号分隔）
	 * 2、传入所有的被选员工对象
	 * 3、传入模板的真实路径
	 */
	@SuppressWarnings("resource")
	public void attendExcel(String[] workArray, List<Employee> list, String path) {
		String year = workArray[workArray.length - 1].split("/")[0];
		String month = workArray[workArray.length - 1].split("/")[1];
		for (Employee elist : list) {
			try {
				HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(path));
				HSSFSheet sheet = workbook.getSheet("Sheet1");//获取Sheet1工作表，一个excel称为工作簿，可包含多个工作表

				HSSFRow row2 = sheet.getRow((short) 1);
				HSSFCell r2c2 = row2.getCell((short) 1);
				r2c2.setCellValue("注：" + year + "年" + month + "月周期为：" + workArray[0].replace("/", "-") + "至"
						+ workArray[workArray.length - 1].replace("/", "-") + "（共计" + workArray.length + "天工作日）");

				HSSFRow row3 = sheet.getRow((short) 2);
				HSSFCell r3c1 = row3.getCell((short) 0);
				r3c1.setCellValue("归属预算名称：" + elist.getProject().getContract_name());

				for (int i = 4; i < workArray.length + 4; i++) {
					HSSFRow row = sheet.getRow((short) i);//获取第i+1行
					HSSFCell cellr1 = row.getCell((short) 0);//获取第1列
					cellr1.setCellValue(workArray[i - 4]);
					HSSFCell cellr2 = row.getCell((short) 1);
					cellr2.setCellValue(elist.getEname());
					HSSFCell cellr3 = row.getCell((short) 2);
					cellr3.setCellValue(elist.getCompany().getCname());
					System.out.println(cellr1.getStringCellValue());
				}

				FileOutputStream out = null;
				try {
					out = new FileOutputStream(
							new File("D:\\项目\\外援管理系统\\6月测评线外援计提材料\\新合同外援考勤表-" + elist.getEname() + ".xls"));
					workbook.write(out);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
