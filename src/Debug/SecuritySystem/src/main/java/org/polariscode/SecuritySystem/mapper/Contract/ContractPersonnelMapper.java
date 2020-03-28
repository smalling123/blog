package org.polariscode.SecuritySystem.mapper.Contract;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Contract.ContractPersonnel;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface ContractPersonnelMapper {
	@Select("select * from ContractPersonnel where ContractID=#{ContractID} and isdelete=0\n"
		+"limit #{startIndex}, #{rowCount}")
	List<ContractPersonnel> getContractPersonnelByContractID(@Param("ContractID") int ContractID, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	@Select("select * from ContractPersonnel where ID=#{id} and isdelete=0")
	ContractPersonnel getContractPersonnelById(@Param("id") int id);

	@Select("select count(*) Count from ContractPersonnel where ContractID=#{ContractID} and isdelete=0")
	Table getContractPersonnelByCount(@Param("ContractID") int ContractID);

	@Insert("Insert Into ContractPersonnel(ContractId, Post, Demand, PNumber, Describes,\n"
		+" CreateUser, CreateTime)\n"
		+" Values(#{contractpersonnel.ContractId}, #{contractpersonnel.Post}, #{contractpersonnel.Demand},\n"
		+" #{contractpersonnel.PNumber}, #{contractpersonnel.Describes}, \n"
		+"#{contractpersonnel.CreateUser}, Now())")
	void insertContractPersonnel(@Param("contractpersonnel") ContractPersonnel contractpersonnel);

	@Update("Update ContractPersonnel Set\n"
		+"	ContractId = #{contractpersonnel.ContractId},\n"
		+"	Post = #{contractpersonnel.Post},\n"
		+"	Demand = #{contractpersonnel.Demand},\n"
		+"	PNumber = #{contractpersonnel.PNumber},\n"
		+"	Describes = #{contractpersonnel.Describes},\n"
		+"	ModifyUser = #{contractpersonnel.CreateUser},\n"
		+"	ModifyTime = Now()\n"
		+" Where ID = #{contractpersonnel.ID}")
	void updateContractPersonnel(@Param("contractpersonnel") ContractPersonnel contractpersonnel);

}
