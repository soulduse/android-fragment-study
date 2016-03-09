package fragment.soul.com.fragment02;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// ① 액티비티에 사용될 레이아웃을 생성한다. 레이아웃 좌측 영역에 배치될
		//    메뉴 리스트 프래그먼트는 액티비티 레이아웃 XML에 정적으로 정의되어
		//    있어서, 액티비티 레이아웃 생성시 같이 생성 및 추가된다.
		// ====================================================================
		setContentView(R.layout.activity_main);
		// ====================================================================

		// ② 액티비티 레이아웃 우측에 텍스트뷰어 프래그먼트를 추가한다.
		// ====================================================================
		TextViewerFragment textViewerFragment =
				TextViewerFragment.newInstance();
		getFragmentManager()
				.beginTransaction()
				.add( R.id.viewer_fragment_container, textViewerFragment )
				.commit();
		// ====================================================================
		// ③ 액티비티 레이아웃 좌측에 리스트 메뉴 프래그먼트에서 아이템을 선택했을 때
		//    이벤트를 처리하기 위한 리스너를 구현 및 등록한다.
		// ====================================================================
		ListMenuFragment listMenuFragment = (ListMenuFragment)
				getFragmentManager().findFragmentById(
						R.id.menu_fragment );

		listMenuFragment.setOnListItemClickListener(
				new ListMenuFragment.OnListItemClickListener()
				{
					@Override
					public void onItemClick( int itemType )
					{
						// ④ 액티비티 우측 영역 프래그먼트 컨테이너에 현재 보여지고 있는
						//    프래그먼트를 참조한다. 만일 선택된 아이템이 현재 보여지고 있는
						//    프래그먼트라면 아무 처리도 하지 않고 끝내고, 아니라면
						//    보여줘야 할 프래그먼트를 생성해둔다.
						// ============================================================
						Fragment fragment = getFragmentManager().
								findFragmentById( R.id.viewer_fragment_container );

						if( itemType == ListMenuFragment.ITEM_TYPE_TEXT_VIEWER)
						{
							if( fragment instanceof TextViewerFragment == true )
							{
								return;
							}

							fragment = TextViewerFragment.newInstance();
						}
						else if( itemType == ListMenuFragment.ITEM_TYPE_IMAGE_VIEWER )
						{
							if( fragment instanceof ImageViewerFragment == true )
							{
								return;
							}

							fragment = ImageViewerFragment.newInstance();
						}
						// ============================================================
						// ⑤ 선택된 아이템에 해당하는 프래그먼트를 액티비티 우측에 배치한다.
						// ============================================================
						getFragmentManager()
								.beginTransaction()
								.replace( R.id.viewer_fragment_container, fragment )
								.commit();
						// ============================================================
					}
				});
		// ====================================================================
	}
}
