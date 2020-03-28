package org.polariscode.SecuritySystem.web.Import;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
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
import org.polariscode.SecuritySystem.config.WebConfig;
import org.polariscode.SecuritySystem.model.Base.Customer;
import org.polariscode.SecuritySystem.mapper.Import.CustomerImportMapper;
import org.polariscode.SecuritySystem.model.Permission.Org;
import org.polariscode.SecuritySystem.model.Config.District;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.mapper.Import.PersonnelImportMapper;
import org.polariscode.SecuritySystem.model.Base.Site;
import org.polariscode.SecuritySystem.model.Permission.User;
import org.polariscode.SecuritySystem.model.Import.SitelinkmanImport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelCustomerController{

	@Autowired
	private CustomerImportMapper m_CustomerImportMapper;

	@Autowired
	private PersonnelImportMapper m_PersonnelImportMapper;

	@RequestMapping(value = "/Import/ExcelCustomer/importCustomerByExcel", method = RequestMethod.POST)
	@Transactional
	public Result importCustomerByExcel(MultipartFile file) {
		Result result = new Result();
		java.util.List<Excel> excel = new java.util.ArrayList<Excel>();
		try {
			if(null == file){
				result.setCode(-99);
				result.setMsg("File does not exist!");
				throw new RuntimeException("File does not exist!");
			}
			String fileName = file.getOriginalFilename();
			if(!fileName.endsWith("xls") && !fileName.endsWith("xlsx")){
				result.setCode(-98);
				result.setMsg("Not an excel file!");
				throw new RuntimeException("Not an excel file!");
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
			        	excel.add(_e);
		        	}
		    	}
			}else{
				result.setCode(-97);
				result.setMsg("The file format is not correct!");
				throw new RuntimeException("The file format is not correct");
			}
		} catch (IOException error) {
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw new RuntimeException(error.getMessage());
		}
		result.setData(excel);
		String username = "";
		username = WebConfig.getUser();
		int CustomerID = 0;
		int i = 0;
		int x = 0;
		while(x<excel.size()){
			if(excel.get(x).getA()==null||excel.get(x).getA().length() <= 0||excel.get(x).getB()==null||excel.get(x).getB().length() <= 0||excel.get(x).getC()==null||excel.get(x).getC().length() <= 0||excel.get(x).getD()==null||excel.get(x).getD().length() <= 0||excel.get(x).getE()==null||excel.get(x).getE().length() <= 0){
				result.setCode(404);
				result.setMsg("第"+(x+2)+"行有必填项为空！");
				return result;
			}
			x = x+1;
		}
		while(i<excel.size()){
			Customer cs = new Customer();
			try{
				cs = m_CustomerImportMapper.getCustomerByName(excel.get(i).getA());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			java.util.List<Org> Orgs = new java.util.ArrayList<Org>();
			try{
				Orgs = m_CustomerImportMapper.getOrgByName(excel.get(i).getC());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			if(Orgs==null || Orgs.size() == 0){
				result.setCode(500);
				result.setMsg("第"+(i+2)+"行  所属部门“"+excel.get(i).getC()+"”未录入系统！");
				return result;
			}
			java.util.List<District> districts = new java.util.ArrayList<District>();
			Table table = new Table();
			try{
				districts = m_CustomerImportMapper.getDistrictByName(excel.get(i).getD());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			if(districts==null || districts.size() == 0){
				result.setCode(500);
				result.setMsg("第"+(i+2)+"行  城市信息未录入系统！");
				return result;
			}
			if(cs!=null && cs.getID() > 0){
				CustomerID = cs.getID();
			}
			else{
				Customer c = new Customer();
				c.setCreateUser(username);
				c.setName(excel.get(i).getA());
				if(Orgs.size()>0){
				c.setOrgID(Orgs.get(0).getID());}
				if(districts.size()>0){
				c.setDistrict(districts.get(0).getID());}
				try{
					m_CustomerImportMapper.InsertCustomer(c);
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
				try{
					table = m_CustomerImportMapper.getInsertCustomerID();
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
				if(table.getID()>0){
					CustomerID = table.getID();
				}
				else{
					result.setCode(500);
					result.setMsg("第"+(i+2)+"行客户信息添加失败！");
					return result;
				}
			}
			try{
				table = m_PersonnelImportMapper.getSiteLeaderByPhone(excel.get(i).getM(), excel.get(i).getB(), excel.get(i).getL());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			int LeaderID = 0;
			if(table!=null && table.getID()>0){
				LeaderID = table.getID();
			}
			Site s = new Site();
			Site sx = new Site();
			try{
				sx = m_CustomerImportMapper.getSiteByName(excel.get(i).getB());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			if(sx!=null&&sx.getID()>0){
				s = sx;
			}
			java.util.List<User> manager = new java.util.ArrayList<User>();
			try{
				manager = m_CustomerImportMapper.getUserByname(excel.get(i).getJ());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			if(manager!=null && manager.size()>0){
			}
			else{
				result.setCode(500);
				result.setMsg("第"+(i+2)+"行  区域经理信息未录入系统！");
				return result;
			}
			java.util.List<User> Leadership = new java.util.ArrayList<User>();
			try{
				Leadership = m_CustomerImportMapper.getUserByname(excel.get(0).getI());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			if(Leadership!=null&& Leadership.size()>0){
				sx.setLeadership(Leadership.get(0).getID());
			}
			int sid = 0;
			s.setName(excel.get(i).getB());
			s.setCustomerID(CustomerID);
			s.setLeader(LeaderID);
			s.setLeaderName(excel.get(i).getL());
			s.setLeaderPhone(excel.get(i).getM());
			s.setAddress(excel.get(i).getE());
			s.setCreateUser(username);
			if(districts.size()>0){
			s.setDistrict(districts.get(0).getID());}
			if(Orgs.size()>0){
			s.setOrgID(Orgs.get(0).getID());}
			if(excel.get(i).getH().equals("商业物业"))
			{
			s.setType(0);
			}else if(excel.get(i).getH().equals("住宅")){
			s.setType(1);
			}else if(excel.get(i).getH().equals("工厂")){
			s.setType(2);
			}else if(excel.get(i).getH().equals("银行")){
			s.setType(3);
			}else if(excel.get(i).getH().equals("医院")){
			s.setType(4);
			}else if(excel.get(i).getH().equals("学校")){
			s.setType(5);
			}else{
			s.setType(9);
			}
			if(manager.size()>0){
			s.setManager(manager.get(0).getID());}
			if(s.getID()==0){
				try{
					m_CustomerImportMapper.InsertSite(s);
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
				try{
					table = m_CustomerImportMapper.getInsertSiteID();
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
				if(table.getID()>0){
					sid = table.getID();
				}
				else{
					result.setCode(500);
					result.setMsg("第"+(i+2)+"行 驻点信息录入失败！");
					return result;
				}
			}
			else{
				try{
					m_CustomerImportMapper.UpdateSite(s);
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
				sid = s.getID();
			}
			try{
				table = m_CustomerImportMapper.getSitelinkmanByName(excel.get(i).getF(), excel.get(i).getG());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			if(table.getCount()<0){
				SitelinkmanImport slk = new SitelinkmanImport();
				slk.setSiteID(sid);
				slk.setName(excel.get(i).getF());
				slk.setPhone(excel.get(i).getG());
				slk.setType(1);
				try{
					m_CustomerImportMapper.InsertSitelinkman(slk);
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
				slk.setName(excel.get(i).getK());
				slk.setPhone(null);
				slk.setType(0);
				try{
					m_CustomerImportMapper.InsertSitelinkman(slk);
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
			}
			i = i+1;
		}
		return result;
	}

}
