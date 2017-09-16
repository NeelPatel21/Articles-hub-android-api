package com.neel.articleshub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.neel.articleshubapi.restapi.beans.ArticleDetail;
import com.neel.articleshubapi.restapi.beans.UserDetail;
import com.neel.articleshubapi.restapi.request.AddRequestTask;
import com.neel.articleshubapi.restapi.request.HeaderTools;
import com.neel.articleshubapi.restapi.request.RequestTask;

import org.springframework.http.HttpMethod;

import static com.neel.articleshubapi.restapi.request.HeaderTools.CONTENT_TYPE_JSON;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        RequestTask<ArticleDetail> rt=new RequestTask<>(ArticleDetail.class,CONTENT_TYPE_JSON);
        rt.execute(getResources().getString(R.string.ser_base_url)+"/article/"+2);
        ArticleDetail article=rt.getObj();
        try{
            TextView titleText=(TextView) findViewById(R.id.titleText);
            TextView dateText=(TextView) findViewById(R.id.publishdateText);
            TextView authorText=(TextView) findViewById(R.id.authorText);
            TextView contantText=(TextView) findViewById(R.id.contantText);
            titleText.setText(article.getTitle());
            authorText.setText(article.getAuthor());
            dateText.setText(article.getDate());
            StringBuilder contant=new StringBuilder();
            for(String c:article.getContent())
                contant.append(c).append("\n");
            contantText.setText(contant.toString());
//            RequestTask<ShortUserDetail[]> rt2=
//                    new RequestTask<>(ShortUserDetail[].class);
//            rt2.execute(getResources().getString(R.string.ser_base_url)+"/article/11/likes");
//            ShortUserDetail[] ud=rt2.getObj();
//            for(ShortUserDetail user : ud){
//                Log.i("ShortUserDetail",user.toString());
//            }
//            Log.i("user",ud.toString());
//            RequestTask<CommentDetail> rt3=new RequestTask<>(CommentDetail.class);
//            rt3.execute(getResources().getString(R.string.ser_base_url)+"/comment/19");
//            CommentDetail com=rt3.getObj();
//            Log.i("comment",com.toString());
            UserDetail login =new UserDetail();
            login.setUserName("user1");
            login.setPass("password");
            AddRequestTask<String,UserDetail> rt4=new AddRequestTask<String, UserDetail>(String.class,
                    login, HttpMethod.POST, HeaderTools.CONTENT_TYPE_JSON, HeaderTools.ACCEPT_TEXT);
            rt4.execute(getResources().getString(R.string.ser_base_url)+"/authentication/user1");
            Log.i("login",rt4.getObj());
            RequestTask<String> rt5=new RequestTask<String>(String.class,
                     HttpMethod.POST, HeaderTools.CONTENT_TYPE_JSON, HeaderTools.makeAuth("402881825d691eaa015d693baadf0000"));
            rt5.execute(getResources().getString(R.string.ser_base_url)+"/user/juser/like/13");
            article.setAuthor("user1");
            article.setTitle("android test");
            article.setArticleId(29);
            article.getContent().add("android update");
            AddRequestTask<String,ArticleDetail> rt6=new AddRequestTask<String, ArticleDetail>(String.class,
                    article, HttpMethod.PUT, HeaderTools.CONTENT_TYPE_JSON, HeaderTools.makeAuth("402881825d691eaa015d693baadf0000"));
            rt6.execute(getResources().getString(R.string.ser_base_url)+"/article/29");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
