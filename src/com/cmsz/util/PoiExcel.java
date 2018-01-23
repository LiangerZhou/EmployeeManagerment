package com.cmsz.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cmsz.dao.EmployeeDao;
import com.cmsz.dao.Impl.EmployeeDaoImpl;
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
	public void attendExcel(String startday, String endday, String[] workArray, List<Employee> list, String path) {
		String[] yms = endday.split("-");
		XSSFWorkbook workbook;
			try {
				workbook = new XSSFWorkbook(new FileInputStream(path));
		for (int j = 0; j<list.size();j++) {
			
				XSSFSheet sheet = workbook.getSheet("Sheet"+(j+1));//获取Sheet工作表，一个excel称为工作簿，可包含多个工作表
				XSSFRow row2 = sheet.getRow((short) 1);
				XSSFCell r2c2 = row2.getCell((short) 1);
				r2c2.setCellValue("注：" + yms[0] + "年" + yms[1] + "月周期为：" + startday + "至"
						+ endday + "（共计" + workArray.length + "天工作日）");

				XSSFRow row3 = sheet.getRow((short) 2);
				XSSFCell r3c1 = row3.getCell((short) 0);
				r3c1.setCellValue("归属预算名称：" + list.get(j).getTask().getBudget_name());//此处要加控制，如果未分配任务，则不考勤

				for (int i = 4; i < workArray.length + 4; i++) {
					XSSFRow row = sheet.getRow((short) i);//获取第i+1行
					XSSFCell cellr1 = row.getCell((short) 0);//获取第1列
					cellr1.setCellValue(workArray[i - 4]);
					XSSFCell cellr2 = row.getCell((short) 1);
					cellr2.setCellValue(list.get(j).getEname());
					XSSFCell cellr3 = row.getCell((short) 2);
					cellr3.setCellValue(list.get(j).getCompany().getCname());
				}
		}
		FileOutputStream out = null;
		out = new FileOutputStream(new File(path.replace("模板", yms[0] + "年" + yms[1] + "月"+"-共计" + workArray.length + "天")));
		workbook.write(out);
		out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 按公司考核表导出
	 * 1、工作任务list
	 * 2、传入公司名
	 * 3、传入模板的真实路径
	 */
	public void assessExcel(List<Task> list, String path,List<Company> cList) {
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(new FileInputStream(path));
			XSSFSheet sheet = workbook.getSheet("Sheet1");//获取Sheet1工作表，一个excel称为工作簿，可包含多个工作表
			XSSFRow row1 = sheet.getRow((short) 0);
			XSSFCell r1c1 = row1.getCell((short) 0);
			int year = Calendar.getInstance().get(Calendar.YEAR);
			int month = 1 + Calendar.getInstance().get(Calendar.MONTH);
			r1c1.setCellValue(cList.get(0).getCdesc()+"合作伙伴技术服务工作任务考核-" + year + "年" + month + "月-内部汇总");//要改
			XSSFRow row2 = sheet.getRow((short) 1);
			XSSFCell r2c1 = row2.getCell((short) 0);
			r2c1.setCellValue("合同编号：" + cList.get(0).getContract_code());//此处要加控制，如果未分配任务，则不考勤
			XSSFCell r2c2 = row2.getCell((short) 2);
			r2c2.setCellValue("合同名称：" + cList.get(0).getContract_name());
			XSSFCell r2c3 = row2.getCell((short) 11);
			r2c3.setCellValue("归属科室/业务线："+ list.get(0).getQm_side());
			for (int i= 0; i<list.size(); i++) {
				XSSFRow row = sheet.getRow((short) i+3);//获取第i+4行
				XSSFCell cellr1 = row.getCell((short)i);
				cellr1.setCellValue(i+1);
				XSSFCell cellr2 = row.getCell((short) 1);//获取第2列
				cellr2.setCellValue(list.get(i).getTask_name());
				XSSFCell cellr3 = row.getCell((short) 2);
				cellr3.setCellValue(list.get(i).getTask_creTime());
				XSSFCell cellr4 = row.getCell((short) 3);
				cellr4.setCellValue(list.get(i).getTask_endTime());
				XSSFCell cellr5 = row.getCell((short) 4);
				cellr5.setCellValue(list.get(i).getReal_endTime());
				XSSFCell cellr6 = row.getCell((short) 5);
				int te_num = list.get(i).getEmps().size();//计算当前人物对应的人数
				cellr6.setCellValue(list.get(i).getWorkdays()/te_num);//结果为整数
				XSSFCell cellr7 = row.getCell((short) 6);
				cellr7.setCellFormula("F"+(i+4)+"/SUM(F4:F"+(list.size()+4)+")");
				XSSFCell cellr8 = row.getCell((short) 7);
				cellr8.setCellValue(list.get(i).getWork_efficiency());
				XSSFCell cellr9 = row.getCell((short) 8);
				cellr9.setCellValue(list.get(i).getWork_quality());
				XSSFCell cellr10 = row.getCell((short) 9);
				cellr10.setCellValue(list.get(i).getWork_norm());
				XSSFCell cellr11 = row.getCell((short) 10);
				cellr11.setCellValue(list.get(i).getWork_score());
				XSSFCell cellr12 = row.getCell((short) 11);
				cellr12.setCellFormula("G"+(i+4)+"*K"+(i+4)+"");
				XSSFCell cellr13 = row.getCell((short) 12);
				cellr13.setCellValue(list.get(i).getCharge_man());
				XSSFCell cellr14 = row.getCell((short) 13);
				cellr14.setCellValue(list.get(i).getRemark());
			}
				XSSFRow rowSum = sheet.getRow((short) list.size() + 6);
				XSSFCell rSumc11 = rowSum.getCell((short) 10);
				rSumc11.setCellValue("总计");
				XSSFCellStyle style = workbook.createCellStyle();
				style.setAlignment(HorizontalAlignment.CENTER);;//水平居中
				style.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
				XSSFDataFormat df = workbook.createDataFormat();  //此处设置数据格式
				style.setDataFormat(df.getFormat("#,#0.00"));
				XSSFFont font = workbook.createFont();
		        font.setColor(Font.COLOR_RED);//字体颜色
		        font.setFontName("宋体");
		        font.setBold(true);
		        font.setFontHeightInPoints((short)10);//设置字体大小
				style.setFont(font);
				XSSFCell rSumc12 = rowSum.getCell((short) 11);
				rSumc12.setCellFormula("SUM(L4:L"+(list.size()+4)+")");
				rSumc12.setCellStyle(style);
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
	/*
	 * 考核汇总表导出
	 * 1、工作任务list
	 * 2、传入模板的真实路径
	 */
	public void assessAllExcel(List<Task> list, String path) {
		XSSFWorkbook workbook;
			try {
				workbook = new XSSFWorkbook(new FileInputStream(path));
				XSSFSheet sheet = workbook.getSheet("任务考核表");//获取Sheet1工作表，一个excel称为工作簿，可包含多个工作表
				XSSFRow row1 = sheet.getRow((short) 0);
				XSSFCell r1c1 = row1.getCell((short) 0);
				int year = Calendar.getInstance().get(Calendar.YEAR);
				int month = 1 + Calendar.getInstance().get(Calendar.MONTH);
				r1c1.setCellValue("合作伙伴技术服务工作任务考核-"+year+"年"+month+"月-内部汇总");
				for(int i = 0; i<list.size(); i++) {
					XSSFRow row = sheet.getRow((short) i+2);//获取第i+3行
					XSSFCell cellr2 = row.getCell((short) 1);//获取第2列
					cellr2.setCellValue(list.get(i).getBudget_name());
					XSSFCell cellr3 = row.getCell((short) 2);
					cellr3.setCellValue(list.get(i).getTask_name());
					XSSFCell cellr4 = row.getCell((short) 3);
					cellr4.setCellValue(list.get(i).getTask_creTime());
					XSSFCell cellr5 = row.getCell((short) 4);
					cellr5.setCellValue(list.get(i).getTask_endTime());
					XSSFCell cellr6 = row.getCell((short) 5);
					cellr6.setCellValue(list.get(i).getReal_endTime());
					XSSFCell cellr7 = row.getCell((short) 6);
					cellr7.setCellValue(list.get(i).getWorkdays());
					XSSFCell cellr8 = row.getCell((short) 7);
					cellr8.setCellFormula("G"+(i+3)+"/SUM(G3:G"+(list.size()+2)+")");
					XSSFCell cellr9 = row.getCell((short) 8);
					cellr9.setCellValue(list.get(i).getWork_efficiency());
					XSSFCell cellr10 = row.getCell((short) 9);
					cellr10.setCellValue(list.get(i).getWork_quality());
					XSSFCell cellr11 = row.getCell((short) 10);
					cellr11.setCellValue(list.get(i).getWork_norm());
					XSSFCell cellr12 = row.getCell((short) 11);
					cellr12.setCellValue(list.get(i).getWork_score());
					XSSFCell cellr13 = row.getCell((short) 12);
					cellr13.setCellFormula("H"+(i+3)+"*L"+(i+3)+"");
					XSSFCell cellr14 = row.getCell((short) 13);
					cellr14.setCellValue(list.get(i).getCharge_man());
					XSSFCell cellr15 = row.getCell((short) 14);
					cellr15.setCellValue(list.get(i).getRemark());
					XSSFCell cellr16 = row.getCell((short) 15);
//					cellr16.setCellValue(list.get(i).getEmps().iterator().next().getCompany().getCname());此处要修改一下，填充公司名
					XSSFCell cellr17 = row.getCell((short) 16);
					cellr17.setCellValue(list.get(i).getWorkType());
				}
				
				XSSFRow rowSum = sheet.getRow((short) list.size()+2);
				XSSFCell rSumc11 = rowSum.getCell((short) 11);
				rSumc11.setCellValue("总计");
				XSSFCellStyle style = workbook.createCellStyle();
				style.setAlignment(HorizontalAlignment.CENTER);;//水平居中
				style.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
				XSSFDataFormat df = workbook.createDataFormat();  //此处设置数据格式
				style.setDataFormat(df.getFormat("#,#0.00"));
				XSSFFont font = workbook.createFont();
		        font.setColor(Font.COLOR_RED);//HSSFColor.VIOLET.index //字体颜色
		        font.setFontName("宋体");
		        font.setBold(true);
		        font.setFontHeightInPoints((short)10);//设置字体大小
				style.setFont(font);
				XSSFCell rSumc12 = rowSum.getCell((short) 12);
				rSumc12.setCellFormula("SUM(M3:M"+(list.size()+2)+")");
				rSumc12.setCellStyle(style);
				
				FileOutputStream out = null;
				try {
					out = new FileOutputStream(
					new File(path.replace("模板", year+"年"+month+"月")));
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
	/*
	 * 中间汇总表导出
	 * 1、分配了任务的员工list
	 * 2、传入模板的真实路径
	 */
	public void midAllExcel(List<Employee> list, String path) {
		XSSFWorkbook workbook;
			try {
				workbook = new XSSFWorkbook(new FileInputStream(path));
				XSSFSheet sheet = workbook.getSheet("付款凭证中间表");//获取Sheet1工作表，一个excel称为工作簿，可包含多个工作表
				XSSFRow row1 = sheet.getRow((short) 0);
				XSSFCell r1c1 = row1.getCell((short) 0);
				//最好在company表加一个别名字段
				int year = Calendar.getInstance().get(Calendar.YEAR);
				int month = 1 + Calendar.getInstance().get(Calendar.MONTH);
				r1c1.setCellValue("技术服务人员明细表-" + year + "年" + month + "月");//要改
				for(int i = 0;i<list.size();i++) {
					XSSFRow row = sheet.getRow((short)(2+i));
					XSSFCell cell1 = row.getCell((short) 0);
					cell1.setCellValue(i+1);
					XSSFCell cell2 = row.getCell((short) 1);
					cell2.setCellValue(((Employee) list.get(i)).getTask().getBudget_name());
					XSSFCell cell3 = row.getCell((short) 2);
					cell3.setCellValue(list.get(i).getTask().getTask_name());
					XSSFCell cell4 = row.getCell((short) 3);
					cell4.setCellValue(list.get(i).getEname());//获取外援姓名
					XSSFCell cell5 = row.getCell((short) 4);
					cell5.setCellValue(list.get(i).getE_level());
					XSSFCell cell6 = row.getCell((short) 5);
					cell6.setCellValue(list.get(i).getTask().getWorkType());
					XSSFCell cell7 = row.getCell((short) 6);
					cell7.setCellValue(list.get(i).getOn_off_duty());
					XSSFCell cell8 = row.getCell((short) 7);
					cell8.setCellValue(list.get(i).getPrice());//单价
					XSSFCell cell9 = row.getCell((short) 8);
					int te_num = list.get(i).getTask().getEmps().size();//计算当前人物对应的人数
					cell9.setCellValue(list.get(i).getTask().getWorkdays()/te_num);
					XSSFCell cell10 = row.getCell((short) 9);
					cell10.setCellValue(0);//离岸费
					XSSFCell cell11 = row.getCell((short) 10);
					cell11.setCellFormula("H"+(3+i)+"*I"+(3+i)+"");//派驻费
					XSSFCell cell12 = row.getCell((short) 11);
					cell12.setCellFormula("J"+(3+i)+"+K"+(3+i)+"");//总金额计算
					XSSFCell cell13 = row.getCell((short) 12);
					cell13.setCellValue(list.get(i).getTask().getRemark());//外援备注，什么时候入职离职 请假等
					XSSFCell cell14 = row.getCell((short) 13);
					cell14.setCellValue(list.get(i).getCompany().getCname());
					XSSFCell cell15 = row.getCell((short) 14);
					cell15.setCellValue(list.get(i).getTask().getQm_side());//归属/业务线
				}
				
				FileOutputStream out = null;
				try {
					out = new FileOutputStream(
					new File(path.replace("模板", year+"年"+month+"月")));
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
	/*
	 * 按公司中间表导出
	 * 1、分配了任务的员工list
	 * 2、传入公司名
	 * 3、传入模板的真实路径
	 */
	public void midExcel(List<Employee> list, String path, List<Company> cList) {
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(new FileInputStream(path));
			XSSFSheet sheet = workbook.getSheet("Sheet1");//获取Sheet1工作表，一个excel称为工作簿，可包含多个工作表
			XSSFRow row1 = sheet.getRow((short) 0);
			XSSFCell r1c1 = row1.getCell((short) 0);
			//最好在company表加一个别名字段
			int year = Calendar.getInstance().get(Calendar.YEAR);
			int month = 1 + Calendar.getInstance().get(Calendar.MONTH);
			r1c1.setCellValue("合作伙伴技术服务人员明细表-" + year + "年第" + month + "月");//要改
			XSSFRow row2 = sheet.getRow((short) 1);
			XSSFCell r2c1 = row2.getCell((short) 0);
			r2c1.setCellValue("合同编号：" + cList.get(0).getContract_code());//此处要加控制，如果未分配任务，则不考勤
			XSSFCell r2c2 = row2.getCell((short) 3);
			r2c2.setCellValue("合同名称：" + cList.get(0).getContract_name());
			XSSFCell r2c3 = row2.getCell((short) 9);
			r2c3.setCellValue("归属科室/业务线："+ list.get(0).getTask().getQm_side());
			
			for(int i = 0;i<list.size();i++) {
				XSSFRow row = sheet.getRow((short)(3+i));
				XSSFCell cell1 = row.getCell((short) 0);
				cell1.setCellValue(i+1);
				XSSFCell cell2 = row.getCell((short) 1);
				cell2.setCellValue(((Employee) list.get(i)).getTask().getBudget_name());
				XSSFCell cell3 = row.getCell((short) 2);
				cell3.setCellValue(list.get(i).getTask().getTask_name());
				XSSFCell cell4 = row.getCell((short) 3);
				cell4.setCellValue(list.get(i).getEname());//获取外援姓名
				XSSFCell cell5 = row.getCell((short) 4);
				cell5.setCellValue(list.get(i).getE_level());
				XSSFCell cell6 = row.getCell((short) 5);
				cell6.setCellValue(list.get(i).getTask().getWorkType());
				XSSFCell cell7 = row.getCell((short) 6);
				cell7.setCellValue(list.get(i).getOn_off_duty());
				XSSFCell cell8 = row.getCell((short) 7);
				cell8.setCellValue(list.get(i).getPrice());//单价
				XSSFCell cell9 = row.getCell((short) 8);
				int te_num = list.get(i).getTask().getEmps().size();//计算当前人物对应的人数
				cell9.setCellValue(list.get(i).getTask().getWorkdays()/te_num);
				XSSFCell cell10 = row.getCell((short) 9);
				cell10.setCellValue(0);//离岸费
				XSSFCell cell11 = row.getCell((short) 10);
				cell11.setCellFormula("H"+(4+i)+"*I"+(4+i)+"");//派驻费
				XSSFCell cell12 = row.getCell((short) 11);
				cell12.setCellFormula("J"+(4+i)+"+K"+(4+i)+"");//总金额计算
			}
			XSSFRow rowSum = sheet.getRow((short) list.size() + 6);
			XSSFCell rSumc11 = rowSum.getCell((short) 10);
			rSumc11.setCellValue("合计金额");
			XSSFCellStyle style = workbook.createCellStyle();
			style.setAlignment(HorizontalAlignment.CENTER);;//水平居中
			style.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
//			XSSFDataFormat df = workbook.createDataFormat();  //此处设置数据格式
//			style.setDataFormat(df.getFormat("#,#0.00"));
			XSSFFont font = workbook.createFont();
	        font.setColor(Font.COLOR_RED);//HSSFColor.VIOLET.index //字体颜色
	        font.setFontName("宋体");
	        font.setBold(true);
	        font.setFontHeightInPoints((short)10);//设置字体大小
			style.setFont(font);
			XSSFCell rSumc12 = rowSum.getCell((short) 11);
			rSumc12.setCellFormula("SUM(L4:L"+(list.size()+4-1)+")");
			rSumc12.setCellStyle(style);
			
			FileOutputStream out = null;
			try {
				out = new FileOutputStream(
				new File(path.replace("模板", list.get(0).getCompany().getCname())));
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
	
	/**
	 * 合同表导出
	 * @param list
	 * @param path
	 */
	public void contract(List<Object[]> list, String path) {
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(new FileInputStream(path));
			XSSFSheet sheet = workbook.getSheet("合同台账-订单接收表");//获取Sheet1工作表，一个excel称为工作簿，可包含多个工作表
			for(int i=0;i<list.size();i++) {
				Object[] ob = list.get(i);
				
				XSSFRow row = sheet.getRow((short) (2 + i));
				XSSFCell cell1 = row.getCell((short) 0);
				cell1.setCellValue((double) i + 1);
				XSSFCell cell2 = row.getCell((short) 1);
				cell2.setCellValue(ob[0].toString());
				XSSFCell cell3 = row.getCell((short) 2);
				cell3.setCellValue("维护费");
				XSSFCell cell4 = row.getCell((short) 3);
				cell4.setCellValue(ob[1].toString());
				XSSFCell cell5 = row.getCell((short) 4);
				cell5.setCellValue(ob[2].toString());
				XSSFCell cell6 = row.getCell((short) 5);
				cell6.setCellValue(ob[3].toString());
				XSSFCell cell7 = row.getCell((short) 6);
				cell7.setCellValue(Double.parseDouble(ob[4].toString()));
				XSSFCell cell8 = row.getCell((short) 7);
				cell8.setCellFormula(ob[5] + "*" + 1.06);
				XSSFCell cell9 = row.getCell((short) 8);
				cell9.setCellValue(Double.parseDouble(ob[5].toString()));
				XSSFCell cell10 = row.getCell((short) 9);
				cell10.setCellValue("技术服务类合同");
				XSSFCell cell11 = row.getCell((short) 10);
				cell11.setCellValue("研发中心");
				XSSFCell cell13 = row.getCell((short) 12);
				cell13.setCellValue("生产系统");
				XSSFCell cell14 = row.getCell((short) 13);
				cell14.setCellValue("测评业务线");
			}				
				FileOutputStream out = null;
				try {
					int year = Calendar.getInstance().get(Calendar.YEAR);
					int month = 1 + Calendar.getInstance().get(Calendar.MONTH);
					out = new FileOutputStream(new File(path.replace("模板", year + "年" + month + "月")));
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
