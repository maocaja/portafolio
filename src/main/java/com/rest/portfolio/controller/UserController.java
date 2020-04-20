package com.rest.portfolio.controller;

import com.rest.portfolio.exception.ResourceNotFoundException;
import com.rest.portfolio.model.Portfolio;
import com.rest.portfolio.repository.PortfolioRepository;
import com.rest.portfolio.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import twitter4j.Status;

import java.util.List;


@Controller
public class UserController
{
	private final int TWEETS_NUMBER = 5;
	@Autowired
	private TwitterService twitterService;
	@Autowired
	private PortfolioRepository portfolioRepository;

	@RequestMapping(value = { "", "user/{id}" })
	public String printHome(@PathVariable(value = "id") Long idPortfolio, ModelMap model) throws ResourceNotFoundException
	{
		try
		{
			Portfolio portfolio = portfolioRepository.findById(idPortfolio)
					.orElseThrow(() -> new ResourceNotFoundException("portfolio not found on :: " + idPortfolio));

			List<Status> tweets = twitterService.getTweetByUser(portfolio.getTwitterUserName(), TWEETS_NUMBER);
			model.addAttribute("tweets", tweets);
			model.addAttribute("portfolio", portfolio);

		}catch (Exception e){
			System.out.println("portfolio not found ");
		}
		return "user";
	}
}