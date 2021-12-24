package app.controller;

import app.entity.ShortenedURL;
import app.service.ShortenedURLService;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/url")
public class ShortenedURLController
{
	private ShortenedURLService shortenedURLService;
	public ShortenedURLController(ShortenedURLService shortenedURLService)
	{
		this.shortenedURLService=shortenedURLService;
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public ShortenedURL save(@RequestBody ShortenedURL shortenedURL)
	{
		return shortenedURLService.save(shortenedURL);
	}
	@GetMapping("/{id}")
	public ShortenedURL findById(@PathVariable Long id)
	{
		return shortenedURLService.findById(id);
	}
}