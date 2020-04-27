package com.ireader.icorki.service;

import com.ireader.icorki.pojo.VO.BookVo;
import com.ireader.icorki.pojo.VO.ContractVO;
import java.util.List;

public interface ContractService {

  void save(ContractVO contractVO);

  void delete(ContractVO contractVO);

  void update(ContractVO contractVO);

  List<ContractVO> listContract();

  BookVo getContract(Long id);

}
