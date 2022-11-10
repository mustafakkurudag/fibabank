package com.info.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.info.spring.entity.CartProduct;

public interface CartProductRepository extends CrudRepository<CartProduct, Long> {
	
	@Query(value = "SELECT p.sales_price FROM Product p WHERE p.product_id= :cart_product_id", nativeQuery = true)
	double findSalesPriceByProductId(@Param("cart_product_id") long product_id);
	
	@Query(value = "SELECT p.product_name FROM Product p WHERE p.product_id= :cart_product_id", nativeQuery = true)
	String findProductNameByProductId(@Param("cart_product_id") long product_id);
	
	@Modifying
	@Query("UPDATE CartProduct SET sales_quantity = sales_quantity + 1 WHERE cart_product_id= :cartProductId")
	void updateSalesQuantityByCartProductId(@Param("cartProductId") long cart_product_id);
}
