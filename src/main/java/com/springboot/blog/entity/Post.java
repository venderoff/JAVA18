package com.springboot.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="posts" , uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Post {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id ;

    @Column(name ="title")
    private String title ;

    @Column(name="description" , nullable = false)
    private String description ;
    @Column(name="content" , nullable = false)
    private String content ;

}
