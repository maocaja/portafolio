package com.rest.portfolio.service.impl;

import com.rest.portfolio.config.TwitterComponent;
import com.rest.portfolio.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;


@Service
public class DefaultTwitterService implements TwitterService
{
	@Autowired
	private TwitterComponent twitterComponent;

	@Override
	public List<Status> getAllTweetByUser(final String user)
	{
		try
		{
			Twitter twitter = twitterComponent.getTwitterComponent();
			List<Status> tweets = twitter.getUserTimeline(user);
			return twitter.getUserTimeline(user);
		}
		catch (TwitterException te)
		{
			return new ArrayList<Status>();
		}
	}

	@Override
	public List<Status> getTweetByUser(final String user, final int number)
	{
		try
		{
			Twitter twitter = twitterComponent.getTwitterComponent();
			List<Status> tweets = twitter.getUserTimeline(user).subList(0, number);
			return tweets;
		}
		catch (TwitterException te)
		{
			return new ArrayList<Status>();
		}
	}

}
