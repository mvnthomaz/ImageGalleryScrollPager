package thomaz.com.br.imagegalleryscrollpager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import thomaz.com.br.imagegalleryscrollpager.R;
import thomaz.com.br.imagegalleryscrollpager.model.ImageGalleryPagerScroll;


/**
 * Created by thomaz on 01/06/17.
 */
public class GalleryImageAdapter<TPI> extends BaseAdapter<TPI, GalleryImageAdapter.ViewHolder>  {

    public GalleryImageAdapter(@NonNull List<TPI> tpis, Context context) {
        super(tpis, R.layout.line_item, context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageGalleryPagerScroll image = ((ImageGalleryPagerScroll) tList.get(position));

        Picasso
                .with(context)
                .load(image.getUrl())
                .into(holder.iv);
    }

    @Override
    protected ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);

            iv = ((ImageView) itemView.findViewById(R.id.iv_element));
        }
    }
}
