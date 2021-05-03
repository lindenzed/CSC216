/**
 * 
 */


import java.util.Objects;

import edu.ncsu.csc216.req_keeper.state.State;

/**
 * @author zachs
 *
 */
public class Req {
	private final State submitted = new Submitted();
	private final State accepted = new Accepted();
	private final State working = new Working();
	private final State completed = new Completed();
	private final State verified = new Verified();
	private final State rejected = new Rejected();
	private int id;
	private State state;
	private String summary;
	private String acceptanceStateId;
	private int priority;
	private String estimate;
	private String developer;
	private String rejectionReason;
	/**
	 * @param state
	 * @param summary
	 * @param acceptanceStateId
	 */
	public Req( String summary, String acceptanceStateId) {
		this.state = submitted;
		this.summary = summary;
		this.acceptanceStateId = acceptanceStateId;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}
	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * @return the acceptanceStateId
	 */
	public String getAcceptanceStateId() {
		return acceptanceStateId;
	}
	/**
	 * @param acceptanceStateId the acceptanceStateId to set
	 */
	public void setAcceptanceStateId(String acceptanceStateId) {
		this.acceptanceStateId = acceptanceStateId;
	}
	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/**
	 * @return the estimate
	 */
	public String getEstimate() {
		return estimate;
	}
	/**
	 * @param estimate the estimate to set
	 */
	public void setEstimate(String estimate) {
		this.estimate = estimate;
	}
	/**
	 * @return the developer
	 */
	public String getDeveloper() {
		return developer;
	}
	/**
	 * @param developer the developer to set
	 */
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	/**
	 * @return the rejectionReason
	 */
	public String getRejectionReason() {
		return rejectionReason;
	}
	/**
	 * @param rejectionReason the rejectionReason to set
	 */
	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}
	
	/**
	 * 
	 * @return
	 */
	public String[] getDisplayArray() {
		
	}
	
	private class Submitted implements State {

		@Override
		public void accept() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void reject() {
			// TODO Auto-generated method stub
			
		}	
	}
	
	private class Accepted implements State {

		@Override
		public void accept() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void reject() {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class Working implements State {

		@Override
		public void accept() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void reject() {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class Completed implements State {

		@Override
		public void accept() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void reject() {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class Verified implements State {

		@Override
		public void accept() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void reject() {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class Rejected implements State {

		@Override
		public void accept() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void reject() {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(acceptanceStateId, developer, estimate, id, priority, summary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Req other = (Req) obj;
		return Objects.equals(acceptanceStateId, other.acceptanceStateId) && Objects.equals(developer, other.developer)
				&& Objects.equals(estimate, other.estimate) && id == other.id && priority == other.priority
				&& Objects.equals(summary, other.summary);
	}
}
