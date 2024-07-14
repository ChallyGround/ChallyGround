package com.chally.dao;

import com.chally.vo.TestChally;
import com.chally.vo.TestChallyExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface TestChallyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_chally
	 * @mbg.generated  Fri Jul 12 22:36:13 KST 2024
	 */
	long countByExample(TestChallyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_chally
	 * @mbg.generated  Fri Jul 12 22:36:13 KST 2024
	 */
	int deleteByExample(TestChallyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_chally
	 * @mbg.generated  Fri Jul 12 22:36:13 KST 2024
	 */
	int deleteByPrimaryKey(String testSeq);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_chally
	 * @mbg.generated  Fri Jul 12 22:36:13 KST 2024
	 */
	int insert(TestChally row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_chally
	 * @mbg.generated  Fri Jul 12 22:36:13 KST 2024
	 */
	int insertSelective(TestChally row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_chally
	 * @mbg.generated  Fri Jul 12 22:36:13 KST 2024
	 */
	List<TestChally> selectByExample(TestChallyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_chally
	 * @mbg.generated  Fri Jul 12 22:36:13 KST 2024
	 */
	TestChally selectByPrimaryKey(String testSeq);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_chally
	 * @mbg.generated  Fri Jul 12 22:36:13 KST 2024
	 */
	int updateByExampleSelective(@Param("row") TestChally row, @Param("example") TestChallyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_chally
	 * @mbg.generated  Fri Jul 12 22:36:13 KST 2024
	 */
	int updateByExample(@Param("row") TestChally row, @Param("example") TestChallyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_chally
	 * @mbg.generated  Fri Jul 12 22:36:13 KST 2024
	 */
	int updateByPrimaryKeySelective(TestChally row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_chally
	 * @mbg.generated  Fri Jul 12 22:36:13 KST 2024
	 */
	int updateByPrimaryKey(TestChally row);
}