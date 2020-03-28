package org.polariscode.SecuritySystem.mapper.Finance;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Finance.Pay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.polariscode.SecuritySystem.model.Table;

public interface PayMapper {
	@Select("select * from Pay where CustomerId=#{CustomerId}\n"
		+"limit #{startIndex}, #{rowCount}")
	List<Pay> getPayByCustomerId(@Param("CustomerId") int CustomerId, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	@Insert("Insert Into Pay(Date, BankNo, CustomerId, Amt, Status, Describes, CreateUser, CreateTime, ClaimUser, ClaimTime, CheckUser, CheckTime)\n"
		+" Values(#{pay.Date}, #{pay.BankNo}, #{pay.CustomerId}, #{pay.Amt}, #{pay.Status}, #{pay.Describes}, #{pay.CreateUser}, #{pay.CreateTime}, #{pay.ClaimUser}, #{pay.ClaimTime}, #{pay.CheckUser}, #{pay.CheckTime})")
	void insertPay(@Param("pay") Pay pay);

	@Update("Update Pay Set\n"
		+"	Date = #{pay.Date},\n"
		+"	BankNo = #{pay.BankNo},\n"
		+"	CustomerId = #{pay.CustomerId},\n"
		+"	Amt = #{pay.Amt},\n"
		+"	Status = #{pay.Status},\n"
		+"	Describes = #{pay.Describes},\n"
		+"	CreateUser = #{pay.CreateUser},\n"
		+"	CreateTime = #{pay.CreateTime},\n"
		+"	ClaimUser = #{pay.ClaimUser},\n"
		+"	ClaimTime = #{pay.ClaimTime},\n"
		+"	CheckUser = #{pay.CheckUser},\n"
		+"	CheckTime = #{pay.CheckTime}\n"
		+" Where ID = #{pay.ID}")
	void updatePay(@Param("pay") Pay pay);

	@Select("select Count(*) Count from Pay where CustomerId=#{CustomerId}")
	Table getPayByCount(@Param("CustomerId") int CustomerId);

	@Select("select * from Pay where id=#{id}")
	Pay getPayById(@Param("id") int id);

}
