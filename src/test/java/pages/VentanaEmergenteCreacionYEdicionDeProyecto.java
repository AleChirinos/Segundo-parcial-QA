package pages;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class VentanaEmergenteCreacionYEdicionDeProyecto {
    public TextBox textBoxNombreProyecto = new TextBox(By.id("edit_project_modal_field_name"));
    public Button buttonGuardar = new Button(By.xpath("//button[@class='ist_button ist_button_red']"));

}
