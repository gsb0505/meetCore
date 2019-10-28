package com.kd.core.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * 终端某控制处理
 * @author zlm
 *
 */
public class NullIntHandler implements TypeHandler<Integer>{

	@Override
	public void setParameter(PreparedStatement ps, int i, Integer parameter,
			JdbcType jdbcType) throws SQLException {
		 if(parameter == 0 && jdbcType == JdbcType.INTEGER){
			 ps.setNull(i, JdbcType.INTEGER.TYPE_CODE);
        }else{
        	ps.setInt(i,parameter);
        }
	}

	@Override
	public Integer getResult(ResultSet rs, String columnName)
			throws SQLException {
		return rs.getInt(columnName);
	}

	@Override
	public Integer getResult(ResultSet rs, int columnIndex) throws SQLException {
		return rs.getInt(columnIndex);
	}

	@Override
	public Integer getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return cs.getInt(columnIndex);
	}
}
