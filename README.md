# Android Image Gallery ScrollPager


## Demo
 
![](https://github.com/maarqin/ImageGalleryScrollPager/blob/master/GIF_20170728_115819.gif?raw=true)
 
## Usage

### Step 1

#### Gradle

```groovy
allprojects {
   repositories {
      ... 
      maven { url 'https://jitpack.io' }
   }
}
dependencies {
      compile 'com.github.maarqin:ImageGalleryScrollPager:v1.1'
}
```


#### Maven

```xml
<repositories>
   <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
   </repository>
</repositories>

<dependency>
    <groupId>com.github.maarqin</groupId>
    <artifactId>ImageGalleryScrollPager</artifactId>
    <version>v1.1</version>
</dependency>
```

### Step 2

Add permissions (if necessary) to your `AndroidManifest.xml`

```xml
<!-- if you want to load images from the internet -->
<uses-permission android:name="android.permission.INTERNET" /> 

<!-- if you want to load images from a file OR from the internet -->
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
```

**Note:** If you want to load images from the internet, you need both the `INTERNET` and `READ_EXTERNAL_STORAGE` permissions to allow files from the internet to be cached into local storage.

If you want to load images from drawable, then no additional permissions are necessary.

### Step 3

Add the Slider to your layout:
 
```java
...

<FrameLayout
    android:id="@+id/flImagesProduct"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
    
...     
```
 
 
```java
...

ArrayList<Image> galleryImages = new ArrayList<>();

galleryImages.add(new Image("https://goo.gl/FLsg2K"));
...
galleryImages.add(new Image("https://goo.gl/MHDwhE"));

FragmentManager fragmentManager = getChildFragmentManager();
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

ImageGalleryPagerScrollFragment galleryImageScrollViewFragment = new ImageGalleryPagerScrollFragment();

Bundle bundle = new Bundle();
bundle.putParcelableArrayList(ImageGalleryPagerScrollFragment.ITEMS, galleryImages);

galleryImageScrollViewFragment.setArguments(bundle);

fragmentTransaction.replace(R.id.flImagesProduct, galleryImageScrollViewFragment);

fragmentTransaction.commit();

...
```        
 
## Advanced usage

Please visit [Wiki](https://github.com/daimajia/AndroidImageSlider/wiki)
 
## Thanks

- [Picasso](https://github.com/square/picasso)
- [NineOldAndroids](https://github.com/JakeWharton/NineOldAndroids)
- [ViewPagerTransforms](https://github.com/ToxicBakery/ViewPagerTransforms)

## About me

Hi, I am Marcos and I am from Brazil.
I've been working with web and mobile programming for some years.
I am a student of the Computer Science course and currently work as an Android programmer in a company specializing in mobile development. If you get any problems when using this library, please feel free to [email me](mailto:thomaz.dev@gmail.com). :smiley:
