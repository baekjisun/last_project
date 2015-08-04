package org.it.saan.member.model;

public interface MemberLogDao {
	public abstract int createOne(String id);
	public abstract int upLog(String id);
	public abstract int upPoint(String id);
}
