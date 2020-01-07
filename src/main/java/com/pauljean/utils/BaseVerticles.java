package com.pauljean.utils;

import java.util.Properties;

import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public abstract class BaseVerticles extends AbstractVerticle {
	
	public Properties getProperties() {

		Properties prop = new Properties();

		return prop;
	}

	public ConfigRetrieverOptions getConfig() {

		ConfigRetrieverOptions configOption = new ConfigRetrieverOptions();

		return configOption;
	}
	
	public static Future<?> createFuture(Vertx vertx, AbstractVerticle verticle, JsonObject config) {
		
		Promise<?> promise = Promise.promise();
		DeploymentOptions options = new DeploymentOptions().setConfig(config).setInstances(1);
		vertx.deployVerticle(verticle, options, r -> {
			if (r.succeeded()) {
				promise.complete();
			} else {
				promise.fail(r.cause());
			}
		});
		return promise.future();
	}

}
