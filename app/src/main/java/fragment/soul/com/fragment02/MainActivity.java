package fragment.soul.com.fragment02;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

	TextViewerFragment  mTextViewerFragment = null;
	ImageViewerFragment mImageViewerFragment = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		// ① 액티비티 레이아웃 우측에 나타날 수 있는 뷰어 프래그먼트를 미리 추가하고,
		//    당장 보여지지 말아야 할 추가한 프래그먼트는 감춘다.
		// ====================================================================
		mTextViewerFragment = TextViewerFragment.newInstance();
		mImageViewerFragment = ImageViewerFragment.newInstance();

		getFragmentManager()
				.beginTransaction()
				.add(R.id.viewer_fragment_container, mTextViewerFragment)
				.add(R.id.viewer_fragment_container, mImageViewerFragment)
				.hide( mImageViewerFragment )
				.commit();
		// ====================================================================

		ListMenuFragment listMenuFragment = (ListMenuFragment)
				getFragmentManager().findFragmentById( R.id.menu_fragment );

		listMenuFragment.setOnListItemClickListener(
				new ListMenuFragment.OnListItemClickListener()
				{
					@Override
					public void onItemClick( int itemType )
					{
						// ② 당장 보여져야 할 프래그먼트는 show 하고, 보이지 말아야 할
						//    프래그먼트는 hide 한다.
						// =============================================================
						if( itemType == ListMenuFragment.ITEM_TYPE_TEXT_VIEWER)
						{
							getFragmentManager()
									.beginTransaction()
									.hide( mImageViewerFragment )
									.show( mTextViewerFragment )
									.commit();
						}
						else if( itemType == ListMenuFragment.ITEM_TYPE_IMAGE_VIEWER )
						{
							getFragmentManager()
									.beginTransaction()
									.hide( mTextViewerFragment )
									.show( mImageViewerFragment )
									.commit();
						}
						//=============================================================
					}
				});
	}
}