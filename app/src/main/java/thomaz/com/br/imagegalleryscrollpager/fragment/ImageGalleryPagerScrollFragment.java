package thomaz.com.br.imagegalleryscrollpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import java.util.ArrayList;

import thomaz.com.br.imagegalleryscrollpager.R;
import thomaz.com.br.imagegalleryscrollpager.adapter.GalleryImageAdapter;
import thomaz.com.br.imagegalleryscrollpager.model.ImageGalleryPagerScroll;
import thomaz.com.br.imagegalleryscrollpager.util.RecyclerItemClickListener;


/**
 * Created by thomaz on 27/07/17.
 */
public class ImageGalleryPagerScrollFragment extends Fragment {

    static final public String ITEMS = "ITEMS";

    private SliderLayout slider;
    private RecyclerView rvImages;

    private ArrayList<ImageGalleryPagerScroll> galleryImages = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_gallery_pager_scroll, null);

        View previ = view.findViewById(R.id.bt_previ);

        previ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous();
            }
        });
        View next = view.findViewById(R.id.bt_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });

        slider = ((SliderLayout) view.findViewById(R.id.slider));

        rvImages = ((RecyclerView) view.findViewById(R.id.rvImages));

        Bundle bundle = getArguments();

        if( bundle.containsKey(ITEMS) ) {

            galleryImages = bundle.getParcelableArrayList(ITEMS);

            if( galleryImages != null && galleryImages.size() > 0 ) {
                previ.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
            } else {
                galleryImages = new ArrayList<>();
            }
        }

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvImages.setLayoutManager(layoutManager);

        rvImages.setHasFixedSize(true);
        rvImages.setAdapter(new GalleryImageAdapter<>(galleryImages, getActivity()));
        rvImages.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                int current = slider.getCurrentPosition();

                int diff = position - current;

                if( diff < 0 ) diff *= -1;

                for (int i = 0; i < diff; i++) {
                    if( position > current ) slider.moveNextPosition(); else slider.movePrevPosition();
                }
            }
        }));

        for (int i = 0; i < galleryImages.size(); i++) {
            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            ImageGalleryPagerScroll image = galleryImages.get(i);

            sliderView.image(image.getUrl());

            slider.addSlider(sliderView);
        }

        slider.stopAutoCycle();

        return view;
    }

    private void previous() {
        slider.movePrevPosition();

        rvImages.smoothScrollToPosition(slider.getCurrentPosition());

    }

    private void next() {
        slider.moveNextPosition();

        rvImages.smoothScrollToPosition(slider.getCurrentPosition());
    }

}
