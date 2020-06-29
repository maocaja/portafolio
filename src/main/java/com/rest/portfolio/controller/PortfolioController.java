package com.rest.portfolio.controller;


import com.rest.portfolio.exception.ResourceNotFoundException;
import com.rest.portfolio.model.Portfolio;
import com.rest.portfolio.repository.PortfolioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
@AllArgsConstructor
public class PortfolioController
{
	@Autowired
	private final PortfolioRepository portfolioRepository;

	public PortfolioController(PortfolioRepository portfolioRepository) {
		this.portfolioRepository = portfolioRepository;
	}

	@GetMapping("/portfolios")
	public List<Portfolio> getAllNotes()
	{
		return portfolioRepository.findAll();
	}

	@RequestMapping(value = "/portfolio/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Portfolio> getPortfolioById(@PathVariable(value = "id") Long idPortfolio) throws
			ResourceNotFoundException
	{
		Portfolio portfolio = portfolioRepository.findById(idPortfolio)
				.orElseThrow(() -> new ResourceNotFoundException("portfolio not found on :: " + idPortfolio));

		return ResponseEntity.ok().body(portfolio);
	}

	@RequestMapping(value = "/portfolio", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createProfile(@RequestBody HashMap<String, Object> mapper)
	{
		String imageUrl = (String) mapper.get("imageUrl");
		String description = (String) mapper.get("description");
		String twitterUserName = (String) mapper.get("twitterUserName");
		String title = (String) mapper.get("title");

		Portfolio portfolio = new Portfolio(imageUrl, title, description, twitterUserName);

		portfolioRepository.save(portfolio);
		return new ResponseEntity("Success!", HttpStatus.CREATED);
	}

}