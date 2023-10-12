package ProjectB94;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskModel {

	public List<TaskBean> getTasks(String catName)
	{
		BufferedReader br=null;
		String line;

		try {
			List<TaskBean> tasks=new ArrayList<TaskBean>();
			TaskBean task;
			br=	new BufferedReader(new FileReader(catName+".todo"));
			while((line=br.readLine())!=null)
			{
				String[]  sa =line.split("-");		
				task =new TaskBean(sa[0],sa[1],sa[2],sa[3],sa[4],sa[5],sa[6]);
				tasks.add(task);

			}
			return tasks;

		} 
		catch (IOException e)
		{
			e.printStackTrace();
			return null;

		}
		catch (NumberFormatException e) 
		{
			e.printStackTrace();
			return null;
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			return null;
		}
		finally {

			try {
				if(br!=null)
					br.close();

			   } 
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}



	public boolean CheckCategoryExists(String catName)
	{
		return new File(catName+ ".todo").exists();
	}
 

	
	public void update(String catName, List<TaskBean> tasks1) 
	{
		BufferedWriter bw=null;
		try {
			bw=	new BufferedWriter(new FileWriter(catName+".todo"));
			
				for (TaskBean task : tasks1)
				{
					bw.write(task.toString());
					bw.flush();
					bw.newLine();
				}
		    }

	    catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				   if(bw!=null)
					bw.close();

			   } 
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		}

	public String  addTask(TaskBean task,String catName)
	{
		BufferedWriter bw=null;
		try {
				bw=	new BufferedWriter(new FileWriter(catName+".todo",true));
				//Date d=new Date();
			//	SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
		//		String plDt=sdf.format(d);
				bw.write(task.toString());
				bw.newLine();
	        	return  Constants.success;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "something went wrong msg= "+e.getMessage();
		}
		finally 
		{
			try
			{
				if(bw!=null)
				bw.close();
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
}
	
	
	
	public List<String> getCategories()
	{
		List<String> li = new ArrayList<String>();

		File f=new File("C:\\Users\\MONIKA\\Desktop\\TaskManager");
		File [] fa=f.listFiles();

		for(File fl:fa)
			if(fl.isFile() && fl.getName().endsWith(".todo") && (fl.isHidden()==false))
			{
				System.out.println("file: "+fl.getName());
				li.add(fl.getName().replace(".todo", ""));

			}
				

		return li;
	}
	
	

	public boolean isCategortExists(String category)
	{
		
		Logger.getInstance().log("Checking for the category "+category);
		return new File(category+".todo").exists();

	}

	
	public List<TaskBean> getTasksBasedOnDueDate(String catName)
	{
		List<TaskBean> li = new ArrayList<TaskBean>();
		li = getTasks(catName);

		return li;
	}
	
	
	
	public String update(TaskBean old, TaskBean newbean,String categoryName)
	{
		BufferedWriter br = null;
		List<TaskBean> litasks = new ArrayList<TaskBean>();
		List<TaskBean> linewtasks = new ArrayList<TaskBean>();
		File f = new File(categoryName+".tasks");
		if(f.exists())
		{
			try
			{
				litasks = getTasks(categoryName);

				for(TaskBean ob : litasks)
				{

					if(!ob.getTaskName().toLowerCase().trim().equals(old.getTaskName().toLowerCase().trim()))
					{
						linewtasks.add(ob);
					}
				}
				linewtasks.add(newbean);
				br = new BufferedWriter(new FileWriter(f));
				for(TaskBean o : linewtasks)
				{
					br.write(o.toString());
					br.newLine();
				}

			}
			catch (IOException e)
			{
				e.printStackTrace();
				return "oops something happened while editing ..." +e.getMessage();
			}
			finally 
			{
				if(br !=null)
				{
					try {
						br.close();
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		return Constants.success;
	}


	public Comparator<TaskBean> getComparator(int a)
	{
		if(a==1)
			return new NameComparator();
		if(a==2)
			return new SortByCr_Dt();
		if(a==3)
			return new SortByEnd_Dt();
		if(a==4)
			return new SortByLongestTimeTaken();

		return new NameComparator();
	}



	public Map<String, List<TaskBean>> findOcc(String word, String catname) 
	{
		Map<String, List<TaskBean>>occ=new HashMap<String, List<TaskBean>>();
		
		occ.put("in name", new ArrayList<>());
		occ.put("in tags", new ArrayList<>());

		occ.put("in desc", new ArrayList<>());

		for(TaskBean b:getTasks(catname))
		{
			if(b.getTaskName().contains(word))
				occ.get("in name").add(b);
			
			if(b.getTags().contains(word))
				occ.get("in tags").add(b);
			
			if(b.getDesc().contains(word))
				occ.get("in desc").add(b);
		}
		
		return occ;
	}
}


