package id.ibam.githubfinder.detail.repolist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ibam.githubfinder.R;
import id.ibam.githubfinder.services.model.repo.UserReposResponse;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

/**
 * Created by Ibam on 11/16/2017.
 */

public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.CustomViewHolder> {
    Context context;
    List<UserReposResponse> repoList;

    public RepoListAdapter(Context c) {
        this.context = c;
        repoList = new ArrayList<>();
    }

    @Override
    public RepoListAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repo, parent, false);

        return new RepoListAdapter.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepoListAdapter.CustomViewHolder holder, int position) {

        UserReposResponse item = repoList.get(position);
        holder.name.setText(item.getName());
        holder.star.setText(item.getStargazersCount() + "");
        holder.fork.setText(item.getForksCount() + "");
        holder.date.setText(item.getCreatedAt().substring(0, 10) + "");
        holder.size.setText(item.getSize() + " Kb");

    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public void setDataSet(List<UserReposResponse> dataSet) {
        this.repoList = dataSet;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.repo_name)
        TextView name;

        @BindView(R.id.star_count)
        TextView star;

        @BindView(R.id.fork_count)
        TextView fork;

        @BindView(R.id.repo_date)
        TextView date;

        @BindView(R.id.repo_size)
        TextView size;

        public CustomViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition() != NO_POSITION) {
                    }
                }
            });
        }


    }
}
