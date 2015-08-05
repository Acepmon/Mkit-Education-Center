package teacher.model;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 *
 * @author Tsogtbayar
 */
public class CustomTable2 {

    public class CustomTableCell {

        private Object cellValue;

        public CustomTableCell(Object cellValue) {
            this.cellValue = cellValue;
        }

        public Object getCellValue() {
            return cellValue;
        }

        public void setCellValue(Object cellValue) {
            this.cellValue = cellValue;
        }

    }

    public class CustomTableRow {

        private ObservableList<CustomTableCell> cells;

        public CustomTableRow(ObservableList<CustomTableCell> cells) {
            this.cells = cells;
        }

        public ObservableList<CustomTableCell> getCells() {
            return cells;
        }

        public void setCells(ObservableList<CustomTableCell> cells) {
            this.cells = cells;
        }

        public Object getCell(int index) {
            return cells.get(index).getCellValue();
        }
    }

    public class CustomTableColumn {

        private String columnName;
        private ObservableList<CustomTableCell> columnDatas;

        public CustomTableColumn(String columnName, ObservableList<CustomTableCell> columnDatas) {
            this.columnName = columnName;
            this.columnDatas = columnDatas;
        }

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }

        public ObservableList<CustomTableCell> getColumnDatas() {
            return columnDatas;
        }

        public void setColumnDatas(ObservableList<CustomTableCell> columnDatas) {
            this.columnDatas = columnDatas;
        }

    }

    private TableView table;
    private ObservableList<CustomTableRow> rows = FXCollections.observableArrayList();
    private ObservableList<CustomTableColumn> cols = FXCollections.observableArrayList();
    private int col_width = 100;

    public CustomTable2() {
        this.table = new TableView(rows);
        this.table.getStylesheets().add(getClass().getResource("style/CustomTable.css").toExternalForm());
    }
    
    public void clearTable() {
        this.table.getColumns().clear();
        this.table.getItems().clear();
        rows.clear();
        cols.clear();
    }

    public void setCol_width(int col_width) {
        this.col_width = col_width;
    }

    public void addColumns(Columns... columns) {

        for (int i = 0; i < columns[0].getData().size(); i++) {
            ObservableList<CustomTableCell> cells = FXCollections.observableArrayList();
            for (int j = 0; j < columns.length; j++) {
                cells.add(new CustomTableCell(columns[j].getData().get(i)));
            }
            rows.add(new CustomTableRow(cells));
        }

        for (int i = 0; i < columns.length; i++) {
            ObservableList<CustomTableCell> cells = FXCollections.observableArrayList();
            for (Object obj : columns[i].getData()) {
                cells.add(new CustomTableCell(obj));
            }
            cols.add(new CustomTableColumn(columns[i].getColumnName(), cells));
        }

        for (int i = 0; i < columns.length; i++) {
            final int index = i;
            TableColumn tc = new TableColumn(columns[i].getColumnName());
            tc.setEditable(false);
            tc.setSortable(false);
            tc.setResizable(false);
            tc.setMinWidth(this.col_width);

            tc.setCellValueFactory(new Callback<CellDataFeatures<CustomTableRow, Object>, SimpleStringProperty>() {

                @Override
                public SimpleStringProperty call(CellDataFeatures<CustomTableRow, Object> param) {
                    return new SimpleStringProperty(param.getValue().getCell(index).toString());
                }
            });
            table.getColumns().add(tc);
        }
        table.setItems(rows);
    }

    public void addRows(ArrayList<ArrayList<Object>> rows) {
        for (ArrayList<Object> row : rows) {
            ObservableList<CustomTableCell> cells = FXCollections.observableArrayList();
            for (Object cell : row) {
//                Object obj = ((CustomTableCell) cell).getCellValue();
                cells.add(new CustomTableCell(cell));
            }
            CustomTableRow newRow = new CustomTableRow(cells);
            this.rows.add(newRow);
        }
    }

    public ArrayList<Columns> getSelectedColumns() {
        ArrayList<Columns> ret = new ArrayList<>();
        for (int i = 0; i < table.getColumns().size(); i++) {
            TableColumn tc = (TableColumn) table.getColumns().get(i);
            CheckBox check = (CheckBox) tc.getGraphic();
            if (check.isSelected()) {
                ArrayList<Object> datas = new ArrayList<>();
                for (CustomTableCell ctc : cols.get(i).getColumnDatas()) {
                    datas.add(ctc.getCellValue());
                }
                Columns column = new Columns(tc.getText(), datas);
                ret.add(column);
            }
        }
        return ret;
    }

    public ArrayList<ArrayList<Object>> getSelectedRows() {
        ArrayList<ArrayList<Object>> ret = new ArrayList<>();
        for (Object obj : table.getSelectionModel().getSelectedItems()) {
            CustomTableRow row = (CustomTableRow) obj;
            ArrayList<Object> r = new ArrayList<>();
            for (Object o : row.getCells()) {
                r.add(o);
            }
            ret.add(r);
        }
        return ret;
    }

    public boolean isColumnSelected() {
        for (TableColumn column : (ObservableList<TableColumn>) table.getColumns()) {
            if (((CheckBox) column.getGraphic()).isSelected()) {
                return true;
            }
        }
        return false;
    }

    public boolean isRowSelected() {
        if (this.table.getSelectionModel().getSelectedItem() != null) {
            return true;
        }
        return false;
    }

    public TableView getTable() {
        return table;
    }

}
