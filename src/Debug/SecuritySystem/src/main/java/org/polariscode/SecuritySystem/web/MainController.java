package org.polariscode.SecuritySystem.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import org.polariscode.SecuritySystem.utils.MD5Util;
import java.util.Random;
import org.polariscode.SecuritySystem.model.Result;

@RestController
public class MainController{

	@RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
	public String downloadFile(HttpServletResponse response, String filename, String type) throws java.io.UnsupportedEncodingException  {
		java.io.File file = null;
		file = new java.io.File(Global.FilePath+filename);
		String file_ContentType = type;
		if(file != null && file.exists()){
			response.setContentType(file_ContentType);
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-Disposition", "attachment;fileName=" + java.net.URLEncoder.encode(file.getName(),"UTF-8"));
			byte[] buffer = new byte[1024];
			java.io.FileInputStream fis = null;
			java.io.BufferedInputStream bis = null;

			java.io.OutputStream os = null;
			try {
				os = response.getOutputStream();
				fis = new java.io.FileInputStream(file);
				bis = new java.io.BufferedInputStream(fis);
				int i = bis.read(buffer);
				while(i != -1){
					os.write(buffer);
					i = bis.read(buffer);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bis.close();
				fis.close();
			} catch (java.io.IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@RequestMapping(value = "/helloworld")
	public String helloworld() {
		String result = "HelloWorld!";
		String md5 = "";
		md5 = MD5Util.encrypt(result);
		result = result + ":" + md5;
		md5 = getRandomString("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789",12);
		return result;
	}

	//上传文件
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public Result uploadFile(MultipartFile file, String type) {
		Result result = new Result();
		String uuid = "";
		uuid = java.util.UUID.randomUUID().toString();
		String filename = type+"/"+(new java.text.SimpleDateFormat("yyyyMMdd")).format(new java.util.Date())+"/"+uuid +"/"+file.getOriginalFilename();
		try{
			if(file!=null && !file.isEmpty()){
				java.io.File m_file = new java.io.File(Global.FilePath+filename);
				if(!m_file.getParentFile().exists()) {
					m_file.getParentFile().mkdirs();
				}
				if(m_file.exists() && m_file.isFile()) {
					m_file.delete();
				}
				java.nio.file.Files.write(java.nio.file.Paths.get(Global.FilePath+filename), file.getBytes());
			}
		} catch(java.io.IOException e){
			e.printStackTrace();
		}
		result.setData(filename);
		return result;
	}

	public String getRandomString(String str, int length) {
		Random random=new Random();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<length;i++){
			int number=random.nextInt(str.length());
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
}
