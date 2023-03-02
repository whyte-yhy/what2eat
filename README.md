# what2eat (next meal or next day? not yet decided)
食谱编制程序摆烂开发ing...

SLS的应用

master：主框架（快告诉自己不要动！！！

branch1：成品菜模式；软子句为菜，硬子句为偏好等约束（完成冷启动），原子为食材；判题器观测营养是否达标，若接受该解择输出原材料等信息
branch2：食材模式；原子为食材，编写得分函数 score=floor(若调整会改变多少单位/违背了多少单位 * 100)；全局共享营养缺口，计算每个食材在当前赋值下的score，贪心进行翻转
