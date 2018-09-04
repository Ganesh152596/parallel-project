package com.cg.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capstore.bean.ProductBean;

public interface IProductRepo extends JpaRepository<ProductBean	, String> {
	@Query("select e.productId,e.productName,e.price,e.quantity from ProductBean e where e.productId=(:id)")
	public ProductBean findProductByProductId(@Param(value="id") List<ProductBean> id);
	
	@Query("select e from ProductBean e ")
	public List<ProductBean> productList();
}
