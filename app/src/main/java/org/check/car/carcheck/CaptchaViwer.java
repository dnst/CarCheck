package org.check.car.carcheck;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class CaptchaViwer extends AppCompatActivity implements View.OnClickListener{

    ImageView ivCaptcha;
    EditText etCaptcha;
    Button btnCaptha;
    String cookies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captcha_viwer);

        ivCaptcha = (ImageView) findViewById(R.id.ivCaptcha);
        etCaptcha = (EditText) findViewById(R.id.etCaptcha);
        btnCaptha = (Button) findViewById(R.id.btnCaptha);
        btnCaptha.setOnClickListener(this);


        //InteractionWithService intService = new InteractionWithService();
        //InteractionWithService.GetCaptcha getCaptcha = intService.new GetCaptcha();

        InteractionWithService.GetCaptcha getCaptcha = new InteractionWithService.GetCaptcha();
        InteractionWithService.ReceivedData receivedData;

        try {
            receivedData = getCaptcha.execute("http://check.gibdd.ru/proxy/captcha.jpg").get();
            ivCaptcha.setImageBitmap(receivedData.bmCaptcha);
            cookies = receivedData.cookies;

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnCaptha:
                String[] params = new String[2];
                params[0] = etCaptcha.getText().toString();
                params[1] = cookies;

                Intent intent = new Intent();
                intent.putExtra("params", params);
                //intent.putExtra("Cookies", cookies);
                setResult(RESULT_OK, intent);
                finish();
        }
    }
}
