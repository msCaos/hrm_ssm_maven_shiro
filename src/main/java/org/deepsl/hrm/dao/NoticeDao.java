package org.deepsl.hrm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.deepsl.hrm.dao.provider.NoticeDynaSqlProvider;
import org.deepsl.hrm.domain.Notice;

import static org.deepsl.hrm.util.common.HrmConstants.NOTICETABLE;


/**   
 * @Description: NoticeMapper接口
 * @version V1.0   
 */
public interface NoticeDao {


	List<Notice> selectByPage(Map<String, Object> params);
	
	Integer count(Map<String, Object> params);
		
	@Select("select * from "+NOTICETABLE+" where ID = #{id}")
	Notice selectById(int id);
	
	// 根据id删除公告
	@Delete(" delete from "+NOTICETABLE+" where id = #{id} ")
	void deleteById(Integer id);
		
	// 动态插入公告
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="insertNotice")
	void save(Notice notice);
		
	// 动态修改公告
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="updateNotice")
	void update(Notice notice);
	
}
