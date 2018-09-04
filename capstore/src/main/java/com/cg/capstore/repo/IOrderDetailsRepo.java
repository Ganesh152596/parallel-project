package com.cg.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.capstore.bean.OrderBean;

@Repository
public interface IOrderDetailsRepo extends JpaRepository<OrderBean,String>{

	@Query("select e from OrderBean e where e.orderId=(:id)")
	public OrderBean findOrderByOrderId(@Param(value="id")OrderBean id);
}