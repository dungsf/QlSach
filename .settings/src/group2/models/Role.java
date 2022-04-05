package group2.models;

public class Role {
	private int role_id;
	private String authority;
	
	public Role() {
		super();
	}
	
	public Role(int role_id, String authority) {
		super();
		this.role_id = role_id;
		this.authority = authority;
	}
	
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
