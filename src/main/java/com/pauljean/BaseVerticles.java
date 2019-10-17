package com.pauljean;

import java.util.Properties;

import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.core.AbstractVerticle;

public abstract class BaseVerticles extends AbstractVerticle {

	public Properties getProperties() {

		Properties prop = new Properties();

		return prop;
	}

	public ConfigRetrieverOptions getConfig() {

		ConfigRetrieverOptions configOption = new ConfigRetrieverOptions();

		return configOption;
	}

}
