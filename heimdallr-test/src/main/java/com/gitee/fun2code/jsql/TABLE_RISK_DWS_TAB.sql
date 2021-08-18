--1. RISK_LIC_CARD_APPL
DROP TABLE DWS.RISK_LIC_CARD_APPL;
CREATE TABLE DWS.RISK_LIC_CARD_APPL(
   DW_ETL_DATE             VARCHAR2(8)            -- 跑批日期
  ,CASE_ID                 NUMBER(32)             -- 案件ID
  ,CREATE_TIME             DATE                   -- 进件时间
  ,CUST_NAME               VARCHAR2(100)          -- 客户名称
  ,AGE                     VARCHAR2(8)            -- 年龄
  ,GENDER                  VARCHAR2(8)            -- 性别
  ,CENSUSADD               VARCHAR2(200)          -- 户籍地址
  ,FACE_RECOGN_SC          VARCHAR2(4)            -- 人脸识别分数
  ,MARITALSTATUS           VARCHAR2(8)            -- 婚否
  ,COMPANY                 VARCHAR2(100)          -- 单位名称
  ,COMPANYADD              VARCHAR2(200)          -- 单位地址
  ,DEPT                    VARCHAR2(100)          -- 部门
  ,POST                    VARCHAR2(100)          -- 岗位
  ,CAREER_TYPE             VARCHAR2(64)           -- 职业类型
  ,SALARY_PRE_TAX          VARCHAR2(30)           -- 税前月收入
  ,EDU                     VARCHAR2(100)          -- 学历
  ,SAME_APPL               VARCHAR2(64)           -- 同申标识
  ,PRODUCT_NAME            VARCHAR2(100)          -- 产品
  ,APPL_CARD_RATE          NUMBER(10,3)           -- 申请费率
  ,APPL_LOAN_PURPOS        VARCHAR2(200)          -- 借款用途
  ,NODE_CODE               VARCHAR2(20)           -- 节点
  ,CASE_STATUS             VARCHAR2(20)           -- 案件状态
  ,CASE_PRIORITY           VARCHAR2(20)           -- 案件优先级
  ,UPDATE_TIME             DATE                   -- 结束时间
  ,AUDIT_RESULT            VARCHAR2(64)           -- 审批结果
  ,AUDIT_CODE1             VARCHAR2(16)           -- 审批代码
  ,AUDIT_ADVICE            VARCHAR2(4000)         -- 意见
  ,TRACK_CODE1             VARCHAR2(16)           -- 跟踪代码1
  ,EXCEPTION_AUDIT_CODE1   VARCHAR2(16)           -- 例批代码1
  ,REFUND_CODE1            VARCHAR2(16)           -- 退件代码1
  ,CUST_GROUP1             VARCHAR2(16)           -- 客群1
  ,CUST_GROUP2             VARCHAR2(16)           -- 客群2
  ,AUDIT_RATE              NUMBER(10,3)           -- 审批费率
  ,AUDIT_QUOTA             NUMBER(12,2)           -- 审批额度
  ,AUDIT_TIME              DATE                   -- 审批时间
  ,RH_EDUCATION            VARCHAR2(100)          -- 学历
  ,RH_HOUSE_LOAN           VARCHAR2(100)          -- 房产贷款
  ,RH_ALL_BALANCE          VARCHAR2(100)          -- 所有负债
  ,RH_CARD_BALANCE         VARCHAR2(100)          -- 所有卡负债
  ,RH_SCORE                VARCHAR2(100)          -- 人行分数
  ,RH_QUERY_1              VARCHAR2(100)          -- 人行近1个月查询次数
  ,RH_QUERY_3              VARCHAR2(100)          -- 人行近3个月查询次数
  ,CZ1_OPERATOR            VARCHAR2(100)          -- 查证经办人
  ,CZ1_BEG_TIME            DATE                   -- 查证开始时间
  ,CZ1_END_TIME            DATE                   -- 查证结束时间
  ,SX1_OPERATOR            VARCHAR2(100)          -- 授信1经办人
  ,SX1_BEG_TIME            DATE                   -- 授信1开始时间
  ,SX1_END_TIME            DATE                   -- 授信1开始时间
  ,SX2_OPERATOR            VARCHAR2(100)          -- 授信2经办人
  ,SX2_BEG_TIME            DATE                   -- 授信2开始时间
  ,SX2_END_TIME            DATE                   -- 授信2开始时间
  ,RGFH_OPERATOR           VARCHAR2(100)          -- 人工复核经办人
  ,RGFH_BEG_TIME           DATE                   -- 人工复核开始时间
  ,RGFH_END_TIME           DATE                   -- 人工复核开始时间
  ,BJ_OPERATOR             VARCHAR2(100)          -- 补件经办人
  ,BJ_BEG_TIME             DATE                   -- 补件开始时间
  ,BJ_END_TIME             DATE                   -- 补件开始时间
  ,BAR_CODE                VARCHAR2(16)           -- 申请件号码
  ,PROJECT_CODE            VARCHAR2(16)           -- 项目代码
  ,SOURCE                  VARCHAR2(20)           -- 进件渠道
  ,CZ_CUST_GROUP           VARCHAR2(20)           -- 查证客群
  ,ADVISE_LIMIT            VARCHAR2(30)           -- 策略输出建议额度
  ,ADVISE_CARD_LIMIT       VARCHAR2(30)           -- 信用卡建议额度
  ,DTI                     VARCHAR2(50)           -- 负债收入比
  ,INCOME                  VARCHAR2(20)	          -- 税前收入
  ,DEPOSIT_BASE            NUMBER(12,2)           -- 缴存基数
  ,SALARY_IN_OUT_AVG       NUMBER(12,2)           -- 流水平均值
  ,VISIT_ADDR              VARCHAR2(480)          -- 亲访地址
  ,AM1_NO                  VARCHAR2(32)           -- 客户经理1工号
  ,AM1_NAME                VARCHAR2(100)          -- 客户经理1姓名
  ,AM1_SUB_BRANCH_NAME     VARCHAR2(100)          -- 客户经理1所属支行名称
  ,AM2_NO                  VARCHAR2(32)           -- 客户经理2工号
  ,AM2_NAME                VARCHAR2(100)          -- 客户经理2姓名
  ,AM2_SUB_BRANCH_NAME     VARCHAR2(100)          -- 客户经理2所属支行名称
);

