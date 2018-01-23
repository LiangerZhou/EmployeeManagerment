package com.cmsz.service.Impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.transaction.annotation.Transactional;

import com.cmsz.dao.EmployeeDao;
import com.cmsz.domain.Employee;
import com.cmsz.domain.PageBean;
import com.cmsz.service.EmployeeService;
//员工管理的业务层实现类


@Transactional(readOnly = false)
public class EmployeeServiceImpl implements EmployeeService {
	//使用spring注入的dao
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

		@Override
		public PageBean<Employee> findAll(int currentPage) {
			PageBean<Employee> pageBean = new PageBean<Employee>();
			//每页显示的数量
			int pageSize = 10;
			//这个方法用于查找出所有的员工的数量
			int totalSize = employeeDao.findAllCount(currentPage);
			int pageCount = (totalSize%pageSize)==0?(totalSize/pageSize):(totalSize/pageSize)+1;
			pageBean.setCurrentPage(currentPage);
			pageBean.setPageCount(pageCount);
			pageBean.setPageSize(pageSize);
			pageBean.setTotalSize(totalSize);
			int begin = (currentPage-1)*pageSize;
			//这个方法用于查找出指定页数中的List<Employee>
			List<Employee> list = employeeDao.findAll(begin,pageSize);
			pageBean.setList(list);
			return pageBean;
		}
		@Override
		public void save(Employee employee) {
			employeeDao.save(employee);
		}
		@Override
		public Employee edit(Integer eid) {
			return employeeDao.edit(eid);
		}
		@Override
		public void update(Employee em) {
			employeeDao.update(em);
		}

		@Override
		public void delete(Employee employee) {
			employeeDao.delete(employee);
			
		}
		
