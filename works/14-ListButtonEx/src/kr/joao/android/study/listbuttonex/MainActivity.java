package kr.joao.android.study.listbuttonex;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnItemClickListener{
	
	FoodAdapter adapter;
	ListView listView1; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView listView1 = (ListView) findViewById(R.id.listView1);
		adapter = new FoodAdapter(getApplicationContext(), R.layout.list_item, new ArrayList<Food>());
		
		listView1.setAdapter(adapter);
		listView1.setOnItemClickListener(this);
		
		addData();
		
		
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		Food choice = adapter.getItem(position);
		
		Toast.makeText(getApplicationContext(), choice.toString(), Toast.LENGTH_SHORT).show();
		
	}

	private class FoodAdapter extends ArrayAdapter<Food>{
		
		// /res/layout/list_item.xml 의 아이디.
		private int resource;

		public FoodAdapter(Context context, int resource, List<Food> objects) {
			super(context, resource, objects);
			
			this.resource = resource;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			View itemView = convertView;
			
			if(itemView == null){
				LayoutInflater li = getLayoutInflater();
				itemView = li.inflate(this.resource, null);
			}
			
			final Food item = getItem(position);
			
			if(item != null){
				TextView textView1 = (TextView) itemView.findViewById(R.id.textView1);
				TextView textView2 = (TextView) itemView.findViewById(R.id.textView2);
				ImageView imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);
				
				Button button1 = (Button) itemView.findViewById(R.id.button1);
				
				imageView1.setImageResource(item.getImg());
				textView2.setText(item.getTitle());
				textView1.setText(item.getContents());
				
				button1.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
						remove(item);
					}
				});
				
			}
			
			return itemView;
		}
		
	}

	  /** 데이터 추가 */
	  public void addData() {
	    adapter.add(new Food("딸기", "꼭지가 마르지 않고 진한 푸른색을 띠는 것이 좋다.", R.drawable.food1));
	    adapter.add(new Food("달래", "알뿌리가 굵은 것일수록 향이 강하다.", R.drawable.food2));
	    adapter.add(new Food("두릅", "두릅순이 연하고 굵은 것, 잎이 피지 않는 것이 좋다.", R.drawable.food3));
	    adapter.add(new Food("감자", "감자의 표면에 흠집이 적으며 매끄러운 것이 좋다.", R.drawable.food4));
	    adapter.add(new Food("참외", "색깔이 선명하고 꼭지가 싱싱한지 확인하여 구입한다.", R.drawable.food5));
	    adapter.add(new Food("복숭아", "알이 크고 고르며 상처가 없으며 향기가 강한 것을 고른다.", R.drawable.food6));
	    adapter.add(new Food("배", "껍질이 팽팽하며 묵직한 것을 고르고 상처가 없는 것이 좋다.", R.drawable.food7));
	    adapter.add(new Food("고구마", "모양이 고르고 병충해의 흠집이 없을 것이 좋다.", R.drawable.food8));
	    adapter.add(new Food("사과", "껍질에 탄력이 있고 꽉찬 느낌이 드는 것이 좋다.", R.drawable.food9));
	    adapter.add(new Food("배추", "배추 잎을 씹어 보면 고소한 맛이 나고 결구의 상태가 둥근 것이 좋다.", R.drawable.food10));
	    adapter.add(new Food("유자", "껍질이 단단하고 울퉁불퉁 한 것, 상처가 없는 것이 좋다.", R.drawable.food11));
	    adapter.add(new Food("과매기", "통통하고 살이 단단한 것을 고른다.", R.drawable.food12));
	  }
}
