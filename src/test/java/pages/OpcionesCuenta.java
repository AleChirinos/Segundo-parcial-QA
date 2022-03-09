package pages;

import control.Button;
import org.openqa.selenium.By;

public class OpcionesCuenta {
    public Button logoutButton = new Button(By.xpath("//button[@role='menuitem']/span[text()='Cerrar sesión']"));
}
