package com.tm.codemapping.dao;


import java.util.List;
import com.tm.codemapping.pojo.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface OverviewDao {

	@Select("select * from asset_item")
    public List<AssetItemPojo> getOneById();
}
