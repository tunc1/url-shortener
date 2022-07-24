package app.service;

import org.springframework.stereotype.Service;
import app.entity.ShortenedURL;
import app.repository.ShortenedURLRepository;
import javax.persistence.EntityNotFoundException;

@Service
public class ShortenedURLService
{
	private ShortenedURLRepository shortenedURLRepository;
	public ShortenedURLService(ShortenedURLRepository shortenedURLRepository)
	{
		this.shortenedURLRepository=shortenedURLRepository;
	}
	public ShortenedURL save(ShortenedURL shortenedURL)
	{
		return shortenedURLRepository.save(shortenedURL);
	}
	public ShortenedURL findById(Long id)
	{
		return shortenedURLRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
}