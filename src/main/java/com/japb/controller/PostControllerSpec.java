package com.japb.controller;

import com.japb.dto.PostDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public interface PostControllerSpec {

    @Operation(summary = "Obtener todos los posts", description = "Devuelve una lista de todos los posts.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de posts recuperada exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/post")
    ResponseEntity<List<PostDto>> getPost();

    @Operation(summary = "Obtener un post por ID", description = "Devuelve un post específico basado en el ID proporcionado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post recuperado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Post no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/post/{id}")
    ResponseEntity<PostDto> getPostById(@PathVariable int id);

    @Operation(summary = "Crear un nuevo post", description = "Crea un nuevo post y lo devuelve.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Post creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error de validación"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("/post")
    ResponseEntity<PostDto> save(@RequestBody PostDto postDto);

    @Operation(summary = "Actualizar un post existente", description = "Actualiza un post existente y devuelve el post actualizado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Post no encontrado"),
            @ApiResponse(responseCode = "400", description = "Error de validación"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PutMapping("/post/{id}")
    ResponseEntity<PostDto> update(@PathVariable int id, @RequestBody PostDto postDto);

    @Operation(summary = "Eliminar un post", description = "Elimina un post específico basado en el ID proporcionado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Post no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/post/{id}")
    ResponseEntity<?> delete(@PathVariable int id);
}
