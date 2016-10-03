package clean.swgreenhouse.com.daggertest.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import clean.swgreenhouse.com.daggertest.R;
import clean.swgreenhouse.com.daggertest.view.fragment.ResourceFragment;
import clean.swgreenhouse.com.data.model.Resource;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Resource} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ResourceRecyclerViewAdapter extends RecyclerView.Adapter<ResourceRecyclerViewAdapter.ViewHolder> {

    public void setmValues(List<Resource> mValues) {
        this.mValues = mValues;
    }

    private List<Resource> mValues;
    private final ResourceFragment.OnListFragmentInteractionListener mListener;


    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Resource item);

    }

    public ResourceRecyclerViewAdapter(ResourceFragment.OnListFragmentInteractionListener listener) {
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_resource, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getId().toString());
        holder.mContentView.setText(mValues.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Resource mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
