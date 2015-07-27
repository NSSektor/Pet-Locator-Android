package pet.locator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by NSSektor on 7/23/15.
 */
public class Portada extends Activity {
    GridView grid;
    String[] web = {
            String.valueOf(R.string.portada_mis_mascotas),
            String.valueOf(R.string.portada_regresar_a_casa),
            String.valueOf(R.string.portada_adoptame),
            String.valueOf(R.string.portada_blog_fido),
            String.valueOf(R.string.portada_vet_and_care),
            String.valueOf(R.string.portada_tienda)
    } ;
    int[] imageId = {
            R.drawable.mismascotas2,
            R.drawable.regresaracasa2,
            R.drawable.adoptame2,
            R.drawable.blogdefido2,
            R.drawable.vetandcare2,
            R.drawable.tienda2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portada);

        CustomGrid adapter = new CustomGrid(Portada.this, web, imageId);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
              //  Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });

    }

}