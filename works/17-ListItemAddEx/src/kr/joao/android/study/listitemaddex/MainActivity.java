package kr.joao.android.study.listitemaddex;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.view.menu.MenuView.ItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener,OnItemClickListener {
	
	private EditText editText1,editText2;
	private ItemView listView1;
	
	private Button button1;
	
	private ContactAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		
		listView1 = (ItemView) findViewById(R.id.listView1);
		button1 = (Button) findViewById(R.id.button1);
		
		button1.setOnClickListener(this);
		
		adapter = new ContactAdapter(getApplicationContext(), R.layout.list_item, new ArrayList<Contact>());
		
	}
	
	
	private class ContactAdapter extends ArrayAdapter<Contact>{
		
		int resource;

		public ContactAdapter(Context context, int resource,
				List<Contact> objects) {
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
			
			Contact item = (Contact) getItem(position);
			
			if(item != null){
				TextView textView1 = (TextView) itemView.findViewById(R.id.textView1);
				TextView textView2 = (TextView) itemView.findViewById(R.id.textView1);
				
				item.setName(textView1.getText().toString());
				item.setPhone(textView2.getText().toString());
			}
			
			return itemView;
		}
	}
	

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		Contact item = adapter.getItem(position);
		Toast.makeText(getApplicationContext(), item.toString(), Toast.LENGTH_SHORT);
		
	}

	@Override
	public void onClick(View v) {
		String name = editText1.getText().toString();
		String phone = editText2.getText().toString();
		
		Contact contact = new Contact(name,phone);
		
		adapter.add(contact);
		
		editText1.setText("");
		editText2.setText("");
	}
	
	
	
}
