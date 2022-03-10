package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;
import singleton.Session;


public class TodoTest {
    PaginaInicio paginaInicio = new PaginaInicio();
    PaginaLogin paginaLogin = new PaginaLogin();
    PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
    OpcionesCuenta opcionesCuenta = new OpcionesCuenta();
    VentanaEmergenteCreacionYEdicionDeProyecto ventanaEmergenteCreacionYEdicionDeProyecto = new VentanaEmergenteCreacionYEdicionDeProyecto();
    VentanaEmergenteEliminarProyecto ventanaEmergenteEliminarProyecto = new VentanaEmergenteEliminarProyecto();

    @Test
    public void verify_login_todoly() throws InterruptedException {

        Session.getInstance().getDriver().get("https://todoist.com/");
        String nameProyect = "Prueba";

        //Login
        paginaInicio.buttonLogin.click();
        paginaLogin.emailTextBox.clearSetText("alecita2702@gmail.com");
        paginaLogin.passwordTextBox.clearSetText("Pass1234567Ale*");
        paginaLogin.botonIniciarSesion.click();

        Assertions.assertTrue(paginaPrincipal.toolbar.isControlDisplayed());

        //Crear nuevo proyecto
        paginaPrincipal.projectButton.click();
        paginaPrincipal.buttonAddProject.click();
        ventanaEmergenteCreacionYEdicionDeProyecto.textBoxNombreProyecto.setText(nameProyect);
        ventanaEmergenteCreacionYEdicionDeProyecto.buttonGuardar.click();
        String actualresult = paginaPrincipal.tituloDeProyecto.getTextControl();
        Thread.sleep(2000);
        Assertions.assertEquals(nameProyect, actualresult, "Error, no se añadio un nuevo proyecto");

        //Update el nombre de un proyecto
        String nameProjectUpdate= "Prueba 123";
        paginaPrincipal.buttonMasOpciones.click();
        paginaPrincipal.buttonEditar.click();
        ventanaEmergenteCreacionYEdicionDeProyecto.textBoxNombreProyecto.clearSetText(nameProjectUpdate);
        ventanaEmergenteCreacionYEdicionDeProyecto.buttonGuardar.click();
        actualresult = paginaPrincipal.tituloDeProyecto.getTextControl();
        Thread.sleep(2000);
        Assertions.assertEquals(nameProjectUpdate, actualresult, "Error, no se cambio el nombre del proyecto");

        //Delete project
        paginaPrincipal.buttonMasOpciones.click();
        paginaPrincipal.buttonEliminar.click();
        ventanaEmergenteEliminarProyecto.buttonEliminarConfirmacion.click();
        Thread.sleep(2000);
        Assertions.assertTrue(!nameProjectUpdate.equals(paginaPrincipal.tituloDeProyecto.getTextControl()));
    }
}
