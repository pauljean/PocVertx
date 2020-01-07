package com.pauljean.handler;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class HandlerReplyMessage implements Handler<AsyncResult<Message<String>>> {

	private RoutingContext routingContext;

	public HandlerReplyMessage(RoutingContext routingContext) {

		this.routingContext = routingContext;
	}

	@Override
	public void handle(AsyncResult<Message<String>> replyHandler) {
		HttpServerResponse httpResponse = routingContext.response();
		httpResponse
		.setStatusCode(200)
		.putHeader("content-type", "application/json; charset=utf-8")
		.end(replyHandler.result().body().toString());
		
	}

}
