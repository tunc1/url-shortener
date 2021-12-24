package app.controller;

import app.entity.ShortenedURL;
import app.service.ShortenedURLService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ShortenedURLControllerTest
{
    @Mock
    ShortenedURLService shortenedURLService;
    ShortenedURLController shortenedURLController;

    @BeforeEach
    void setUp()
    {
        shortenedURLController=new ShortenedURLController(shortenedURLService);
    }
    @Test
    void save()
    {
        ShortenedURL shortenedURL=new ShortenedURL();
        Mockito.when(shortenedURLService.save(Mockito.any())).thenAnswer(e->e.getArgument(0,ShortenedURL.class));
        ShortenedURL saved=shortenedURLController.save(shortenedURL);
        Assertions.assertEquals(saved,shortenedURL);
    }
    @Test
    void findById_returnsShortenedURL()
    {
        ShortenedURL shortenedURL=new ShortenedURL();
        Mockito.when(shortenedURLService.findById(Mockito.any())).thenReturn(shortenedURL);
        ShortenedURL actual=shortenedURLController.findById(1L);
        Assertions.assertEquals(actual,shortenedURL);
    }
}