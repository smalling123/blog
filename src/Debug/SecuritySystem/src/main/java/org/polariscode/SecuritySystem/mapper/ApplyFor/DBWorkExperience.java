package org.polariscode.SecuritySystem.mapper.ApplyFor;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.ApplyFor.WorkExperience;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

//工作经历表
public interface DBWorkExperience {
	//获取工作经历表
	@Select("select * from WorkExperience\n"
		+"limit #{startIndex}, #{rowCount}")
	List<WorkExperience> getAllWorkExperience(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	//获取所有工作经历条数
	@Select("select Count(*) Count from  WorkExperience")
	Table getWorkCount();

	//根据Id获取工作经历
	@Select("select * from WorkExperience \n"
		+"where Id=#{id}")
	WorkExperience getWorkById(@Param("id") int id);

	//根据员工编号获取工作经历
	@Select("select * from WorkExperience \n"
		+"where Eid=#{eid}")
	List<WorkExperience> getWorkByEid(@Param("eid") int eid);

	@Insert("INSERT INTO workexperience\n"
		+"(Eid, Company, Phone, \n"
		+"BeiginDate, EndDate, Position, \n"
		+"salary, Witness, WitnessPhone, \n"
		+"LeavingReasons) \n"
		+"VALUES (#{work.Eid}, #{work.Company}, #{work.Phone}, \n"
		+"#{work.BeiginDate}, #{work.EndDate}, #{work.Position}, \n"
		+"#{work.salary}, #{work.Witness}, #{work.WitnessPhone},\n"
		+"#{work.LeavingReasons})")
	void InsertWorkExperience(@Param("work") WorkExperience work);

	@Update("UPDATE workexperience \n"
		+"SET  Company = #{work.Company}, Phone = #{work.Phone}, \n"
		+"BeiginDate = #{work.BeiginDate}, EndDate = #{work.EndDate}, Position = #{work.Position}, \n"
		+"salary = #{work.salary}, Witness = #{work.Witness}, WitnessPhone = #{work.WitnessPhone}, \n"
		+"LeavingReasons = #{work.LeavingReasons}\n"
		+"WHERE Id = #{work.Id}")
	void UpdateWorkExperience(@Param("work") WorkExperience work);

	@Delete("delete from WorkExperience\n"
		+"where Id=#{id}")
	void DeleteWorkExperience(@Param("id") int id);

	//根据Eid查询工作经历信息
	@Select("select Count(*) Count from WorkExperience \n"
		+"where Eid=#{eid}")
	Table getCountByEid(@Param("eid") int eid);

}
