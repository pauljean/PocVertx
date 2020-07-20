package com.pauljean;

import com.pauljean.handler.EventProxyHandler;
import com.pauljean.utils.BaseVerticles;

import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class VerticleHttpServer extends BaseVerticles {

	private static int PORT_NUMBER = 7070;

	private static String CONTEXT_PATH = "/poc-vertx/";

	private EventProxyHandler eventProxyHandler = new EventProxyHandler();

	Logger logger = LoggerFactory.getLogger(VerticleHttpServer.class);

	@Override
	public void start(Future<Void> future) throws Exception {

		logger.info(" Start VerticleServer ...");

		HttpServer serveur = vertx.createHttpServer();

		Router rootContext = Router.router(vertx);
		Router loginRoute = Router.router(vertx);

		loginRoute.get("/login").handler(eventProxyHandler);

		// http://localhost:7070/poc-vertx/login
		rootContext.mountSubRouter(CONTEXT_PATH, loginRoute);
		rootContext.route("/*").handler(this::notFound);

		logger.info("Server starting at port 7070");

		serveur.requestHandler(rootContext).listen(PORT_NUMBER);

	}

	protected void dispatcher(RoutingContext routingContext) {

		logger.info("in the dispatcher");

		HttpServerResponse httpResponse = routingContext.response();

		httpResponse.setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8")
				.end("reponse dispatcher ");
	}

	public void notFound(RoutingContext context) {
		context.response().setStatusCode(404).putHeader("content-type", "application/json").end("bad route");
	}

}
