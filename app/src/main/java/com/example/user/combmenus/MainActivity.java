package com.example.user.combmenus;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
    Button bt,bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        bt1=(Button)findViewById(R.id.btnShow);
        registerForContextMenu(bt1);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Camera");
        menu.add(0, v.getId(), 0, "Web");
        menu.add(0, v.getId(), 0, "Phone");

        menu.add(0, v.getId(), 0, "Sms");
    }

    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle() == "Camera") {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

            startActivity(cameraIntent);
        } else if (item.getTitle() == "Web") {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("http://www.yourURL.com"));
            startActivity(intent);
        } else if (item.getTitle() == "Phone") {
            Intent i = new Intent(Intent.ACTION_DIAL);

            startActivity(i);

        } else if (item.getTitle() == "Sms") {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" ));

            startActivity(intent);
        } else {


            return false;
        }
        return true;
    }

    public void btonclick(View view) {
        PopupMenu popup=new PopupMenu(MainActivity.this,bt);
        popup.getMenuInflater().inflate(R.menu.hello, (Menu) popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.cam) {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                    startActivity(cameraIntent);

                } else if (id == R.id.wb) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse("http://www.yourURL.com"));
                    startActivity(intent);

                } else if (id == R.id.phn) {
                    Intent i = new Intent(Intent.ACTION_DIAL);

                    startActivity(i);

                }
                else if(id==R.id.sms)

                {


                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" ));

                    startActivity(intent);

                }
                return false;
            }
        });popup.show();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.hello,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        if(id==R.id.cam)
        {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

            startActivity(cameraIntent);
        }
        else if(id==R.id.phn)
        {
            Intent i = new Intent(Intent.ACTION_DIAL);

            startActivity(i);
        }
        else if(id==R.id.wb)
        {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("http://www.yourURL.com"));
            startActivity(intent);
        }
        else if(id==R.id.sms)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" ));

            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    }

