package com.pauljean;

import com.pauljean.controller.MyFirstVertxController;

import io.vertx.core.Vertx;

public class MainVertx {
	
	
	public static void main(String ...strings) {
		
		Vertx vertx= Vertx.vertx();
		
		vertx.deployVerticle(new MyFirstVertxController());
		
	}

}
