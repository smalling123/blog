package org.polariscode.SecuritySystem.mapper.Logistics;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Logistics.House;
import org.polariscode.SecuritySystem.model.Logistics.HouseContract;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface HouseMapper {
	@Select("<script>select * from House\n"
		+"where City like &apos;%${City}%&apos;\n"
		+"and Address like &apos;%${Address}%&apos;\n"
		+"\n"
		+"<choose>\n"
		+"<when test='org == 0'></when>\n"
		+"<otherwise>and orgid=#{org}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"\n"
		+"<choose>\n"
		+"<when test='site == 0'></when>\n"
		+"<otherwise>and siteid=#{site}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<House> getAllHouse(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount, @Param("City") String City, @Param("Address") String Address, @Param("org") int org, @Param("site") int site);

	@Select("select * from HouseContract\n"
		+"where HouseId=#{id}")
	List<HouseContract> getHouseContractById(@Param("id") int id);

	@Select("<script>select count(*) Count from House\n"
		+"where City like &apos;%${City}%&apos;\n"
		+"and Address like &apos;%${Address}%&apos;\n"
		+"\n"
		+"<choose>\n"
		+"<when test='org == 0'></when>\n"
		+"<otherwise>and orgid=#{org}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"\n"
		+"<choose>\n"
		+"<when test='site == 0'></when>\n"
		+"<otherwise>and siteid=#{site}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	Table getHouseByCount(@Param("City") String City, @Param("Address") String Address, @Param("org") int org, @Param("site") int site);

	@Select("Select * From House Where ID = #{id}")
	House getHouseOne(@Param("id") int id);

	@Insert("Insert Into House(City, OrgId, SiteId, Address, UserId, LinkMan, Phone, Rent, RentMonth, Deposit, PNumber, SNumber, Describes, CreateUser, CreateTime)\n"
		+" Values(#{house.City}, #{house.OrgId}, #{house.SiteId}, #{house.Address}, #{house.UserId}, #{house.LinkMan}, #{house.Phone}, #{house.Rent}, #{house.RentMonth}, #{house.Deposit}, #{house.PNumber}, #{house.SNumber}, #{house.Describes}, #{house.CreateUser}, Now())")
	void insertHouse(@Param("house") House house);

	@Update("Update House Set\n"
		+"	City = #{house.City},\n"
		+"	OrgId = #{house.OrgId},\n"
		+"	SiteId = #{house.SiteId},\n"
		+"	Address = #{house.Address},\n"
		+"	UserId = #{house.UserId},\n"
		+"	LinkMan = #{house.LinkMan},\n"
		+"	Phone = #{house.Phone},\n"
		+"	Rent = #{house.Rent},\n"
		+"	RentMonth = #{house.RentMonth},\n"
		+"	Deposit = #{house.Deposit},\n"
		+"	PNumber = #{house.PNumber},\n"
		+"	SNumber = #{house.SNumber},\n"
		+"	Describes = #{house.Describes},\n"
		+"	ModifyUser = #{house.CreateUser},\n"
		+"	ModifyTime = Now()\n"
		+"Where ID = #{house.ID}")
	void updateHouse(@Param("house") House house);

	@Select("Select * From HouseContract Where ID = #{id}")
	HouseContract getHouseContractOne(@Param("id") int id);

	@Insert("Insert Into HouseContract(HouseId, BeginDate, EndDate, Rent, RentMonth, Deposit, Describes)\n"
		+" Values(#{housecontract.HouseId}, #{housecontract.BeginDate}, #{housecontract.EndDate}, #{housecontract.Rent}, #{housecontract.RentMonth}, #{housecontract.Deposit}, #{housecontract.Describes})")
	void insertHouseContract(@Param("housecontract") HouseContract housecontract);

	@Update("Update HouseContract Set\n"
		+"	HouseId = #{housecontract.HouseId},\n"
		+"	BeginDate = #{housecontract.BeginDate},\n"
		+"	EndDate = #{housecontract.EndDate},\n"
		+"	Rent = #{housecontract.Rent},\n"
		+"	RentMonth = #{housecontract.RentMonth},\n"
		+"	Deposit = #{housecontract.Deposit},\n"
		+"	Describes = #{housecontract.Describes}\n"
		+" Where ID = #{housecontract.ID}")
	void updateHouseContract(@Param("housecontract") HouseContract housecontract);

}
