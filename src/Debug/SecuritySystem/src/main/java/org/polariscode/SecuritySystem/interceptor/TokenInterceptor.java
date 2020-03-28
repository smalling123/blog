package org.polariscode.SecuritySystem.interceptor;


import org.polariscode.SecuritySystem.config.WebConfig;
import org.polariscode.SecuritySystem.config.JwtConfig;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private JwtConfig jwtConfig ;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		String uri = request.getRequestURI() ;

		if( uri.toLowerCase().contains("/downloadfile") 
			|| uri.toLowerCase().contains("/helloworld") 
			|| uri.toLowerCase().contains("/application") 
			|| uri.toLowerCase().contains("/languageapplication") 
			|| uri.toLowerCase().contains("/managementapprovals") 
			|| uri.toLowerCase().contains("/theuserapplication") 
			|| uri.toLowerCase().contains("/twoapplication") 
			|| uri.toLowerCase().contains("/applyfor/educationaltraining/deleteeducational") 
			|| uri.toLowerCase().contains("/applyfor/educationaltraining/getalleducational") 
			|| uri.toLowerCase().contains("/applyfor/educationaltraining/geteducationalbyeid") 
			|| uri.toLowerCase().contains("/applyfor/educationaltraining/geteducationalbyid") 
			|| uri.toLowerCase().contains("/applyfor/educationaltraining/instupeducational") 
			|| uri.toLowerCase().contains("/applyfor/employee/getempbycardno") 
			|| uri.toLowerCase().contains("/applyfor/employee/getempid") 
			|| uri.toLowerCase().contains("/applyfor/family/deletefamily") 
			|| uri.toLowerCase().contains("/applyfor/family/getallfamily") 
			|| uri.toLowerCase().contains("/applyfor/family/getfamilybyeid") 
			|| uri.toLowerCase().contains("/applyfor/family/getfamilybyid") 
			|| uri.toLowerCase().contains("/applyfor/family/instupfamily") 
			|| uri.toLowerCase().contains("/applyfor/userimg/getbyeid") 
			|| uri.toLowerCase().contains("/applyfor/userimg/getuserimgbyeid") 
			|| uri.toLowerCase().contains("/applyfor/userimg/getuserimgbyid") 
			|| uri.toLowerCase().contains("/applyfor/userimg/instupuserimg") 
			|| uri.toLowerCase().contains("/applyfor/workexperience/deletework") 
			|| uri.toLowerCase().contains("/applyfor/workexperience/getallworkexperience") 
			|| uri.toLowerCase().contains("/applyfor/workexperience/getworkbyeid") 
			|| uri.toLowerCase().contains("/applyfor/workexperience/getworkbyid") 
			|| uri.toLowerCase().contains("/applyfor/workexperience/instupwork") 
			|| uri.toLowerCase().contains("/base/personnelcontract/updatepersonnelcontract") 
			|| uri.toLowerCase().contains("/getmaxcontractcode") 
			|| uri.toLowerCase().contains("/getsitecontractpostbyid") 
			|| uri.toLowerCase().contains("/updatesitecontractpost") 
			|| uri.toLowerCase().contains("/getinvoicebyid") 
			|| uri.toLowerCase().contains("/getpaybyid") 
			|| uri.toLowerCase().contains("/insertsbill") 
			|| uri.toLowerCase().contains("/replacebillfee") 
			|| uri.toLowerCase().contains("/updatebill") 
			|| uri.toLowerCase().contains("/updatebillfee") 
			|| uri.toLowerCase().contains("/updateinvoice") 
			|| uri.toLowerCase().contains("/updatepay") 
			|| uri.toLowerCase().contains("/logistics/equipment/updateequipment") 
			|| uri.toLowerCase().contains("/logistics/equipmentinstock/updateequipmentinstock") 
			|| uri.toLowerCase().contains("/logistics/equipmentinstock/updateequipmentinstockitem") 
			|| uri.toLowerCase().contains("/logistics/equipmentorder/updateequipmentorder") 
			|| uri.toLowerCase().contains("/logistics/equipmentorder/updateequipmentorderitem") 
			|| uri.toLowerCase().contains("/logistics/equipmentoutstock/updateequipmentoutstock") 
			|| uri.toLowerCase().contains("/logistics/equipmentoutstock/updateequipmentoutstockitem") 
			|| uri.toLowerCase().contains("/logistics/house/updatehouse") 
			|| uri.toLowerCase().contains("/logistics/house/updatehousecontract") 
			|| uri.toLowerCase().contains("/login") 
			|| uri.toLowerCase().contains("/permission/menu/getallmenus") 
			|| uri.toLowerCase().contains("/permission/menu/getmenubyid") 
			|| uri.toLowerCase().contains("/permission/menu/getmenubypid") 
			|| uri.toLowerCase().contains("/permission/user/updateuser") 
			|| uri.toLowerCase().contains("/gataccfunitembyid") 
			|| uri.toLowerCase().contains("/getinsurancebyid") 
			|| uri.toLowerCase().contains("/gettaxmbyid") 
			|| uri.toLowerCase().contains("/gettaxybyid") 
			|| uri.toLowerCase().contains("/updateaccfund") 
			|| uri.toLowerCase().contains("/updateaccfunditem") 
			|| uri.toLowerCase().contains("/updateinsurance") 
			|| uri.toLowerCase().contains("/updatetamy") 
			|| uri.toLowerCase().contains("/updatetax") 
			|| uri.toLowerCase().contains("/updatetaxm") 
			|| uri.toLowerCase().contains("/updateleader") 
			|| uri.toLowerCase().contains("/getmyoktask") 
			|| uri.toLowerCase().contains(".html") 
			|| uri.toLowerCase().contains(".htm") 
			|| uri.toLowerCase().contains(".js") 
			|| uri.toLowerCase().contains(".css") 
			|| uri.toLowerCase().contains(".png") 
			|| uri.toLowerCase().contains(".jpeg") 
			|| uri.toLowerCase().contains(".jpg") 
			|| uri.toLowerCase().contains(".gif") 
			|| uri.toLowerCase().contains(".") ){
			return true;
		}

		String token = request.getHeader(jwtConfig.getHeader());
		if(StringUtils.isEmpty(token)){
			token = request.getParameter(jwtConfig.getHeader());
		}

		if(StringUtils.isEmpty(token)){
			throw new Exception(jwtConfig.getHeader()+ " can't be empty.");
		}

		Claims claims = jwtConfig.getTokenClaim(token);

		if(claims == null || jwtConfig.isTokenExpired(claims.getExpiration())){
			throw new Exception(jwtConfig.getHeader() + "Invalid, Please login again");
		}

		WebConfig.addUserContext(claims.getSubject());

		return true;
	}

}