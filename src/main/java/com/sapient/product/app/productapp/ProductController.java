package com.sapient.product.app.productapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class ProductController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/getProducts", method = RequestMethod.GET, produces = "application/json")
	public List<Product> getProducts() {
		return createProductList();
	}

	@RequestMapping(value = "/getProducts/getPrice/{productcode}", method = RequestMethod.GET, produces = "application/json")
	@HystrixCommand(fallbackMethod = "productFallback", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") })
	public long getProductprice(@PathVariable String productcode) {
		return restTemplate.getForObject("http://35.224.4.67:80/getPrice/"+productcode, Long.class);
	}
	
	public long productFallback(@PathVariable String productcode) {
		return 0;
	}

	private List<Product> createProductList() {
		List<Product> proList = new ArrayList<>();

		Product product = new Product("Pro1", "Television", "Electronic", true);
		proList.add(product);

		product = new Product("Pro2", "Mobile", "Electronic", true);
		proList.add(product);

		product = new Product("Pro3", "Computer", "Electronic", true);
		proList.add(product);

		return proList;

	}

}
