package com.example.jagat.tourguide.customAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jagat.tourguide.R;
import com.example.jagat.tourguide.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyViewHolder> {
    private Context mContext;
    private List<Album> mAlbums;

    public AlbumAdapter(Context mContext,List<Album> albums){
        this.mAlbums=albums;
        this.mContext=mContext;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView thumbnail,overflow;
        public TextView title,count;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail=itemView.findViewById(R.id.thumbnail);
            overflow=itemView.findViewById(R.id.overflow);
            title=itemView.findViewById(R.id.title);
            count=itemView.findViewById(R.id.count);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView=LayoutInflater.from(mContext).inflate(R.layout.album_card,viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        Album album=mAlbums.get(i);
        myViewHolder.title.setText(album.getName());
        myViewHolder.count.setText(album.getNumOfSongs()+" Songs");
        Glide.with(mContext).load(album.getThumbnail()).into(myViewHolder.thumbnail);

        myViewHolder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(myViewHolder.overflow);
            }
        });
    }

    private void showPopupMenu(View view)
    {
        PopupMenu popup=new PopupMenu(mContext,view);
        MenuInflater inflater=popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album,popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener{

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId())
            {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext,"Add to Fav",Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext,"Next song",Toast.LENGTH_SHORT).show();
                    return true;
                    default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return mAlbums.size();
    }


}
