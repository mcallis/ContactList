package edu.uoc.pec3.android.contactlist.views;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import edu.uoc.pec3.android.contactlist.R;
import edu.uoc.pec3.android.contactlist.adapters.ContactsArrayAdapter;
import edu.uoc.pec3.android.contactlist.manager.FirebaseContactManager;
import edu.uoc.pec3.android.contactlist.model.Contact;
import edu.uoc.pec3.android.contactlist.utils.Alert;
import edu.uoc.pec3.android.contactlist.utils.RecyclerItemClickListener;

public class MainActivity extends AppCompatActivity {

    private List<Contact> mListContact;
    private RecyclerView mRecycler;
    private ContactsArrayAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set views
        mRecycler = (RecyclerView)findViewById(R.id.recycler);
        mRecycler.setHasFixedSize(true);
        // Connect the RecyclerView to controller
        LinearLayoutManager llm = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(llm);
        // Detecting gesture
        mRecycler.addOnItemTouchListener(onRecyclerItemClickListener());

        // Get data
        mListContact = FirebaseContactManager.getInstance().getAllContacts();

        // If list is null show alert
        if (mListContact == null){
            Alert.show(this, "Contact information is not available");
        } else {
            // Set adapter
            mAdapter = new ContactsArrayAdapter(this, mListContact);
            mRecycler.setAdapter(mAdapter);
        }

    }

    private RecyclerItemClickListener onRecyclerItemClickListener(){
        return new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Get contact
                Contact currentContact = mListContact.get(position);
                // Intent to Detail
                showDetail(currentContact.getObjectId());
            }
        });
    }

    private void showDetail(String contactID) {
        Intent intent = new Intent(MainActivity.this, ContactDetailsActivity.class);
        // Set contact id
        intent.putExtra(ContactDetailsActivity.CONTACT_ID, contactID);
        startActivity(intent);
    }




}
