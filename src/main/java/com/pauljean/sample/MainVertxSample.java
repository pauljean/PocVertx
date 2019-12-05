package com.pauljean.sample;

import com.pauljean.sample.controller.MyFirstVertxController;

import io.vertx.core.Vertx;

public class MainVertxSample {
	
	
	public static void main(String ...strings) {
		
		Vertx vertx= Vertx.vertx();
		
		vertx.deployVerticle(new MyFirstVertxController());
		
	}

}
