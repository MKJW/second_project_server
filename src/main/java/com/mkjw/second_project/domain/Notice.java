package com.mkjw.second_project.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Notice {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

    //TODO 카테고리 enum 값으로 특정 값으로 한정하기
    private String category;

    private Date createdDate;
}
