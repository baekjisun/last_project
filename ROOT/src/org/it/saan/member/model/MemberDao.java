package org.it.saan.member.model;

public interface MemberDao {
	public abstract int createOne(MemberDto dto);
	public abstract MemberDto readOne(String id);
	public abstract int manCnt();
	public abstract int womanCnt();
}
