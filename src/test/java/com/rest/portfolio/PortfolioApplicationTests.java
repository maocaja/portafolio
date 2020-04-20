package com.rest.portfolio;

import com.rest.portfolio.model.Portfolio;
import com.rest.portfolio.repository.PortfolioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;


@SpringBootTest
class PortfolioApplicationTests
{

	@Autowired
	private PortfolioRepository portfolioRepository;

	@Test
	public void findPortfolioAfterSave()
	{

		Portfolio portfolioOne = createPorfolio();
		portfolioRepository.save(portfolioOne);
		Portfolio portfolioTwo = searchPortfolio(portfolioOne);
		assertEquals(portfolioOne.getImageUrl(), portfolioTwo.getImageUrl());
		assertEquals(portfolioOne.getTitle(), portfolioTwo.getTitle());
		assertEquals(portfolioOne.getDescription(), portfolioTwo.getDescription());
		assertEquals(portfolioOne.getTwitterUserName(), portfolioTwo.getTwitterUserName());
		portfolioRepository.delete(portfolioOne);
	}

	private Portfolio searchPortfolio(final Portfolio portfolioOne)
	{
		List<Portfolio> portfolios = portfolioRepository.findAll();
		return portfolios.stream()
				.filter(portfolio -> portfolioOne.getTwitterUserName().equals(portfolio.getTwitterUserName()))
				.findAny()
				.orElse(null);
	}

	private Portfolio createPorfolio()
	{
		String imageUrl = "https://i1.wp.com/diariolalibertad.com/sitio/wp-content/uploads/2019/07/Nairo-Quintana-ciclista-colombiano-1.jpg?fit=630%2C354&ssl=1";
		String title = "Sr";
		String description = " ciclista de ruta colombiano, profesional desde 2009 y actual miembro del equipo francés Arkéa Samsic, de categoría UCI ProTeam";
		String twitterUserName = "nairoQuinCol";
		return new Portfolio(imageUrl, title, description, twitterUserName);
	}

}