--2. RISK_LIC_LOAN_APPL
DROP TABLE DWS.RISK_LIC_LOAN_APPL;
CREATE TABLE DWS.RISK_LIC_LOAN_APPL(
   DW_ETL_DATE             VARCHAR2(8)            -- 跑批日期
  ,CASE_ID                 NUMBER(32)             -- 案件ID
  ,CREATE_TIME             DATE                   -- 进件时间
  ,CUST_NAME               VARCHAR2(100)          -- 客户名称
  ,AGE                     VARCHAR2(8)            -- 年龄
  ,GENDER                  VARCHAR2(8)            -- 性别
  ,CENSUSADD               VARCHAR2(200)          -- 户籍地址
  ,FACE_RECOGN_SC          VARCHAR2(4)            -- 人脸识别分数
  ,MARITALSTATUS           VARCHAR2(8)            -- 婚否
  ,COMPANY                 VARCHAR2(100)          -- 单位名称
  ,COMPANYADD              VARCHAR2(200)          -- 单位地址
  ,DEPT                    VARCHAR2(100)          -- 部门
  ,POST                    VARCHAR2(100)          -- 岗位
  ,CAREER_TYPE             VARCHAR2(64)           -- 职业类型
  ,SALARY_PRE_TAX          VARCHAR2(30)           -- 税前月收入
  ,EDU                     VARCHAR2(100)          -- 学历
  ,SAME_APPL               VARCHAR2(64)           -- 同申标识
  ,PRODUCT_NAME            VARCHAR2(100)          -- 产品
  ,APPL_PAY_TYPE           VARCHAR2(16)           -- 申请还款类型
  ,APPL_LOAN_AMT           VARCHAR2(20)           -- 申请借款金额
  ,APPL_LOAN_PERIODS       VARCHAR2(4)            -- 贷款期限
  ,APPL_LOAN_RATE          NUMBER(10,3)           -- 申请费率
  ,APPL_LOAN_PURPOS        VARCHAR2(200)          -- 借款用途
  ,NODE_CODE               VARCHAR2(20)           -- 节点
  ,CASE_STATUS             VARCHAR2(20)           -- 案件状态
  ,CASE_PRIORITY           VARCHAR2(20)           -- 案件优先级
  ,UPDATE_TIME             DATE                   -- 结束时间
  ,AUDIT_RESULT            VARCHAR2(64)           -- 审批结果
  ,AUDIT_CODE1             VARCHAR2(16)           -- 审批代码
  ,AUDIT_ADVICE            VARCHAR2(4000)         -- 意见
  ,AUDIT_LOAN_PERIODS      NUMBER(11)             -- 分期期数
  ,TRACK_CODE1             VARCHAR2(16)           -- 跟踪代码1
  ,EXCEPTION_AUDIT_CODE1   VARCHAR2(16)           -- 例批代码1
  ,REFUND_CODE1            VARCHAR2(16)           -- 退件代码1
  ,CUST_GROUP1             VARCHAR2(16)           -- 客群1
  ,CUST_GROUP2             VARCHAR2(16)           -- 客群2
  ,AUDIT_PAY_TYPE          VARCHAR2(16)           -- 还款方式
  ,AUDIT_RATE              NUMBER(10,3)           -- 审批费率
  ,AUDIT_QUOTA             NUMBER(12,2)           -- 审批额度
  ,AUDIT_TIME              DATE                   -- 审批时间
  ,RH_EDUCATION            VARCHAR2(100)          -- 学历
  ,RH_HOUSE_LOAN           VARCHAR2(100)          -- 房产贷款
  ,RH_ALL_BALANCE          VARCHAR2(100)          -- 所有负债
  ,RH_CARD_BALANCE         VARCHAR2(100)          -- 所有卡负债
  ,RH_SCORE                VARCHAR2(100)          -- 人行分数
  ,RH_QUERY_1              VARCHAR2(100)          -- 人行近1个月查询次数
  ,RH_QUERY_3              VARCHAR2(100)          -- 人行近3个月查询次数
  ,CZ1_OPERATOR            VARCHAR2(100)          -- 查证经办人
  ,CZ1_BEG_TIME            DATE                   -- 查证开始时间
  ,CZ1_END_TIME            DATE                   -- 查证结束时间
  ,SX1_OPERATOR            VARCHAR2(100)          -- 授信1经办人
  ,SX1_BEG_TIME            DATE                   -- 授信1开始时间
  ,SX1_END_TIME            DATE                   -- 授信1开始时间
  ,SX2_OPERATOR            VARCHAR2(100)          -- 授信2经办人
  ,SX2_BEG_TIME            DATE                   -- 授信2开始时间
  ,SX2_END_TIME            DATE                   -- 授信2开始时间
  ,RGFH_OPERATOR           VARCHAR2(100)          -- 人工复核经办人
  ,RGFH_BEG_TIME           DATE                   -- 人工复核开始时间
  ,RGFH_END_TIME           DATE                   -- 人工复核开始时间
  ,BJ_OPERATOR             VARCHAR2(100)          -- 补件经办人
  ,BJ_BEG_TIME             DATE                   -- 补件开始时间
  ,BJ_END_TIME             DATE                   -- 补件开始时间
  ,BAR_CODE                VARCHAR2(16)           -- 申请件号码
  ,PROJECT_CODE            VARCHAR2(16)           -- 项目代码
  ,SOURCE                  VARCHAR2(20)           -- 进件渠道
  ,CZ_CUST_GROUP           VARCHAR2(20)           -- 查证客群
  ,ADVISE_LIMIT            VARCHAR2(30)           -- 策略输出建议额度
  ,ADVISE_CARD_LIMIT       VARCHAR2(30)           -- 信用卡建议额度
  ,DTI                     VARCHAR2(50)           -- 负债收入比
  ,INCOME                  VARCHAR2(20)	          -- 税前收入
  ,DEPOSIT_BASE            NUMBER(12,2)           -- 缴存基数
  ,SALARY_IN_OUT_AVG       NUMBER(12,2)           -- 流水平均值
  ,VISIT_ADDR              VARCHAR2(480)          -- 亲访地址
  ,AM1_NO                  VARCHAR2(32)           -- 客户经理1工号
  ,AM1_NAME                VARCHAR2(100)          -- 客户经理1姓名
  ,AM1_SUB_BRANCH_NAME     VARCHAR2(100)          -- 客户经理1所属支行名称
  ,AM2_NO                  VARCHAR2(32)           -- 客户经理2工号
  ,AM2_NAME                VARCHAR2(100)          -- 客户经理2姓名
  ,AM2_SUB_BRANCH_NAME     VARCHAR2(100)          -- 客户经理2所属支行名称
);

