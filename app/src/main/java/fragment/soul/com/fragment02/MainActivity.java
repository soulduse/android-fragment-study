package fragment.soul.com.fragment02;

import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnBackStackChangedListener {

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


		getSupportFragmentManager()
				.beginTransaction()
				.add(R.id.viewer_fragment_container, mTextViewerFragment, "TEXT_VIEWER")
				.add(R.id.viewer_fragment_container, mImageViewerFragment, "IMAGE_VIEWER")
				.hide(mImageViewerFragment)
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
						TextViewerFragment textViewerFragment =
								(TextViewerFragment)getSupportFragmentManager().findFragmentByTag("TEXT_VIEWER");
						ImageViewerFragment imageViewerFragment =
								(ImageViewerFragment)getSupportFragmentManager().findFragmentByTag("IMAGE_VIEWER");

						// ② 당장 보여져야 할 프래그먼트는 show 하고, 보이지 말아야 할
						//    프래그먼트는 hide 한다.
						// =============================================================
						if( itemType == ListMenuFragment.ITEM_TYPE_TEXT_VIEWER && mImageViewerFragment.isVisible())
						{
							getSupportFragmentManager()
									.beginTransaction()
									.hide(mImageViewerFragment)
									.show( mTextViewerFragment )
									.addToBackStack("TEXT_VIEWER_BACKSTACK")
									.commit();

						}
						else if( itemType == ListMenuFragment.ITEM_TYPE_IMAGE_VIEWER && mTextViewerFragment.isVisible())
						{
							getSupportFragmentManager()
									.beginTransaction()
									.hide( mTextViewerFragment )
									.show( mImageViewerFragment )
									.addToBackStack("IMAGE_VIEWER_BACKSTACK")
									.commit();
						}
						//=============================================================
					}
				});

		getSupportFragmentManager().addOnBackStackChangedListener(this);
	}

	@Override
	public void onBackStackChanged() {
		Toast.makeText(getApplicationContext(),
				"Changed BackStack \n"+
				"BackStack Entry Count : "+
				getSupportFragmentManager().getBackStackEntryCount(),
				Toast.LENGTH_LONG).show();
	}

	//<editor-fold desc="Description">
	@Override
	//</editor-fold>
	protected void onDestroy() {
		getSupportFragmentManager().removeOnBackStackChangedListener(this);
		super.onDestroy();
	}
}