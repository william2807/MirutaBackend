import com.example.demo.modelo.Rutas;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = crudtest.class)
public class crudtest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCRUDOperations() {
        // Crear un nuevo usuario
        Rutas rutas= new Rutas();
        rutas.setZona_origen("Usa");
        ResponseEntity<Rutas> responseCreate = restTemplate.postForEntity("/Registrar", rutas, Rutas.class);
        assertEquals(HttpStatus.OK, responseCreate.getStatusCode());

        // Obtener el ID del nuevo usuario
        Long usuarioId = responseCreate.getBody().getId();

        // Obtener el usuario recién creado
        ResponseEntity<Rutas> responseGet = restTemplate.getForEntity("/todos" + usuarioId, Rutas.class);
        assertEquals(HttpStatus.OK, responseGet.getStatusCode());
        assertEquals("John Doe", responseGet.getBody().getZona_origen());

        // Actualizar el nombre del usuario
        rutas.setZona_origen("Usa");
        HttpEntity<Rutas> requestUpdate = new HttpEntity<>(rutas);
        ResponseEntity<Rutas> responseUpdate = restTemplate.exchange("/{id}" + usuarioId, HttpMethod.PUT, requestUpdate, Rutas.class);
        assertEquals(HttpStatus.OK, responseUpdate.getStatusCode());
        assertEquals("Usa", responseUpdate.getBody().getZona_origen());

        // Eliminar el usuario
        restTemplate.delete("/api/usuarios/" + usuarioId);

        // Intentar obtener el usuario eliminado debe devolver un 404
        ResponseEntity<Void> responseGetDeleted = restTemplate.getForEntity("/{id}" + usuarioId, Void.class);
        assertEquals(HttpStatus.NOT_FOUND, responseGetDeleted.getStatusCode());
    }
}

