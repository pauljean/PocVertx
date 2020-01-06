package com.pauljean.handler;

import io.vertx.core.Handler;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.RoutingContext;

public class LoginHandler implements Handler<RoutingContext>{
	
	Logger logger =LoggerFactory.getLogger(LoginHandler.class);

	@Override
	public void handle(RoutingContext event) {
		
		logger.info("---------LoginHandler----------");
		
		logger.debug(event.getBodyAsJson());
		
		
		
	}

}
