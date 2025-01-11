package com.vitordev.workshopmongodb.services;

import com.vitordev.workshopmongodb.domain.Post;
import com.vitordev.workshopmongodb.repository.PostRepository;
import com.vitordev.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public List<Post> findByTitle(String title) {
        return postRepository.searchTitle(title);
    }
}
