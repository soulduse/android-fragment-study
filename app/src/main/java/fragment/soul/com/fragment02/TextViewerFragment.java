package fragment.soul.com.fragment02;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TextViewerFragment extends Fragment implements View.OnClickListener{

    private static final String TAG = "soul >> ";
    boolean mIsRead = false;
    private static final int REQUEST_CODE_REQUEST_TEXT_URI = 1;

    // 1. 텍스트 뷰어 프래그먼트 객체를 생성하는 함수다.
    public static TextViewerFragment newInstance() 
    {
        TextViewerFragment f = new TextViewerFragment();
        
        return f;
    }

    @Override
    public void onAttach( Activity activity ) {
        printLog("Fragment onAttach()");
        super.onAttach( activity ); }

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        printLog("Fragment onCreate()");

        if(savedInstanceState != null)
            mIsRead = savedInstanceState.getBoolean("mIsRead");

        super.onCreate(savedInstanceState);
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
        printLog("onCreateView");
        View view = inflater.inflate(R.layout.fragment_text_viewer, container, false);
        Button changeBtn = (Button)view.findViewById(R.id.check_read_state_btn);
        Button showBtn = (Button)view.findViewById(R.id.show_read_state_btn);
        // ① 텍스트 URI를 요청하는 버튼에 클릭 리스너를 설정한다.
        // ====================================================================
        Button requestUriBtn = (Button)view.findViewById(R.id.request_text_uri_btn);
        changeBtn.setOnClickListener(this);
        showBtn.setOnClickListener(this);
        requestUriBtn.setOnClickListener(this);

        return view;
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.check_read_state_btn :
            {
                mIsRead = true;
                break;
            }
            case R.id.show_read_state_btn :
            {
                Toast.makeText(getActivity(), "읽음 여부 : "+mIsRead, Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.request_text_uri_btn :
            {
                // ② 액티비티를 실행하기 위한 인텐트를 생성한다.
                //    인텐트를 생성할 때 인자로 실행될 액티비티의 클래스를 설정한다.
                Intent intent = new Intent(getActivity(), SelectUriActivity.class);
                // ③ 실행될 액티비티에 전달할 값을 인텐트 엑스트라에 설정한다.
                //    전달할 값은 요청할 Uri의 타입이다.
                //    실행되는 프래그먼트를 해당 타입을 보고 이미지 혹은 택스트의 Uri를
                //    반환하게 된다.
                intent.putExtra("UriType", "text");
                // ④ 프래그먼트에서 액티비티를 실행하는 방법은 액티비티에서
                //    다른 액티비티를 실행하는 방법과 같다.
                //    따라서 startActivity 함수로 액티비티를 실행할 수 있다.
                //    그런데 실행되는 액티비티로 부터 결과를 받아야 하기 때문에
                //    startActivityForResult 함수를 사용한다.
                startActivityForResult(intent, REQUEST_CODE_REQUEST_TEXT_URI);
                break;
            }
        }
    }

    // ⑤ 실행된 액티비티 결과를 받기 위해 onActivityResult 함수를 재정의 한다.
    //    프래그먼트에서 실행한 액티비티의 결과를 받는 방법 역시 액티비티 간에 결과를
    //    받는 방법과 같다. 따라서 액티비티와 같이 onActivityResult 함수만 재정의
    //    하면 된다.
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE_REQUEST_TEXT_URI && resultCode == Activity.RESULT_OK){
            // ⑥ 실행된 액티비티의 Uri 결과를 받아 텍스트뷰에 출력한다.
            // ================================================================
            String responseUri = data.getStringExtra("ResponseUri");
            TextView tv = (TextView)getView().findViewById(R.id.show_response_text_uri);
            tv.setText(responseUri);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        printLog("Fragment onSaveInstanceState()");
        outState.putBoolean("mIsRead", mIsRead);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState ) {
        printLog("Fragment onActivityCreated()");
        super.onActivityCreated(savedInstanceState); }

    @Override
    public void onStart() {
        printLog("Fragment 0nStart()");
        super.onStart(); }

    @Override
    public void onResume() {
        printLog("Fragment 0nResume()");
        super.onResume(); }

    @Override
    public void onPause() {
        printLog("Fragment 0nPause()");
        super.onPause(); }

    @Override
    public void onStop() {
        printLog("Fragment 0nStop()");
        super.onStop(); }

    @Override
    public void onDestroyView() {
        printLog("Fragment onDestroyView()");
        super.onDestroyView(); }

    @Override
    public void onDestroy() {
        printLog("Fragment onDestroy()");
        super.onDestroy(); }

    @Override
    public void onDetach() {
        printLog("Fragment onDetach()");
        super.onDetach(); }

    @Override
    public void onHiddenChanged( boolean hidden ) {
        printLog("Fragment onHiddenChanged(" + hidden + ")");
        super.onHiddenChanged(hidden); }

    private void printLog(String message){
        Log.e(TAG, message);
    }

}
