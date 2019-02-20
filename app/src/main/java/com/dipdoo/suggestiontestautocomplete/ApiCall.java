package com.dipdoo.suggestiontestautocomplete;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ApiCall {

    private static ApiCall mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    public ApiCall(Context ctx){
        mCtx = ctx;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized ApiCall getInstance(Context context){
        if(mInstance == null){
            mInstance = new ApiCall(context);
        }
        return  mInstance;
    }

    public RequestQueue getRequestQueue(){
        if(mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req){
        getRequestQueue().add(req);
    }

    public static void make(Context ctx, String query, Response .Listener<String>listener,Response.ErrorListener errorListener){

        try {
            query= URLEncoder.encode(query,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String url = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input="+query+"&types=geocode&language=korea&key=AIzaSyA0z-RXXqdl3Vzt4Kq3c8WTr9WsHy3aJ2k";
        StringRequest stringRequest = new StringRequest(Request.Method.GET,url,listener,errorListener);
        ApiCall.getInstance(ctx).addToRequestQueue(stringRequest);
    }
}
