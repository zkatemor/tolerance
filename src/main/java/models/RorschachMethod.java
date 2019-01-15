package models;

import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class RorschachMethod {

    private int numberOfTest;

    public RorschachMethod(int numberOfTest){
        this.numberOfTest = numberOfTest;
    }

    public Image getImage(){
        Image image = new Image(getClass().
                getResourceAsStream("/images/rorschach/rorschach_test_" + String.valueOf(numberOfTest) + ".jpg"),
                790, 525, false,false);
        return image;
    }

    public ObservableList<JFXRadioButton> getRadioButtonsList(){
        ObservableList<JFXRadioButton> radioButtons = FXCollections.observableArrayList();

        switch (numberOfTest){
            case 1: {
                radioButtons.add(new JFXRadioButton("ЛЕТУЧАЯ МЫШЬ"));
                radioButtons.add(new JFXRadioButton("БАБОЧКА"));
                radioButtons.add(new JFXRadioButton("МОТЫЛЁК"));
                radioButtons.add(new JFXRadioButton("МОРДА ЖИВОТНОГО"));
                radioButtons.add(new JFXRadioButton("ДРУГОЕ"));
            }
                break;
            case 2: {
                radioButtons.add(new JFXRadioButton("ЧЕЛОВЕКОПОДНЫЕ ФИГУРЫ"));
                radioButtons.add(new JFXRadioButton("ЧЕЛОВЕК У ЗЕРКАЛА"));
                radioButtons.add(new JFXRadioButton("ЧЕТЫРЁХЛАПОЕ ЖИВОТНОЕ"));
                radioButtons.add(new JFXRadioButton("МЕДВЕДЬ ИЛИ МЕДВЕДИ"));
                radioButtons.add(new JFXRadioButton("ДРУГОЕ"));
            }
            break;
            case 3: {
                radioButtons.add(new JFXRadioButton("ЧЕЛОВЕКОПОДНЫЕ ФИГУРЫ"));
                radioButtons.add(new JFXRadioButton("ЧЕЛОВЕК У ЗЕРКАЛА"));
                radioButtons.add(new JFXRadioButton("БАБОЧКА"));
                radioButtons.add(new JFXRadioButton("МОЛЬ"));
                radioButtons.add(new JFXRadioButton("ДРУГОЕ"));
            }
            break;
            case 4: {
                radioButtons.add(new JFXRadioButton("ЧЕЛОВЕКОПОДОБНАЯ ФИГУРА"));
                radioButtons.add(new JFXRadioButton("БОЛЬШОЕ ЖИВОТНОЕ"));
                radioButtons.add(new JFXRadioButton("ФАНТАСТИЧЕСКОЕ ЖИВОТНОЕ"));
                radioButtons.add(new JFXRadioButton("ШКУРА ЖИВОТНОГО"));
                radioButtons.add(new JFXRadioButton("ДРУГОЕ"));
            }
            break;
            case 5: {
                radioButtons.add(new JFXRadioButton("ЧЕЛОВЕКОПОДОБНАЯ ФИГУРА"));
                radioButtons.add(new JFXRadioButton("БАБОЧКА ИЛИ МОЛЬ"));
                radioButtons.add(new JFXRadioButton("ЛЕТУЧАЯ МЫШЬ"));
                radioButtons.add(new JFXRadioButton("ДРУГОЕ"));
            }
            break;
            case 6: {
                radioButtons.add(new JFXRadioButton("ШКУРА ЖИВОТНОГО"));
                radioButtons.add(new JFXRadioButton("КОВЕР"));
                radioButtons.add(new JFXRadioButton("ФАНТАСТИЧЕСКОЕ ЖИВОТНОЕ"));
                radioButtons.add(new JFXRadioButton("КОЖА"));
                radioButtons.add(new JFXRadioButton("ДРУГОЕ"));
            }
            break;
            case 7: {
                radioButtons.add(new JFXRadioButton("ДВЕ ЖЕНЩИНЫ"));
                radioButtons.add(new JFXRadioButton("ДЕТИ"));
                radioButtons.add(new JFXRadioButton("ЖИВОТНОЕ"));
                radioButtons.add(new JFXRadioButton("ПОЦЕЛУЙ"));
                radioButtons.add(new JFXRadioButton("ЧЕЛОВЕЧЕСКИЕ ЛИЦА"));
                radioButtons.add(new JFXRadioButton("ДРУГОЕ"));
            }
            break;
            case 8: {
                radioButtons.add(new JFXRadioButton("ЧЕТЫРЕХЛАПОЕ ЖИВОТНОЕ"));
                radioButtons.add(new JFXRadioButton("БАБОЧКА ИЛИ МОЛЬ"));
                radioButtons.add(new JFXRadioButton("АНАТОМИЯ ЧЕЛОВЕКА"));
                radioButtons.add(new JFXRadioButton("ФАНТАСТИЧЕСКОЕ СУЩЕСТВО"));
                radioButtons.add(new JFXRadioButton("ДРУГОЕ"));
            }
            break;
            case 9: {
                radioButtons.add(new JFXRadioButton("ЧЕЛОВЕЧЕСКОЕ ЛИЦО"));
                radioButtons.add(new JFXRadioButton("МИСТИЧЕСКИЙ ОБРАЗ"));
                radioButtons.add(new JFXRadioButton("ЖИВОТНОЕ"));
                radioButtons.add(new JFXRadioButton("ДРУГОЕ"));
            }
            break;
            case 10: {
                radioButtons.add(new JFXRadioButton("КРАБ, ОМАР ИЛИ ЛОБСТЕР"));
                radioButtons.add(new JFXRadioButton("ПАУК"));
                radioButtons.add(new JFXRadioButton("МОРДА КРОЛИКА"));
                radioButtons.add(new JFXRadioButton("ЗМЕИ"));
                radioButtons.add(new JFXRadioButton("ГУСЕНИЦА"));
                radioButtons.add(new JFXRadioButton("ДРУГОЕ"));
            }
            break;
        }
        return radioButtons;
    }
}
