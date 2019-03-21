package como.exampleo.firebaseo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.List;

import static android.R.color.background_light;
import static java.lang.String.valueOf;

public class Adaptador_personalizado extends ArrayAdapter <Cada_dia> {
    public Adaptador_personalizado( Context context, int resource, List objects) {
        super(context, resource, objects);

    }



    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
       View result = convertView;
       if (result == null){

           LayoutInflater inflater = LayoutInflater.from(getContext());
           result = inflater.inflate(R.layout.pastillita_listview_cada_item, null);
       }
        Button columna_uno = (Button) result.findViewById(R.id.item_hora_descanso);
       Button columna_dos = (Button) result.findViewById(R.id.item_hora_reloj);
        Button columna_tres = (Button) result.findViewById(R.id.item_asignatura);
       Cada_dia item = getItem(position);
        columna_uno.setText(valueOf(item.getHora_descanso()));
        columna_dos.setText(valueOf(item.getHora_reloj()));
        columna_tres.setText(valueOf(item.getAsignatura()));
        if(columna_tres.getText().equals("")){columna_tres.setBackgroundColor(background_light);}

        if((columna_uno.getText().equals("descanso")||(columna_uno.getText().equals("almuerzo"))))
        {columna_uno.setBackgroundColor(Color.parseColor("#4CAF50"));
            columna_dos.setBackgroundColor(Color.parseColor("#4CAF50"));
            columna_tres.setBackgroundColor(Color.parseColor("#4CAF50"));
            }
        if(!(columna_uno.getText().equals("descanso")||(columna_uno.getText().equals("almuerzo"))))
        {columna_uno.setBackgroundColor(Color.parseColor("#ADA8A8"));
            columna_dos.setBackgroundColor(Color.parseColor("#ADA8A8"));
            columna_tres.setBackgroundColor(Color.parseColor("#ADA8A8"));
        }
        if((!columna_tres.getText().equals(""))&&(!columna_tres.getText().equals("descanso"))&&
                (!columna_tres.getText().equals("almuerzo"))){
            columna_uno.setBackgroundColor(Color.parseColor("#808080"));
            columna_dos.setBackgroundColor(Color.parseColor("#808080"));
            columna_tres.setBackgroundColor(Color.parseColor("#808080"));
        }
       return result;

    }

}
