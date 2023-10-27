package com.example.example_511;

import java.util.ArrayList;        //导入ArrayList类
import java.util.List;             //导入List类

import com.example.example_511.R;

import android.app.Activity;       //导入Activity类
import android.content.Context;    //导入Context类
import android.os.Bundle;          //导入Bundle类
import android.view.LayoutInflater;//导入LayoutInflater类
import android.view.View;          //导入视图类
import android.view.ViewGroup;     //导入视图组类
import android.widget.BaseAdapter; //导入基本适配器类
import android.widget.GridView;    //导入网格视图类
import android.widget.ImageView;   //导入图像视图类
import android.widget.ListView;
import android.widget.TextView;    //导入文本视图类 
import android.widget.Toast;       //导入Toast类

public class Example_511 extends Activity {
	/** Called when the activity is first created. */
	private List<MyList> mylist;   //声明 MyList对象列表
	private SelfAdapter gridadapter; //声明SelfAdapter对象，该适配器类是本程序定义的适配器
	private ListView mylistview;     //声明网格视图对象mylistview  
	/** Called when the activity is first created. */  
	@Override  
	public void onCreate(Bundle savedInstanceState) {  //重载 onCreate方法
		super.onCreate(savedInstanceState);   //调用父类的onCreate方法
		setContentView(R.layout.main);        //使用main.xml生成程序布局
		mylistview = (ListView) findViewById(R.id.listview); //根据XML定义的mylistview生成GridView对象   
		try
		{
			mylist = new ArrayList<MyList>();   //使用数组列表创建MyGrid的对象列表
			gridadapter = new SelfAdapter(this);  //创建自定义的SelfAdapter对象
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
			/*使用ArrayList的add方法添加MyGrid对象*/
			gridadapter.setList(mylist);       //自定义的适配器设置关联的列表   
			mylistview.setAdapter(gridadapter);  //通过setAdapter建立同自定义适配器对象的关联

		}
		/*try包含可能出现异常的代码*/
		catch(Exception e)
		{
			Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
		}
		/*catch块捕获异常*/
		finally
		{
			//TODO
		}
		/*finally块为最后的处理代码*/
	} 

	public class MyList {   
		private String objname;       //MyGrid类只有一个属性，这个属性为对象的名字

		/*MyGrid类定义了3个方法：MyGrid 、getObjName和setObjName */
		public MyList(String objname) {   
			super();                  
			this.objname = objname;    //通过关键字this来区分类属性objname和MyGrid形参objname
		}   
		/*MyGrid(String name)是自定义的构造函数*/

		public String getObjName() {   
			return objname;   
		}   
		/*getObjName方法用来获取objname*/

		public void setObjName(String objname) {   
			this.objname = objname;    //通过关键字this来区分类属性objname和setObjName形参objname
		}
		/*setObjName方法用来获取objname*/
	}  

	public class SelfAdapter extends BaseAdapter {   

		private Context context;               //声明Context对象context
		private List<MyList> gridlist;         //声明List对象gridlist
		private LayoutInflater layoutinflator; //声明LayoutInflater对象layoutinflator 
		private class Grider {   
			ImageView imageview; //声明类的属性imageview  
			TextView textview;   //声明类的属性textview 
		} 
		/*SelfAdapter的私有类Grider，该类只有两个属性，没有方法。
		 * 这个类的功能类似于一个特殊的数据结构*/

		public SelfAdapter(Context context) {   
			super();   
			this.context = context;   //根据构造函数制定的Context对象构造SelfAdapter对象
		}
		/*SelfAdapter的构造函数，调用构造函数需要指定一个上下文对象*/

		public void setList(List<MyList> gridlist) {   
			this.gridlist = gridlist;        //通过关键字this来区分类属性gridlist和形参gridlist
			layoutinflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			//getSystemService使用Context提供的LAYOUT_INFLATER_SERVICE属性构造LayoutInflater对象
		}   
		/*setList方法设置本适配器对象的MyGrid列表*/

		public int getCount() {   
			// TODO   
			return gridlist.size(); //返回列表的元素个数  
		}  
		/*返回本适配器的列表的元素个数*/

		@Override  
		public long getItemId(int index) {   
			return index;   
		}  
		/*getItem方法获取索引标识，事实上这个方法返回指定的索引。*/

		@Override  
		public Object getItem(int index) {   
			return gridlist.get(index);   //返回列表中第index个元素
		}   
		/*getItem方法根据索引，获取gridlist对应的元素即MyGrid对象*/

		@Override  
		public View getView(int index, View view, ViewGroup parent) {   
			Grider gridholder;   //声明Grider对象 gridholder

			if (view != null) 
			{      
				gridholder = (Grider) view.getTag(); //获取标记 

			}
			else
			{   
				gridholder = new Grider();    //创建Grider对象gridholder
				view = layoutinflator.inflate(R.layout.grid, null); //获取R.layout.grid对应的View对象     
				gridholder.imageview = (ImageView)view.findViewById(R.id.XMLimageview); 
				//根据grid.xml定义的文本视图组件生成gridholder的 imageview对象 
				gridholder.textview = (TextView)view.findViewById(R.id.XMLtextview); 
				//根据grid.xml定义的文本视图组件生成gridholder的 textview对象 
				view.setTag(gridholder);  //设置标记      
			}
			/*若view为空，则设置标记。否则使用getTag方法获取其标记*/
			MyList grid = gridlist.get(index);   //根据索引获取MyGrid对象
			if (grid != null) 
			{      
				gridholder.textview.setText(grid.getObjName());  //设置 其对应的文本
			}
			else
			{
				//TODO
			}		
			return view;   //返回view对象
		}
	}  

}