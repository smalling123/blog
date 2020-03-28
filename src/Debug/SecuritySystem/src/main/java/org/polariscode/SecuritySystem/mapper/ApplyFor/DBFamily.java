package org.polariscode.SecuritySystem.mapper.ApplyFor;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.ApplyFor.Family;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

//家庭成员
public interface DBFamily {
	//获取家庭成员
	@Select("select * from Family\n"
		+"limit #{startIndex}, #{rowCount}")
	List<Family> getAllFamily(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	//获取所有家庭信息的总数
	@Select("select Count(*) Count from  Family")
	Table getFamilyCount();

	//根据Id查询家庭信息
	@Select("select * from Family where Id=#{id}")
	Family getFamilyById(@Param("id") int id);

	//根据用户编号查询家庭信息
	@Select("select * from Family where Eid=#{eid}")
	List<Family> getFamilyByEid(@Param("eid") int eid);

	//添加家庭信息
	@Insert("INSERT INTO family\n"
		+"(Eid, Appellation, Name,  \n"
		+"Age, Company, Phone) \n"
		+"VALUES (#{family.Eid}, #{family.Appellation}, #{family.Name}, \n"
		+"#{family.Age}, #{family.Company}, #{family.Phone})")
	void InsertFamily(@Param("family") Family family);

	//修改家庭信息
	@Update("UPDATE family \n"
		+"SET Eid = #{family.Eid}, Appellation = #{family.Appellation}, Name = #{family.Name}, \n"
		+"Age = #{family.Age}, Company = #{family.Company}, Phone = #{family.Phone}\n"
		+"WHERE Id = #{family.Id}")
	void UpdateFamily(@Param("family") Family family);

	//删除家庭信息
	@Delete("delete from Family\n"
		+"where Id =#{id}")
	void DeleteFamily(@Param("id") int id);

	//根据Eid查询家庭信息条数
	@Select("select Count(*) Count from Family where Eid=#{eid}")
	Table getCountByEid(@Param("eid") int eid);

}
