package edu.uw.tacoma.mmuppa.cssappwithdata.Controllers;

import edu.uw.tacoma.mmuppa.cssappwithdata.R;
import edu.uw.tacoma.mmuppa.cssappwithdata.model.Course;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.content.Intent;

import java.util.*;

import edu.uw.tacoma.mmuppa.cssappwithdata.data.CourseDB;

public class CourseListActivity extends ActionBarActivity {

    private ListView mCoursesListView;
    private CourseDB mCourseDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mCoursesListView = (ListView) findViewById(R.id.course_list_view);

        mCourseDB = new CourseDB(this);
        ArrayList<Course> courses = mCourseDB.selectAll();
        mCourseDB.close();

        if (!courses.isEmpty()) {
            CourseAdapter adapter = new CourseAdapter(this, courses);
            mCoursesListView.setAdapter(adapter);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_new) {
            Intent intent = new Intent(this, CourseActivity.class);
            startActivity(intent);

        }
        else if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
