package com.myblog.myblog1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;//    This is Encapsulations  Class

@Data //   for getters and setters encapsulation class  for this variables
@AllArgsConstructor // For arguments constructors
@NoArgsConstructor // for default constructor annotations
public class PostDto {

    private long id ;
    private String title; //     This Data goes to Post Controller Class method
    private String description;
    private String content;
}
