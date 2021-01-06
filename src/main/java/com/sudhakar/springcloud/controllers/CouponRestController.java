package com.sudhakar.springcloud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhakar.springcloud.model.Coupon;
import com.sudhakar.springcloud.repos.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
	
	@Autowired
	CouponRepo repo;
	
	@PostMapping("/coupons")
	public Coupon create(@RequestBody Coupon coupon) {
		return repo.save(coupon);
	}
	
	@GetMapping("/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		return repo.findByCode(code);		
	}
	
	@GetMapping("/coupons")
	public List<Coupon> getAllCoupons(){
		return repo.findAll();
	}
	
	@PostMapping("coupons/delete/{id}")	
	public void deleteCoupon(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}

}
