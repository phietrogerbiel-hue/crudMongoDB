package com.phietro.crudMongo.services;

import com.phietro.crudMongo.domain.Post;
import com.phietro.crudMongo.repository.PostRepository;
import com.phietro.crudMongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitleContainingIgnoreCase(String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }
}