-------------------------
--3.进件整体情况报表
-------------------------
DROP TABLE DWS.RISK_APPLY_INFO ;
CREATE TABLE DWS.RISK_APPLY_INFO(
  DW_ETL_DATE                                       VARCHAR2(8)
 ,PROD_ID                                           VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APPL_CNT                                          NUMBER(18,2)
 ,APPR_CNT                                          NUMBER(18,2)
 ,DECL_CNT                                          NUMBER(18,2)
 ,CANC_CNT                                          NUMBER(18,2)
 ,DEAL_CNT                                          NUMBER(18,2)
 ,APPR_RATIO                                        NUMBER(18,2)
 ,APPL_AMT                                          NUMBER(18,2)
 ,APPR_AMT                                          NUMBER(18,2)
 ,LOAN_AMT                                          NUMBER(18,2)
 ,LOAN_APPR_RATIO_AMT                               NUMBER(18,2)
 ,REJ_NO_ADMIT_PROP                                 NUMBER(18,2)
 ,REJ_HIGH_CKTM_PROP                                NUMBER(18,2)
 ,REJ_HIGH_DEBT_PROP                                NUMBER(18,2)
 ,REJ_NO_QUOTA_PROP                                 NUMBER(18,2)
 ,REJ_RH_SCORE_LOW_PROP                             NUMBER(18,2)
 ,REJ_CRDT_RPT_BAD_PROP                             NUMBER(18,2)
 ,REJ_LOAN_PURPOS_PROP                              NUMBER(18,2)
 ,REJ_AUDIT_OTHER_PROP                              NUMBER(18,2)
);
-------------------------
--4.随时分进件整体情况报表
-------------------------
DROP TABLE DWS.RISK_LOAN_APPLY_INFO ;
CREATE TABLE DWS.RISK_LOAN_APPLY_INFO(
  DW_ETL_DATE                                       VARCHAR2(8)
 ,SUB_BRANCH_ID                                     VARCHAR2(32)
 ,SUB_BRANCH_NAME                                   VARCHAR2(100)
 ,BRANCH_ID                                         VARCHAR2(32)
 ,BRANCH_NAME                                       VARCHAR2(100)
 ,PROD_ID                                           VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APPL_CNT                                          NUMBER(18,2)
 ,APPR_CNT                                          NUMBER(18,2)
 ,DECL_CNT                                          NUMBER(18,2)
 ,CANC_CNT                                          NUMBER(18,2)
 ,DEAL_CNT                                          NUMBER(18,2)
 ,APPL_AMT                                          NUMBER(18,2)
 ,APPR_AMT                                          NUMBER(18,2)
 ,LOAN_AMT                                          NUMBER(18,2)
 ,DEAL_APPL_AMT                                     NUMBER(18,2)
 ,REJ_NO_ADMIT                                      NUMBER(18,2)
 ,REJ_HIGH_CKTM                                     NUMBER(18,2)
 ,REJ_HIGH_DEBT                                     NUMBER(18,2)
 ,REJ_NO_QUOTA                                      NUMBER(18,2)
 ,REJ_RH_SCORE_LOW                                  NUMBER(18,2)
 ,REJ_CRDT_RPT_BAD                                  NUMBER(18,2)
 ,REJ_LOAN_PURPOS                                   NUMBER(18,2)
 ,REJ_AUDIT_OTHER                                   NUMBER(18,2)
);
-------------------------
--5.随时借进件整体情况报表
-------------------------
DROP TABLE DWS.RISK_CARD_APPLY_INFO ;
CREATE TABLE DWS.RISK_CARD_APPLY_INFO(
  DW_ETL_DATE                                       VARCHAR2(8)
 ,SUB_BRANCH_ID                                     VARCHAR2(32)
 ,SUB_BRANCH_NAME                                   VARCHAR2(100)
 ,BRANCH_ID                                         VARCHAR2(32)
 ,BRANCH_NAME                                       VARCHAR2(100)
 ,PROD_ID                                           VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APPL_CNT                                          NUMBER(18,2)
 ,APPR_CNT                                          NUMBER(18,2)
 ,DECL_CNT                                          NUMBER(18,2)
 ,CANC_CNT                                          NUMBER(18,2)
 ,DEAL_CNT                                          NUMBER(18,2)
 ,APPL_AMT                                          NUMBER(18,2)
 ,APPR_AMT                                          NUMBER(18,2)
 ,LOAN_AMT                                          NUMBER(18,2)
 ,DEAL_APPL_AMT                                     NUMBER(18,2)
 ,REJ_NO_ADMIT                                      NUMBER(18,2)
 ,REJ_HIGH_CKTM                                     NUMBER(18,2)
 ,REJ_HIGH_DEBT                                     NUMBER(18,2)
 ,REJ_NO_QUOTA                                      NUMBER(18,2)
 ,REJ_RH_SCORE_LOW                                  NUMBER(18,2)
 ,REJ_CRDT_RPT_BAD                                  NUMBER(18,2)
 ,REJ_LOAN_PURPOS                                   NUMBER(18,2)
 ,REJ_AUDIT_OTHER                                   NUMBER(18,2)
);
-------------------------
--6.当月随时分进件整体情况报表
-------------------------
DROP TABLE DWS.RISK_LOAN_APPLY_INFO_MON ;
CREATE TABLE DWS.RISK_LOAN_APPLY_INFO_MON(
  DW_ETL_MON                                        VARCHAR2(8)
 ,SUB_BRANCH_ID                                     VARCHAR2(32)
 ,SUB_BRANCH_NAME                                   VARCHAR2(100)
 ,BRANCH_ID                                         VARCHAR2(32)
 ,BRANCH_NAME                                       VARCHAR2(100)
 ,PROD_ID                                           VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APPL_CNT                                          NUMBER(18,2)
 ,APPR_CNT                                          NUMBER(18,2)
 ,DECL_CNT                                          NUMBER(18,2)
 ,CANC_CNT                                          NUMBER(18,2)
 ,DEAL_CNT                                          NUMBER(18,2)
 ,APPL_AMT                                          NUMBER(18,2)
 ,APPR_AMT                                          NUMBER(18,2)
 ,LOAN_AMT                                          NUMBER(18,2)
 ,DEAL_APPL_AMT                                     NUMBER(18,2)
 ,REJ_NO_ADMIT                                      NUMBER(18,2)
 ,REJ_HIGH_CKTM                                     NUMBER(18,2)
 ,REJ_HIGH_DEBT                                     NUMBER(18,2)
 ,REJ_NO_QUOTA                                      NUMBER(18,2)
 ,REJ_RH_SCORE_LOW                                  NUMBER(18,2)
 ,REJ_CRDT_RPT_BAD                                  NUMBER(18,2)
 ,REJ_LOAN_PURPOS                                   NUMBER(18,2)
 ,REJ_AUDIT_OTHER                                   NUMBER(18,2)
);
-------------------------
--7.当月随时借进件整体情况报表
-------------------------
DROP TABLE DWS.RISK_CARD_APPLY_INFO_MON ;
CREATE TABLE DWS.RISK_CARD_APPLY_INFO_MON(
  DW_ETL_MON                                        VARCHAR2(8)
 ,SUB_BRANCH_ID                                     VARCHAR2(32)
 ,SUB_BRANCH_NAME                                   VARCHAR2(100)
 ,BRANCH_ID                                         VARCHAR2(32)
 ,BRANCH_NAME                                       VARCHAR2(100)
 ,PROD_ID                                           VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APPL_CNT                                          NUMBER(18,2)
 ,APPR_CNT                                          NUMBER(18,2)
 ,DECL_CNT                                          NUMBER(18,2)
 ,CANC_CNT                                          NUMBER(18,2)
 ,DEAL_CNT                                          NUMBER(18,2)
 ,APPL_AMT                                          NUMBER(18,2)
 ,APPR_AMT                                          NUMBER(18,2)
 ,LOAN_AMT                                          NUMBER(18,2)
 ,DEAL_APPL_AMT                                     NUMBER(18,2)
 ,REJ_NO_ADMIT                                      NUMBER(18,2)
 ,REJ_HIGH_CKTM                                     NUMBER(18,2)
 ,REJ_HIGH_DEBT                                     NUMBER(18,2)
 ,REJ_NO_QUOTA                                      NUMBER(18,2)
 ,REJ_RH_SCORE_LOW                                  NUMBER(18,2)
 ,REJ_CRDT_RPT_BAD                                  NUMBER(18,2)
 ,REJ_LOAN_PURPOS                                   NUMBER(18,2)
 ,REJ_AUDIT_OTHER                                   NUMBER(18,2)
);
-------------------------
--8.当月进件整体情况报表
-------------------------
DROP TABLE DWS.RISK_APPLY_INFO_MON ;
CREATE TABLE DWS.RISK_APPLY_INFO_MON(
  DW_ETL_MON                                        VARCHAR2(8)
 ,PROD_ID                                           VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APPL_CNT                                          NUMBER(18,2)
 ,APPR_CNT                                          NUMBER(18,2)
 ,DECL_CNT                                          NUMBER(18,2)
 ,CANC_CNT                                          NUMBER(18,2)
 ,DEAL_CNT                                          NUMBER(18,2)
 ,APPR_RATIO                                        NUMBER(18,2)
 ,APPL_AMT                                          NUMBER(18,2)
 ,APPR_AMT                                          NUMBER(18,2)
 ,LOAN_AMT                                          NUMBER(18,2)
 ,LOAN_APPR_RATIO_AMT                               NUMBER(18,2)
 ,REJ_NO_ADMIT_PROP                                 NUMBER(18,2)
 ,REJ_HIGH_CKTM_PROP                                NUMBER(18,2)
 ,REJ_HIGH_DEBT_PROP                                NUMBER(18,2)
 ,REJ_NO_QUOTA_PROP                                 NUMBER(18,2)
 ,REJ_RH_SCORE_LOW_PROP                             NUMBER(18,2)
 ,REJ_CRDT_RPT_BAD_PROP                             NUMBER(18,2)
 ,REJ_LOAN_PURPOS_PROP                              NUMBER(18,2)
 ,REJ_AUDIT_OTHER_PROP                              NUMBER(18,2)
);
-------------------------
--9.渠道批核情况报表
-------------------------
DROP TABLE DWS.RISK_CHNL_APPROVE_INFO ;
CREATE TABLE DWS.RISK_CHNL_APPROVE_INFO(
  DW_ETL_MON                                        VARCHAR2(8)
 ,BRANCH_ID                                         VARCHAR2(32)
 ,BRANCH_NAME                                       VARCHAR2(100)
 ,SUB_BRANCH_ID                                     VARCHAR2(32)
 ,SUB_BRANCH_NAME                                   VARCHAR2(100)
 ,PROD_ID                                           VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APPL_CNT                                          NUMBER(18,2)
 ,APPR_CNT                                          NUMBER(18,2)
 ,DECL_CNT                                          NUMBER(18,2)
 ,CANC_CNT                                          NUMBER(18,2)
 ,DEAL_CNT                                          NUMBER(18,2)
 ,APPL_AMT                                          NUMBER(18,2)
 ,APPR_AMT                                          NUMBER(18,2)
 ,LOAN_AMT                                          NUMBER(18,2)
 ,DEAL_APPL_AMT                                     NUMBER(18,2)
 ,REJ_NO_ADMIT                                      NUMBER(18,2)
 ,REJ_HIGH_CKTM                                     NUMBER(18,2)
 ,REJ_HIGH_DEBT                                     NUMBER(18,2)
 ,REJ_NO_QUOTA                                      NUMBER(18,2)
 ,REJ_RH_SCORE_LOW                                  NUMBER(18,2)
 ,REJ_CRDT_RPT_BAD                                  NUMBER(18,2)
 ,REJ_LOAN_PURPOS                                   NUMBER(18,2)
 ,REJ_AUDIT_OTHER                                   NUMBER(18,2)
);
-------------------------
--10.随时分客群批核情况报表
-------------------------
DROP TABLE DWS.RISK_LOAN_CUST_GROUP_PROP ;
CREATE TABLE DWS.RISK_LOAN_CUST_GROUP_PROP(
  DW_ETL_MON                                        VARCHAR2(8)
 ,PROD_ID                                           VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,CUST_GROUP1                                       VARCHAR2(10)
 ,APPL_CNT                                          NUMBER(18,2)
 ,APPR_CNT                                          NUMBER(18,2)
 ,DECL_CNT                                          NUMBER(18,2)
 ,CANC_CNT                                          NUMBER(18,2)
 ,DEAL_CNT                                          NUMBER(18,2)
 ,APPL_AMT                                          NUMBER(18,2)
 ,APPR_AMT                                          NUMBER(18,2)
 ,LOAN_AMT                                          NUMBER(18,2)
 ,DEAL_APPL_AMT                                     NUMBER(18,2)
 ,REJ_NO_ADMIT                                      NUMBER(18,2)
 ,REJ_HIGH_CKTM                                     NUMBER(18,2)
 ,REJ_HIGH_DEBT                                     NUMBER(18,2)
 ,REJ_NO_QUOTA                                      NUMBER(18,2)
 ,REJ_RH_SCORE_LOW                                  NUMBER(18,2)
 ,REJ_CRDT_RPT_BAD                                  NUMBER(18,2)
 ,REJ_LOAN_PURPOS                                   NUMBER(18,2)
 ,REJ_AUDIT_OTHER                                   NUMBER(18,2)
);
-------------------------
--11.随时借客群批核情况报表
-------------------------
DROP TABLE DWS.RISK_CARD_CUST_GROUP_PROP ;
CREATE TABLE DWS.RISK_CARD_CUST_GROUP_PROP(
  DW_ETL_MON                                        VARCHAR2(8)
 ,PROD_ID                                           VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,CUST_GROUP1                                       VARCHAR2(10)
 ,APPL_CNT                                          NUMBER(18,2)
 ,APPR_CNT                                          NUMBER(18,2)
 ,DECL_CNT                                          NUMBER(18,2)
 ,CANC_CNT                                          NUMBER(18,2)
 ,DEAL_CNT                                          NUMBER(18,2)
 ,APPL_AMT                                          NUMBER(18,2)
 ,APPR_AMT                                          NUMBER(18,2)
 ,LOAN_AMT                                          NUMBER(18,2)
 ,DEAL_APPL_AMT                                     NUMBER(18,2)
 ,REJ_NO_ADMIT                                      NUMBER(18,2)
 ,REJ_HIGH_CKTM                                     NUMBER(18,2)
 ,REJ_HIGH_DEBT                                     NUMBER(18,2)
 ,REJ_NO_QUOTA                                      NUMBER(18,2)
 ,REJ_RH_SCORE_LOW                                  NUMBER(18,2)
 ,REJ_CRDT_RPT_BAD                                  NUMBER(18,2)
 ,REJ_LOAN_PURPOS                                   NUMBER(18,2)
 ,REJ_AUDIT_OTHER                                   NUMBER(18,2)
);
-------------------------
--12.客群分布情况报表
-------------------------
DROP TABLE DWS.RISK_CUST_GROUP_PROP ;
CREATE TABLE DWS.RISK_CUST_GROUP_PROP(
  DW_ETL_MON                                        VARCHAR2(8)
 ,PROD_ID                                           VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,CUST_GROUP1                                       VARCHAR2(10)
 ,APPL_CNT                                          NUMBER(18,2)
 ,APPR_CNT                                          NUMBER(18,2)
 ,DECL_CNT                                          NUMBER(18,2)
 ,CANC_CNT                                          NUMBER(18,2)
 ,DEAL_CNT                                          NUMBER(18,2)
 ,APPL_AMT                                          NUMBER(18,2)
 ,APPR_AMT                                          NUMBER(18,2)
 ,LOAN_AMT                                          NUMBER(18,2)
 ,DEAL_APPL_AMT                                     NUMBER(18,2)
 ,REJ_NO_ADMIT                                      NUMBER(18,2)
 ,REJ_HIGH_CKTM                                     NUMBER(18,2)
 ,REJ_HIGH_DEBT                                     NUMBER(18,2)
 ,REJ_NO_QUOTA                                      NUMBER(18,2)
 ,REJ_RH_SCORE_LOW                                  NUMBER(18,2)
 ,REJ_CRDT_RPT_BAD                                  NUMBER(18,2)
 ,REJ_LOAN_PURPOS                                   NUMBER(18,2)
 ,REJ_AUDIT_OTHER                                   NUMBER(18,2)
);
-------------------------
--13.各环节处理数量报表
-------------------------
DROP TABLE DWS.RISK_NODE_DEAL_USER_CNT ;
CREATE TABLE DWS.RISK_NODE_DEAL_USER_CNT(
  DW_ETL_MON                                        VARCHAR2(8)
 ,NODE_CODE                                         VARCHAR2(20)
 ,OPER_NAME                                         VARCHAR2(100)
 ,LOAN_JZFQ                                         NUMBER(20,2)
 ,LOAN_GCFQ                                         NUMBER(20,2)
 ,LOAN_XFFQ                                         NUMBER(20,2)
 ,CARD_FQ03                                         NUMBER(20,2)
);
-------------------------
--14.全流程处理耗时报表
-------------------------
DROP TABLE DWS.RISK_CASE_TIME_USED_TOT ;
CREATE TABLE DWS.RISK_CASE_TIME_USED_TOT(
  DW_ETL_MON                                        VARCHAR2(8)
 ,PROD_ID                                           VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APP_AVG_TIME                                      NUMBER(32,2)
 ,CZ1_AVG_TIME                                      NUMBER(32,2)
 ,SX1_AVG_TIME                                      NUMBER(32,2)
 ,SX2_AVG_TIME                                      NUMBER(32,2)
 ,RGFH_AVG_TIME                                     NUMBER(32,2)
 ,TOT_AVG_TIME                                      NUMBER(32,2)
);
-------------------------
--15.批核结构-产品维度报表
-------------------------
DROP TABLE DWS.RISK_APPR_STRUCT_PROD ;
CREATE TABLE DWS.RISK_APPR_STRUCT_PROD(
  DW_ETL_MON                                        VARCHAR2(8)
 ,PROD                                              VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APPR_CNT_PROP                                     NUMBER(18,2)
);
-------------------------
--16.批核结构-物理维度报表
-------------------------
DROP TABLE DWS.RISK_APPR_STRUCT_PHYSIC ;
CREATE TABLE DWS.RISK_APPR_STRUCT_PHYSIC(
  DW_ETL_MON                                        VARCHAR2(8)
 ,PHYSICS                                           VARCHAR2(100)
 ,PHYSICS_NAME                                      VARCHAR2(100)
 ,APPR_CNT_PROP                                     NUMBER(18,2)
);
-------------------------
--17.批核结构-征信维度报表
-------------------------
DROP TABLE DWS.RISK_APPR_STRUCT_CREDIT ;
CREATE TABLE DWS.RISK_APPR_STRUCT_CREDIT(
  DW_ETL_MON                                        VARCHAR2(8)
 ,CREDIT_PROD                                       VARCHAR2(100)
 ,CREDIT_NAME                                       VARCHAR2(100)
 ,APPR_CNT_PROP                                     NUMBER(18,2)
);


