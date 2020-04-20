package com.rest.portfolio.service.impl;

import com.rest.portfolio.model.Portfolio;
import com.rest.portfolio.repository.PortfolioRepository;
import com.rest.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DefaultPortfolioService implements PortfolioService
{
	private final PortfolioRepository portfolioRepository;

	public List<Portfolio> findAll()
	{
		return portfolioRepository.findAll();
	}

	public Optional<Portfolio> findById(Long id)
	{
		return portfolioRepository.findById(id);
	}

	public Portfolio save(Portfolio stock)
	{
		return portfolioRepository.save(stock);
	}

	public void deleteById(Long id)
	{
		portfolioRepository.deleteById(id);
	}
}
