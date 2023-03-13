# HBCriterianApi

Criterion Api
-----------------
SRO ====> hibernate persistence methods
bulkoperations => we use HQL(query written using classname and properties) to
write queries.

=> In case of Criterion api, we can perform both singlerow and bulkoperations
without using any queries just like java statements.
=> Criterion api will generate SQL queries based on the given entity classnames and
properties name.
=> It doesnot support non-select operation,it supports only select operation.
=> Using Criteria object we can add 3 object

a. Criterion objects(for where clause condition)
b. Project objects(for scalar select operation)
c. Order object( for orderBy operations)

There are 2 modes of writing Criterion api
a. HB QBC(Query by Criteria)====> specific to hibernate only
b. JPA QBC ===> common to all ORM framework
refer: HBQBCApi

Pagination
========
Displaying large volume of records into muliptle pages is called as
"pagination".
Hibernate supports pagination through QBC
1. setFirstResult(int pageNo)
2. setMaxResult(int maxNo)