-------------------------
--18.批核量-产品维度报表
-------------------------
DROP TABLE DWS.RISK_APPR_AMOUNT_PROD ;
CREATE TABLE DWS.RISK_APPR_AMOUNT_PROD(
  DW_ETL_MON                                        VARCHAR2(8)
 ,PROD                                              VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APPR_CNT                                          NUMBER(18,2)
);
-------------------------
--19.批核量-物理维度报表
-------------------------
DROP TABLE DWS.RISK_APPR_AMOUNT_PHYS ;
CREATE TABLE DWS.RISK_APPR_AMOUNT_PHYS(
  DW_ETL_MON                                        VARCHAR2(8)
 ,PHYSICS                                           VARCHAR2(100)
 ,PHYSICS_NAME                                      VARCHAR2(100)
 ,APPR_CNT                                          NUMBER(18,2)
);
-------------------------
--20.批核量-征信维度报表
-------------------------
DROP TABLE DWS.RISK_APPR_AMOUNT_CREDIT ;
CREATE TABLE DWS.RISK_APPR_AMOUNT_CREDIT(
  DW_ETL_MON                                        VARCHAR2(8)
 ,CREDIT_PROD                                       VARCHAR2(100)
 ,CREDIT_NAME                                       VARCHAR2(100)
 ,APPR_CNT                                          NUMBER(18,2)
);


