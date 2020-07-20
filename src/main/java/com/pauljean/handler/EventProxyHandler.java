package com.pauljean.handler;

import io.vertx.core.Handler;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.RoutingContext;

public class EventProxyHandler implements Handler<RoutingContext> {

	Logger logger = LoggerFactory.getLogger(EventProxyHandler.class);

	@Override
	public void handle(RoutingContext routingContext) {

		logger.info("********************");
		logger.info(routingContext);

		logger.info("---------LoginHandler----------");

		logger.info("---------LoginHandler----------  !!");
		logger.info(routingContext.currentRoute().getPath());

		logger.info(routingContext.getBodyAsJson());

		HandlerReplyMessage handlerReplyMessage = new HandlerReplyMessage(routingContext);

		EventBus loginBus = routingContext.vertx().eventBus();

		loginBus.request(routingContext.currentRoute().getPath(), "send new message  from event proxy !!!", handlerReplyMessage);

	}

}
