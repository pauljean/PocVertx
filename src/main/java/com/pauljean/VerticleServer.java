package com.pauljean;

import java.util.ArrayList;
import java.util.List;

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

public class VerticleServer extends AbstractVerticle {

	private static String BASE_ROUTE = "/poc-vertx";

	Logger logger = LoggerFactory.getLogger(VerticleServer.class);

	@Override
	public void start(Future<Void> future) throws Exception {

		logger.info(" Start VerticleServer ...");

		HttpServer serveur = vertx.createHttpServer();

		Router baseRouter = Router.router(vertx);
		Router subRouter = Router.router(vertx);

		baseRouter = baseRouter.mountSubRouter(BASE_ROUTE, subRouter);

		baseRouter.route().handler(this::dispatcher);

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
