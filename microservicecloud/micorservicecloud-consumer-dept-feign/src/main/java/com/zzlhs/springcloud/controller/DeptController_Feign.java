package com.zzlhs.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zzlhs.springcloud.entities.Account;
import com.zzlhs.springcloud.entities.Dept;
import com.zzlhs.springcloud.service.AccountService;
import com.zzlhs.springcloud.service.DeptClientService;

@RestController
public class DeptController_Feign {
	
	@Autowired
	private DeptClientService service;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/transferT")
	public void test1() {
		accountService.serviceA();
	}
	
	@GetMapping("/transferF")
	public void test2() {
		accountService.serviceB();
	}
	
	@GetMapping("/transferNotTran")
	public void test3() {
		accountService.serviceNotTransactional();
	}
	
	
	
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		return this.service.add(dept);
	}
	
	@RequestMapping(value="/consumer/dept/get/{id}",method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return this.service.get(id);
	}
	
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list(){
		return this.service.list();
	}
	
	
}
