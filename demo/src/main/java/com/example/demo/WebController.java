package com.example.demo;

// Importa las clases necesarias de Spring para construir controladores web tradicionales (no REST).
import org.springframework.beans.factory.annotation.Autowired; // Permite la inyección automática de dependencias.
import org.springframework.stereotype.Controller; // Marca esta clase como un controlador que devuelve vistas (por ejemplo, páginas HTML).
import org.springframework.ui.Model; // Permite pasar datos desde el controlador hacia la vista.
import org.springframework.web.bind.annotation.GetMapping; // Maneja solicitudes HTTP GET.

@Controller // Indica que esta clase es un controlador que se usará en aplicaciones web con
            // vistas (no solo API REST).
public class WebController {

    @Autowired // Inyecta automáticamente una instancia del repositorio de productos.
    private ProductRepository productRepository;

    /**
     * Maneja las solicitudes GET a la ruta "/products".
     * 
     * Este método consulta todos los productos y los agrega al modelo para que
     * puedan ser accedidos desde la vista "products.html".
     *
     * @param model Objeto que transporta datos entre el controlador y la vista.
     * @return Nombre de la vista que se debe renderizar (en este caso, "products").
     */
    @GetMapping("/products")
    public String viewProducts(Model model) {
        // Agrega al modelo la lista de productos obtenida del repositorio.
        model.addAttribute("products", productRepository.findAll());
        // Retorna el nombre de la plantilla HTML (sin extensión), ubicada en
        // src/main/resources/templates/products.html.
        return "products";
    }
}
