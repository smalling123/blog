package org.polariscode.SecuritySystem.mapper.System;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.System.Bug;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

//Bug信息
public interface BugMapper {
	//查询BUG
	@Select("<script>select * from Bug\n"
		+"where Handler LIKE &apos;%${handler}%&apos; \n"
		+"and ModuleName LIKE &apos;%${modulename}%&apos; \n"
		+"and Question LIKE &apos;%${question}%&apos;\n"
		+"\n"
		+"<choose>\n"
		+"<when test='type == \"\"'></when>\n"
		+"<otherwise>and Type=#{type}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"\n"
		+"<choose>\n"
		+"<when test='level == \"\"'></when>\n"
		+"<otherwise>and Level=#{level}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"\n"
		+"<choose>\n"
		+"<when test='status == \"\"'></when>\n"
		+"<otherwise>and Status=#{status}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<Bug> getBug(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount, @Param("handler") String handler, @Param("modulename") String modulename, @Param("question") String question, @Param("type") String type, @Param("level") String level, @Param("status") String status);

	//根据ID查询Bug信息
	@Select("select * from Bug where ID=#{id}")
	Bug getBugById(@Param("id") int id);

	//查询BUG
	@Select("<script>select count(1) As Count\n"
		+"from Bug\n"
		+"where Handler LIKE &apos;%${handler}%&apos; \n"
		+"and ModuleName LIKE &apos;%${modulename}%&apos; \n"
		+"and Question LIKE &apos;%${question}%&apos;\n"
		+"\n"
		+"<choose>\n"
		+"<when test='type == \"\"'></when>\n"
		+"<otherwise>and Type=#{type}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"\n"
		+"<choose>\n"
		+"<when test='level == \"\"'></when>\n"
		+"<otherwise>and Level=#{level}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"\n"
		+"<choose>\n"
		+"<when test='status == \"\"'></when>\n"
		+"<otherwise>and Status=#{status}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	Table getBugCount(@Param("handler") String handler, @Param("modulename") String modulename, @Param("question") String question, @Param("type") String type, @Param("level") String level, @Param("status") String status);

	@Insert("Insert Into Bug(ModuleName, Question, Type, Level, Finder, FindDate, Handler, EndTime, Status, Description)\n"
		+" Values(#{bug.ModuleName}, #{bug.Question}, #{bug.Type}, #{bug.Level}, #{bug.Finder}, #{bug.FindDate}, #{bug.Handler}, #{bug.EndTime}, #{bug.Status}, #{bug.Description})")
	void insertBug(@Param("bug") Bug bug);

	@Update("Update Bug Set\n"
		+"	ModuleName = #{bug.ModuleName},\n"
		+"	Question = #{bug.Question},\n"
		+"	Type = #{bug.Type},\n"
		+"	Level = #{bug.Level},\n"
		+"	Finder = #{bug.Finder},\n"
		+"	FindDate = #{bug.FindDate},\n"
		+"	Handler = #{bug.Handler},\n"
		+"	EndTime = #{bug.EndTime},\n"
		+"	Status = #{bug.Status},\n"
		+"	Description = #{bug.Description}\n"
		+" Where ID = #{bug.ID}")
	void updateBug(@Param("bug") Bug bug);

}
