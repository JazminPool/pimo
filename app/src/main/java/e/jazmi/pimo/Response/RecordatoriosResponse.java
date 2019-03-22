package e.jazmi.pimo.Response;

import java.lang.reflect.Array;
import java.util.ArrayList;

import e.jazmi.pimo.Atributos.Atributos_Recordatorios;

public class RecordatoriosResponse {
    private ArrayList<Atributos_Recordatorios> list;

    public ArrayList<Atributos_Recordatorios> getList() {
        return list;
    }

    public void setList(ArrayList<Atributos_Recordatorios> list) {
        this.list = list;
    }
}
