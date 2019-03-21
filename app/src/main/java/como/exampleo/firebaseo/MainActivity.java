package como.exampleo.firebaseo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {



    Button boton;
    Firebase firebase;
    Adaptador_personalizado adapter ;
    ArrayList <Cada_dia>listadia = new ArrayList<Cada_dia>();
    String palabra = "";
    ListView list;
    String horario_a_mostrar = "grado_81";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_81:
                horario_a_mostrar="grado_81";
                limpiar_y_rellenar();
                cambiatextoenboton();

                return true;
           // case R.id.profe:
             //   horario_a_mostrar="profe";
              //  limpiar_y_rellenar();
               // cambiatextoenboton();
              //  return true;

            case R.id.menu_101:
                horario_a_mostrar="grado_10-1";
                limpiar_y_rellenar();
                cambiatextoenboton();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebase.setAndroidContext(this);
        firebase = new Firebase("https://fir-5ff84.firebaseio.com/");
        setContentView(R.layout.activity_main);

        boton = (Button) findViewById(R.id.boton);
        list = findViewById(R.id.list);


        boton.setOnClickListener(new View.OnClickListener() {
    @Override
     public void onClick(View v) {
        limpiar_y_rellenar();
        cambiatextoenboton();
       // adapter.notifyDataSetChanged();

//        list.smoothScrollToPosition(listadia.size()-1);

        }




        });



        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                limpiar_y_rellenar();
                //boton2.setText("miercoles");

                palabra = snapshot.child("horarios").child(horario_a_mostrar).child("estado").getValue().toString();
                boton.setText(horario_a_mostrar+" ...."+palabra);

                for (DataSnapshot messageSnapshot : snapshot.child("horarios")
                        .child(horario_a_mostrar).child(palabra).getChildren()) {
                    int lugar=Integer.parseInt(messageSnapshot.getKey());
                  if ((lugar >2)&(lugar <7)){lugar = lugar+ 1;}
                  else if ((lugar >6)&(lugar <10)){lugar = lugar +2;}
                  else if ((lugar > 9)){lugar = lugar +3;}
                    listadia.get(lugar).setAsignatura(messageSnapshot.getValue().toString());

                    //  listadia.set((Integer.parseInt(messageSnapshot.getKey()),
                    // messageSnapshot.getValue().toString()))
                    //         System.out.println("");

                }

               // for (DataSnapshot dttSnapshot2 : snapshot.child("horarios").child("profe").getChildren()) {
                 //   String pack = String.format("%s:%s\n\r", dttSnapshot2.getKey()
                   //         , dttSnapshot2.getValue().toString());
                    //texto4.append(pack);
               // }
            }

                                           @Override
                                            public void onCancelled(FirebaseError firebaseError) {
                                           //texto4.setText("no se ha podido acceder a la base de datos en este momento");
                                             }
                                           });


       adapter = new Adaptador_personalizado(this, android.R.layout.simple_list_item_1, listadia );
       list.setAdapter(adapter);


}




    private void limpiar_y_rellenar() {
        listadia.clear();
        listadia.add(new Cada_dia(0,"hora","reloj",""));
        listadia.add(new Cada_dia(1,"1","6:35",""));
        listadia.add(new Cada_dia(2,"2","7:30",""));
        listadia.add(new Cada_dia(3,"descanso","8:25",""));
        listadia.add(new Cada_dia(4,"3","8:40",""));
        listadia.add(new Cada_dia(5,"4","9:35",""));
        listadia.add(new Cada_dia(6,"5","10:30",""));
        listadia.add(new Cada_dia(7,"6","11:25",""));
        listadia.add(new Cada_dia(8,"almuerzo","12:20",""));
        listadia.add(new Cada_dia(9,"7","12:35",""));
        listadia.add(new Cada_dia(10,"8","13:30",""));
        listadia.add(new Cada_dia(11,"9","14:25",""));
        listadia.add(new Cada_dia(12,"descanso","15:20",""));
        listadia.add(new Cada_dia(13,"10","15:35",""));
        listadia.add(new Cada_dia(14,"11","16:30",""));
        adapter.notifyDataSetChanged();


    }
    private void cambiatextoenboton() {

        if (palabra.equals("lunes")){firebase.child("horarios").child(horario_a_mostrar).child("estado").setValue("martes");}
        if (palabra.equals("martes")){firebase.child("horarios").child(horario_a_mostrar).child("estado").setValue("miercoles");}
        if (palabra.equals("miercoles")){firebase.child("horarios").child(horario_a_mostrar).child("estado").setValue("jueves");}
        if (palabra.equals("jueves")){firebase.child("horarios").child(horario_a_mostrar).child("estado").setValue("viernes");}
        if (palabra.equals("viernes")){firebase.child("horarios").child(horario_a_mostrar).child("estado").setValue("lunes");}

    }
}


