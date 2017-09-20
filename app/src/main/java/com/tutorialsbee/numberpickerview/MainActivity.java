package com.tutorialsbee.numberpickerview;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow= (Button) this.findViewById(R.id.btn_show);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

    }

    public void openDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setTitle("");

        TextView tvSave= (TextView) dialog.findViewById(R.id.tv_save);
        TextView tvCancel= (TextView) dialog.findViewById(R.id.tv_cancel);
        final CustomView customView= (CustomView) dialog.findViewById(R.id.custom_view);

        //customView.setNumberPickerTextColor(customView.getView(1), Color.BLUE);

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer val1= customView.getVal1();
                Integer val2= customView.getVal2();
                Integer val3= customView.getVal3();
                Integer val4= customView.getVal4();
                // or
                String[] vals= customView.getValue();

                //Toast.makeText(MainActivity.this, val1 + ":" + val2 + ":" + val3 + ":" + val4, Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, vals[0] + ":" + vals[1] + ":" + vals[2] + ":" + vals[3], Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }
}
