package com.fiap.friendsecret;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.fiap.friendsecret.repository.WishRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;

@SpringBootApplication
@EnableScheduling
public class FriendSecretApplication {

	@Value("${telegram.token}")
	private String TOKEN;

	static TelegramBot bot;
	
	public static void main(String[] args) {
		SpringApplication.run(FriendSecretApplication.class, args);
	}

	@Bean
	public TelegramBot getbot() {
		if(bot == null) {
			bot = TelegramBotAdapter.build(TOKEN);
		}
			
		return bot;
	}
	
	@Bean
	public WishRepository getWishRepository() {
		return new WishRepository();
	}
}
