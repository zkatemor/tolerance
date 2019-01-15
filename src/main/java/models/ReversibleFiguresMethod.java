package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class ReversibleFiguresMethod {
    private int index;

    public ReversibleFiguresMethod(int index){
        this.index = index;
    }

    public Image getImage(){
        int tmpIndex = index;
        if (index > 5)
            tmpIndex -= 5;

        Image image = new Image(getClass().
                getResourceAsStream("/images/reversibleFigures/reversible_figures_" + String.valueOf(tmpIndex)
                        + ".png"), 835, 580, false, false);
        return image;
    }

    public String getInfoAboutImage(){
        String result = "";

        switch (index){
            case 1:
            case 6: { //утка или заяц
                result = "Иллюзия Ястрова, 1899";
            }
            break;
            case 2:
            case 7: { //две женщины
                result = "Е.Г. Боринг и Р.В. Липер, 1930";
            }
            break;
            case 3:
            case 8: { //мужчина или ковбой
                result = "Я. Ботвинник, первая половина ХХ в.";
            }
            break;
            case 4:
            case 9: { //два старика
                result = "Октавия Окампо, 1950-60";
            }
            break;
            case 5:
            case 10: { //с. дали ваза
                result = "Сальвадор Дали, 1938";
            }
            break;
        }
        return result;
    }

    public ObservableList<String> getButtonsText(){
        ObservableList<String> buttonsText = FXCollections.observableArrayList();

        switch (index){
            case 1:
            case 6:{
                buttonsText.add("УТКА");
                buttonsText.add("КРОЛИК");
            }
            break;
            case 2:
            case 7:{ //две женщины
                buttonsText.add("МОЛОДАЯ ДЕВУШКА");
                buttonsText.add("ПОЖИЛАЯ ЖЕНЩИНА");
            }
            break;
            case 3:
            case 8:{
                buttonsText.add("СТАРИК");
                buttonsText.add("КОВБОЙ");
            }
            break;
            case 4:
            case 9:{
                buttonsText.add("МЕКСИКАНЦЫ");
                buttonsText.add("ПОЖИЛАЯ ПАРА");
            }
            break;
            case 5:
            case 10:{
                buttonsText.add("ВАЗА");
                buttonsText.add("ПЛЯЖ");
            }
            break;
        }
        return buttonsText;
    }
}
