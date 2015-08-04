package org.it.saan.guest.model;

import java.util.List;

import org.springframework.stereotype.Component;

public interface GuestDao {
	public int createOne(GuestDto dto);
	public List readLatest();
}
