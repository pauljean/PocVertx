package com.pauljean.service;

import com.pauljean.constant.RouteConstant;
import com.pauljean.utils.BaseVerticles;

import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class VerticleService extends BaseVerticles{
	
	
	Logger logger = LoggerFactory.getLogger(VerticleService.class);

	@Override
	public void start(Future<Void> future) throws Exception {

		logger.info("Start LoginVerticle ...");
		
		EventBus loginBusConsummer= vertx.eventBus();
		
		MessageConsumer<String> message=loginBusConsummer.consumer(RouteConstant.ROUTE_LOGIN);
		
		message.handler(msg ->{
			
			logger.info("-----------------------------------------------message from loginBus ", msg.body());
			logger.info(msg.body());
			
			msg.reply("longin service Hello from login bus !!!");
			
		});
					

	}

}
