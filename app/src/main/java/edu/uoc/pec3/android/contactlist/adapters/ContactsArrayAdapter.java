package edu.uoc.pec3.android.contactlist.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import edu.uoc.pec3.android.contactlist.R;
import edu.uoc.pec3.android.contactlist.model.Contact;

/**
 * Created by Marc on 11/5/16.
 */
public class ContactsArrayAdapter extends RecyclerView.Adapter<ContactsArrayAdapter.ViewHolder> {

    private List<Contact> mListContact;
    private Context mContext;

    public ContactsArrayAdapter(Context context, List<Contact> listContact){
        this.mContext = context;
        this.mListContact = listContact;
    }

    @Override
    public ContactsArrayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);

        ViewHolder pvh = new ViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(ContactsArrayAdapter.ViewHolder holder, int position) {
        // Get contact
        Contact currentContact = mListContact.get(position);
        // Get url
        String urlImage = currentContact.getImageUrl();
        // Fill views
        Picasso.with(mContext).load(urlImage).into(holder.image);
        holder.name.setText(currentContact.getName());
    }

    @Override
    public int getItemCount() {
        if (mListContact == null){
            return 0;
        }
        return mListContact.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView image;
        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image);
            name = (TextView)itemView.findViewById(R.id.name);
        }
    }
}
