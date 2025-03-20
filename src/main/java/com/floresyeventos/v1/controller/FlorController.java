package com.floresyeventos.v1.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.floresyeventos.v1.Service.FlorService;
import com.floresyeventos.v1.model.Flores;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;



// import io.swagger.v3.oas.annotations.media.Content;
// import io.swagger.v3.oas.annotations.media.Schema;

@Tag(name = "Arreglos Florales", description = "Operaciones sobre el manejo y recursos para los arreglos florales")
@Controller
@RequestMapping("/flores")
public class FlorController {
    @Autowired 
    private FlorService florService;

    private static final String UPLOAD_DIR = "C:/Temp/uploads/";

     @Operation(
        summary = "Obtener todos los usuarios",
        description = "Devuelve una lista de usuarios registrados.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de arreglos florales obtenida correctamente",
                content = @Content(schema = @Schema(implementation = Flores.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
        }
    )           
    @GetMapping("/listar")
    public String listarFLores(Model model){
        //  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //  String username = auth.getName(); // Nombre del usuario autenticado
         model.addAttribute("flores",florService.listarFlores());
        //  model.addAttribute("user",username);
        return "listarFlores";
    }

    
    @GetMapping("/agregar") 
    public String mostrarFormulario(Model model){
        model.addAttribute("flores", new Flores());
        return "floresForm";
    }

    @Operation(
        summary = "Guardar arreglo floral",
        description = "Recolecta variables del formulario para la creaci[on del arreglo floral.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de arreglos florales obtenida correctamente",
                content = @Content(schema = @Schema(implementation = Flores.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
        }
    )
@PostMapping("/guardar")
public String guardarFlor(
        @ModelAttribute("flores") Flores flores,
        @RequestParam("foto") MultipartFile foto) throws IOException {

    // Guardar la imagen en el sistema de archivos
    String nombreImagen = guardarImagen(foto);
    flores.setRutaFoto(nombreImagen);

    // Guardar en la base de datos
    florService.guardarFlor(flores);

    return "redirect:/flores/listar"; // Redirigir a la lista de flores
}
@Operation(
    summary = "Metodo para eliminar  arreglo floral",
    description = "Indicar el ID del arreglo floral que se desea eliminar.",
    responses = {
        @ApiResponse(responseCode = "200", description = "Arreglo floral eliminado correctamente",
            content = @Content(schema = @Schema(implementation = Flores.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    }
)
@GetMapping("/eliminar/{id}")
public String eliminarFlor(@PathVariable Long id) {
    florService.eliminarFlor(id);
    return "redirect:/flores/listar"; // Redirigir a la lista de flores
}



private String guardarImagen(MultipartFile foto) throws IOException {
    if (foto.isEmpty()) {
        throw new IllegalArgumentException("La imagen no puede estar vacía");
    }

    // Crear el directorio si no existe
    Path uploadPath = Paths.get(UPLOAD_DIR);
    if (!Files.exists(uploadPath)) {
        Files.createDirectories(uploadPath);
    }

     // Generar un nombre único para la imagen
     String nombreArchivo = System.currentTimeMillis() + "_" + foto.getOriginalFilename();
     Path filePath = uploadPath.resolve(nombreArchivo);
     Files.copy(foto.getInputStream(), filePath);

     // Devolvemos solo el nombre del archivo (no la ruta completa)
     return nombreArchivo;

    // Guardar la imagen
    // String nombreArchivo = System.currentTimeMillis() + "_" + foto.getOriginalFilename();
    // Path filePath = uploadPath.resolve(nombreArchivo);
    // Files.copy(foto.getInputStream(), filePath);

    // return UPLOAD_DIR + nombreArchivo;
}

}
