package com.pauljean.utils;

import com.pauljean.constant.ConstantService;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.MessageConsumer;

public abstract class EventDispatcher extends AbstractVerticle {

	public void sendOnBus(String msg) {

		vertx.eventBus().send(ConstantService.SENDER_ADRESS_SERVICE, msg);
	}

	public MessageConsumer<Object> consumeOnBus() {
		
		return vertx.eventBus().consumer(ConstantService.CONSUMER_ADRESS_SERVICE);

	}

}
