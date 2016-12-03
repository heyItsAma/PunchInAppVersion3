package com.example.tehhuzzlenut.punchinappversion3;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TehHuzzlenut on 8/15/2016.
 */
public class RegisterRequest extends StringRequest {
    //allows us to make a request to the register.php file on the sever
    //and get a response as a string

    //1. specify url
    private static String REGISTER_REQUEST_URL = "http://172.31.55.12/employees/punchRegister.php";

    //2. create hashmap
    private Map<String, String> params;

    //3. class constructor
    public RegisterRequest(String name, String username, int age, String password, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);

        //4. use params to let volley pass on the request
        params = new HashMap<>();
        params.put("name", name);
        params.put("username", username);
        params.put("password", password);
        params.put("age", age + "");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
