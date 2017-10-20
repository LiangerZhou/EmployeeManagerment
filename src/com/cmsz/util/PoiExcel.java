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

import com.cmsz.domain.Company;
import com.cmsz.domain.Employee;
import com.cmsz.domain.Task;
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
				r3c1.setCellValue("归属预算名称：" + elist.getTask().getBudget_name());//此处要加控制，如果未分配任务，则不考勤

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
							new File(path.replace("模板", elist.getEname())));
					workbook.write(out);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
						out.close();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void assessExcel(List<Task> list, String path,List<Company> cList) {
		
		HSSFWorkbook workbook;
		try {
			workbook = new HSSFWorkbook(new FileInputStream(path));
		
		
		HSSFSheet sheet = workbook.getSheet("Sheet1");//获取Sheet1工作表，一个excel称为工作簿，可包含多个工作表
		HSSFRow row1 = sheet.getRow((short) 0);
		HSSFCell r1c1 = row1.getCell((short) 0);
		//最好在company表加一个别名字段
		r1c1.setCellValue(cList.get(0).getCdesc()+"合作伙伴技术服务工作任务考核-" + "2017" + "年" + "6" + "月-内部汇总");//要改

		HSSFRow row2 = sheet.getRow((short) 1);
		HSSFCell r2c1 = row2.getCell((short) 0);
		r2c1.setCellValue("合同编号：" + cList.get(0).getContract_code());//此处要加控制，如果未分配任务，则不考勤
		
		HSSFCell r2c2 = row2.getCell((short) 1);
		r2c2.setCellValue("合同名称：" + cList.get(0).getContract_code());
		
		HSSFCell r2c3 = row2.getCell((short) 1);
		r2c3.setCellValue("归属科室/业务线："+ list.get(0).getQm_side());
		
		for (int i= 0; i<list.size(); i++) {
				HSSFRow row = sheet.getRow((short) i+3);//获取第i+4行
				HSSFCell cellr2 = row.getCell((short) 1);//获取第2列
				cellr2.setCellValue(list.get(i).getTask_name());
				HSSFCell cellr3 = row.getCell((short) 2);
				cellr3.setCellValue(list.get(i).getTask_creTime());
				HSSFCell cellr4 = row.getCell((short) 3);
				cellr4.setCellValue(list.get(i).getTask_endTime());
				HSSFCell cellr5 = row.getCell((short) 4);
				cellr5.setCellValue(list.get(i).getReal_endTime());
				HSSFCell cellr6 = row.getCell((short) 5);
				cellr6.setCellValue(list.get(i).getWorkdays());
				HSSFCell cellr7 = row.getCell((short) 6);
				cellr7.setCellValue(list.get(i).getWorkratio());
				HSSFCell cellr8 = row.getCell((short) 7);
				cellr8.setCellValue(list.get(i).getWork_efficiency());
				HSSFCell cellr9 = row.getCell((short) 8);
				cellr9.setCellValue(list.get(i).getWork_quality());
				HSSFCell cellr10 = row.getCell((short) 9);
				cellr10.setCellValue(list.get(i).getWork_norm());
				HSSFCell cellr11 = row.getCell((short) 10);
				cellr11.setCellValue(list.get(i).getWork_score());
				HSSFCell cellr12 = row.getCell((short) 11);
				cellr12.setCellValue(list.get(i).getConvert_score());
				HSSFCell cellr13 = row.getCell((short) 12);
				cellr13.setCellValue(list.get(i).getCharge_man());
				HSSFCell cellr14 = row.getCell((short) 13);
				cellr14.setCellValue(list.get(i).getRemark());
		}
				FileOutputStream out = null;
				try {
					out = new FileOutputStream(
							new File(path.replace("模板", cList.get(0).getCname())));
					workbook.write(out);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
						out.close();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
