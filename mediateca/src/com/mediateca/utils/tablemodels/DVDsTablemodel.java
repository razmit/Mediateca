package com.mediateca.utils.tablemodels;

import com.mediateca.utils.dbmodels.ModelCDs;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author E095713
 */

public class DVDsTablemodel extends AbstractTableModel {

    private String[] columnNames; // Array of column names (headers)
    private List<ModelCDs> tableData; // List of ModelCDS objects representing table rows

    public DVDsTablemodel(String[] columnNames, List<ModelCDs> tableData) {
        this.columnNames = columnNames;
        this.tableData = tableData;
    }

    // Implement required methods from AbstractTableModel (inherited from TableModel)

    @Override
    public int getRowCount() {
        return tableData.size(); // Return the number of rows based on the data list size
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; // Return the number of columns based on the column names array
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col]; // Return the column name at the given index
    }

    @Override
    public Object getValueAt(int row, int col) {
        ModelCDs cds = tableData.get(row);
        switch (col) {
            case 0:
                return cds.getId_cd_audio();
            case 1:
                return cds.getCodigo();
            case 2:
                return cds.getTitulo();
            case 3:
                return cds.getUnidades_disponibles();
            case 4:
                return cds.getArtista();
            case 5:
                return cds.getGenero();
            case 6:
                return cds.getDuracion();
            case 7:
                return cds.getNum_canciones();
            case 8:
                return cds.getTipo_material_id();
            default:
                return null;
        }
    }

    // Optional method to update the table data (assuming your external method provides a way to fetch new data)
    public void updateData(List<ModelCDs> newData) {
        this.tableData = newData;
        fireTableDataChanged(); // Notify JTable about data changes (triggers table refresh)
    }
}
