package com.cloud.cloudtest.dao;

import org.apache.ibatis.annotations.Param;

import com.cloud.cloudtest.domain.Schedule;

public interface IApproveDao {

	public Schedule find(@Param("id") int id);
}
