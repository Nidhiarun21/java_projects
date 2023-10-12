package ProjectB94;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskBean implements Comparable<TaskBean> {
	
	private String taskName;
	private String desc;
	private String tags;
	private Date cr_Dt; 
	private Date end_Dt;
	private String status;
	private int priority;
	SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
	public TaskBean()
	{
		
	}
	
	
	public TaskBean(String taskName, String desc, String tags, String status, String cr_Dt, String end_Dt, String priority)throws ParseException  {
		
		this.taskName = taskName;
		this.desc = desc;
		this.tags = tags;
		this.status =status;
		this.cr_Dt =sdf1.parse(cr_Dt);
		this.end_Dt=sdf2.parse(end_Dt);
		this.priority =Integer.parseInt(priority);
	}
	@Override
	public String toString() {
		return taskName+"-" +desc+"-" +tags+"-"+status+"-"+sdf1.format(cr_Dt)+"-"+sdf2.format(end_Dt)+"-"+priority;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cr_Dt == null) ? 0 : cr_Dt.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((end_Dt == null) ? 0 : end_Dt.hashCode());
		result = prime * result + priority;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((taskName == null) ? 0 : taskName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskBean other = (TaskBean) obj;
		if (cr_Dt == null) {
			if (other.cr_Dt != null)
				return false;
		} else if (!cr_Dt.equals(other.cr_Dt))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (end_Dt == null) {
			if (other.end_Dt != null)
				return false;
		} else if (!end_Dt.equals(other.end_Dt))
			return false;
		if (priority != other.priority)
			return false;
		
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (taskName == null) {
			if (other.taskName != null)
				return false;
		} else if (!taskName.equals(other.taskName))
			return false;
		return true;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Date getCr_Dt() {
		return cr_Dt;
	}

	public void setCr_Dt(Date cr_Dt) {
		this.cr_Dt = cr_Dt;
	}

	public Date getEnd_Dt() {
		return end_Dt;
	}

	public void setEnd_Dt(Date end_Dt) {
		this.end_Dt = end_Dt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int compareTo(TaskBean o)
	{
		return this.taskName.compareTo(o.taskName);
	}

	
}

	

	
		
	

	
	
	
	

	
	