-------------------------
--21.批核率-产品维度报表
-------------------------
DROP TABLE DWS.RISK_APPR_PROD_RATE ;
CREATE TABLE DWS.RISK_APPR_PROD_RATE(
  DW_ETL_MON                                        VARCHAR2(8)
 ,PROD                                              VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APPROVE_RATE                                      NUMBER(18,2)
);
-------------------------
--22.批核率-物理维度报表
-------------------------
DROP TABLE DWS.RISK_APPR_PHYS_RATE ;
CREATE TABLE DWS.RISK_APPR_PHYS_RATE(
  DW_ETL_MON                                        VARCHAR2(8)
 ,PHYSICS                                           VARCHAR2(100)
 ,PHYSICS_NAME                                      VARCHAR2(100)
 ,APPROVE_RATE                                      NUMBER(18,2)
);
-------------------------
--23.批核率-征信维度报表
-------------------------
DROP TABLE DWS.RISK_APPR_CREDIT_RATE ;
CREATE TABLE DWS.RISK_APPR_CREDIT_RATE(
  DW_ETL_MON                                        VARCHAR2(8)
 ,CREDIT_PROD                                       VARCHAR2(100)
 ,CREDIT_NAME                                       VARCHAR2(100)
 ,APPROVE_RATE                                      NUMBER(18,2)
);



-------------------------
--24.MOB3_M1（户数）-产品维度表
-------------------------
DROP TABLE DWS.RISK_PROD_MOB3_M1_USERS_PROD;
CREATE TABLE DWS.RISK_PROD_MOB3_M1_USERS_PROD(
 DW_ETL_MON				                            VARCHAR2(6)
 ,PROD                                              VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APPR_CNT                                          NUMBER(18,2)
);

-------------------------
--25.MOB3_M1（户数）-物理维度表
-------------------------
DROP TABLE DWS.RISK_PROD_MOB3_M1_USERS_PHYS ;
CREATE TABLE DWS.RISK_PROD_MOB3_M1_USERS_PHYS(
  DW_ETL_MON                                        VARCHAR2(6)
 ,PHYSICS                                           VARCHAR2(100)
 ,PHYSICS_NAME                                      VARCHAR2(100)
 ,APPR_CNT                                          NUMBER(18,2)
);

