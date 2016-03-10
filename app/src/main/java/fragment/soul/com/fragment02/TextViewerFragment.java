package fragment.soul.com.fragment02;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TextViewerFragment extends Fragment {

    private static final String TAG = "soul >> ";

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
        super.onCreate(savedInstanceState); }
    
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

        return inflater.inflate( R.layout.fragment_text_viewer, 
                                 container, 
                                 false);
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
