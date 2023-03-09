package app.service;

import org.springframework.stereotype.Service;
import app.entity.ShortenedURL;
import app.repository.ShortenedURLRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ShortenedURLService
{
	private ShortenedURLRepository shortenedURLRepository;
	public ShortenedURLService(ShortenedURLRepository shortenedURLRepository)
	{
		this.shortenedURLRepository=shortenedURLRepository;
	}
	public Long save(ShortenedURL shortenedURL)
	{
		return shortenedURLRepository.save(shortenedURL).getId();
	}
	public ShortenedURL findById(Long id)
	{
		return shortenedURLRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
}