-------------------------
--26.MOB3_M1（户数）-征信维度表
-------------------------
DROP TABLE DWS.RISK_PROD_MOB3_M1_USERS_CREDIT ;
CREATE TABLE DWS.RISK_PROD_MOB3_M1_USERS_CREDIT(
  DW_ETL_MON					                    VARCHAR2(6)
 ,CREDIT_PROD                                       VARCHAR2(200)
 ,CREDIT_NAME                                       VARCHAR2(100)
 ,APPR_CNT                                          NUMBER(18,2)
);

-------------------------
--27.MOB3_M1（户数）-产品维度总报表
-------------------------
DROP TABLE DWS.RISK_PROD_MOB3_M1_USERS_PROD_TOTLE;
CREATE TABLE DWS.RISK_PROD_MOB3_M1_USERS_PROD_TOTLE(
 DW_ETL_MON				                            VARCHAR2(6)
 ,PROD                                              VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APPR_CNT                                          NUMBER(18,2)
);

-------------------------
--28.MOB3_M1（户数）-物理维度总报表
-------------------------
DROP TABLE DWS.RISK_PROD_MOB3_M1_USERS_PHYS_TOTLE ;
CREATE TABLE DWS.RISK_PROD_MOB3_M1_USERS_PHYS_TOTLE(
  DW_ETL_MON                                        VARCHAR2(6)
 ,PHYSICS                                           VARCHAR2(100)
 ,PHYSICS_NAME                                      VARCHAR2(100)
 ,APPR_CNT                                          NUMBER(18,2)
);

-------------------------
--29.MOB3_M1（户数）-征信维度总报表
-------------------------
DROP TABLE DWS.RISK_PROD_MOB3_M1_USERS_CREDIT_TOTLE ;
CREATE TABLE DWS.RISK_PROD_MOB3_M1_USERS_CREDIT_TOTLE(
  DW_ETL_MON					                    VARCHAR2(6)
 ,CREDIT_PROD                                       VARCHAR2(200)
 ,CREDIT_NAME                                       VARCHAR2(100)
 ,APPR_CNT                                          NUMBER(18,2)
);

-------------------------
--30.MOB3_M1（户数）逾期率-产品维度报表
-------------------------
DROP TABLE DWS.RISK_APPR_PROD_LATE_RATE;
CREATE TABLE DWS.RISK_APPR_PROD_LATE_RATE(
 DW_ETL_MON				                            VARCHAR2(6)
 ,PROD                                              VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APPROVE_RATE                                      NUMBER(18,2)
);

-------------------------
--31.MOB3_M1（户数）逾期率-物理维度报表
-------------------------
DROP TABLE DWS.RISK_APPR_PHYS_LATE_RATE；
CREATE TABLE DWS.RISK_APPR_PHYS_LATE_RATE(
  DW_ETL_MON                                        VARCHAR2(6)
 ,PHYSICS                                           VARCHAR2(100)
 ,PHYSICS_NAME                                      VARCHAR2(100)
 ,APPROVE_RATE                                      NUMBER(18,2)
);

-------------------------
--32.MOB3_M1（户数）逾期率-征信维度报表
-------------------------
DROP TABLE DWS.RISK_APPR_CREDIT_LATE_RATE；
CREATE TABLE DWS.RISK_APPR_CREDIT_LATE_RATE(
  DW_ETL_MON					                    VARCHAR2(6)
 ,CREDIT_PROD                                       VARCHAR2(200)
 ,CREDIT_NAME                                       VARCHAR2(100)
 ,APPROVE_RATE                                      NUMBER(18,2)
);


-------------------------
--33.MOB3_M1（金额）逾期金额-产品维度报表
-------------------------
DROP TABLE DWS.RISK_PROD_MOB3_M1_AMOUNT_PROD;
CREATE TABLE DWS.RISK_PROD_MOB3_M1_AMOUNT_PROD(
 DW_ETL_MON				                            VARCHAR2(6)
 ,PROD                                              VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APPR_CNT                                          NUMBER(18,2)
);

-------------------------
--34.MOB3_M1（金额）逾期金额-物理维度报表
-------------------------
DROP TABLE DWS.RISK_PROD_MOB3_M1_AMOUNT_PHYS ;
CREATE TABLE DWS.RISK_PROD_MOB3_M1_AMOUNT_PHYS(
  DW_ETL_MON                                        VARCHAR2(6)
 ,PHYSICS                                           VARCHAR2(100)
 ,PHYSICS_NAME                                      VARCHAR2(100)
 ,APPR_CNT                                          NUMBER(18,2)
);

-------------------------
--35.MOB3_M1（金额）逾期金额-征信维度报表
-------------------------
DROP TABLE DWS.RISK_PROD_MOB3_M1_AMOUNT_CREDIT ;
CREATE TABLE DWS.RISK_PROD_MOB3_M1_AMOUNT_CREDIT(
  DW_ETL_MON					    VARCHAR2(6)
 ,CREDIT_PROD                                       VARCHAR2(200)
 ,CREDIT_NAME                                       VARCHAR2(100)
 ,APPR_CNT                                          NUMBER(18,2)
);

-------------------------
--36.MOB3_M1（金额）逾期金额-产品维度总报表
-------------------------
DROP TABLE DWS.RISK_PROD_MOB3_M1_AMOUNT_PROD_TOTLE;
CREATE TABLE DWS.RISK_PROD_MOB3_M1_AMOUNT_PROD_TOTLE(
 DW_ETL_MON				            VARCHAR2(6)
 ,PROD                                              VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APPR_CNT                                          NUMBER(18,2)
);

-------------------------
--37.MOB3_M1（金额）逾期金额-物理维度总报表
-------------------------
DROP TABLE DWS.RISK_PROD_MOB3_M1_AMOUNT_PHYS_TOTLE ;
CREATE TABLE DWS.RISK_PROD_MOB3_M1_AMOUNT_PHYS_TOTLE(
  DW_ETL_MON                                        VARCHAR2(6)
 ,PHYSICS                                           VARCHAR2(100)
 ,PHYSICS_NAME                                      VARCHAR2(100)
 ,APPR_CNT                                          NUMBER(18,2)
);

-------------------------
--38.MOB3_M1（金额）逾期金额-征信维度总报表
-------------------------
DROP TABLE DWS.RISK_PROD_MOB3_M1_AMOUNT_CREDIT_TOTLE ;
CREATE TABLE DWS.RISK_PROD_MOB3_M1_AMOUNT_CREDIT_TOTLE(
  DW_ETL_MON					                    VARCHAR2(6)
 ,CREDIT_PROD                                       VARCHAR2(200)
 ,CREDIT_NAME                                       VARCHAR2(100)
 ,APPR_CNT                                          NUMBER(18,2)
);

-------------------------
--39.MOB3_M1（金额）逾期率-产品维度报表
-------------------------
DROP TABLE DWS.RISK_APPR_PROD_AMOUNT_LATE_RATE;
CREATE TABLE DWS.RISK_APPR_PROD_AMOUNT_LATE_RATE(
 DW_ETL_MON				                            VARCHAR2(6)
 ,PROD                                              VARCHAR2(100)
 ,PRODUCT_NAME                                      VARCHAR2(100)
 ,APPROVE_RATE                                      NUMBER(18,2)
);

