package com.example.dictionary;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;

public class HelloController {
        public Map<String, String> vocabulary = new HashMap<>();
        public TextField KeyInput=new TextField();
        public TextField ValueInput=new TextField();
        public ListView listKeys;
        public ListView listValues;
        public Button closeTheWindow;


        public void addToCollection(ActionEvent actionEvent) {
            vocabulary.put(KeyInput.getText(),ValueInput.getText());
            String A = ValueInput.getText();
            String K = " ";
            listKeys.getItems().add(vocabulary.get(KeyInput.getText()));
            for (String Key : vocabulary.keySet()){
                if (vocabulary.get(Key).equals(A) )  {
                    K = Key;
                    break;}}
            listValues.getItems().add(K);
            ValueInput.clear();
            KeyInput.clear();
        }

        public void deleteFromCollection(ActionEvent actionEvent) {
            int deletedWord = listKeys.getSelectionModel().getSelectedIndex();
            vocabulary.remove(deletedWord);
            listKeys.getItems().remove(deletedWord);
            listValues.getItems().remove(deletedWord);

        }
        public void editeWord(ActionEvent actionEvent){
            MultipleSelectionModel editedWord = listValues.getSelectionModel();
            listValues.getItems().remove(editedWord.getSelectedIndex());
            String word = editedWord.toString();
            String V = word;
            String K ="";
            for (String Key : vocabulary.keySet()){
                if (vocabulary.get(Key).equals(V) )  {
                    K = Key;
                    break; }}
            listValues.getItems().add(KeyInput.getText());
            ValueInput.clear();
            vocabulary.put(K,KeyInput.getText());
        }

        public void closeWindow(ActionEvent actionEvent) {
            Stage stage = (Stage)closeTheWindow.getScene().getWindow();
            stage.close();
        }
}