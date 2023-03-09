package app.controller;

import app.entity.ShortenedURL;
import app.service.ShortenedURLService;
import app.controller.request.ShortenedURLSaveRequest;
import app.controller.response.ShortenedURLSaveResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.junit.jupiter.api.extension.ExtendWith;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ShortenedURLControllerTest
{
	@Mock
	ShortenedURLService shortenedURLService;
	@Mock
	ObjectMapper objectMapper;
	ShortenedURLController shortenedURLController;

	@BeforeEach
	void setUp()
	{
		shortenedURLController=new ShortenedURLController(shortenedURLService,objectMapper);
	}
	@Test
	void save()
	{
		ShortenedURL shortenedURL=new ShortenedURL();
		Long id=Long.valueOf("1");
		shortenedURL.setId(id);
		Mockito.when(shortenedURLService.save(Mockito.any())).thenReturn(id);
		Mockito.when(objectMapper.convertValue(Mockito.any(),Mockito.eq(ShortenedURL.class))).thenReturn(shortenedURL);
		ShortenedURLSaveRequest request=new ShortenedURLSaveRequest();
		ShortenedURLSaveResponse response=shortenedURLController.save(request);
		Assertions.assertEquals(shortenedURL.getId(),response.getId());
	}
	@Test
	void findById()
	{
		ShortenedURL shortenedURL=new ShortenedURL();
		Mockito.when(shortenedURLService.findById(Mockito.any())).thenReturn(shortenedURL);
		ShortenedURL actual=shortenedURLController.findById(Long.valueOf("1"));
		Assertions.assertEquals(shortenedURL,actual);
	}
}