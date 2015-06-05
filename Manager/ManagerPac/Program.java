package ManagerPac;

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class Program {
    Pane programPane;
    
    ObservableList<ProgramObj> data=FXCollections.observableArrayList(
            new ProgramObj("Заал авах", "5-р сургууль дээр орой 19:30 цагт", "2015-12-12", "2015-12-12"),
            new ProgramObj("Dota 2 тэмцээн", "MKIT сургууль дээр өдөр 15:30 цагт", "2015-01-01", "2015-01-01"),
            new ProgramObj("Counter Strike тэмцээн", "MKIT сургууль дээр өдөр 14:30 цагт", "2015-02-02", "2015-02-02")
    );
    
    public Pane getProgramPane() {
        return programPane;
    }

    public void setProgramPane(Pane programPane) {
        this.programPane = programPane;
    }
    private TableView programTableView;

    public Program() {
        programPane = new Pane();
        
        Label todayLabel = new Label("Өнөөдөр :");
        todayLabel.setLayoutX(55);
        todayLabel.setLayoutY(110);
        
        Label startLabel = new Label("Эхлэлийн огноо :");
        startLabel.setLayoutX(650);
        startLabel.setLayoutY(25);
        
        DatePicker startDatePicker = new DatePicker(LocalDate.now());
        startDatePicker.setLayoutX(780);
        startDatePicker.setLayoutY(20);
        
        Label endLabel = new Label("Төгсгөлийн огноо :");
        endLabel.setLayoutX(650);
        endLabel.setLayoutY(65);
        
        DatePicker endDatePicker = new DatePicker(LocalDate.now());
        endDatePicker.setLayoutX(780);
        endDatePicker.setLayoutY(60);
        
        Button searchButton = new Button("Хайлт хийх");
        searchButton.setPrefSize(100, 30);
        searchButton.setLayoutX(855);
        searchButton.setLayoutY(100);
        
        TabPane weekTab = new TabPane();
        weekTab.setPrefSize(900, 500);
        weekTab.setLayoutX(55);
        weekTab.setLayoutY(150);
        
        programTableView = new TableView();
        programTableView.setEditable(false);
        programTableView.setPrefWidth(900);
        programTableView.setPrefHeight(463);
        
        Tab todayTab = new Tab("Өнөөдөр");
        todayTab.setId("tab_today");
        todayTab.setClosable(false);
        todayTab.setOnSelectionChanged(ae->{
            Pane todayPane = new Pane();
            todayPane.getChildren().clear();
            todayPane.getChildren().add(programTableView);
            todayTab.setContent(todayPane);
        });
        
        Tab allTab = new Tab("Бүх Хөтөлбөр");
        allTab.setId("tab_all");
        allTab.setClosable(false);
        allTab.setOnSelectionChanged(ae->{
            Pane allPane = new Pane();
            allPane.getChildren().clear();
            allPane.getChildren().addAll(programTableView);
            allTab.setContent(allPane);
        });
        
        Tab mondayTab = new Tab("Даваа");
        mondayTab.setId("tab_monday");
        mondayTab.setClosable(false);
        mondayTab.setOnSelectionChanged(ae->{
            Pane monPane = new Pane();
            monPane.getChildren().clear();
            monPane.getChildren().addAll(programTableView);
            mondayTab.setContent(monPane);
        });
        
        Tab tuesdayTab = new Tab("Мягмар");
        tuesdayTab.setId("tab_tuesday");
        tuesdayTab.setClosable(false);
        tuesdayTab.setOnSelectionChanged(ae->{
            Pane tuesPane = new Pane();
            tuesPane.getChildren().clear();
            tuesPane.getChildren().addAll(programTableView);
            tuesdayTab.setContent(tuesPane);
        });
        
        Tab wednesdayTab = new Tab("Лхагва");
        wednesdayTab.setId("tab_wednesday");
        wednesdayTab.setClosable(false);
        wednesdayTab.setOnSelectionChanged(ae->{
            Pane wednesPane = new Pane();
            wednesPane.getChildren().clear();
            wednesPane.getChildren().addAll(programTableView);
            wednesdayTab.setContent(wednesPane);
        });
        
        Tab thursdayTab = new Tab("Пүрэв");
        thursdayTab.setId("tab_thursday");
        thursdayTab.setClosable(false);
        thursdayTab.setOnSelectionChanged(ae->{
            Pane thursPane = new Pane();
            thursPane.getChildren().clear();
            thursPane.getChildren().addAll(programTableView);
            thursdayTab.setContent(thursPane);
        });
        
        Tab fridayTab = new Tab("Баасан");
        fridayTab.setId("tab_friday");
        fridayTab.setClosable(false);
        fridayTab.setOnSelectionChanged(e->{
            Pane friPane = new Pane();
            friPane.getChildren().clear();
            friPane.getChildren().addAll(programTableView);
            fridayTab.setContent(friPane);
        });
        
        Tab saturdayTab = new Tab("Бямба");
        saturdayTab.setId("tab_saturday");
        saturdayTab.setClosable(false);
        saturdayTab.setOnSelectionChanged(e->{
            Pane saturPane = new Pane();
            saturPane.getChildren().clear();
            saturPane.getChildren().addAll(programTableView);
            saturdayTab.setContent(saturPane);
        });
        
        Tab sundayTab = new Tab("Ням");
        sundayTab.setId("tab_sunday");
        sundayTab.setClosable(false);
        sundayTab.setOnSelectionChanged(e->{
            Pane sunPane = new Pane();
            sunPane.getChildren().clear();
            sunPane.getChildren().addAll(programTableView);
            sundayTab.setContent(sunPane);
        });
        
        weekTab.getTabs().addAll(todayTab,allTab,mondayTab, tuesdayTab, wednesdayTab, thursdayTab, fridayTab, saturdayTab, sundayTab);

        TableColumn nameCol = new TableColumn("Нэр");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setMaxWidth(200);
        nameCol.setMinWidth(200);
        
        TableColumn descriptionCol = new TableColumn("Тодорхойлолт");
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        descriptionCol.setMaxWidth(395);
        descriptionCol.setMinWidth(395);
        
        
        TableColumn startCol = new TableColumn("Эхлэх огноо");
        startCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        startCol.setMaxWidth(150);
        startCol.setMinWidth(150);
        
        TableColumn endCol = new TableColumn("Дуусах огноо");
        endCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        endCol.setMaxWidth(150);
        endCol.setMinWidth(150);
        
        programTableView.getColumns().addAll(nameCol, descriptionCol, startCol, endCol);
        programTableView.setItems(data);
        programPane.getChildren().addAll(todayLabel, startLabel, startDatePicker, endLabel, endDatePicker, searchButton, weekTab);
    }
}
