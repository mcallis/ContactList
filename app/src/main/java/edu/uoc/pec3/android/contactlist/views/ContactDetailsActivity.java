package edu.uoc.pec3.android.contactlist.views;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.pkmmte.view.CircularImageView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import edu.uoc.pec3.android.contactlist.R;
import edu.uoc.pec3.android.contactlist.manager.FirebaseContactManager;
import edu.uoc.pec3.android.contactlist.model.Contact;
import edu.uoc.pec3.android.contactlist.utils.Alert;

public class ContactDetailsActivity extends AppCompatActivity {

    public static final String CONTACT_ID = "ContactId";

    private CircularImageView mImage;
    private TextView mNameTxt;
    private TextView mPhoneTxt;
    private TextView mEmailTxt;
    private TextView mCityTxt;
    private TextView mDescTxt;
    private Contact mCurrentContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(getArrow());

        // Set views
        mImage = (CircularImageView)findViewById(R.id.circular_image);
        mNameTxt = (TextView)findViewById(R.id.name);
        mPhoneTxt = (TextView)findViewById(R.id.phone);
        mEmailTxt = (TextView)findViewById(R.id.mail);
        mCityTxt = (TextView)findViewById(R.id.city);
        mDescTxt = (TextView)findViewById(R.id.description);

        // Get current contact details
        mCurrentContact = FirebaseContactManager.getInstance().getContactByObjectId(getIntent().getStringExtra(CONTACT_ID));

        if (mCurrentContact == null){
            Alert.show(this, "Contact information is not available");
        } else {
            // Show data
            showDetails();
        }
    }

    /**
     * Method to define color of arrow up button
     * @return
     */
    private Drawable getArrow() {
        final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(ContextCompat.getColor(this, android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        return upArrow;
    }


    private void showDetails() {
        // Fill views
        Picasso.with(this).load(mCurrentContact.getImageUrl()).into(mImage);
        mNameTxt.setText(mCurrentContact.getName());
        mPhoneTxt.setText(mCurrentContact.getPhone());
        mEmailTxt.setText(mCurrentContact.getEmail());
        mCityTxt.setText(mCurrentContact.getCity());
        mDescTxt.setText(mCurrentContact.getDescription());
    }



}
