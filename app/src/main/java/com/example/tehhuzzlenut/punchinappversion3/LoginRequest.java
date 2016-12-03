package com.example.tehhuzzlenut.punchinappversion3;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TehHuzzlenut on 8/15/2016.
 */
public class LoginRequest extends StringRequest{
    //allows us to make a request to the register.php file on the sever
    //and get a response as a string

    //1. specify url
    private static String LOGIN_REQUEST_URL = "http://172.31.55.12/employees/punchLogin.php";

    //2. create hashmap
    private Map<String, String> params;

    //3. class constructor
    public LoginRequest(String username, String password, Response.Listener<String> listener){
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);

        //4. use params to let volley pass on the request
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
