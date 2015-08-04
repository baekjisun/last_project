package org.it.saan.guest.model;

import java.util.List;

import org.it.saan.guest.model.GuestDto;

public interface GuestRegisterService {
	public int registerService(GuestDto dto);
	public List readService();
}
