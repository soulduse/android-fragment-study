package fragment.soul.com.fragment02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sould on 2016-03-14.
 */
public class SelectUriActivity extends Activity {

	String mUriType = "";
	String mResponseUri = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_uri_layout);

		// ① 프래그먼트로 부터 전달받은 Uri 타입을 인텐트 엑스트라로 부터 추출한다.
		// ====================================================================
		Intent intent = getIntent();
		mUriType = intent.getStringExtra("UriType");


		// ====================================================================
		// ② 전달받은 Uri 타입에 따라 텍스트뷰에 보여질 내용을 달리한다.
		//    텍스트뷰에는 프래그먼트의 요청 타입을 출력하게 된다.
		//    그리고 미리 프래그먼트로 전달할 Uri를 설정해둔다.
		// ====================================================================
		TextView tv = (TextView) findViewById(R.id.request_uri_title);

		if ("image".equals(mUriType) == true) {
			mResponseUri = "/image/1.jpg";
			tv.setText("이미지 경로를 요청");
		} else if ("text".equals(mUriType) == true) {
			mResponseUri = "/text/1.txt";
			tv.setText("텍스트 경로를 요청");
		}
	}

		public void onClick(View v)
		{
			// ③ Uri 전달 버튼을 누르면 액티비티를 실행한 프래그먼트로 결과를 전달한다.
			//    결과 값은 인텐트를 통해 전달한다. 그리고 프래그먼트로 액티비티의 결과값을
			//    전달하는 방법은 액티비티로 결과값을 전달하는 방법과 동일하다.
			// ====================================================================
			Intent responseIntent = new Intent();
			responseIntent.putExtra("ResponseUri", mResponseUri);
			setResult(RESULT_OK, responseIntent);
			finish();
		}
}
