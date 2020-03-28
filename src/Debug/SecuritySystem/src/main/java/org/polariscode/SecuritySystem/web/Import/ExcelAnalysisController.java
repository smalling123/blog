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
import org.polariscode.SecuritySystem.config.WebConfig;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.polariscode.SecuritySystem.model.Import.personnelImport;
import org.polariscode.SecuritySystem.model.Config.District;
import org.polariscode.SecuritySystem.mapper.Import.CustomerImportMapper;
import org.polariscode.SecuritySystem.mapper.Import.PersonnelImportMapper;
import org.polariscode.SecuritySystem.model.Base.Customer;
import org.polariscode.SecuritySystem.model.Base.Site;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.Import.SitepersonnelImport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelAnalysisController{

	@Autowired
	private CustomerImportMapper m_CustomerImportMapper;

	@Autowired
	private PersonnelImportMapper m_PersonnelImportMapper;

	@RequestMapping(value = "/Import/ExcelAnalysis/ExcelPersonnel", method = RequestMethod.POST)
	@Transactional
	public Result ExcelPersonnel(MultipartFile file) {
		Result result = new Result();
		java.util.List<Excel> excel = new java.util.ArrayList<Excel>();
		String username = "";
		username = WebConfig.getUser();
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
		int i = 0;
		int x = 0;
		while(x<excel.size()){
			if(excel.get(x).getC()==null||excel.get(x).getC().length() <= 0||excel.get(x).getE()==null||excel.get(x).getE().length() <= 0||excel.get(x).getF()==null||excel.get(x).getF().length() <= 0){
				result.setCode(404);
				result.setMsg("第"+(x+2)+"行有必填项为空！");
				return result;
			}
			if(excel.get(x).getF().length() !=18){
				result.setCode(404);
				result.setMsg("第"+(x+2)+"行有身份证信息长度不是18位！");
				return result;
			}
			x = x+1;
		}
		while(i<excel.size()){
			personnelImport p = new personnelImport();
			java.util.List<District> district = new java.util.ArrayList<District>();
			java.util.List<District> district1 = new java.util.ArrayList<District>();
			try{
				district = m_CustomerImportMapper.getDistrictByName(excel.get(i).getK());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			try{
				district1 = m_CustomerImportMapper.getDistrictByName(excel.get(i).getN());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			personnelImport pbycode = new personnelImport();
			if(excel.get(i).getA()!=null && excel.get(i).getA().length()>0){
			}
			else{
				excel.get(i).setA(excel.get(i).getF().replace( 'x','0' ).replace( 'X','0' ).substring((excel.get(i).getF().length()-8), excel.get(i).getF().length()));
			}
			personnelImport px = new personnelImport();
			try{
				px = m_PersonnelImportMapper.getPersonnelByCardCode(excel.get(i).getF());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			if(px!=null && px.getID()>0){
				p = px;
			}
			else{
				while(1==1){
					try{
						pbycode = m_PersonnelImportMapper.getPersonnelByCode(excel.get(i).getA());
					}catch(Exception error){
						result.setCode(error.hashCode());
						result.setMsg(error.getMessage());
						throw error;
					}
					if(pbycode!=null &&  pbycode.getID()>0){
						String a = "00000000"+(Integer.parseInt(excel.get(i).getA())+1);
						excel.get(i).setA(a.substring( (a.length()-8), a.length()));
					}
					else{
						break;
					}
				}
			}
			Customer c = new Customer();
			Customer cx = new Customer();
			Site s = new Site();
			Site sx = new Site();
			try{
				cx = m_CustomerImportMapper.getCustomerByName(excel.get(i).getB());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			Table t = new Table();
			if(cx!=null&&cx.getID()>0){
				c.setID(cx.getID());
			}
			else{
				c.setName(excel.get(i).getB());
				c.setCreateUser(username);
				try{
					m_CustomerImportMapper.InsertCustomer(c);
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
				try{
					t = m_CustomerImportMapper.getInsertCustomerID();
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
				c.setID(t.getID());
			}
			p.setCode(excel.get(i).getA());
			p.setName(excel.get(i).getE());
			p.setCardCode(excel.get(i).getF());
			if(excel.get(i).getI().equals("群众")){
			p.setPolitics(0);
			}else if(excel.get(i).getI().equals("中共党员")){
			p.setPolitics(1);
			}else if(excel.get(i).getI().equals("预备党员")){
			p.setPolitics(2);
			}else if(excel.get(i).getI().equals("共青团员")){
			p.setPolitics(3);
			}else  if(excel.get(i).getI().equals("民主党派")){
			p.setPolitics(4);
			}else{
			p.setPolitics(0);
			}
			
			try{
			
			p.setHeight(Integer.parseInt(excel.get(i).getG()));
			
			}
			catch(Exception e){
			}
			
			try{
			
			p.setWeight(Integer.parseInt(excel.get(i).getH()));
			
			}
			catch(Exception e){
			}
			
			
			
			if(excel.get(i).getJ().equals("小学")){
			p.setEducation(1);
			}else if(excel.get(i).getJ().equals("初中")){
			p.setEducation(2);
			}else if(excel.get(i).getJ().equals("高中")){
			p.setEducation(3);
			}else if(excel.get(i).getJ().equals("大专")){
			p.setEducation(4);
			}else if(excel.get(i).getJ().equals("本科")){
			p.setEducation(5);
			}else if(excel.get(i).getJ().equals("硕士")){
			p.setEducation(6);
			}else if(excel.get(i).getJ().equals("博士")){
			p.setEducation(7);
			}else {
			p.setEducation(0);
			}
			
			
			if(excel.get(i).getL().equals("汉族")){p.setNation(0);}
			else if(excel.get(i).getL().equals("满族")){p.setNation(1);}
			else if(excel.get(i).getL().equals("蒙古族")){p.setNation(2);}
			else if(excel.get(i).getL().equals("回族")){p.setNation(3);}
			else if(excel.get(i).getL().equals("藏族")){p.setNation(4);}
			else if(excel.get(i).getL().equals("维吾尔族")){p.setNation(5);}
			else if(excel.get(i).getL().equals("苗族")){p.setNation(6);}
			else if(excel.get(i).getL().equals("彝族")){p.setNation(7);}
			else if(excel.get(i).getL().equals("壮族")){p.setNation(8);}
			else if(excel.get(i).getL().equals("布依族")){p.setNation(9);}
			else if(excel.get(i).getL().equals("侗族")){p.setNation(10);}
			else if(excel.get(i).getL().equals("瑶族")){p.setNation(11);}
			else if(excel.get(i).getL().equals("白族")){p.setNation(12);}
			else if(excel.get(i).getL().equals("土家族")){p.setNation(13);}
			else if(excel.get(i).getL().equals("哈尼族")){p.setNation(14);}
			else if(excel.get(i).getL().equals("哈萨克族")){p.setNation(15);}
			else if(excel.get(i).getL().equals("傣族")){p.setNation(16);}
			else if(excel.get(i).getL().equals("黎族")){p.setNation(17);}
			else if(excel.get(i).getL().equals("傈僳族")){p.setNation(18);}
			else if(excel.get(i).getL().equals("佤族")){p.setNation(19);}
			else if(excel.get(i).getL().equals("畲族")){p.setNation(20);}
			else if(excel.get(i).getL().equals("高山族")){p.setNation(21);}
			else if(excel.get(i).getL().equals("拉祜族")){p.setNation(22);}
			else if(excel.get(i).getL().equals("水族")){p.setNation(23);}
			else if(excel.get(i).getL().equals("东乡族")){p.setNation(24);}
			else if(excel.get(i).getL().equals("纳西族")){p.setNation(25);}
			else if(excel.get(i).getL().equals("景颇族")){p.setNation(26);}
			else if(excel.get(i).getL().equals("柯尔克孜族")){p.setNation(27);}
			else if(excel.get(i).getL().equals("土族")){p.setNation(28);}
			else if(excel.get(i).getL().equals("达斡尔族")){p.setNation(29);}
			else if(excel.get(i).getL().equals("仫佬族")){p.setNation(30);}
			else if(excel.get(i).getL().equals("羌族")){p.setNation(31);}
			else if(excel.get(i).getL().equals("布朗族")){p.setNation(32);}
			else if(excel.get(i).getL().equals("撒拉族")){p.setNation(33);}
			else if(excel.get(i).getL().equals("毛南族")){p.setNation(34);}
			else if(excel.get(i).getL().equals("仡佬族")){p.setNation(35);}
			else if(excel.get(i).getL().equals("锡伯族")){p.setNation(36);}
			else if(excel.get(i).getL().equals("阿昌族")){p.setNation(37);}
			else if(excel.get(i).getL().equals("普米族")){p.setNation(38);}
			else if(excel.get(i).getL().equals("朝鲜族")){p.setNation(39);}
			else if(excel.get(i).getL().equals("塔吉克族")){p.setNation(40);}
			else if(excel.get(i).getL().equals("怒族")){p.setNation(41);}
			else if(excel.get(i).getL().equals("乌孜别克族")){p.setNation(42);}
			else if(excel.get(i).getL().equals("俄罗斯族")){p.setNation(43);}
			else if(excel.get(i).getL().equals("鄂温克族")){p.setNation(44);}
			else if(excel.get(i).getL().equals("德昂族")){p.setNation(45);}
			else if(excel.get(i).getL().equals("保安族")){p.setNation(46);}
			else if(excel.get(i).getL().equals("裕固族")){p.setNation(47);}
			else if(excel.get(i).getL().equals("京族")){p.setNation(48);}
			else if(excel.get(i).getL().equals("塔塔尔族")){p.setNation(49);}
			else if(excel.get(i).getL().equals("独龙族")){p.setNation(50);}
			else if(excel.get(i).getL().equals("鄂伦春族")){p.setNation(51);}
			else if(excel.get(i).getL().equals("赫哲族")){p.setNation(52);}
			else if(excel.get(i).getL().equals("门巴族")){p.setNation(53);}
			else if(excel.get(i).getL().equals("珞巴族")){p.setNation(54);}
			else if(excel.get(i).getL().equals("基诺族")){p.setNation(55);}
			else{
			p.setNation(0);
			}
			
			if(district.size()>0){
			p.setNative(district.get(0).getID());
			}else{
			p.setNative(Integer.parseInt(excel.get(i).getF().substring(0,2)+"0000"));
			}
			p.setHomeAddress(excel.get(i).getM());
			if(district1.size()>0){
			p.setCensus(district1.get(0).getID());
			}else {
			p.setCensus(Integer.parseInt(excel.get(i).getF().substring(0,2)+"0000"));
			}
			
			p.setCensusAddress(excel.get(i).getO());
			
			if(excel.get(i).getP().equals("已婚未育")){p.setMarital(1);}
			else if(excel.get(i).getP().equals("已婚已育")){p.setMarital(2);}
			else if(excel.get(i).getP().equals("离异")){p.setMarital(3);}
			else{p.setMarital(0);}
			
			p.setLinkMan(excel.get(i).getU());
			p.setLinkManRelation(excel.get(i).getV());
			p.setLinkManPhone(excel.get(i).getW());
			p.setArmy(excel.get(i).getX());
			
			java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
			
			try{
			p.setArmyInDate(df.format(excel.get(i).getY()));
			
			}
			catch(Exception e){
			}
			
			try{
			
			p.setArmyOutDate(df.format(excel.get(i).getZ()));
			
			}
			catch(Exception e){
			}
			try{
			
			p.setInDate(df.format(excel.get(i).getQ()));
			
			}
			catch(Exception e){
			}
			try{
			
			p.setHTBeginDate(df.format(excel.get(i).getR()));
			
			}
			catch(Exception e){
			}
			try{
			
			p.setHTEndDate(df.format(excel.get(i).getS()));
			}
			catch(Exception e){
			}
			
			
			if(excel.get(i).getAA().equals("无")||excel.get(i).getAA().equals("否")||excel.get(i).getAA().equals("没有")||excel.get(i).getAA().equals("")||excel.get(i).getAA()==null){
			p.setZ1(false);
			}else{
			p.setZ1(true);
			}
			if(excel.get(i).getAB().equals("无")||excel.get(i).getAB().equals("否")||excel.get(i).getAB().equals("没有")||excel.get(i).getAB().equals("")||excel.get(i).getAB()==null){
			p.setZ2(false);
			}else{
			p.setZ2(true);
			}
			if(excel.get(i).getAC().equals("无")||excel.get(i).getAC().equals("否")||excel.get(i).getAC().equals("没有")||excel.get(i).getAC().equals("")||excel.get(i).getAC()==null){
			p.setZ3(false);
			}else{
			p.setZ3(true);
			}
			if(excel.get(i).getAD().equals("无")||excel.get(i).getAD().equals("否")||excel.get(i).getAD().equals("没有")||excel.get(i).getAD().equals("")||excel.get(i).getAD()==null){
			p.setZ4(false);
			}else{
			p.setZ4(true);
			}
			if(excel.get(i).getAE().equals("无")||excel.get(i).getAE().equals("否")||excel.get(i).getAE().equals("没有")||excel.get(i).getAE().equals("")||excel.get(i).getAE()==null){
			p.setZ5(false);
			}else{
			p.setZ5(true);
			}
			
			if(excel.get(i).getAF().equals("一般")){
			p.setComputer(1);
			}else if(excel.get(i).getAF().equals("熟练")){
			p.setComputer(2);
			}else if(excel.get(i).getAF().equals("精通")){
			p.setComputer(3);
			}else{
			p.setComputer(0);
			}
			
			if(excel.get(i).getAG().equals("四级")){
			p.setEnglish(1);
			}else if(excel.get(i).getAG().equals("六级")){
			p.setEnglish(2);
			}else if(excel.get(i).getAG().equals("八级")){
			p.setEnglish(3);
			}else{
			p.setEnglish(0);
			}
			
			if(excel.get(i).getAE().equals("无")||excel.get(i).getAE().equals("否")||excel.get(i).getAE().equals("没有")||excel.get(i).getAE().equals("")||excel.get(i).getAE()==null){
			p.setPartTime(false);
			}else{
			p.setPartTime(true);
			}
			
			
			if(excel.get(i).getAE().equals("无")||excel.get(i).getAE().equals("否")||excel.get(i).getAE().equals("没有")||excel.get(i).getAE().equals("")||excel.get(i).getAE()==null){
			p.setDisease(false);
			}else{
			p.setDisease(true);
			}
			
			if(excel.get(i).getAE().equals("无")||excel.get(i).getAE().equals("否")||excel.get(i).getAE().equals("没有")||excel.get(i).getAE().equals("")||excel.get(i).getAE()==null){
			p.setCrime(false);
			}else{
			p.setCrime(true);
			}
			
			p.setAppearance(excel.get(i).getAK());
			p.setCommunication(excel.get(i).getAL());
			
			if(excel.get(i).getAM().equals("网站")){
			p.setSource(1);
			}else if(excel.get(i).getAM().equals("员工推荐")){
			p.setSource(2);
			}else if(excel.get(i).getAM().equals("领导安排")){
			p.setSource(3);
			}else if(excel.get(i).getAM().equals("队长推荐")){
			p.setSource(4);
			}else if(excel.get(i).getAM().equals("客户推荐")){
			p.setSource(5);
			}else{
			p.setSource(0);
			}
			
			
			
			
			
			p.setCreateUser(username);
			try{
				sx = m_CustomerImportMapper.getSiteByName(excel.get(i).getC());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			if(c.getID()<0){
				result.setCode(501);
				result.setMsg("第"+(x+2)+"行 客户id未找到！");
				return result;
			}
			if(sx!=null){
				s = sx;
				s.setName(excel.get(i).getC());
				s.setCreateUser(username);
				s.setCustomerID(c.getID());
				try{
					m_CustomerImportMapper.UpdateSite(s);
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
			}
			else{
				s.setName(excel.get(i).getC());
				s.setCreateUser(username);
				s.setCustomerID(c.getID());
				try{
					m_CustomerImportMapper.InsertSite(s);
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
			}
			if(p.getID()>0){
				try{
					m_PersonnelImportMapper.UpdatePersonnel(p);
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
				try{
					t = m_PersonnelImportMapper.insertPersonnelByID();
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
				p.setID(t.getID());
			}
			else{
				try{
					m_PersonnelImportMapper.InsertPersonnel(p);
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
			}
			java.util.List<SitepersonnelImport> Sitepersonnels = new java.util.ArrayList<SitepersonnelImport>();
			try{
				Sitepersonnels = m_PersonnelImportMapper.getSitepersonnelByPID(excel.get(i).getF(), excel.get(i).getC());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			String Job = "01";
			if(excel.get(i).getD().equals("队长")){
				Job = "04";
			}
			if(Sitepersonnels!=null && Sitepersonnels.size()>0){
				try{
					m_PersonnelImportMapper.UpdateSitepersonnel(Job, excel.get(i).getF(), excel.get(i).getC());
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
			}
			else{
				try{
					m_PersonnelImportMapper.InsertSitepersonnel(excel.get(i).getF(), Job, username, excel.get(i).getC());
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
			}
			i = i+1;
		}
		try{
			m_PersonnelImportMapper.UpdatePersonnelAll();
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		return result;
	}

}
