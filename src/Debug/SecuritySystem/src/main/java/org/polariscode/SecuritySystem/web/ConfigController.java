package org.polariscode.SecuritySystem.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Config.DistrictMapper;
import org.polariscode.SecuritySystem.model.Excel;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.transaction.annotation.Transactional;
import org.polariscode.SecuritySystem.model.Config.District;

@RestController
public class ConfigController{

	@Autowired
	private DistrictMapper m_DistrictMapper;

	@RequestMapping(value = "/Config/getDistrictById", method = RequestMethod.POST)
	public Result getDistrictById(int id) {
		Result result = new Result();
		try{
			result.setData(m_DistrictMapper.getDistrictOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Config/getDistrictByPid", method = RequestMethod.POST)
	public Result getDistrictByPid(int pid) {
		Result result = new Result();
		try{
			result.setData(m_DistrictMapper.getDistrictByPid(pid));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Config/importDistrictByExcel", method = RequestMethod.POST)
	public Result importDistrictByExcel(MultipartFile file) {
		Result result = new Result();
		java.util.List<Excel> list = new java.util.ArrayList<Excel>();
		try {
			if(null == file){
				result.setCode(-99);
				result.setMsg("File does not exist!");
				return result;
			}

			String fileName = file.getOriginalFilename();
			if(!fileName.endsWith("xls") && !fileName.endsWith("xlsx")){
				result.setCode(-98);
				result.setMsg("Not an excel file!");
				return result;
			}

			Workbook _workbook = null;
			InputStream _is = file.getInputStream();
			if(fileName.endsWith("xls")){
				_workbook = new HSSFWorkbook(_is);
			}else if(fileName.endsWith("xlsx")){
				_workbook = new XSSFWorkbook(_is);
			}
			if(_workbook != null){
				Sheet _sheet = _workbook.getSheetAt(0);
				if(_sheet != null){
					for(int _rowNum = 1; _rowNum <= _sheet.getLastRowNum(); _rowNum++){
						Row _row = _sheet.getRow(_rowNum);
						if(_row == null){
							continue;
						}
						int _lastCellNum = _row.getLastCellNum();
						Excel _e = new Excel();
						for(int _cellNum=0; _cellNum<_lastCellNum; _cellNum++){
							Cell _cell = _row.getCell(_cellNum);
							String _cellValue = "";
							if(_cell != null){
								if(_cell.getCellType() == CellType.NUMERIC){
									_cell.setCellType(CellType.STRING);
								}
								switch (_cell.getCellType()){
								case NUMERIC:
									_cellValue = String.valueOf(_cell.getNumericCellValue());
									break;
								case STRING:
									_cellValue = String.valueOf(_cell.getStringCellValue());
									break;
								case BOOLEAN:
									_cellValue = String.valueOf(_cell.getBooleanCellValue());
									break;
								case FORMULA:
									_cellValue = String.valueOf(_cell.getStringCellValue());
									break;
								case BLANK:
									_cellValue = "";
									break;
								case ERROR:
									_cellValue = "Illegal character";
									break;
								default:
									_cellValue = "Unknown type";
									break;
								}
							}
							switch(_cellNum+0){
							case 0:
								_e.setA(_cellValue);
								break;
							case 1:
								_e.setB(_cellValue);
								break;
							case 2:
								_e.setC(_cellValue);
								break;
							case 3:
								_e.setD(_cellValue);
								break;
							case 4:
								_e.setE(_cellValue);
								break;
							case 5:
								_e.setF(_cellValue);
								break;
							case 6:
								_e.setG(_cellValue);
								break;
							case 7:
								_e.setH(_cellValue);
								break;
							case 8:
								_e.setI(_cellValue);
								break;
							case 9:
								_e.setJ(_cellValue);
								break;
							case 10:
								_e.setK(_cellValue);
								break;
							case 11:
								_e.setL(_cellValue);
								break;
							case 12:
								_e.setM(_cellValue);
								break;
							case 13:
								_e.setN(_cellValue);
								break;
							case 14:
								_e.setO(_cellValue);
								break;
							case 15:
								_e.setP(_cellValue);
								break;
							case 16:
								_e.setQ(_cellValue);
								break;
							case 17:
								_e.setR(_cellValue);
								break;
							case 18:
								_e.setS(_cellValue);
								break;
							case 19:
								_e.setT(_cellValue);
								break;
							case 20:
								_e.setU(_cellValue);
								break;
							case 21:
								_e.setV(_cellValue);
								break;
							case 22:
								_e.setW(_cellValue);
								break;
							case 23:
								_e.setX(_cellValue);
								break;
							case 24:
								_e.setY(_cellValue);
								break;
							case 25:
								_e.setZ(_cellValue);
								break;
							case 26:
								_e.setAA(_cellValue);
								break;
							case 27:
								_e.setAB(_cellValue);
								break;
							case 28:
								_e.setAC(_cellValue);
								break;
							case 29:
								_e.setAD(_cellValue);
								break;
							case 30:
								_e.setAE(_cellValue);
								break;
							case 31:
								_e.setAF(_cellValue);
								break;
							case 32:
								_e.setAG(_cellValue);
								break;
							case 33:
								_e.setAH(_cellValue);
								break;
							case 34:
								_e.setAI(_cellValue);
								break;
							case 35:
								_e.setAJ(_cellValue);
								break;
							case 36:
								_e.setAK(_cellValue);
								break;
							case 37:
								_e.setAL(_cellValue);
								break;
							case 38:
								_e.setAM(_cellValue);
								break;
							case 39:
								_e.setAN(_cellValue);
								break;
							case 40:
								_e.setAO(_cellValue);
								break;
							case 41:
								_e.setAP(_cellValue);
								break;
							case 42:
								_e.setAQ(_cellValue);
								break;
							case 43:
								_e.setAR(_cellValue);
								break;
							case 44:
								_e.setAS(_cellValue);
								break;
							case 45:
								_e.setAT(_cellValue);
								break;
							case 46:
								_e.setAU(_cellValue);
								break;
							case 47:
								_e.setAV(_cellValue);
								break;
							case 48:
								_e.setAW(_cellValue);
								break;
							case 49:
								_e.setAX(_cellValue);
								break;
							case 50:
								_e.setAY(_cellValue);
								break;
							case 51:
								_e.setAZ(_cellValue);
								break;
			        		}
			        	}
			        	list.add(_e);
		        	}
		    	}
			}else{
				result.setCode(-97);
				result.setMsg("The file format is not correct!");
				return result;
			}

		} catch (IOException error) {
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			m_DistrictMapper.DeleteAllDistrict();
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			if(list.size()>0){
				m_DistrictMapper.ImportDistrict(list);
			}
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Config/updateDistrict", method = RequestMethod.POST)
	@Transactional
	public Result updateDistrict(@RequestBody District district) {
		Result result = new Result();
		if(district.getID() == 0){
			try{
				m_DistrictMapper.InsertDistrict(district);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		else{
			try{
				m_DistrictMapper.UpdateDistrict(district);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		return result;
	}

}
