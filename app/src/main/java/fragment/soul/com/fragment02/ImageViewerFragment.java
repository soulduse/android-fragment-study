package fragment.soul.com.fragment02;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ImageViewerFragment extends Fragment {

    // 1. 이미지 뷰어 프래그먼트 객체를 생성하는 함수다.
    public static ImageViewerFragment newInstance() 
    {
        ImageViewerFragment f = new ImageViewerFragment();

        return f;
    }
    
    // 2. 부모 액티비티는 해당 프래그먼트를 구동하고, 액티비티에 추가될 프래그먼트의
    //    레이아웃을 onCreateView 함수의 반환값으로 요구한다. 
    //    따라서 해당 프래그먼트는 onCreateView 재정의 함수에서 자신의 레이아웃을 
    //    생성하고 반환한다.
    @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState )
    {
        return inflater.inflate( R.layout.fragment_image_viewer, 
                                 container, 
                                 false);
    }
}
