package com.pauljean;

import io.vertx.core.Vertx;

public class MainVertx {

	public static void main(String[] args) {

		Vertx vertx = Vertx.vertx();

		vertx.deployVerticle(new InitVerticles());

	}

}
