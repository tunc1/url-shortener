package app.entity;

import jakarta.persistence.*;

@Entity
public class ShortenedURL
{
    @Id
    @SequenceGenerator(name="SHORTENEDURL_SEQUENCE_GENERATOR",sequenceName="SHORTENEDURL_SEQUENCE",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SHORTENEDURL_SEQUENCE_GENERATOR")
    private Long id;
    private String url;
    public String getUrl()
    {
        return url;
    }
    public void setUrl(String url)
    {
        this.url=url;
    }
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id=id;
    }
}