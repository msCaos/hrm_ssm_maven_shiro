package org.deepsl.hrm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.deepsl.hrm.dao.provider.DocumentDynaSqlProvider;
import org.deepsl.hrm.domain.Document;

import static org.deepsl.hrm.util.common.HrmConstants.DOCUMENTTABLE;

/**   
 * @Description: DocumentMapper接口  
 * @version V1.0   
 */
public interface DocumentDao {


	List<Document> selectByPage(Map<String, Object> params);
		
 	Integer count(Map<String, Object> params);
		
	// 动态插入文档
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="insertDocument")
	void save(Document document);
	
	@Select("select * from "+DOCUMENTTABLE+" where ID = #{id}")
	Document selectById(int id);
	
	// 根据id删除文档
	@Delete(" delete from "+DOCUMENTTABLE+" where id = #{id} ")
	void deleteById(Integer id);
		
	// 动态修改文档
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="updateDocument")
	void update(Document document);
		
}