		@Override
		public List<Employee> findAll() {
			return employeeDao.findAll();
		}

//		@Override
//		public InputStream exportExcel() {
//			//创建workbook，对应一个Excel文件
//			HSSFWorkbook workbook = new HSSFWorkbook();
//			//创建一个sheet
//			HSSFSheet sheet = workbook.createSheet("考勤表");
//			//创建第一行
//			HSSFRow row1 = sheet.createRow(0); 
//			//创建第一个单元格
//	        HSSFCell r1c1 = row1.createCell((short)0);     
//	        r1c1.setCellValue("技术服务人员签到表"); 
//	        //表头样式
//	        HSSFCellStyle titleStyle =  workbook.createCellStyle();  
//	        titleStyle.setAlignment(HorizontalAlignment.CENTER);;//水平居中
//	        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
//	        titleStyle.setBorderTop(BorderStyle.THIN);//上边框    
//	        titleStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
//	        titleStyle.setBorderBottom(BorderStyle.THIN); //下边框    
//	        titleStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//	        titleStyle.setBorderLeft(BorderStyle.THIN);//左边框    
//	        titleStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
//	        titleStyle.setBorderRight(BorderStyle.THIN);//右边框  
//	        titleStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
//	        HSSFFont titleFont = workbook.createFont();
//	        titleFont.setFontName("宋体");//设置字体
//	        titleFont.setFontHeightInPoints((short)18);//设置字体大小
//	        // titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示	       
//	        titleStyle.setFont(titleFont);
//
//	        //设置单元格内容和样式
//	        r1c1.setCellValue("技术服务人员签到表"); 
//	        r1c1.setCellStyle(titleStyle);
//	       //上面单元格固定样式
//	        HSSFCellStyle cellStyle = workbook.createCellStyle();
//	        cellStyle.setAlignment(HorizontalAlignment.LEFT);
//	        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//	        cellStyle.setBorderTop(BorderStyle.THIN);//上边框    
//	        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
//	        cellStyle.setBorderBottom(BorderStyle.THIN); //下边框    
//	        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//	        cellStyle.setBorderLeft(BorderStyle.THIN);//左边框    
//	        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
//	        cellStyle.setBorderRight(BorderStyle.THIN);//右边框  
//	        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
//	        HSSFFont cellFont = workbook.createFont();
//	        cellFont.setFontName("宋体");
//	        cellFont.setFontHeightInPoints((short)12);
//	        // cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//	        cellStyle.setFont(cellFont);
//	        
//	        HSSFCellStyle cellStyle1 = workbook.createCellStyle();
//	        cellStyle1.setWrapText(true);//内容自适应
//	        cellStyle1.setAlignment(HorizontalAlignment.CENTER);
//	        cellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
//	        cellStyle1.setBorderTop(BorderStyle.THIN);//上边框    
//	        cellStyle1.setTopBorderColor(IndexedColors.BLACK.getIndex());
//	        cellStyle1.setBorderBottom(BorderStyle.THIN); //下边框    
//	        cellStyle1.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//	        cellStyle1.setBorderLeft(BorderStyle.THIN);//左边框    
//	        cellStyle1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
//	        cellStyle1.setBorderRight(BorderStyle.THIN);//右边框  
//	        cellStyle1.setRightBorderColor(IndexedColors.BLACK.getIndex());
//	        HSSFFont cellFont1 = workbook.createFont();
//	        cellFont1.setFontName("宋体");
//	        cellFont1.setFontHeightInPoints((short)12);
//	        // cellFont1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//	        
//	        cellStyle1.setFont(cellFont1);
//	        
//	        
//	       
//	        
//	        
//	        HSSFRow row2 = sheet.createRow(1);
//	        HSSFRow row3 = sheet.createRow(2);
//	        HSSFRow row4 = sheet.createRow(3);
//	        HSSFCell r2c1 = row2.createCell((short)0);
//	        r2c1.setCellValue("核准周期");
//	        HSSFCell r2c2 = row2.createCell((short)1);
//	        r2c2.setCellValue("注："+"2017"+"年"+"7"+"月周期为："+"2017-6-21"+"至"+"2017-7-20（共计22天工作日）");
//	        HSSFCell r3c1 = row3.createCell(0);
//	        r3c1.setCellValue("归属预算名称："+"测试综合管理平台一期");
//	    
//	        
//	        
//	        HSSFCell r3c2 = row3.createCell(4);
//	        r3c2.setCellValue("项目负责人：");
//	        
//	        HSSFCell r4c1 = row4.createCell(0);
//	        r4c1.setCellValue("日期");
//	        HSSFCell r4c2 = row4.createCell(1);
//	        r4c2.setCellValue("外援名称\r\n（机打）");
//	        HSSFCell r4c3 = row4.createCell(2);
//	        r4c3.setCellValue("外援所属公司\r\n（机打）");
//	        HSSFCell r4c4 = row4.createCell(3);
//	        r4c4.setCellValue("开始时间\r\n（手写）");
//	        HSSFCell r4c5 = row4.createCell(4);
//	        r4c5.setCellValue("结束时间\r\n（手写）");
//	        HSSFCell r4c6 = row4.createCell(5);
//	        r4c6.setCellValue("外援签名\r\n（手写）");
//	       
//	        r2c1.setCellStyle(cellStyle);
//	        r2c2.setCellStyle(cellStyle);
//	        r3c1.setCellStyle(cellStyle);
//	        r3c2.setCellStyle(cellStyle);
//	        r4c1.setCellStyle(cellStyle);
//	        r4c2.setCellStyle(cellStyle1);
//	        r4c3.setCellStyle(cellStyle1);
//	        r4c4.setCellStyle(cellStyle1);
//	        r4c5.setCellStyle(cellStyle1);
//	        r4c6.setCellStyle(cellStyle1);
//	        
//	        //合并单元格
//	        CellRangeAddress cellMerge1 = new CellRangeAddress(0, 0, 0, 5);
//	        sheet.addMergedRegion(cellMerge1);
//	        
//	        CellRangeAddress cellMerge2 = new CellRangeAddress(1, 1, 1, 5);
//	        sheet.addMergedRegion(cellMerge2);
//	        
//	        CellRangeAddress cellMerge3 = new CellRangeAddress(2, 2, 0, 3);
//	        sheet.addMergedRegion(cellMerge3);
//
//	        CellRangeAddress cellMerge4 = new CellRangeAddress(2, 2, 4, 5);
//	        sheet.addMergedRegion(cellMerge4);
//	        
//	       //合并的单元格加边框 
//	        // RegionUtil.setBorderBottom(1, cellMerge1, sheet);
//	        // RegionUtil.setBorderLeft(1, cellMerge1, sheet);
//	        // RegionUtil.setBorderRight(1, cellMerge1, sheet);
//	        // RegionUtil.setBorderRight(1, cellMerge1, sheet);
//	       
//	        // RegionUtil.setBorderBottom(1, cellMerge2, sheet);
//	        // RegionUtil.setBorderLeft(1, cellMerge2, sheet);
//	        // RegionUtil.setBorderRight(1, cellMerge2, sheet);
//	        // RegionUtil.setBorderRight(1, cellMerge2, sheet);
//
//	        // RegionUtil.setBorderBottom(1, cellMerge3, sheet);
//	        // RegionUtil.setBorderLeft(1, cellMerge3, sheet);
//	        // RegionUtil.setBorderRight(1, cellMerge3, sheet);
//	        // RegionUtil.setBorderRight(1, cellMerge3, sheet);
//	        
//	        // RegionUtil.setBorderBottom(1, cellMerge4, sheet);
//	        // RegionUtil.setBorderLeft(1, cellMerge4, sheet);
//	        // RegionUtil.setBorderRight(1, cellMerge4, sheet);
//	        // RegionUtil.setBorderRight(1, cellMerge4, sheet);
//	      //设置列宽自适应
//	        sheet.autoSizeColumn(0,true);//行号，true
//	        sheet.autoSizeColumn(1,true);
//	        sheet.autoSizeColumn(2,true);
//	        sheet.autoSizeColumn(3,true);
//	        sheet.autoSizeColumn(4,true);
//	        sheet.autoSizeColumn(5,true);
//	        
//			//写入实体数据 实际应用中这些数据从数据库获得
//	        
//	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//	        try {
//				workbook.write(bos);
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//	        
//	        InputStream is = null;
//	        is = new ByteArrayInputStream(bos.toByteArray());
//	        try {
//				workbook.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			return is;
//			
//		}

		@Override
		public List<Employee> findByName(String findname) {
			return employeeDao.findByName(findname);
			
		}

		@Override
		public List<Employee> findByIds(String eids) {
			return employeeDao.findByIds(eids);
		}

}
