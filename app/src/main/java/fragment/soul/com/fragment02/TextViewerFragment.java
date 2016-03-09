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
public class TextViewerFragment extends Fragment {

	public static TextViewerFragment newInstance(){
		TextViewerFragment f = new TextViewerFragment();

		return f;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// 프래그먼트
		return inflater.inflate(R.layout)
	}
}
