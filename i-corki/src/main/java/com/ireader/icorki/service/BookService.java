package com.ireader.icorki.service;

import com.ireader.icorki.pojo.VO.BookVo;
import java.util.List;

public interface BookService {

  void save(BookVo bookVo);

  void delete(BookVo bookVo);

  void update(BookVo bookVo);

  List<BookVo> listBook();

  BookVo getBook(Long id);

}
