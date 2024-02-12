package com.myblog.myblog1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name ="posts")
@AllArgsConstructor  // constructure with argument with created
@NoArgsConstructor
@Data // use for getters and setters
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String title;
    private String  description;
    private String Content;
}
