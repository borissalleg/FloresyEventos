package com.floresyeventos.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String guardarFlor(@ModelAttribute Flores flores){
        florService.guardarFlor(flores);
       return "redirect:/flores/listar";
    }

}
