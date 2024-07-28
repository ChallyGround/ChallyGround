package com.chally.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user_info
	 * @mbg.generated  Sun Jul 28 22:42:36 KST 2024
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user_info
	 * @mbg.generated  Sun Jul 28 22:42:36 KST 2024
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user_info
	 * @mbg.generated  Sun Jul 28 22:42:36 KST 2024
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbg.generated  Sun Jul 28 22:42:36 KST 2024
	 */
	public UserInfoExample() {
		oredCriteria = new ArrayList<>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbg.generated  Sun Jul 28 22:42:36 KST 2024
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbg.generated  Sun Jul 28 22:42:36 KST 2024
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbg.generated  Sun Jul 28 22:42:36 KST 2024
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbg.generated  Sun Jul 28 22:42:36 KST 2024
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbg.generated  Sun Jul 28 22:42:36 KST 2024
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbg.generated  Sun Jul 28 22:42:36 KST 2024
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbg.generated  Sun Jul 28 22:42:36 KST 2024
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbg.generated  Sun Jul 28 22:42:36 KST 2024
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbg.generated  Sun Jul 28 22:42:36 KST 2024
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbg.generated  Sun Jul 28 22:42:36 KST 2024
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user_info
	 * @mbg.generated  Sun Jul 28 22:42:36 KST 2024
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andOauthIdIsNull() {
			addCriterion("OAUTH_ID is null");
			return (Criteria) this;
		}

		public Criteria andOauthIdIsNotNull() {
			addCriterion("OAUTH_ID is not null");
			return (Criteria) this;
		}

		public Criteria andOauthIdEqualTo(String value) {
			addCriterion("OAUTH_ID =", value, "oauthId");
			return (Criteria) this;
		}

		public Criteria andOauthIdNotEqualTo(String value) {
			addCriterion("OAUTH_ID <>", value, "oauthId");
			return (Criteria) this;
		}

		public Criteria andOauthIdGreaterThan(String value) {
			addCriterion("OAUTH_ID >", value, "oauthId");
			return (Criteria) this;
		}

		public Criteria andOauthIdGreaterThanOrEqualTo(String value) {
			addCriterion("OAUTH_ID >=", value, "oauthId");
			return (Criteria) this;
		}

		public Criteria andOauthIdLessThan(String value) {
			addCriterion("OAUTH_ID <", value, "oauthId");
			return (Criteria) this;
		}

		public Criteria andOauthIdLessThanOrEqualTo(String value) {
			addCriterion("OAUTH_ID <=", value, "oauthId");
			return (Criteria) this;
		}

		public Criteria andOauthIdLike(String value) {
			addCriterion("OAUTH_ID like", value, "oauthId");
			return (Criteria) this;
		}

		public Criteria andOauthIdNotLike(String value) {
			addCriterion("OAUTH_ID not like", value, "oauthId");
			return (Criteria) this;
		}

		public Criteria andOauthIdIn(List<String> values) {
			addCriterion("OAUTH_ID in", values, "oauthId");
			return (Criteria) this;
		}

		public Criteria andOauthIdNotIn(List<String> values) {
			addCriterion("OAUTH_ID not in", values, "oauthId");
			return (Criteria) this;
		}

		public Criteria andOauthIdBetween(String value1, String value2) {
			addCriterion("OAUTH_ID between", value1, value2, "oauthId");
			return (Criteria) this;
		}

		public Criteria andOauthIdNotBetween(String value1, String value2) {
			addCriterion("OAUTH_ID not between", value1, value2, "oauthId");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("EMAIL is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("EMAIL is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("EMAIL =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("EMAIL <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("EMAIL >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("EMAIL >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("EMAIL <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("EMAIL <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("EMAIL like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("EMAIL not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("EMAIL in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("EMAIL not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("EMAIL between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("EMAIL not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("NAME is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("NAME is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("NAME =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("NAME <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("NAME >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("NAME >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("NAME <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("NAME <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("NAME like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("NAME not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("NAME in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("NAME not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("NAME between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("NAME not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andTelIsNull() {
			addCriterion("TEL is null");
			return (Criteria) this;
		}

		public Criteria andTelIsNotNull() {
			addCriterion("TEL is not null");
			return (Criteria) this;
		}

		public Criteria andTelEqualTo(String value) {
			addCriterion("TEL =", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelNotEqualTo(String value) {
			addCriterion("TEL <>", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelGreaterThan(String value) {
			addCriterion("TEL >", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelGreaterThanOrEqualTo(String value) {
			addCriterion("TEL >=", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelLessThan(String value) {
			addCriterion("TEL <", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelLessThanOrEqualTo(String value) {
			addCriterion("TEL <=", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelLike(String value) {
			addCriterion("TEL like", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelNotLike(String value) {
			addCriterion("TEL not like", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelIn(List<String> values) {
			addCriterion("TEL in", values, "tel");
			return (Criteria) this;
		}

		public Criteria andTelNotIn(List<String> values) {
			addCriterion("TEL not in", values, "tel");
			return (Criteria) this;
		}

		public Criteria andTelBetween(String value1, String value2) {
			addCriterion("TEL between", value1, value2, "tel");
			return (Criteria) this;
		}

		public Criteria andTelNotBetween(String value1, String value2) {
			addCriterion("TEL not between", value1, value2, "tel");
			return (Criteria) this;
		}

		public Criteria andBirthIsNull() {
			addCriterion("BIRTH is null");
			return (Criteria) this;
		}

		public Criteria andBirthIsNotNull() {
			addCriterion("BIRTH is not null");
			return (Criteria) this;
		}

		public Criteria andBirthEqualTo(Date value) {
			addCriterion("BIRTH =", value, "birth");
			return (Criteria) this;
		}

		public Criteria andBirthNotEqualTo(Date value) {
			addCriterion("BIRTH <>", value, "birth");
			return (Criteria) this;
		}

		public Criteria andBirthGreaterThan(Date value) {
			addCriterion("BIRTH >", value, "birth");
			return (Criteria) this;
		}

		public Criteria andBirthGreaterThanOrEqualTo(Date value) {
			addCriterion("BIRTH >=", value, "birth");
			return (Criteria) this;
		}

		public Criteria andBirthLessThan(Date value) {
			addCriterion("BIRTH <", value, "birth");
			return (Criteria) this;
		}

		public Criteria andBirthLessThanOrEqualTo(Date value) {
			addCriterion("BIRTH <=", value, "birth");
			return (Criteria) this;
		}

		public Criteria andBirthIn(List<Date> values) {
			addCriterion("BIRTH in", values, "birth");
			return (Criteria) this;
		}

		public Criteria andBirthNotIn(List<Date> values) {
			addCriterion("BIRTH not in", values, "birth");
			return (Criteria) this;
		}

		public Criteria andBirthBetween(Date value1, Date value2) {
			addCriterion("BIRTH between", value1, value2, "birth");
			return (Criteria) this;
		}

		public Criteria andBirthNotBetween(Date value1, Date value2) {
			addCriterion("BIRTH not between", value1, value2, "birth");
			return (Criteria) this;
		}

		public Criteria andDeleteAtIsNull() {
			addCriterion("DELETE_AT is null");
			return (Criteria) this;
		}

		public Criteria andDeleteAtIsNotNull() {
			addCriterion("DELETE_AT is not null");
			return (Criteria) this;
		}

		public Criteria andDeleteAtEqualTo(String value) {
			addCriterion("DELETE_AT =", value, "deleteAt");
			return (Criteria) this;
		}

		public Criteria andDeleteAtNotEqualTo(String value) {
			addCriterion("DELETE_AT <>", value, "deleteAt");
			return (Criteria) this;
		}

		public Criteria andDeleteAtGreaterThan(String value) {
			addCriterion("DELETE_AT >", value, "deleteAt");
			return (Criteria) this;
		}

		public Criteria andDeleteAtGreaterThanOrEqualTo(String value) {
			addCriterion("DELETE_AT >=", value, "deleteAt");
			return (Criteria) this;
		}

		public Criteria andDeleteAtLessThan(String value) {
			addCriterion("DELETE_AT <", value, "deleteAt");
			return (Criteria) this;
		}

		public Criteria andDeleteAtLessThanOrEqualTo(String value) {
			addCriterion("DELETE_AT <=", value, "deleteAt");
			return (Criteria) this;
		}

		public Criteria andDeleteAtLike(String value) {
			addCriterion("DELETE_AT like", value, "deleteAt");
			return (Criteria) this;
		}

		public Criteria andDeleteAtNotLike(String value) {
			addCriterion("DELETE_AT not like", value, "deleteAt");
			return (Criteria) this;
		}

		public Criteria andDeleteAtIn(List<String> values) {
			addCriterion("DELETE_AT in", values, "deleteAt");
			return (Criteria) this;
		}

		public Criteria andDeleteAtNotIn(List<String> values) {
			addCriterion("DELETE_AT not in", values, "deleteAt");
			return (Criteria) this;
		}

		public Criteria andDeleteAtBetween(String value1, String value2) {
			addCriterion("DELETE_AT between", value1, value2, "deleteAt");
			return (Criteria) this;
		}

		public Criteria andDeleteAtNotBetween(String value1, String value2) {
			addCriterion("DELETE_AT not between", value1, value2, "deleteAt");
			return (Criteria) this;
		}

		public Criteria andRegistDtIsNull() {
			addCriterion("REGIST_DT is null");
			return (Criteria) this;
		}

		public Criteria andRegistDtIsNotNull() {
			addCriterion("REGIST_DT is not null");
			return (Criteria) this;
		}

		public Criteria andRegistDtEqualTo(Date value) {
			addCriterion("REGIST_DT =", value, "registDt");
			return (Criteria) this;
		}

		public Criteria andRegistDtNotEqualTo(Date value) {
			addCriterion("REGIST_DT <>", value, "registDt");
			return (Criteria) this;
		}

		public Criteria andRegistDtGreaterThan(Date value) {
			addCriterion("REGIST_DT >", value, "registDt");
			return (Criteria) this;
		}

		public Criteria andRegistDtGreaterThanOrEqualTo(Date value) {
			addCriterion("REGIST_DT >=", value, "registDt");
			return (Criteria) this;
		}

		public Criteria andRegistDtLessThan(Date value) {
			addCriterion("REGIST_DT <", value, "registDt");
			return (Criteria) this;
		}

		public Criteria andRegistDtLessThanOrEqualTo(Date value) {
			addCriterion("REGIST_DT <=", value, "registDt");
			return (Criteria) this;
		}

		public Criteria andRegistDtIn(List<Date> values) {
			addCriterion("REGIST_DT in", values, "registDt");
			return (Criteria) this;
		}

		public Criteria andRegistDtNotIn(List<Date> values) {
			addCriterion("REGIST_DT not in", values, "registDt");
			return (Criteria) this;
		}

		public Criteria andRegistDtBetween(Date value1, Date value2) {
			addCriterion("REGIST_DT between", value1, value2, "registDt");
			return (Criteria) this;
		}

		public Criteria andRegistDtNotBetween(Date value1, Date value2) {
			addCriterion("REGIST_DT not between", value1, value2, "registDt");
			return (Criteria) this;
		}

		public Criteria andUpdtDtIsNull() {
			addCriterion("UPDT_DT is null");
			return (Criteria) this;
		}

		public Criteria andUpdtDtIsNotNull() {
			addCriterion("UPDT_DT is not null");
			return (Criteria) this;
		}

		public Criteria andUpdtDtEqualTo(Date value) {
			addCriterion("UPDT_DT =", value, "updtDt");
			return (Criteria) this;
		}

		public Criteria andUpdtDtNotEqualTo(Date value) {
			addCriterion("UPDT_DT <>", value, "updtDt");
			return (Criteria) this;
		}

		public Criteria andUpdtDtGreaterThan(Date value) {
			addCriterion("UPDT_DT >", value, "updtDt");
			return (Criteria) this;
		}

		public Criteria andUpdtDtGreaterThanOrEqualTo(Date value) {
			addCriterion("UPDT_DT >=", value, "updtDt");
			return (Criteria) this;
		}

		public Criteria andUpdtDtLessThan(Date value) {
			addCriterion("UPDT_DT <", value, "updtDt");
			return (Criteria) this;
		}

		public Criteria andUpdtDtLessThanOrEqualTo(Date value) {
			addCriterion("UPDT_DT <=", value, "updtDt");
			return (Criteria) this;
		}

		public Criteria andUpdtDtIn(List<Date> values) {
			addCriterion("UPDT_DT in", values, "updtDt");
			return (Criteria) this;
		}

		public Criteria andUpdtDtNotIn(List<Date> values) {
			addCriterion("UPDT_DT not in", values, "updtDt");
			return (Criteria) this;
		}

		public Criteria andUpdtDtBetween(Date value1, Date value2) {
			addCriterion("UPDT_DT between", value1, value2, "updtDt");
			return (Criteria) this;
		}

		public Criteria andUpdtDtNotBetween(Date value1, Date value2) {
			addCriterion("UPDT_DT not between", value1, value2, "updtDt");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user_info
	 * @mbg.generated  Sun Jul 28 22:42:36 KST 2024
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_info
     *
     * @mbg.generated do_not_delete_during_merge Sun Jul 21 22:26:23 KST 2024
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}