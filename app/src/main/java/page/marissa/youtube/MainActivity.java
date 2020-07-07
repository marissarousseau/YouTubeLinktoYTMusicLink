package page.marissa.youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(android.R.id.content);

        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

    }

    public void sendMessage(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editTextLink);
        String link = editText.getText().toString();

        if(link.length() >= 11)
        {
            String newLink = "https://music" + link.substring(11);
            System.out.println(newLink);
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("newLink", newLink);
            clipboard.setPrimaryClip(clip);

            Context context = getApplicationContext();
            CharSequence text = "Copied to clipboard";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Invalid link. Please try again";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
    }
}