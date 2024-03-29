package com.myblog.myblog1.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name ="posts")
@AllArgsConstructor  // Constructor with argument with created , No need to created constructor separately
@NoArgsConstructor
@Data // use for getters and setters
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String title;
    private String  description;
    private String content;
}
