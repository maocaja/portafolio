package com.rest.portfolio.service;


import com.rest.portfolio.model.Portfolio;

import java.util.List;
import java.util.Optional;


public interface PortfolioService
{
	public List<Portfolio> findAll();

	public Optional<Portfolio> findById(Long id);

	public Portfolio save(Portfolio stock);

	public void deleteById(Long id);
}