-------------------------
--40.MOB3_M1（金额）逾期率-物理维度报表
-------------------------
DROP TABLE DWS.RISK_APPR_PHYS_AMOUNT_LATE_RATE;
CREATE TABLE DWS.RISK_APPR_PHYS_AMOUNT_LATE_RATE(
  DW_ETL_MON                                        VARCHAR2(6)
 ,PHYSICS                                           VARCHAR2(100)
 ,PHYSICS_NAME                                      VARCHAR2(100)
 ,APPROVE_RATE                                      NUMBER(18,2)
);

-------------------------
--41.MOB3_M1（金额）逾期率-征信维度报表
-------------------------
DROP TABLE DWS.RISK_APPR_CREDIT_AMOUNT_LATE_RATE;
CREATE TABLE DWS.RISK_APPR_CREDIT_AMOUNT_LATE_RATE(
  DW_ETL_MON					    VARCHAR2(6)
 ,CREDIT_PROD                                       VARCHAR2(200)
 ,CREDIT_NAME                                       VARCHAR2(100)
 ,APPROVE_RATE                                          NUMBER(18,2)
);


-------------------------
--42.风险随时分逾期M1+表
-------------------------
DROP TABLE DWS.RISK_LOAN_MOB1_MON ;
CREATE TABLE DWS.RISK_LOAN_MOB1_MON(
  DW_ETL_MON                                        VARCHAR2(8)
 ,ISCRD_MON                                         VARCHAR2(8)
 ,MOB_MON                                           VARCHAR2(64)
 ,CARD_CNT                                          NUMBER(20)
 ,OVDUE_CNT                                         NUMBER(20)
 ,AVG_CRDT_QTA                                      NUMBER(20,2)
 ,SUM_CRDT_QTA                                      NUMBER(20,2)
 ,TMS_REM_PPL                                       NUMBER(20,2)
 ,OVDUE_CNT_PROP                                    NUMBER(20,2)
 ,OVDUE_AMT_PROP                                    NUMBER(20,2)
);
-------------------------
--43.风险随时分逾期M2+表
-------------------------
DROP TABLE DWS.RISK_LOAN_MOB2_MON ;
CREATE TABLE DWS.RISK_LOAN_MOB2_MON(
  DW_ETL_MON                                        VARCHAR2(8)
 ,ISCRD_MON                                         VARCHAR2(8)
 ,MOB_MON                                           VARCHAR2(64)
 ,CARD_CNT                                          NUMBER(20)
 ,OVDUE_CNT                                         NUMBER(20)
 ,AVG_CRDT_QTA                                      NUMBER(20,2)
 ,SUM_CRDT_QTA                                      NUMBER(20,2)
 ,TMS_REM_PPL                                       NUMBER(20,2)
 ,OVDUE_CNT_PROP                                    NUMBER(20,2)
 ,OVDUE_AMT_PROP                                    NUMBER(20,2)
);
-------------------------
--44.风险随时分逾期M3+表
-------------------------
DROP TABLE DWS.RISK_LOAN_MOB3_MON ;
CREATE TABLE DWS.RISK_LOAN_MOB3_MON(
  DW_ETL_MON                                        VARCHAR2(8)
 ,ISCRD_MON                                         VARCHAR2(8)
 ,MOB_MON                                           VARCHAR2(64)
 ,CARD_CNT                                          NUMBER(20)
 ,OVDUE_CNT                                         NUMBER(20)
 ,AVG_CRDT_QTA                                      NUMBER(20,2)
 ,SUM_CRDT_QTA                                      NUMBER(20,2)
 ,TMS_REM_PPL                                       NUMBER(20,2)
 ,OVDUE_CNT_PROP                                    NUMBER(20,2)
 ,OVDUE_AMT_PROP                                    NUMBER(20,2)
);
-------------------------
--45.风险随时借逾期M1+表
-------------------------
DROP TABLE DWS.RISK_CARD_MOB1_MON ;
CREATE TABLE DWS.RISK_CARD_MOB1_MON(
  DW_ETL_MON                                        VARCHAR2(8)
 ,ISCRD_MON                                         VARCHAR2(8)
 ,MOB_MON                                           VARCHAR2(64)
 ,CARD_CNT                                          NUMBER(20)
 ,OVDUE_CNT                                         NUMBER(20)
 ,AVG_CRDT_QTA                                      NUMBER(20,2)
 ,SUM_REM_PPL                                       NUMBER(20,2)
 ,TMS_REM_PPL                                       NUMBER(20,2)
 ,OVDUE_CNT_PROP                                    NUMBER(20,2)
 ,OVDUE_AMT_PROP                                    NUMBER(20,2)
);
-------------------------
--46.风险随时借逾期M2+表
-------------------------
DROP TABLE DWS.RISK_CARD_MOB2_MON ;
CREATE TABLE DWS.RISK_CARD_MOB2_MON(
  DW_ETL_MON                                        VARCHAR2(8)
 ,ISCRD_MON                                         VARCHAR2(8)
 ,MOB_MON                                           VARCHAR2(64)
 ,CARD_CNT                                          NUMBER(20)
 ,OVDUE_CNT                                         NUMBER(20)
 ,AVG_CRDT_QTA                                      NUMBER(20,2)
 ,SUM_REM_PPL                                       NUMBER(20,2)
 ,TMS_REM_PPL                                       NUMBER(20,2)
 ,OVDUE_CNT_PROP                                    NUMBER(20,2)
 ,OVDUE_AMT_PROP                                    NUMBER(20,2)
);
-------------------------
--47.风险随时借逾期M3+表
-------------------------
DROP TABLE DWS.RISK_CARD_MOB3_MON ;
CREATE TABLE DWS.RISK_CARD_MOB3_MON(
  DW_ETL_MON                                        VARCHAR2(8)
 ,ISCRD_MON                                         VARCHAR2(8)
 ,MOB_MON                                           VARCHAR2(64)
 ,CARD_CNT                                          NUMBER(20)
 ,OVDUE_CNT                                         NUMBER(20)
 ,AVG_CRDT_QTA                                      NUMBER(20,2)
 ,SUM_REM_PPL                                       NUMBER(20,2)
 ,TMS_REM_PPL                                       NUMBER(20,2)
 ,OVDUE_CNT_PROP                                    NUMBER(20,2)
 ,OVDUE_AMT_PROP                                    NUMBER(20,2)
);

---------------------------
--48.风险MOB6_M2逾期率-产品维度报表
---------------------------
DROP TABLE DWS.RISK_MOB6_M2_PRODUCT;
CREATE TABLE DWS.RISK_MOB6_M2_PRODUCT(
   DW_ETL_MON           VARCHAR2(6)              --月份
  ,PROD                 VARCHAR2(100)            --维度（大）
  ,PRODUCT_NAME         VARCHAR2(100)            --维度（小）
  ,USER_RATE            NUMBER(5,2)              --用户比
  ,BALANCE_RATE         NUMBER(5,2)              --余额比
  ,ORIG_RATE            NUMBER(5,2)              --余额金额比
);

