package org.polariscode.SecuritySystem.mapper.SiteManage;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Base.SitePersonnel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface SitePersonnelMapper {
	//获取主岗信息
	@Select("Select  *\n"
		+"From SitePersonnel\n"
		+"Where pid = #{pid} and IsMain = 1 and EndDate is null")
	SitePersonnel getMainSitePersonnel(@Param("pid") int pid);

	//获取个人的调动记录
	@Select("Select *\n"
		+"From SitePersonnel\n"
		+"Where PID = #{pid}")
	List<SitePersonnel> getSitePersonnelByPID(@Param("pid") int pid);

	@Insert("Insert Into SitePersonnel(SiteId, PID, BeginDate, EndDate, IsMain, Job, Level, PostSubsidy, CreateUser, CreateTime)\n"
		+" Values(#{sitepersonnel.SiteId}, #{sitepersonnel.PID}, #{sitepersonnel.BeginDate}, #{sitepersonnel.EndDate}, #{sitepersonnel.IsMain}, #{sitepersonnel.Job}, #{sitepersonnel.Level}, #{sitepersonnel.PostSubsidy}, #{user}, now())")
	void insertSitePersonnel(@Param("sitepersonnel") SitePersonnel sitepersonnel, @Param("user") String user);

	@Update("Update SitePersonnel Set\n"
		+"	EndDate = #{sitepersonnel.EndDate},\n"
		+"	Job = #{sitepersonnel.Job},\n"
		+"	Level = #{sitepersonnel.Level},\n"
		+"	PostSubsidy = #{sitepersonnel.PostSubsidy}\n"
		+" Where ID = #{sitepersonnel.ID}")
	void updateSitePersonnel(@Param("sitepersonnel") SitePersonnel sitepersonnel);

	//根据ID获取调动记录
	@Select("Select  *\n"
		+"From SitePersonnel\n"
		+"Where id = #{id}")
	SitePersonnel getSitePersonnelById(@Param("id") int id);

}
