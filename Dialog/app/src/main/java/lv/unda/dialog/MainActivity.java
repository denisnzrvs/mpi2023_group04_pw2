package lv.unda.dialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button goToSecondButton = findViewById(R.id.buttonGoToSecond);
        Button dialogButton = findViewById(R.id.buttonDialog);

        goToSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the second activity
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the custom dialog
                showDialog();
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("4. Group's Dialog");
        String[] groupMembers = {"Unda Žurevska", "Denis Nazarovs", "Lydia Kamynina"};
        boolean[] checkedItems = {false, false, false};

        builder.setMultiChoiceItems(groupMembers, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                String member = groupMembers[which];
                String action = isChecked ? "checked" : "unchecked";
                Toast.makeText(MainActivity.this, member + " " + action, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "You clicked OK", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "You closed dialog", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        Dialog dialog = builder.create();
        dialog.show();
    }
}

