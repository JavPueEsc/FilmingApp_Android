package es.studium.pmdm_practicat6;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.Menu;

import com.google.android.material.navigation.NavigationView;

import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import es.studium.pmdm_practicat6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_inicio, R.id.nav_peliculas, R.id.nav_series)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        Menu menu = navigationView.getMenu();

        // Cambiar colores de íconos y texto
        personalizarOpcionesMenu(menu.findItem(R.id.nav_inicio), R.color.verdeApp, R.color.white);
        personalizarOpcionesMenu(menu.findItem(R.id.nav_peliculas), R.color.rosaApp, R.color.white);
        personalizarOpcionesMenu(menu.findItem(R.id.nav_series), R.color.amarilloApp, R.color.white);

        // Cambiar el icono de la hamburguesa por otro icono
        binding.appBarMain.toolbar.setNavigationIcon(R.drawable.ic_icono_menulateral);

    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void cambiarIconoMenuLateral(int iconResId) {
        if (binding.appBarMain.toolbar != null) {
            binding.appBarMain.toolbar.setNavigationIcon(iconResId);
        }
    }

    public void cambiarColorTextoBarraSuperior(int colorResId) {
        if (binding.appBarMain.toolbar != null) {
            // Usamos ContextCompat para obtener el color de manera compatible con API 30
            int color = ContextCompat.getColor(this, colorResId);
            binding.appBarMain.toolbar.setTitleTextColor(color);
        }
    }

    // Método para personalizar cada ítem del menú
    private void personalizarOpcionesMenu(MenuItem menuItem, int textColorResId, int iconColorResId) {
        // Cambiar el color del ícono
        menuItem.setIconTintList(ColorStateList.valueOf(getResources().getColor(iconColorResId)));

        // Cambiar el color del texto usando SpannableString
        SpannableString spannableTitle = new SpannableString(menuItem.getTitle());
        spannableTitle.setSpan(
                new ForegroundColorSpan(getResources().getColor(textColorResId)),
                0,
                spannableTitle.length(),
                0
        );
        menuItem.setTitle(spannableTitle);
    }

}