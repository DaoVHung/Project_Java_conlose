package bussiness.entity;

import java.io.Serializable;

public class Table implements Serializable {
    private String tableID;
    private String tableName;
    private int seat;
    private int tableStatus;

    public Table() {
    }

    public Table(String tableID, String tableName, int seat, int tableStatus) {
        this.tableID = tableID;
        this.tableName = tableName;
        this.seat = seat;
        this.tableStatus = tableStatus;
    }

    public String getTableID() {
        return tableID;
    }

    public void setTableID(String tableID) {
        this.tableID = tableID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(int tableStatus) {
        this.tableStatus = tableStatus;
    }
}
