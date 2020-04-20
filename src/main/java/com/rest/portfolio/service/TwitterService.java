package com.rest.portfolio.service;

import twitter4j.Status;

import java.util.List;


public interface TwitterService
{
	public List<Status> getAllTweetByUser(final String user);
	public List<Status> getTweetByUser(final String user, final int number);
}
