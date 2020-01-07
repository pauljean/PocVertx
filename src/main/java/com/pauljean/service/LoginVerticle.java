package com.pauljean.service;

import com.pauljean.utils.BaseVerticles;

import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class LoginVerticle extends BaseVerticles {

	Logger logger = LoggerFactory.getLogger(LoginVerticle.class);

	@Override
	public void start(Future<Void> future) throws Exception {

		logger.info("Start LoginVerticle ...");
		
		EventBus loginBusConsummer= vertx.eventBus();
		
		MessageConsumer<String> message=loginBusConsummer.consumer("LOGIN");
		
		message.handler(msg ->{
			
			logger.info("message from loginBus {}", msg);
			
			msg.reply("Hello from login bus !!!");
			
		});
		
		
		

	}

}
