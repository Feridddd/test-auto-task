package org.test_task.components;

import com.codeborne.selenide.SelenideElement;
import org.test_task.enums.Hobby;

import static com.codeborne.selenide.Selenide.$x;


public class HobbiesComponent {
    public void selectHobbies(Hobby... hobbiesList) {
        for (Hobby hobby : hobbiesList) {
            SelenideElement element = $x(hobby.getXpath());
            if (!element.isSelected()) {
                element.click();
            }
        }
    }
}
