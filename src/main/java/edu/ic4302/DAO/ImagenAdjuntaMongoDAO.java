package edu.ic4302.DAO;

import edu.ic4302.model.ImagenAdjunta;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImagenAdjuntaMongoDAO extends MongoRepository<ImagenAdjunta, String>{

    ImagenAdjunta findByName(String name);

}