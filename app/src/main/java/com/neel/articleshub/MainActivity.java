package com.neel.articleshub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.neel.articleshubapi.restapi.beans.ArticleDetail;
import com.neel.articleshubapi.restapi.beans.CommentDetail;
import com.neel.articleshubapi.restapi.beans.UserDetail;
import com.neel.articleshubapi.restapi.request.RequestTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        RequestTask<ArticleDetail> rt=new RequestTask<>(ArticleDetail.class);
        rt.execute(getResources().getString(R.string.ser_base_url)+"/article/"+13);
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
            for(String c:article.getContant())
                contant.append(c).append("\n");
            contantText.setText(contant.toString());
//            RequestTask<UserDetail> rt2=new RequestTask<>(UserDetail.class);
//            rt2.execute(getResources().getString(R.string.ser_base_url)+"/user/username");
//            UserDetail ud=rt2.getObj();
//            Log.i("user",ud.toString());
//            RequestTask<CommentDetail> rt3=new RequestTask<>(CommentDetail.class);
//            rt3.execute(getResources().getString(R.string.ser_base_url)+"/comment/19");
//            CommentDetail com=rt3.getObj();
//            Log.i("comment",com.toString());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
