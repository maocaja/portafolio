package com.rest.portfolio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


@Component
public class TwitterComponent
{
	@Value("${spring.social.twitter.appId}")
	private String consumerKey;

	@Value("${spring.social.twitter.appSecret}")
	private String consumerSecret;

	@Value("${twitter.access.token}")
	private String accessToken;

	@Value("${twitter.access.token.secret}")
	private String accessTokenSecret;


	public Twitter getTwitterComponent()
	{
		ConfigurationBuilder builder = getConfigurationBuilder();
		TwitterFactory twitterFactory = new TwitterFactory(builder.build());
		return twitterFactory.getInstance();
	}

	private ConfigurationBuilder getConfigurationBuilder()
	{
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setDebugEnabled(true)
				.setOAuthConsumerKey(consumerKey)
				.setOAuthConsumerSecret(consumerSecret)
				.setOAuthAccessToken(accessToken)
				.setOAuthAccessTokenSecret(accessTokenSecret);
		return builder;
	}
}
