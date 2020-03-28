package org.polariscode.SecuritySystem.mapper.ApplyFor;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.ApplyFor.UserImg;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

//用户图像信息
public interface DBUserImg {
	//获取所有用户图像信息
	@Select("select * from  UserImg\n"
		+"limit #{startIndex}, #{rowCount}")
	List<UserImg> getAllUserImg(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	//获取所有用户图像条数
	@Select("select Count(*) Count from  UserImg")
	Table getUserImgCount();

	//根据ID获取一条用户图像信息
	@Select("select * from UserImg  where Id=#{id}")
	UserImg getUserImgById(@Param("id") int id);

	//根据用户Id获取图像
	@Select("<script>select * from  UserImg \n"
		+"where UserID=#{userid} \n"
		+"<choose>\n"
		+"<when test='type == 0'></when>\n"
		+"<when test='userid == \"\"'></when>\n"
		+"<otherwise>and Type=#{type}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	List<UserImg> getUserImgByUserId(@Param("userid") int userid, @Param("type") String type);

	//根据申请流程ID获取条数
	@Select("<script>select * from UserImg \n"
		+"where Eid=#{eid} \n"
		+"<choose>\n"
		+"<when test='type == 0'></when>\n"
		+"<when test='type == \"\"'></when>\n"
		+"<otherwise>and Type=#{type}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	List<UserImg> getUserImgByEid(@Param("eid") int eid, @Param("type") String type);

	//添加用户图像
	@Insert("INSERT INTO userimg \n"
		+" (UserID, Eid, Img, Type, Status, CreateTime) \n"
		+" VALUES \n"
		+" (#{userimg.UserID}, #{userimg.Eid}, #{userimg.Img}, #{userimg.Type}, #{userimg.Status}, Now())")
	void InsertUserImg(@Param("userimg") UserImg userimg);

	//修改用户图像
	@Update("UPDATE userimg \n"
		+"	SET UserID = #{userimg.UserID}, Eid =  #{userimg.Eid}, Img =  #{userimg.Img}, \n"
		+"	Type =  #{userimg.Type}, `Status` =  #{userimg.Status}\n"
		+"	WHERE Id =  #{userimg.Id}")
	void UpdateUserImg(@Param("userimg") UserImg userimg);

	//删除用户图像
	@Delete("Delete from  UserImg \n"
		+"	where Id=#{id}")
	void DeleteUserImg(@Param("id") int id);

	@Update("UPDATE userimg SET UserID =#{userid}  WHERE  EId = #{eid}")
	void UpdateUserId(@Param("eid") int eid, @Param("userid") int userid);

	@Select("Select *,img as img10 From userimg Where eid = #{eid} and type!=1 and type!=2 and type!=0")
	List<UserImg> getByEid(@Param("eid") int eid);

}
