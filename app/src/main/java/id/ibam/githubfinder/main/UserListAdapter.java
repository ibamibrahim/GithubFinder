package id.ibam.githubfinder.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.ibam.githubfinder.R;
import id.ibam.githubfinder.detail.DetailActivity;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

/**
 * Created by Ibam on 11/15/2017.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.CustomViewHolder> {

    Context context;
    List<String> userList;

    public UserListAdapter(Context c) {
        this.context = c;
        userList = new ArrayList<>();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);

        return new UserListAdapter.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        String name = userList.get(position);
        holder.name.setText(name);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void setDataSet(List<String> dataSet) {
        this.userList = dataSet;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        public CustomViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.username);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition() != NO_POSITION) {
                        Context c = view.getContext();
                        String name = userList.get(getAdapterPosition());
                        Intent intent = new Intent(c, DetailActivity.class);
                        intent.putExtra("name", name);
                        c.startActivity(intent);
                    }
                }
            });
        }


    }
}
