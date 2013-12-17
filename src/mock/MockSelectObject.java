package mock;

import java.util.ArrayList;

import com.etk.parser.ProjectionCell;
import com.etk.parser.SelectObject;

public class MockSelectObject extends SelectObject {

	public MockSelectObject() {
		super();
	}
	
	@Override
	public ArrayList<String> getNoPrefColNames() {
		ArrayList<String> ret = new ArrayList<String>();
		ret.add("host");
		ret.add("awards");
		return ret;
		
	}
	
	@Override
	public ArrayList<ProjectionCell> getPrefColNames() {
		ArrayList<ProjectionCell> ret = new ArrayList<ProjectionCell>();
		return ret;
	}
	
	@Override
	public ArrayList<String> getTableNames() {
		ArrayList<String> ret = new ArrayList<String>();
		ret.add("festival");
		return ret;

	}
	
}
                      