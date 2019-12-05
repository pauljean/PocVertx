package com.pauljean.sample.controller;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;

public class MyFirstVertxController extends AbstractVerticle {

	Logger logger = LoggerFactory.getLogger(MyFirstVertxController.class);

	public void start(Future<Void> future) {

		logger.info(" welcome verticle");

		HttpServer serveur = vertx.createHttpServer();

		Router router = Router.router(vertx);
		router.route().handler(RoutingContext -> {

			HttpServerResponse reponse = RoutingContext.response();
			reponse.putHeader("content-type", "text/plan");

			logger.info(" hello from route !!!");
			reponse.end("Hello World from VertX !!!");

		});

		serveur.requestHandler(router).listen(7071);
	}

}
