package in.bitcode.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int MENU_NEW = 1, MENU_SETTINGS = 2, MENU_HELP = 3;
    public static final int MENU_PHONE_SETTINGS = 10, MENU_SYS_SETTINGS = 11;

    private CheckBox mChkSettings;
    private TextView mTxtInfo;
    private EditText mEdtInfo;

    public static final int MENU_COPY = 1, MENU_CUT = 2, MENU_PASTE = 3, MENU_APPEND = 4;

    private String mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

    }

    private void init() {
        setContentView(R.layout.activity_main);

        mChkSettings = findViewById(R.id.chkSettings);
        mTxtInfo = findViewById(R.id.txtInfo);
        mEdtInfo = findViewById(R.id.edtInfo);

        registerForContextMenu(mTxtInfo);
        registerForContextMenu(mEdtInfo);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);

        mt("onCreateContextMenu");

        if( view == mTxtInfo) {
            menu.add(0, MENU_PASTE, 0, R.string.menu_paste);
            menu.add(0, MENU_APPEND, 0, R.string.menu_append);
        }
        if(view.getId() == R.id.edtInfo) {
            menu.add(1, MENU_COPY, 0, R.string.menu_copy);
            menu.add(1, MENU_CUT, 0, R.string.menu_cut);
        }
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case MENU_COPY:
                mText = mEdtInfo.getText().toString();
                break;
            case MENU_CUT:
                mText = mEdtInfo.getText().toString();
                mEdtInfo.setText("");
                break;
            case MENU_PASTE:
                mTxtInfo.setText(mText);
                break;
            case MENU_APPEND:
                mTxtInfo.append(mText);
                break;
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        mt("onCreateOptionsMenu");

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);

        /*MenuItem menuItem;

        menuItem = menu.add(0, MENU_NEW, 0, R.string.menu_new);
        menuItem.setAlphabeticShortcut('N');
        menuItem.setNumericShortcut('9');
        menuItem.setIcon(android.R.drawable.ic_menu_add);
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        SubMenu subMenu = menu.addSubMenu(0, MENU_SETTINGS, 0, R.string.menu_setting);
        subMenu.add(1, MENU_PHONE_SETTINGS, 0, R.string.menu_phone_settings);
        subMenu.add(1, MENU_SYS_SETTINGS, 0, R.string.menu_sys_settings);

        *//*menuItem.setCheckable(true);
        menuItem.setChecked(true);*//*

        menu.add(0, MENU_HELP, 0, R.string.menu_help);
        */

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mt("onPrepareOptionsMenu");

        menu.findItem(R.id.menuSettings).setEnabled(mChkSettings.isChecked());

        //menu.findItem(MENU_SETTINGS).setEnabled(mChkSettings.isChecked());


        /*MenuItem menuItem = menu.findItem(MENU_SETTING);
        menuItem.setEnabled(mChkSettings.isChecked());
        */

       /* if(mChkSettings.isChecked()) {
            menuItem.setEnabled(true);
        }
        else {
            menuItem.setEnabled(false);
        }
*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuNew:
                mt("New");
                break;
            case R.id.menuSettings:
                mt("Settings");
                break;
            case R.id.menuHelp:
                mt("Help");
                break;
            case R.id.menuPhoneSettings:
                mt("Phone Settings");
                break;
            case R.id.menuSysSettings:
                mt("System Settings");
                break;
        }


        /*switch (item.getItemId()) {
            case MENU_NEW:
                mt("New");
                break;
            case MENU_SETTINGS:
                mt("Settings");
                break;
            case MENU_HELP:
                mt("Help");
                break;
            case MENU_PHONE_SETTINGS:
                mt("Phone Settings");
                break;
            case MENU_SYS_SETTINGS:
                mt("System Settings");
                break;
        }*/


        return true;
    }

    private void mt(String text) {
        Log.e("tag", text);
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}