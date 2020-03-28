package org.polariscode.SecuritySystem.mapper.ApplyFor;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.ApplyFor.EducationalTraining;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

//教育培训记录表
public interface DBEducationalTraining {
	//获取所有教育经历
	@Select("select * from EducationalTrainingRecords\n"
		+"limit #{startIndex}, #{rowCount}")
	List<EducationalTraining> getAllEducational(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	//获取教育记录总条数
	@Select("select Count(*) Count from  EducationalTrainingRecords")
	Table getEducationalCount();

	//根据Id获取教育记录信息
	@Select("select * from EducationalTrainingRecords where Id=#{id}")
	EducationalTraining getEducationalById(@Param("id") int id);

	//根据EId获取教育记录信息
	@Select("select * from EducationalTrainingRecords where Eid=#{eid}")
	List<EducationalTraining> getEducationalByEId(@Param("eid") int eid);

	//添加教育信息
	@Insert("INSERT INTO educationaltrainingrecords\n"
		+"(Eid, Education, BeiginDate, EndDate,\n"
		+"School, Department, Certificate) \n"
		+"VALUES (#{educational.Eid},#{educational.Education}, #{educational.BeiginDate}, #{educational.EndDate}, \n"
		+"#{educational.School}, #{educational.Department}, #{educational.Certificate})")
	void InsertEducational(@Param("educational") EducationalTraining educational);

	//修改教育信息
	@Update("UPDATE educationaltrainingrecords \n"
		+"SET  Education = #{educational.Education}, BeiginDate = #{educational.BeiginDate}, \n"
		+"EndDate = #{educational.EndDate}, School = #{educational.School}, Department = #{educational.Department}, \n"
		+"Certificate = #{educational.Certificate }\n"
		+"WHERE Id = #{educational.Id }")
	void UpdateEducational(@Param("educational") EducationalTraining educational);

	//删除教育信息
	@Delete("delete from EducationalTrainingRecords\n"
		+"where Id=#{id}")
	void DeleteEducational(@Param("id") int id);

	//根据Eid获取教育条数
	@Select("select Count(*) Count from EducationalTrainingRecords where Eid=#{eid}")
	Table getCountByEid(@Param("eid") int eid);

}
