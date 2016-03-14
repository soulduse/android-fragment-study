package fragment.soul.com.fragment02;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sould on 2016-03-14.
 */
public class SelectUriFragment extends Fragment implements View.OnClickListener {

	String mUriType = "";
	String mResponseUri = "";

	public static SelectUriFragment newInstance(){
		SelectUriFragment f = new SelectUriFragment();
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// ① 프래그먼트로 부터 전달받은 Uri 타입을 추출한다.
		// ====================================================================
		Bundle argBundle = getArguments();
		mUriType = argBundle.getString("UriType");

		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.select_uri_layout, container, false);

		// ② 전달받은 Uri 타입에 따라 텍스트뷰에 보여질 내용을 달리한다.
		//    텍스트뷰에는 프래그먼트의 요청 타입을 출력하게 된다.
		//    그리고 미리 프래그먼트로 전달할 Uri를 설정해둔다.
		// ====================================================================
		TextView tv = (TextView)view.findViewById(R.id.request_uri_title);
		if("image".equals(mUriType) == true)
		{
			mResponseUri = "/images/1.jpg";
			tv.setText("이미지 경로를 요청");
		}
		else if("text".equals(mUriType) == true)
		{
			mResponseUri = "/text/1.txt";
			tv.setText("텍스트 경로를 요청");
		}

		// ③ Uri 전달 버튼에 클릭 리스너를 설정한다.
		// ====================================================================
		Button responseBtn = (Button)view.findViewById(R.id.response_uri_btn);
		responseBtn.setOnClickListener(this);

		return view;
	}

	@Override
	public void onClick(View v) {
		// ④ 현재 프래그먼트를 종료한다.
		//    프래그먼트를 종료하기 위해 프래그먼트가 포함된 부모 액티비티의
		//    onBackPressed 함수를 호출한다. 그 이유는 해당 함수 내부에 백스택을
		//    처리하는 popBackStack 함수가 포함되어 있기 때문이다.
		getActivity().onBackPressed();

		// ⑤ Uri 전달 버튼을 누르면 프래그먼트로 결과를 전달한다.
		//    결과 전달 방법은 액티비티의 결과 전달 방법과 동일하게 맞춘다.
		//    프래그먼트가 액티비티의 결과를 받는 코드와 동일하게 구조를 일치시키면
		//    재사용성을 높힐 수 있기 때문이다.
		// ====================================================================
		Intent responseIntent = new Intent();
		responseIntent.putExtra("ResponseUri", mResponseUri);
		getTargetFragment().onActivityResult(getTargetRequestCode(),
				Activity.RESULT_OK, responseIntent);
	}
}
