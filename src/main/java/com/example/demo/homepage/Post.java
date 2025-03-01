package com.example.demo.homepage;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Post")
public class Post {
    @Id
    private String id;

    @Column (name = "Thumbnail")
    private String thumbnail;

    @Column (name = "Title")
    private String title;

    @Column (name = "BriefInformation")
    private String briefInformation;

    @Column (name = "Description")
    private String description;

    @Column (name = "Flag")
    private int flag;

    @Column (name = "Status")
    private String status;
}
