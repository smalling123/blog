package org.polariscode.SecuritySystem.mapper.Contract;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Contract.ContractEquipment;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface ContractEquipmentMapper {
	@Select("select * from ContractEquipment where ContractID=#{ContractID}  and isdelete=0\n"
		+"limit #{startIndex}, #{rowCount}")
	List<ContractEquipment> getContractEquipmentByContractID(@Param("ContractID") int ContractID, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	@Select("select count(*) Count  from ContractEquipment where ContractID=#{ContractID}  and isdelete=0")
	Table getContractEquipmentByCount(@Param("ContractID") int ContractID);

	@Select("select * from ContractEquipment where id=#{id}  and isdelete=0")
	ContractEquipment getContractEquipmentById(@Param("id") int id);

	@Insert("Insert Into ContractEquipment(ContractId, Equipment, Qty, Describes, CreateUser, CreateTime)\n"
		+" Values(#{contractequipment.ContractId}, #{contractequipment.Equipment}, #{contractequipment.Qty}, #{contractequipment.Describes}, #{contractequipment.CreateUser}, Now())")
	void insertContractEquipment(@Param("contractequipment") ContractEquipment contractequipment);

	@Update("Update ContractEquipment Set\n"
		+"	ContractId = #{contractequipment.ContractId},\n"
		+"	Equipment = #{contractequipment.Equipment},\n"
		+"	Qty = #{contractequipment.Qty},\n"
		+"	Describes = #{contractequipment.Describes},\n"
		+"	ModifyUser = #{contractequipment.CreateUser},\n"
		+"	ModifyTime = Now()\n"
		+" Where ID = #{contractequipment.ID}")
	void updateContractEquipment(@Param("contractequipment") ContractEquipment contractequipment);

	@Select("select MAX(left(ContractCode, 8)) Count from contract WHERE ContractCode like CONCAT(YEAR(now()),'%')")
	List<Table> getMaxContractCode();

}
