package com.rest.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "portfolio", schema = "targetSchemaName")
public class Portfolio
{
	@Id
	@GeneratedValue
	@Column(name = "idportfolio")
	private Long idPortfolio;

	@Column(name = "image_url")
	private String imageUrl;

	private String title;

	private String description;

	@Column(name = "twitter_user_name")
	private String twitterUserName;

	public Portfolio()
	{
		super();
	}

	public Portfolio(@NotBlank final String imageUrl, @NotBlank final String title,
			@NotBlank final String description, @NotBlank final String twitterUserName)
	{
		super();
		this.imageUrl = imageUrl;
		this.title = title;
		this.description = description;
		this.twitterUserName = twitterUserName;
	}

	public Long getIdPortfolio()
	{
		return idPortfolio;
	}

	public void setIdPortfolio(final Long idPortfolio)
	{
		this.idPortfolio = idPortfolio;
	}

	public String getImageUrl()
	{
		return imageUrl;
	}

	public void setImageUrl(final String imageUrl)
	{
		this.imageUrl = imageUrl;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getTwitterUserName()
	{
		return twitterUserName;
	}

	public void setTwitterUserName(final String twitterUserName)
	{
		this.twitterUserName = twitterUserName;
	}
}