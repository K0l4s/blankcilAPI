package com.blankcil.api.blankcilapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "podcast")
@Builder
public class PodcastEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String audio_url;
    private String content;
    private LocalDateTime createDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public UserEntity user_podcast;

    @OneToMany(mappedBy = "podcast_comment")
    private List<CommentEntity> comments;

    @OneToMany(mappedBy = "podcast_like", cascade = CascadeType.ALL)
    private List<PodcastLikeEntity> podcast_likes;
}