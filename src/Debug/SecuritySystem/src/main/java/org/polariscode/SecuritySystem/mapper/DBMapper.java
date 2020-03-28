package org.polariscode.SecuritySystem.mapper;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Table;

public interface DBMapper {
	@Select("Select LAST_INSERT_ID() As ID")
	Table getTableID();

}
