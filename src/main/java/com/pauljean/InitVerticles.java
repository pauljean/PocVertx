package com.pauljean;

import java.util.ArrayList;
import java.util.List;

import com.pauljean.utils.BaseVerticles;

import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class InitVerticles extends BaseVerticles {

	Logger logger = LoggerFactory.getLogger(InitVerticles.class);

	@Override
	public void start(Promise<Void> promise) throws Exception {
		
		List<Future> futures= new ArrayList();
		
		futures.add(createFuture(vertx, new VerticleServer(), null));
		
        CompositeFuture.all(futures).setHandler(r->{
            if(r.succeeded()){
                logger.info("Application well loaded");
                promise.complete();
            }else{
            	
            	promise.fail(r.cause());

                logger.error("Impossible to start",r.cause());
            }
        });				

	}

}
