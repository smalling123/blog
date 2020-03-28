package org.polariscode.SecuritySystem.mapper.ApplyFor;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.ApplyFor.ProcessNode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.polariscode.SecuritySystem.model.Table;

//流程节点表
public interface DBProcessNode {
	//查询流程节点表
	@Select("select * from ProcessNode\n"
		+"limit #{startIndex}, #{rowCount}")
	List<ProcessNode> getAllProcessNode(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	//根据Id获取流程节点
	@Select("select * from ProcessNode\n"
		+"where Id =#{id}")
	ProcessNode getProcessNodeById(@Param("id") int id);

	//添加流程节点
	@Insert("INSERT INTO processnode\n"
		+"(ProcessName, ProcessNode, \n"
		+"ProcessNo, ProcessRole, `Order`) \n"
		+"VALUES (#{pro.ProcessName}, #{pro.ProcessNode}, \n"
		+"#{pro.ProcessNo}, #{pro.ProcessRole}, #{pro.Order})")
	void InsertProcessNode(@Param("pro") ProcessNode pro);

	//修改流程节点
	@Update("UPDATE processnode \n"
		+"SET ProcessName = #{pro.ProcessName}, ProcessNode = #{pro.ProcessNode}, \n"
		+"ProcessNo = #{pro.ProcessNo}, ProcessRole = #{pro.ProcessRole}, `Order` = #{pro.Order}\n"
		+"WHERE Id = #{pro.Id}")
	void UpdateProcessNode(@Param("pro") ProcessNode pro);

	//删除流程节点
	@Delete("DELETE FROM ProcessNode\n"
		+"WHERE Id=#{id}")
	void DeleteProcessNode(@Param("id") int id);

	//获取流程为0且序号为1的数据
	@Select("select * from ProcessNode where ProcessNo='0' and `Order`='1'")
	ProcessNode getProcessNodeToList();

	@Select("select max(ProcessNo) max from processnode")
	@Results({
		@Result(property = "ID", column = "max")
	})
	Table getMax();

	//查询角色所对节点
	@Select("Select processnode.*\n"
		+"From User Join UserRole on User.ID = UserRole.UserID\n"
		+"		Join OrgRole on UserRole.OrgRoleID = OrgRole.ID\n"
		+"		Join Org on Org.ID = OrgRole.OrgID\n"
		+"		Join Role on Role.ID = OrgRole.RoleID\n"
		+"	  Join processnode on role.Name=processnode.ProcessRole\n"
		+"	  where User.LoginName=#{name} and ProcessNode.ProcessNo=#{processno}")
	ProcessNode getUserProcessNode(@Param("name") String name, @Param("processno") int processno);

	@Select("select distinct ProcessNode  from processnode where ProcessNo=#{processno}")
	ProcessNode getProcessNode(@Param("processno") int processno);

}
