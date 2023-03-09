package app.controller;

import app.entity.ShortenedURL;
import app.service.ShortenedURLService;
import app.controller.request.ShortenedURLSaveRequest;
import app.controller.response.ShortenedURLSaveResponse;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/shortenedURL")
public class ShortenedURLController
{
	private ShortenedURLService shortenedURLService;
	private ObjectMapper objectMapper;
	public ShortenedURLController(ShortenedURLService shortenedURLService,ObjectMapper objectMapper)
	{
		this.shortenedURLService=shortenedURLService;
		this.objectMapper=objectMapper;
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public ShortenedURLSaveResponse save(@RequestBody ShortenedURLSaveRequest request)
	{
		ShortenedURL shortenedURL=objectMapper.convertValue(request,ShortenedURL.class);
		Long savedId=shortenedURLService.save(shortenedURL);
		return new ShortenedURLSaveResponse(savedId);
	}
	@GetMapping("/{id}")
	public ShortenedURL findById(@PathVariable Long id)
	{
		return shortenedURLService.findById(id);
	}
}