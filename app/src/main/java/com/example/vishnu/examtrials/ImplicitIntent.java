package com.example.vishnu.examtrials;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ImplicitIntent extends AppCompatActivity {
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
        et = (EditText)findViewById(R.id.editText);


        Paint paint = new Paint();

        paint.setColor(android.graphics.Color.BLACK);
        Bitmap bg = Bitmap.createBitmap(300,400,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        canvas.drawPaint(paint);

        paint.setStrokeWidth(4);
        paint.setColor(android.graphics.Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);

        Point a = new Point(0, 0);
        Point b = new Point(0, 100);
        Point c = new Point(87, 50);

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);
        path.close();

        canvas.drawPath(path, paint);
        LinearLayout ll= (LinearLayout)findViewById(R.id.ll);
        ll.setBackgroundDrawable(new BitmapDrawable(bg));
    }
    public void urlgo(View view){
        String url = et.getText().toString();
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);
    }
}
