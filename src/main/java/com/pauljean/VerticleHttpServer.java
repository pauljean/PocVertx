package com.pauljean;

import com.pauljean.handler.LoginHandler;
import com.pauljean.utils.BaseVerticles;

import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class VerticleHttpServer extends BaseVerticles {

	private static String CONTEXT_PATH = "/poc-vertx/*";

	private LoginHandler loginHandler = new LoginHandler();

	Logger logger = LoggerFactory.getLogger(VerticleHttpServer.class);

	@Override
	public void start(Future<Void> future) throws Exception {

		logger.info(" Start VerticleServer ...");

		HttpServer serveur = vertx.createHttpServer();

		Router rootContext = Router.router(vertx);
		Router loginRoute = Router.router(vertx);

		rootContext.route().path(CONTEXT_PATH);

		rootContext.mountSubRouter("/login", loginRoute).route().handler(loginHandler);

		serveur.requestHandler(rootContext).listen(7070);

		logger.info("Server starting at port 7070");

	}

	protected void dispatcher(RoutingContext routingContext) {

		logger.info("in the dispatcher");

		HttpServerResponse httpResponse = routingContext.response();

		httpResponse.setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8")
				.end("reponse dispatcher ");
	}

}
