package edu.uoc.pec3.android.contactlist.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.uoc.pec3.android.contactlist.model.Contact;

/**
 * Created by Marc on 11/5/16.
 */
public class ContactsArrayAdapter extends RecyclerView.Adapter<ContactsArrayAdapter.ViewHolder> {

    private List<Contact> mListContacts;

    public ContactsArrayAdapter(List<Contact> listContacts){
        this.mListContacts = listContacts;
    }

    @Override
    public ContactsArrayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ContactsArrayAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
