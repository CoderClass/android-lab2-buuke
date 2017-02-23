package com.codepath.android.booksearch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.android.booksearch.R;
import com.codepath.android.booksearch.models.Book;
import com.codepath.android.booksearch.models.Publisher;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookDetailActivity extends AppCompatActivity {
    private ImageView ivBookCover;
    private TextView tvTitle;
    private TextView tvAuthor;
    @BindView(R.id.action_bar)
    Toolbar toolbar;
    @BindView(R.id.tvPublishDate)
    TextView tvPublishDate;
    @BindView(R.id.tvPublisher)
    TextView tvPublisher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        // Fetch views
        ivBookCover = (ImageView) findViewById(R.id.ivBookCover);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvAuthor = (TextView) findViewById(R.id.tvAuthor);
        Intent i = getIntent();
        Book book = i.getParcelableExtra("BOOK_DETAIL");
        getSupportActionBar().setTitle(book.getTitle());
        tvAuthor.setText(book.getAuthor());
        tvTitle.setText(book.getTitle());
        tvPublishDate.setText(book.getPublish_date());
//        String publishers = "";
//        for (Publisher pub : book.getPublishers()) {
//            publishers += pub + "|";
//        }
//        tvPublisher.setText(publishers);
        Picasso.with(this)
                .load(book.getCoverUrl())
                .into(ivBookCover);

        // Extract book object from intent extras

        // Use book object to populate data into views
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
