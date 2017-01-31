package com.glarimy.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

public class DictionaryVerticle extends AbstractVerticle {
	@Override
	public void start(Future<Void> future) throws Exception {
		System.out.println("starting...");
		Router router = Router.router(vertx);
		vertx.deployVerticle("com.glarimy.vertx.DatabaseVerticle", new DeploymentOptions().setWorker(true));
		router.route("/static/*").handler(StaticHandler.create("web"));
		router.get("/api/dictionary/:word").handler(rctx -> {
			System.out.println("word: " + rctx.request().getParam("word"));
			String word = rctx.request().getParam("word");
			vertx.eventBus().send("com.glarimy.vertx.dictionary", word, r -> {
				System.out.println(r.result().body());
				rctx.response().setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8")
						.end(r.result().body().toString());

			});
		});

		vertx.createHttpServer().requestHandler(router::accept).listen(config().getInteger("http.port", 8080),
				result -> {
					if (result.succeeded()) {
						future.complete();
					} else {
						future.fail(result.cause());
					}
				});
	}

	@Override
	public void stop() throws Exception {
		System.out.println("stopping...");
		super.stop();
	}
}
