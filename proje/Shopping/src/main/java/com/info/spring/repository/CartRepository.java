package com.info.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.info.spring.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {

}
