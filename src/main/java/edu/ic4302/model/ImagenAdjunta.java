package edu.ic4302.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "imagenes_adjuntas")
public class ImagenAdjunta {

    @Id
    private String id;
    private String rutaImagen;

    public ImagenAdjunta() {
    }

    public ImagenAdjunta(String id, String rutaImagen) {
        this.id = id;
        this.rutaImagen = rutaImagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
