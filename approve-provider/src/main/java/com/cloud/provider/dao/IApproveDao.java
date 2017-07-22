package com.cloud.provider.dao;

import org.apache.ibatis.annotations.Param;

import com.cloud.provider.domain.Schedule;


public interface IApproveDao {

	public Schedule find(@Param("id") int id);
}
