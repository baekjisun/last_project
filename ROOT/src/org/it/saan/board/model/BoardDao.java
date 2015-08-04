package org.it.saan.board.model;

import java.util.List;

public interface BoardDao {
	public int createOne(BoardDto dto);
	public BoardDto readOne(String m);
	public List readAll();
}
