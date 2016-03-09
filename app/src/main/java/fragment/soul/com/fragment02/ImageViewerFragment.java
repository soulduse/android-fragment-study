package fragment.soul.com.fragment02;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sould on 2016-03-09.
 */
public class ImageViewerFragment extends Fragment {

	public static ImageViewerFragment newInstance(){
		ImageViewerFragment f = new ImageViewerFragment();

		return f;
	}


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_image_viewer, container, false);
	}
}
