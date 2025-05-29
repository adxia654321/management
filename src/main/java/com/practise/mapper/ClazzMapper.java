package com.practise.mapper;

import com.practise.entity.Clazz;
import com.practise.entity.ClazzQueryParam;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClazzMapper {

    // 條件查詢班級
    public List<Clazz> list(ClazzQueryParam clazzQueryParam);

    // 修改班級
    public void update(Clazz clazz);
}
