package com.pauljean;

import java.util.ArrayList;
import java.util.List;

import com.pauljean.handler.LoginHandler;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class VerticleHttpServer extends AbstractVerticle {

	private static String BASE_ROUTE = "/poc-vertx";
	
	private LoginHandler loginHandler = new LoginHandler();

	Logger logger = LoggerFactory.getLogger(VerticleHttpServer.class);

	@Override
	public void start(Future<Void> future) throws Exception {

		logger.info(" Start VerticleServer ...");

		HttpServer serveur = vertx.createHttpServer();

		Router baseRouter = Router.router(vertx);

		baseRouter.route().handler(loginHandler);

		serveur.requestHandler(baseRouter).listen(7070);

		logger.info("Server starting at port 7070");		

	}
	

	protected void dispatcher(RoutingContext routingContext) {

		logger.info("in the dispatcher");

		HttpServerResponse httpResponse = routingContext.response();

		httpResponse
		.setStatusCode(200)
		.putHeader("content-type", "application/json; charset=utf-8")
		.end("reponse dispatcher ");
	}

}
