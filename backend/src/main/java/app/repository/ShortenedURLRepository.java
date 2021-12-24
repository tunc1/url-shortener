package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.entity.ShortenedURL;

public interface ShortenedURLRepository extends JpaRepository<ShortenedURL,Long>{}