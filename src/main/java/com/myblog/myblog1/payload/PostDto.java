package com.myblog.myblog1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;//    This is Encapsulations  Class

@Data // for getters and setters
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private long id ;
    private String title; //     This Data goes to Post Controller class method
    private String description;
    private String content;
}
