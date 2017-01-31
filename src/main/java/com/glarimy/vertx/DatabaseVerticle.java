package com.glarimy.vertx;

import java.util.ArrayList;
import java.util.List;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.Json;

public class DatabaseVerticle extends AbstractVerticle {
	@Override
	public void start() throws Exception {
		vertx.eventBus().consumer("com.glarimy.vertx.dictionary", message -> {
			String word = message.body().toString();
			System.out.println(word);
			List<String> synonyms = new ArrayList<>();
			synonyms.add("s1");
			synonyms.add("s2");
			Entry entry = new Entry(word, word + "meaning", synonyms);
			message.reply(Json.encodePrettily(entry));
		});
	}
}