-----------------------------
--49.风险MOB6_M2逾期率-物理维度报表
-----------------------------
DROP TABLE DWS.RISK_MOB6_M2_PHYSICS;
CREATE TABLE DWS.RISK_MOB6_M2_PHYSICS(
  DW_ETL_MON    VARCHAR2(6),     --月份
  PHYSICS     VARCHAR2(100),    --维度（大）
  PHYSICS_NAME  VARCHAR2(100),    --维度（小）
  USER_RATE     NUMBER(5,2),       --用户比
  BALANCE_RATE  NUMBER(5,2),     --余额比
  ORIG_RATE    NUMBER(5,2)      --余额金额比
);

----------------------------
--50.风险MOB6_M2逾期率-征信维度报表
----------------------------
DROP TABLE DWS.RISK_MOB6_M2_CREDIT;
CREATE TABLE DWS.RISK_MOB6_M2_CREDIT(
   DW_ETL_MON      VARCHAR2(6)      --月份
  ,CREDIT_PROD     VARCHAR2(200)    --维度（大）
  ,CREDIT_NAME     VARCHAR2(100)    --维度（小）
  ,USER_RATE       NUMBER(5,2)      --用户比
  ,BALANCE_RATE    NUMBER(5,2)      --余额比
  ,ORIG_RATE       NUMBER(5,2)      --余额金额比
);

----------------------------
--51.风险MOB9_M3逾期率-产品维度报表
----------------------------
DROP TABLE DWS.RISK_APPR_PROD_LATE_RATE_M0B9;
CREATE TABLE DWS.RISK_APPR_PROD_LATE_RATE_M0B9(
   DW_ETL_MON                     VARCHAR2(6)
  ,PROD                           VARCHAR2(100)
  ,PRODUCT_NAME                   VARCHAR2(100)
  ,APPROVE_RATE_USER              NUMBER(18,2)
  ,APPROVE_RATE_AMOUNT            NUMBER(18,2)
  ,APPROVE_RATE_AMOUNT_S          NUMBER(18,2)
  );

----------------------------
--52.风险MOB9_M3逾期率-物理维度报表
----------------------------
DROP TABLE DWS.RISK_APPR_PHYS_LATE_RATE_M0B9;
CREATE TABLE DWS.RISK_APPR_PHYS_LATE_RATE_M0B9(
   DW_ETL_MON                     VARCHAR2(6)
  ,PHYSICS                        VARCHAR2(100)
  ,PHYSICS_NAME                   VARCHAR2(100)
  ,APPROVE_RATE_USER              NUMBER(18,2)
  ,APPROVE_RATE_AMOUNT            NUMBER(18,2)
  ,APPROVE_RATE_AMOUNT_S          NUMBER(18,2)
  );

----------------------------
--53.风险MOB9_M3逾期率-征信维度报表
----------------------------
DROP TABLE DWS.RISK_APPR_CRET_LATE_RATE_M0B9;
CREATE TABLE DWS.RISK_APPR_CRET_LATE_RATE_M0B9(
   DW_ETL_MON                     VARCHAR2(6)
  ,CREDIT                        VARCHAR2(100)
  ,CREDIT_NAME                   VARCHAR2(100)
  ,APPROVE_RATE_USER              NUMBER(18,2)
  ,APPROVE_RATE_AMOUNT            NUMBER(18,2)
  ,APPROVE_RATE_AMOUNT_S          NUMBER(18,2)
  );

-------------------------------
--54.风险MOB12_M3逾期率-产品维度报表
-------------------------------
DROP TABLE DWS.RISK_MOB12_M3_PRODUCT;
CREATE TABLE DWS.RISK_MOB12_M3_PRODUCT(
   DW_ETL_MON           VARCHAR2(6)              --月份
  ,PROD                 VARCHAR2(100)            --维度（大）
  ,PRODUCT_NAME         VARCHAR2(100)            --维度（小）
  ,USER_RATE            NUMBER(5,2)              --用户比
  ,BALANCE_RATE         NUMBER(5,2)              --余额比
  ,ORIG_RATE            NUMBER(5,2)              --余额金额比
);

-------------------------------
--55.风险MOB12_M3逾期率-物理维度报表
-------------------------------
DROP TABLE DWS.RISK_MOB12_M3_PHYSICS;
CREATE TABLE DWS.RISK_MOB12_M3_PHYSICS(
  DW_ETL_MON    VARCHAR2(6),     --月份
  PHYSICS     VARCHAR2(100),    --维度（大）
  PHYSICS_NAME  VARCHAR2(100),    --维度（小）
  USER_RATE     NUMBER(5,2),       --用户比
  BALANCE_RATE  NUMBER(5,2),     --余额比
  ORIG_RATE    NUMBER(5,2)      --余额金额比
);

-------------------------------
--56.风险MOB12_M3逾期率-征信维度报表
-------------------------------
DROP TABLE DWS.RISK_MOB12_M3_CREDIT;
CREATE TABLE DWS.RISK_MOB12_M3_CREDIT(
   DW_ETL_MON      VARCHAR2(6)      --月份
  ,CREDIT_PROD     VARCHAR2(200)    --维度（大）
  ,CREDIT_NAME     VARCHAR2(100)    --维度（小）
  ,USER_RATE       NUMBER(5,2)      --用户比
  ,BALANCE_RATE    NUMBER(5,2)      --余额比
  ,ORIG_RATE       NUMBER(5,2)      --余额金额比
);

-------------------------------
--57.风险MOB03_M1逾期率-物理维度报表
-------------------------------
DROP TABLE DWS.RISK_APPR_PHYS_LATE_RATE_M0B3;
CREATE TABLE DWS.RISK_APPR_PHYS_LATE_RATE_M0B3(
      DW_ETL_MON                     VARCHAR2(6)
     ,PHYSICS                        VARCHAR2(100)
     ,PHYSICS_NAME                   VARCHAR2(100)
     ,APPROVE_RATE_USER              NUMBER(18,2)
     ,APPROVE_RATE_AMOUNT            NUMBER(18,2)
     ,APPROVE_RATE_AMOUNT_S          NUMBER(18,2)
 );

 -------------------------------
 --58.风险MOB03_M1逾期率-产品维度报表
 -------------------------------
 DROP TABLE DWS.RISK_APPR_PROD_LATE_RATE_M0B3;
 CREATE TABLE DWS.RISK_APPR_PROD_LATE_RATE_M0B3(
    DW_ETL_MON                     VARCHAR2(6)
   ,PROD                           VARCHAR2(100)
   ,PRODUCT_NAME                   VARCHAR2(100)
   ,APPROVE_RATE_USER              NUMBER(18,2)
   ,APPROVE_RATE_AMOUNT            NUMBER(18,2)
   ,APPROVE_RATE_AMOUNT_S          NUMBER(18,2)
   );

    -------------------------------
    --59.风险MOB03_M1逾期率-征信维度报表
    -------------------------------
    DROP TABLE DWS.RISK_APPR_CRET_LATE_RATE_M0B3;
    CREATE TABLE DWS.RISK_APPR_CRET_LATE_RATE_M0B3(
       DW_ETL_MON                     VARCHAR2(6)
      ,CREDIT                        VARCHAR2(100)
      ,CREDIT_NAME                   VARCHAR2(100)
      ,APPROVE_RATE_USER              NUMBER(18,2)
      ,APPROVE_RATE_AMOUNT            NUMBER(18,2)
      ,APPROVE_RATE_AMOUNT_S          NUMBER(18,2)
      );