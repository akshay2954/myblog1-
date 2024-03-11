package com.myblog.myblog1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@Data                   // Use @Lombok Annotation is here to implement constructor quickly
@NoArgsConstructor
public class ErrorDetails {

    private String massage;
    private Date date;
    private String uri;


}
