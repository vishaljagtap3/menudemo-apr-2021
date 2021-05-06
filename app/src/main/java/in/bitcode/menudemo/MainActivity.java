package in.bitcode.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int MENU_NEW = 1, MENU_SETTING = 2, MENU_HELP = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        mt("onCreateOptionsMenu");

        MenuItem menuItem;

        menuItem = menu.add(0, MENU_NEW, 0, R.string.menu_new);
        menuItem.setAlphabeticShortcut('N');
        menuItem.setNumericShortcut('9');
        menuItem.setIcon(android.R.drawable.ic_menu_add);
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        menuItem = menu.add(0, MENU_SETTING, 0, R.string.menu_setting);
        menuItem.setCheckable(true);
        menuItem.setChecked(true);

        menu.add(0, MENU_HELP, 0, R.string.menu_help);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case MENU_NEW:
                mt("New");
                break;
            case MENU_SETTING:
                mt("Settings");
                break;
            case MENU_HELP:
                mt("Help");
        }


        return true;
    }

    private void mt(String text) {
        Log.e("tag", text);
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}