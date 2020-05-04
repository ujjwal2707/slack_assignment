package com.slack.pojoModels;

public class Channels {

	private String name;
	private String is_channel;
	private String created;
	private Boolean is_archived;
	private String is_general;
	private String creator;

	private int unlinked;
	private String name_normalized;
	private Boolean is_shared;
	private Boolean is_org_shared;
	private Boolean is_member;
	private Boolean is_private;
	private Boolean is_mpim;
	private String[] members;
	private Topic topic;
	private Purpose purpose;
	private String[] previous_names;
	private int num_members;

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIs_channel() {
		return is_channel;
	}

	public void setIs_channel(String is_channel) {
		this.is_channel = is_channel;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public Boolean getIs_archived() {
		return is_archived;
	}

	public void setIs_archived(Boolean is_archived) {
		this.is_archived = is_archived;
	}

	public String getIs_general() {
		return is_general;
	}

	public void setIs_general(String is_general) {
		this.is_general = is_general;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getUnlinked() {
		return unlinked;
	}

	public void setUnlinked(int unlinked) {
		this.unlinked = unlinked;
	}

	public String getName_normalized() {
		return name_normalized;
	}

	public void setName_normalized(String name_normalized) {
		this.name_normalized = name_normalized;
	}

	public Boolean getIs_shared() {
		return is_shared;
	}

	public void setIs_shared(Boolean is_shared) {
		this.is_shared = is_shared;
	}

	public Boolean getIs_org_shared() {
		return is_org_shared;
	}

	public void setIs_org_shared(Boolean is_org_shared) {
		this.is_org_shared = is_org_shared;
	}

	public Boolean getIs_member() {
		return is_member;
	}

	public void setIs_member(Boolean is_member) {
		this.is_member = is_member;
	}

	public Boolean getIs_private() {
		return is_private;
	}

	public void setIs_private(Boolean is_private) {
		this.is_private = is_private;
	}

	public Boolean getIs_mpim() {
		return is_mpim;
	}

	public void setIs_mpim(Boolean is_mpim) {
		this.is_mpim = is_mpim;
	}

	public String[] getMembers() {
		return members;
	}

	public void setMembers(String[] members) {
		this.members = members;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Purpose getPurpose() {
		return purpose;
	}

	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}

	public String[] getPrevious_names() {
		return previous_names;
	}

	public void setPrevious_names(String[] previous_names) {
		this.previous_names = previous_names;
	}

	public int getNum_members() {
		return num_members;
	}

	public void setNum_members(int num_members) {
		this.num_members = num_members;
	}

}
