package com.example.example_511;

import java.util.ArrayList;        //����ArrayList��
import java.util.List;             //����List��

import com.example.example_511.R;

import android.app.Activity;       //����Activity��
import android.content.Context;    //����Context��
import android.os.Bundle;          //����Bundle��
import android.view.LayoutInflater;//����LayoutInflater��
import android.view.View;          //������ͼ��
import android.view.ViewGroup;     //������ͼ����
import android.widget.BaseAdapter; //���������������
import android.widget.GridView;    //����������ͼ��
import android.widget.ImageView;   //����ͼ����ͼ��
import android.widget.ListView;
import android.widget.TextView;    //�����ı���ͼ�� 
import android.widget.Toast;       //����Toast��

public class Example_511 extends Activity {
	/** Called when the activity is first created. */
	private List<MyList> mylist;   //���� MyList�����б�
	private SelfAdapter gridadapter; //����SelfAdapter���󣬸����������Ǳ��������������
	private ListView mylistview;     //����������ͼ����mylistview  
	/** Called when the activity is first created. */  
	@Override  
	public void onCreate(Bundle savedInstanceState) {  //���� onCreate����
		super.onCreate(savedInstanceState);   //���ø����onCreate����
		setContentView(R.layout.main);        //ʹ��main.xml���ɳ��򲼾�
		mylistview = (ListView) findViewById(R.id.listview); //����XML�����mylistview����GridView����   
		try
		{
			mylist = new ArrayList<MyList>();   //ʹ�������б���MyGrid�Ķ����б�
			gridadapter = new SelfAdapter(this);  //�����Զ����SelfAdapter����
			mylist.add(new MyList("Grid_1"));   
			mylist.add(new MyList("Grid_2"));   
			mylist.add(new MyList("Grid_3"));   
			mylist.add(new MyList("Grid_4"));   
			mylist.add(new MyList("Grid_5"));   
			mylist.add(new MyList("Grid_6"));    
			mylist.add(new MyList("Grid_7"));   
			mylist.add(new MyList("Grid_8"));   
			mylist.add(new MyList("Grid_9"));   
			mylist.add(new MyList("Grid_10"));
			mylist.add(new MyList("Grid_11")); 
			mylist.add(new MyList("Grid_12")); 
			mylist.add(new MyList("Grid_13")); 
			mylist.add(new MyList("Grid_13")); 
			/*ʹ��ArrayList��add�������MyGrid����*/
			gridadapter.setList(mylist);       //�Զ�������������ù������б�   
			mylistview.setAdapter(gridadapter);  //ͨ��setAdapter����ͬ�Զ�������������Ĺ���

		}
		/*try�������ܳ����쳣�Ĵ���*/
		catch(Exception e)
		{
			Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
		}
		/*catch�鲶���쳣*/
		finally
		{
			//TODO
		}
		/*finally��Ϊ���Ĵ������*/
	} 

	public class MyList {   
		private String objname;       //MyGrid��ֻ��һ�����ԣ��������Ϊ���������

		/*MyGrid�ඨ����3��������MyGrid ��getObjName��setObjName */
		public MyList(String objname) {   
			super();                  
			this.objname = objname;    //ͨ���ؼ���this������������objname��MyGrid�β�objname
		}   
		/*MyGrid(String name)���Զ���Ĺ��캯��*/

		public String getObjName() {   
			return objname;   
		}   
		/*getObjName����������ȡobjname*/

		public void setObjName(String objname) {   
			this.objname = objname;    //ͨ���ؼ���this������������objname��setObjName�β�objname
		}
		/*setObjName����������ȡobjname*/
	}  

	public class SelfAdapter extends BaseAdapter {   

		private Context context;               //����Context����context
		private List<MyList> gridlist;         //����List����gridlist
		private LayoutInflater layoutinflator; //����LayoutInflater����layoutinflator 
		private class Grider {   
			ImageView imageview; //�����������imageview  
			TextView textview;   //�����������textview 
		} 
		/*SelfAdapter��˽����Grider������ֻ���������ԣ�û�з�����
		 * �����Ĺ���������һ����������ݽṹ*/

		public SelfAdapter(Context context) {   
			super();   
			this.context = context;   //���ݹ��캯���ƶ���Context������SelfAdapter����
		}
		/*SelfAdapter�Ĺ��캯�������ù��캯����Ҫָ��һ�������Ķ���*/

		public void setList(List<MyList> gridlist) {   
			this.gridlist = gridlist;        //ͨ���ؼ���this������������gridlist���β�gridlist
			layoutinflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			//getSystemServiceʹ��Context�ṩ��LAYOUT_INFLATER_SERVICE���Թ���LayoutInflater����
		}   
		/*setList�������ñ������������MyGrid�б�*/

		public int getCount() {   
			// TODO   
			return gridlist.size(); //�����б��Ԫ�ظ���  
		}  
		/*���ر����������б��Ԫ�ظ���*/

		@Override  
		public long getItemId(int index) {   
			return index;   
		}  
		/*getItem������ȡ������ʶ����ʵ�������������ָ����������*/

		@Override  
		public Object getItem(int index) {   
			return gridlist.get(index);   //�����б��е�index��Ԫ��
		}   
		/*getItem����������������ȡgridlist��Ӧ��Ԫ�ؼ�MyGrid����*/

		@Override  
		public View getView(int index, View view, ViewGroup parent) {   
			Grider gridholder;   //����Grider���� gridholder

			if (view != null) 
			{      
				gridholder = (Grider) view.getTag(); //��ȡ��� 

			}
			else
			{   
				gridholder = new Grider();    //����Grider����gridholder
				view = layoutinflator.inflate(R.layout.grid, null); //��ȡR.layout.grid��Ӧ��View����     
				gridholder.imageview = (ImageView)view.findViewById(R.id.XMLimageview); 
				//����grid.xml������ı���ͼ�������gridholder�� imageview���� 
				gridholder.textview = (TextView)view.findViewById(R.id.XMLtextview); 
				//����grid.xml������ı���ͼ�������gridholder�� textview���� 
				view.setTag(gridholder);  //���ñ��      
			}
			/*��viewΪ�գ������ñ�ǡ�����ʹ��getTag������ȡ����*/
			MyList grid = gridlist.get(index);   //����������ȡMyGrid����
			if (grid != null) 
			{      
				gridholder.textview.setText(grid.getObjName());  //���� ���Ӧ���ı�
			}
			else
			{
				//TODO
			}		
			return view;   //����view����
		}
	}  

}