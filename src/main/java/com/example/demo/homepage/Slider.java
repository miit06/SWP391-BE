package com.example.demo.homepage;

import jakarta.persistence.*;
import lombok.*;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Slider")
public class Slider {
    @Id
    @Column(name = "SliderId")
    private String id;

    @Column(name = "Image")
    private String image;

    @Column(name = "Title")
    private String title;

    @Column(name = "Backlink")
    private String backlink;

    @Column(name = "Status")
    private String status;

    @Column(name = "Note")
    private String note;
}