package org.check.car.carcheck;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class CheckHistory extends AppCompatActivity implements View.OnClickListener{

    EditText etVin;
    Button btnCheckHistory;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_history);

        etVin = (EditText) findViewById(R.id.etVin);
        btnCheckHistory = (Button) findViewById(R.id.btnCheckHistory);
        btnCheckHistory.setOnClickListener(this);
        tvResult = (TextView) findViewById(R.id.tvResult);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnCheckHistory:
                if (checkVin()) {
                    Toast.makeText(this, "Не корректный Vin", Toast.LENGTH_SHORT).show();
                    break;
                }

                int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
                LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                        wrapContent, wrapContent);

                intent = new Intent(this, CaptchaViwer.class);
                startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        String[] params;
        params = data.getStringArrayExtra("params");
        //Log.d("MyLog", params[0]);
        //Log.d("MyLog", params[1]);
        checkCarRequest(params);
    }

    protected void checkCarRequest(String[] params){
        Intent intent;
        intent = getIntent();
        final String type = intent.getStringExtra("typeOfCheck");

        String[] requestData = new String[8];

        //InteractionWithService interactionWithService = new InteractionWithService();
        //InteractionWithService.GetCheckAuto getHistory = interactionWithService.new GetCheckAuto();

        InteractionWithService.GetCheckAuto getCheckAuto = new InteractionWithService.GetCheckAuto();

        switch (type){
            case "history":
                requestData[0] = "http://check.gibdd.ru/proxy/check/auto/history";
                break;
            case "wanted":
                requestData[0] = "http://check.gibdd.ru/proxy/check/auto/wanted";
                break;
            case "restricted":
                requestData[0] = "http://check.gibdd.ru/proxy/check/auto/restrict";
                break;
            case "aiusdtp":
                requestData[0] = "http://check.gibdd.ru/proxy/check/auto/dtp";
                break;
        }

        requestData[1] = "vin";
        requestData[2] = etVin.getText().toString();
        requestData[3] = "captchaWord";
        requestData[4] = params[0];
        requestData[5] = "checkType";
        requestData[6] = type;
        requestData[7] = params[1];

        String result;

        try {
            result = getCheckAuto.execute(requestData).get();
            //Log.d("MyLog", result);
            //tvResult.setText(result);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    protected boolean checkVin(){
        if(etVin.getText().toString().equals("")){
            return true;
        }
        else return false;
    }
}
