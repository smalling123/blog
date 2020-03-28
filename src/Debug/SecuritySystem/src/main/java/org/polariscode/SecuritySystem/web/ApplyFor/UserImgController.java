package org.polariscode.SecuritySystem.web.ApplyFor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.ApplyFor.DBUserImg;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.ApplyFor.UserImg;

@RestController
public class UserImgController{

	@Autowired
	private DBUserImg m_DBUserImg;

	//删除用户图像
	@RequestMapping(value = "/ApplyFor/UserImg/deleteUserImg", method = RequestMethod.POST)
	public Result deleteUserImg(int id) {
		Result result = new Result();
		try{
			m_DBUserImg.DeleteUserImg(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//查询总的用户图像
	@RequestMapping(value = "/ApplyFor/UserImg/getAllUserImg", method = RequestMethod.POST)
	public Result getAllUserImg(int pageNumber, int pageSize) {
		Result result = new Result();
		Table table = new Table();
		//获取总的数据条数
		try{
			table = m_DBUserImg.getUserImgCount();
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		//查询总的用户头像数据
		try{
			result.setData(m_DBUserImg.getAllUserImg(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setRecordCount(table.getCount());
		result.setPageNumber(pageNumber);
		result.setPageSize(pageSize);
		return result;
	}

	@RequestMapping(value = "/ApplyFor/UserImg/getByEid", method = RequestMethod.POST)
	public Result getByEid(int eid) {
		Result result = new Result();
		try{
			result.setData(m_DBUserImg.getByEid(eid));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//根据Eid查询用户图像
	@RequestMapping(value = "/ApplyFor/UserImg/getUserImgByEid", method = RequestMethod.POST)
	public Result getUserImgByEid(int eid, String type) {
		Result result = new Result();
		try{
			result.setData(m_DBUserImg.getUserImgByEid(eid, type));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//根据ID查询用户头像信息
	@RequestMapping(value = "/ApplyFor/UserImg/getUserImgById", method = RequestMethod.POST)
	public Result getUserImgById(int id) {
		Result result = new Result();
		try{
			result.setData(m_DBUserImg.getUserImgById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//根据UserID查询用户图像
	@RequestMapping(value = "/ApplyFor/UserImg/getUserImgByUserId", method = RequestMethod.POST)
	public Result getUserImgByUserId(int userid, String type) {
		Result result = new Result();
		try{
			result.setData(m_DBUserImg.getUserImgByUserId(userid, type));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//添加、修改用户图像
	@RequestMapping(value = "/ApplyFor/UserImg/instUpUserImg", method = RequestMethod.POST)
	public Result instUpUserImg(@RequestBody UserImg userImg) {
		Result result = new Result();
		userImg.setStatus("0");
		if(userImg.getId()==0){
			//添加用户图像
			try{
				m_DBUserImg.InsertUserImg(userImg);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

			result.setCharacters(userImg.getType());
			result.setMsg("添加成功！");
		}
		else{
			//修改用户图像
			try{
				m_DBUserImg.UpdateUserImg(userImg);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

			result.setCharacters(userImg.getType());
			result.setMsg("修改成功！");
		}
		return result;
	}

}
