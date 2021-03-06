郑大晔校: Java Collection &amp; Guava
======================

## 需求1：显示购物车中物品的数量，并可以向购物车中添加产品

* 要求:
    - 最简单实现。

## 需求2：按产品名字查找

* 要求:
    - 产品对象需要包含：产品名称
    - 用数组实现，数组初始化大小10
    - 查询不到返回null

## 需求3：处理添加的产品超过10个的情况

* 要求:
    - 在不改变行为的前提下处理异常

## 需求4：按产品名字移除（Advance Requirement）

* 要求:
    - 用数组实现
    - 移除方法返回被移除的对象，如果没有找到，返回null

## 需求5：按产品名字移除

* 要求:
    - 用List实现
    - 不再限制购物车中产品的数量
    - 移除方法返回被移除的对象，如果没有找到，返回null

## 需求6：可以多次添加同一个产品，能根据产品名找到有几个这样的产品

* 要求:
    - 用Map实现
    - 能支持现有功能

## 需求7：计算所有商品总价

* 要求:
    - 给产品加一个域，保存价格，价格为整数

## 需求8：用Guava重构以上功能

* 要求:
    - Product的equals, hashCode方法
    - 按产品名查找
    - 按产品名移除
    - 查询某种产品数量