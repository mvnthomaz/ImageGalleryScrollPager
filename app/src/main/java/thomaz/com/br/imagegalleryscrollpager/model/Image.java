package thomaz.com.br.imagegalleryscrollpager.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by thomaz on 12/05/17.
 */
public class Image implements ImageGalleryPagerScroll {

    private String url;

    public Image(String url) {
        this.url = url;
    }

    public Image() {
    }

    protected Image(Parcel in) {
        url = in.readString();
    }

    public String getUrl() {
        return url;
    }

    public static final Parcelable.Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
    }
}