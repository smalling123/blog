package org.polariscode.SecuritySystem.mapper.Base;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Base.Customer;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface CustomerMapper {
	@Select("<script>Select * From Customer\n"
		+"Where Name Like &apos;%${name}%&apos;\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='type == \"\"'></when>\n"
		+"<otherwise>And Type= #{type}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='status == \"\"'></when>\n"
		+"<otherwise>And Status = #{status}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='org == \"\"'></when>\n"
		+"<otherwise>And OrgID = #{org}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='orgid == 0'></when>\n"
		+"<otherwise>And OrgID = #{orgid}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"Order By convert(Name using gbk) collate gbk_chinese_ci\n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<Customer> getAllCustomers(@Param("name") String name, @Param("type") String type, @Param("status") String status, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount, @Param("org") String org, @Param("orgid") int orgid);

	@Select("<script>Select Count(1) As Count From Customer\n"
		+"Where Name Like &apos;%${name}%&apos;\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='type == \"\"'></when>\n"
		+"<otherwise>And Type= #{type}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='status == \"\"'></when>\n"
		+"<otherwise>And Status = #{status}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='org == \"\"'></when>\n"
		+"<otherwise>And OrgID = #{org}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='orgid == 0'></when>\n"
		+"<otherwise>And OrgID = #{orgid}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	Table getCustomerCount(@Param("name") String name, @Param("type") String type, @Param("status") String status, @Param("org") String org, @Param("orgid") int orgid);

	@Insert("Insert Into Customer(Name, OrgID, Manager, Leader, District, Address, Describes, Type, Status, CreateUser, CreateTime)\n"
		+" Values(#{customer.Name}, #{customer.OrgID}, #{customer.Manager}, #{customer.Leader}, #{customer.District}, #{customer.Address}, #{customer.Describes}, #{customer.Type}, #{customer.Status}, #{customer.CreateUser}, Now())")
	void insertCustomer(@Param("customer") Customer customer);

	@Update("Update Customer Set\n"
		+"	Name = #{customer.Name},\n"
		+"	OrgID = #{customer.OrgID},\n"
		+"	Manager = #{customer.Manager},\n"
		+"	Leader = #{customer.Leader},\n"
		+"	District = #{customer.District},\n"
		+"	Address = #{customer.Address},\n"
		+"	Describes = #{customer.Describes},\n"
		+"	Type = #{customer.Type},\n"
		+"	Status = #{customer.Status},\n"
		+"	Isdelete = #{customer.Isdelete},\n"
		+"	ModifyUser = #{customer.ModifyUser},\n"
		+"	ModifyTime = Now()\n"
		+" Where ID = #{customer.ID}")
	void updateCustomer(@Param("customer") Customer customer);

	@Select("Select * From Customer Where ID = #{id}")
	Customer getCustomerOne(@Param("id") int id);

}
