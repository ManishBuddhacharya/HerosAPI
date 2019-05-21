package adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.herosapi.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import model.Heroes;
import url.Url;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder>{
    Context mContext;
    List<Heroes> heroLists;

    public HeroAdapter(Context mContext, List<Heroes> heroLists) {
        this.mContext = mContext;
        this.heroLists = heroLists;
    }

    private void StrictMode(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }


    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_heroes, viewGroup, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder heroViewHolder, int i) {
        final Heroes item = heroLists.get(i);
        String imagePath = Url.BASE_URL+"uploads"+item.getImage();
        StrictMode();
        try {
            URL url = new URL(imagePath);
            heroViewHolder.imgProfile.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        heroViewHolder.tvName.setText(item.getName());
        heroViewHolder.tvContact.setText(item.getDesc());

    }

    @Override
    public int getItemCount() {
        return heroLists.size();
    }

    public class HeroViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imgProfile;
        TextView tvName, tvContact;

        public HeroViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            tvName = itemView.findViewById(R.id.tvName);
            tvContact = itemView.findViewById(R.id.tvContact);
        }
    }
}
