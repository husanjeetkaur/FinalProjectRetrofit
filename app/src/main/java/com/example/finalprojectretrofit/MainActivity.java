package com.example.finalprojectretrofit;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.finalprojectretrofit.API_interfaces.JsonPlaceholderApi;
import com.example.finalprojectretrofit.Models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);

        createPost();

    }

    public void createPost(){
        Post post = new Post("email.gmail.com", 7755);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceholderApi jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);
        Call<Post> call = jsonPlaceholderApi.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    txt.setText("Code :"+response.code());
                    return;
                }
                Post postResponse =  response.body();

                String content ="";
                content += "Email: " +post.getEmail()+ "\n";
                content += "Password: " +post.getPassword()+ "\n\n";

                txt.append(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                txt.setText(t.getMessage());
            }
        });
    }

    public void getPost(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceholderApi jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);
        Call<List<Post>> call = jsonPlaceholderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    txt.setText("Code :"+response.code());
                    return;
                }

                List<Post> posts = response.body();
                for(Post post:posts){
                    String content ="";
                    content += "Email: " +post.getEmail()+ "\n";
                    content += "Password: " +post.getPassword()+ "\n\n";

                    txt.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                txt.setText(t.getMessage());
            }
        });
    }
}