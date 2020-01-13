-- client用户表
CREATE TABLE oauth_client_details
(
  client_id               VARCHAR2(256) NOT NULL ,
  resource_ids            VARCHAR2(256),
  client_secret           VARCHAR2(256),
  scope                   VARCHAR2(256),
  authorized_grant_types  VARCHAR2(256),
  web_server_redirect_uri VARCHAR2(256),
  authorities             VARCHAR2(256),
  access_token_validity   NUMBER(10, 0),
  refresh_token_validity  NUMBER(10, 0),
  additional_information  VARCHAR2(2048) ,
  autoapprove             VARCHAR2(256) ,
  CONSTRAINT pk_oauth_details_client_id PRIMARY KEY (client_id)
);
   COMMENT ON TABLE SIOR.oauth_client_details  IS '客户端授权令牌表';
   COMMENT ON COLUMN SIOR.oauth_client_details.client_id IS '客户端ID';
   COMMENT ON COLUMN SIOR.oauth_client_details.resource_ids IS '资源ID集合,多个资源时用逗号(,)分隔';
   COMMENT ON COLUMN SIOR.oauth_client_details.client_secret IS '客户端密匙';
   COMMENT ON COLUMN SIOR.oauth_client_details.scope IS '客户端申请的权限范围';
   COMMENT ON COLUMN SIOR.oauth_client_details.authorized_grant_types IS '客户端支持的grant_type';
   COMMENT ON COLUMN SIOR.oauth_client_details.web_server_redirect_uri IS '重定向URI';
   COMMENT ON COLUMN SIOR.oauth_client_details.authorities IS '客户端所拥有的Spring Security的权限值，多个用逗号(,)分隔';
   COMMENT ON COLUMN SIOR.oauth_client_details.access_token_validity IS '访问令牌有效时间值(单位:秒)';
   COMMENT ON COLUMN SIOR.oauth_client_details.refresh_token_validity IS '更新令牌有效时间值(单位:秒)';
   COMMENT ON COLUMN SIOR.oauth_client_details.additional_information IS '预留字段';
   COMMENT ON COLUMN SIOR.oauth_client_details.autoapprove IS '用户是否自动Approval操作';

-- access_token存储表
CREATE TABLE oauth_access_token
(
  token_id          VARCHAR2(256) ,
  token             BLOB ,
  authentication_id VARCHAR2(256) ,
  user_name         VARCHAR2(256) ,
  client_id         VARCHAR2(256) ,
  authentication    BLOB ,
  refresh_token     VARCHAR2(256)
);
   COMMENT ON TABLE SIOR.oauth_access_token  IS '访问令牌表';
   COMMENT ON COLUMN SIOR.oauth_access_token.token_id IS 'MD5加密的access_token的值';
   COMMENT ON COLUMN SIOR.oauth_access_token.token IS 'OAuth2AccessToken.java对象序列化后的二进制数据';
   COMMENT ON COLUMN SIOR.oauth_access_token.authentication_id IS 'MD5加密过的username,client_id,scope';
   COMMENT ON COLUMN SIOR.oauth_access_token.user_name IS '登录的用户名';
   COMMENT ON COLUMN SIOR.oauth_access_token.client_id IS '客户端ID';
   COMMENT ON COLUMN SIOR.oauth_access_token.authentication IS 'OAuth2Authentication.java对象序列化后的二进制数据';
   COMMENT ON COLUMN SIOR.oauth_access_token.refresh_token IS 'MD5加密果的refresh_token的值';

-- refresh_token存储表
CREATE TABLE oauth_refresh_token
(
  token_id       VARCHAR2(256),
  token          BLOB,
  authentication BLOB
) ;
   COMMENT ON TABLE SIOR.oauth_refresh_token  IS '更新令牌表';
   COMMENT ON COLUMN SIOR.oauth_refresh_token.token_id IS 'MD5加密过的refresh_token的值';
   COMMENT ON COLUMN SIOR.oauth_refresh_token.token IS 'OAuth2RefreshToken.java对象序列化后的二进制数据';
   COMMENT ON COLUMN SIOR.oauth_refresh_token.authentication IS 'OAuth2Authentication.java对象序列化后的二进制数据';
-- 授权记录表
CREATE TABLE oauth_approvals
(
  userid         VARCHAR2(256),
  clientid       VARCHAR2(256) ,
  scope          VARCHAR2(256),
  status         VARCHAR2(10) ,
  expiresat      DATE,
  lastmodifiedat DATE
) ;
COMMENT ON TABLE SIOR.oauth_approvals  IS '授权记录表';
   COMMENT ON COLUMN SIOR.oauth_approvals.userid IS '登录的用户名';
   COMMENT ON COLUMN SIOR.oauth_approvals.clientid IS '客户端ID';
   COMMENT ON COLUMN SIOR.oauth_approvals.scope IS '申请的权限';
   COMMENT ON COLUMN SIOR.oauth_approvals.status IS '状态（Approve或Deny）';
   COMMENT ON COLUMN SIOR.oauth_approvals.expiresat IS '过期时间';
   COMMENT ON COLUMN SIOR.oauth_approvals.lastmodifiedat IS '最终修改时间';



-- 授权码表
CREATE TABLE oauth_code
(
  code           VARCHAR2(256),
  authentication BLOB
) ;
COMMENT ON TABLE SIOR.oauth_code  IS '授权码表';
   COMMENT ON COLUMN SIOR.oauth_code.code IS 'MD5加密过的refresh_token的值';
   COMMENT ON COLUMN SIOR.oauth_code.authentication IS 'OAuth2RefreshToken.java对象序列化后的二进制数据';
-- 客户端授权令牌表
CREATE TABLE oauth_client_token
(
  token_id          VARCHAR2(256) ,
  token             BLOB  ,
  authentication_id VARCHAR2(256) ,
  user_name         VARCHAR2(256) ,
  client_id         VARCHAR2(256)
) ;
COMMENT ON TABLE SIOR.oauth_client_token  IS '客户端授权令牌表';
   COMMENT ON COLUMN SIOR.oauth_client_token.token_id IS 'MD5加密的access_token值';
   COMMENT ON COLUMN SIOR.oauth_client_token.token IS 'OAuth2AccessToken.java对象序列化后的二进制数据';
   COMMENT ON COLUMN SIOR.oauth_client_token.authentication_id IS 'MD5加密过的username,client_id,scope';
   COMMENT ON COLUMN SIOR.oauth_client_token.user_name IS '登录的用户名';
   COMMENT ON COLUMN SIOR.oauth_client_token.client_id IS '客户端ID';

