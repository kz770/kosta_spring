package exam05;

import java.util.List;

public class ProtocolHandler {
	private List<Filter> filters;

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}
	
	public void exec() {
		for(Filter filter:filters) {
			filter.pro();
		}
	}
}



