package com.secondfury.attractgroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * Created by Konstantyn Zakharchenko on 19.11.2019.
 */
public class FullDescriptionFragment extends Fragment {
    private DataBundle dataBundle;

    public FullDescriptionFragment(){}
    public static FullDescriptionFragment newInstance() {
        return new FullDescriptionFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.item_full_description, container, false);
        TextView name = root.findViewById(R.id.name);
        TextView time = root.findViewById(R.id.time);

        name.setText(dataBundle.getName());
        time.setText(TimeUtils.prepareTimeForList(dataBundle.getTime()));
        ImageView image = root.findViewById(R.id.image);
        image.setImageBitmap(dataBundle.getImage());


        return root;
    }

    public void setData(DataBundle dataBundle) {
        this.dataBundle = dataBundle;
    }
}
