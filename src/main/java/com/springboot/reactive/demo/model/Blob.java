package com.springboot.reactive.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document(collection = "blobs")
public class Blob
{
    @Id
    private String id;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy mm:ss")
    private Date creationDate;

    private String text;

    public Blob()
    {
    }

    public Blob(Date creationDate, String text)
    {
        this.creationDate = creationDate;
        this.text = text;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blob blob = (Blob) o;
        return Objects.equals(id, blob.id) && Objects.equals(creationDate, blob.creationDate) && Objects.equals(text, blob.text);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(id, creationDate, text);
    }
}
