package com.cmsz.service.Impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.transaction.annotation.Transactional;

import com.cmsz.dao.CompanyDao;
import com.cmsz.domain.Company;
import com.cmsz.domain.PageBean;
import com.cmsz.service.CompanyService;
import com.opensymphony.xwork2.ActionContext;

@Transactional(readOnly = false)
public class CompanyServiceImpl implements CompanyService {

	private CompanyDao companyDao;
	
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}
	
	@Override
	public PageBean<Company> findByPage(int currentPage) {
		PageBean<Company> pageBean = new PageBean<Company>();
		int pageSize = 5;
		//从数据库获得总共的条数
		int totalSize = companyDao.findCount();
		int pageCount = (totalSize%pageSize)==0?(totalSize/pageSize):(totalSize/pageSize)+1;
		pageBean.setPageCount(pageCount);
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalSize(totalSize);
		int begin = (currentPage-1)*pageSize;
		List<Company> list = companyDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		ActionContext.getContext().put("list", list);
		return pageBean;
	}
	@Override
	public void save(Company company) {
		companyDao.save(company);
	}
	@Override
	public Company editById(Integer cid) {
		return companyDao.editById(cid);
	}
	@Override
	public void update(Company company) {
		companyDao.update(company);
	}
	@Override
	public void delete(Company company) {
		companyDao.delete(company);
	}
	@Override
	public List<Company> findAll() {
		return companyDao.findAll();
	}

	@Override
	public InputStream exportExcel() {
		//创建workbook，对应一个Excel文件
		SXSSFWorkbook workbook = new SXSSFWorkbook();
//		workbook.setCompressTempFiles(true);
        //表头样式
        CellStyle titleStyle =  workbook.createCellStyle();  
        titleStyle.setAlignment(HorizontalAlignment.CENTER);;//水平居中
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
        titleStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());//设置背景色
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);;
        Font titleFont = workbook.createFont();
        titleFont.setFontName("微软雅黑");//设置字体
        titleFont.setFontHeightInPoints((short)10);//设置字体大小
        // titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);//粗体显示
        titleFont.setColor(Font.COLOR_RED);
        titleFont.setColor(IndexedColors.BLACK.getIndex());
       
        
        titleStyle.setFont(titleFont);
        // 列头样式
        CellStyle headerStyle = workbook.createCellStyle();
        
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerStyle.setFont(headerFont);
        // 单元格样式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderTop(BorderStyle.DASH_DOT);//上边框    
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderBottom(BorderStyle.THIN); //下边框    
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderLeft(BorderStyle.THIN);//左边框    
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderRight(BorderStyle.THIN);//右边框  
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        Font cellFont = workbook.createFont();
        
        cellStyle.setFont(cellFont);
        
        //在workbook中添加一个sheet，对应Excel文件中的sheet
  		SXSSFSheet sheet1 = workbook.createSheet("合同台账-订单接收表");
//  		SXSSFSheet sheet2 = workbook.createSheet("归属预算名称");
//  		SXSSFSheet sheet3 = workbook.createSheet("合同信息");
  		
  		//在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        SXSSFRow row = sheet1.createRow((int) 0);  
        //创建单元格，并设置值表头 设置表头居中  
        sheet1.trackAllColumnsForAutoSizing();
        sheet1.autoSizeColumn((short)0);//设置列宽自适应
        SXSSFCell cell = row.createCell((short) 0);  
        cell.setCellValue("合同伙伴");  
        cell.setCellStyle(titleStyle);  
        cell = row.createCell((short) 1);  
        cell.setCellValue("工作量核算（人日）");  
        cell.setCellStyle(titleStyle);  
        cell = row.createCell((short) 2);  
        cell.setCellValue("总额");  
        cell.setCellStyle(titleStyle);  
        cell = row.createCell((short) 3);  
        cell.setCellValue("不含税金额（元）");  
        cell.setCellStyle(titleStyle); 
        cell = row.createCell((short) 4);  
        cell.setCellValue("合同类型");  
        cell.setCellStyle(titleStyle); 
        cell = row.createCell((short) 5);  
        cell.setCellValue("归口部门");  
        cell.setCellStyle(titleStyle); 
        cell = row.createCell((short) 6);  
        cell.setCellValue("备注");  
        cell.setCellStyle(titleStyle); 
        cell = row.createCell((short) 7);  
        cell.setCellValue("生产系统（维护类需要填写）");  
        cell.setCellStyle(titleStyle); 
        cell = row.createCell((short) 8);  
        cell.setCellValue("科室/业务线");  
        cell.setCellStyle(titleStyle); 
		
		//写入实体数据 实际应用中这些数据从数据库获得
        List<Company> list = findAll();
        for(int i=0;i<list.size();i++) {
        	row = sheet1.createRow((int)i+1);
        	Company company = list.get(i);
        	//创建单元格，并设置值
        	row.createCell((short)0).setCellValue(company.getCid());
        	row.createCell(1).setCellValue(company.getCname());
        }
        
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
			workbook.write(bos);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
        InputStream is = null;
        is = new ByteArrayInputStream(bos.toByteArray());
        try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return is;
		
	}

	@Override
	public List<Company> findByName(String cpname) {
		
		return companyDao.findByName(cpname);
	}
}
