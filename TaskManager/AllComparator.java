package ProjectB94;

import java.util.Comparator;


class SortByCr_Dt  implements Comparator<TaskBean>
{
	public int compare(TaskBean o1, TaskBean o2) 
	{
		return (o1.getCr_Dt().compareTo(o2.getCr_Dt()));
	}
}


class SortByEnd_Dt  implements Comparator<TaskBean> 
{
	public int compare(TaskBean o1, TaskBean o2) 
	{
		return (o1. getEnd_Dt().compareTo(o2. getEnd_Dt()));
    }
}


class SortByLongestTimeTaken implements Comparator<TaskBean> 
{
	public int compare(TaskBean o1, TaskBean o2)
	{
			return (o1.getEnd_Dt().compareTo(o2.getCr_Dt()));
	}
}


class NameComparator implements Comparator<TaskBean> 
{
	public int compare(TaskBean o1, TaskBean o2) 
	{
		return (o1.getTaskName().compareTo(o2.getTaskName()));
	}
}