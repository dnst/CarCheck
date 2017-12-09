package org.check.car.carcheck;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class InteractionWithService{

    public static class ReceivedData{
        String cookies;
        Bitmap bmCaptcha;
    }

    public static class GetCaptcha extends AsyncTask<String, Void, ReceivedData>{
        OkHttpClient client = new OkHttpClient();

        @Override
        protected ReceivedData doInBackground(String... urls) {
            Request request = new Request.Builder().url(urls[0]).build();
            ReceivedData receivedData = new ReceivedData();

            try {
                Response response = client.newCall(request).execute();
                receivedData.cookies = response.headers().get("Set-Cookie");
                receivedData.bmCaptcha = BitmapFactory.decodeStream(response.body().byteStream());
                return receivedData;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(ReceivedData receivedData) {
            super.onPostExecute(receivedData);
        }

    }

    public static class GetCheckAuto extends AsyncTask<String, Void, String>{
        OkHttpClient client = new OkHttpClient();

        @Override
        protected String doInBackground(String... requestData) {
            RequestBody requestBody = new FormBody.Builder()
                    .add(requestData[1], requestData[2])
                    .add(requestData[3], requestData[4])
                    .add(requestData[5], requestData[6])
                    .build();
            Request request = new Request.Builder()
                    .header("Cookie", requestData[7])
                    .url(requestData[0]).post(requestBody).build();
            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.d("MyLog", result);
            JSONObject dataJson = null;
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();


            try {
                dataJson = new JSONObject(result);
                String color = dataJson.getJSONObject("RequestResult")
                        .getJSONObject("vehicle")
                        .getString("color");
                Log.d("MyLog", color);


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

}
