package com.pauljean.handler;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.RoutingContext;

public class LoginHandler implements Handler<RoutingContext>{
	
	Logger logger =LoggerFactory.getLogger(LoginHandler.class);

	@Override
	public void handle(RoutingContext routingContext) {
		
		logger.info("---------LoginHandler----------");
		
		logger.debug(routingContext.getBodyAsJson());
		
		HandlerReplyMessage handlerReplyMessage= new HandlerReplyMessage(routingContext);
	
		
		EventBus loginBus=routingContext.vertx().eventBus();
		
		loginBus.request("LOGIN", "Hello from login bus !!!", handlerReplyMessage);

	}
		
	

}
