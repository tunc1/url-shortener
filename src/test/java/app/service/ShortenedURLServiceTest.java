package app.service;

import app.entity.ShortenedURL;
import app.repository.ShortenedURLRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ShortenedURLServiceTest
{
	@Mock
	ShortenedURLRepository shortenedURLRepository;
	ShortenedURLService shortenedURLService;

	@BeforeEach
	void setUp()
	{
		shortenedURLService=new ShortenedURLService(shortenedURLRepository);
	}
	@Test
	void save()
	{
		ShortenedURL shortenedURL=new ShortenedURL();
		Long id=Long.valueOf("1");
		Mockito.when(shortenedURLRepository.save(Mockito.any())).thenAnswer(e->
		{
			ShortenedURL entity=new ShortenedURL();
			entity.setId(id);
			return entity;
		});
		Long savedId=shortenedURLService.save(shortenedURL);
		Assertions.assertEquals(id,savedId);
	}
	@Test
	void findById_returnsShortenedURL()
	{
		ShortenedURL shortenedURL=new ShortenedURL();
		Mockito.when(shortenedURLRepository.findById(Mockito.any())).thenReturn(Optional.of(shortenedURL));
		ShortenedURL actual=shortenedURLService.findById(Long.valueOf("1"));
		Assertions.assertEquals(shortenedURL,actual);
	}
	@Test
	void findById_throwsEntityNotFoundException()
	{
		Mockito.when(shortenedURLRepository.findById(Mockito.any())).thenReturn(Optional.empty());
		Assertions.assertThrows(EntityNotFoundException.class,()->shortenedURLService.findById(Long.valueOf("1")));
	}
}