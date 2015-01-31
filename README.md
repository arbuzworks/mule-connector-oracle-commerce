Mule Oracle Commerce Connector
=========================

The Oracle Commerce (formerly ATG) ESB Connector for Mule from ArbuzWorks provides connectivity between the Oracle Commerce Platform and other applications and services. Users can access Repositories, Personalization module, and Core Commerce module

#Usage
Configuration
-------------
You can configure the connector as follows:

	<oracle-commerce:config name="oracleCommerce" doc:name="OracleCommerce" host="73.47.102.249" port="8080"/>

Here is detailed list of all the configuration attributes:

| attribute | description | optional | default value |
|:-----------|:-----------|:---------|:--------------|
|name|Give a name to this configuration so it can be later referenced by config-ref.|yes||
|host|Web service host|no||
|port|Web service port|no||


Perform RQL query
------------------

	<oracle-commerce:perform-r-q-l-query itemDescriptorName="user" repositoryComponentPath="/atg/userprofiling/ProfileAdapterRepository" RQLString="id=1" doc:name="OracleCommerce"/>

| attribute | description | optional | default value |
|:-----------|:-----------|:---------|:--------------|
|itemDescriptorName|name|no||
|repositoryComponentPath|path to repository|no||
|RQLString| RQL request|no||


Perform RQL count query
------------------

	<oracle-commerce:perform-r-q-l-count-query itemDescriptorName="user" repositoryComponentPath="/atg/userprofiling/ProfileAdapterRepository" RQLString="id=1" doc:name="OracleCommerce"/>

| attribute | description | optional | default value |
|:-----------|:-----------|:---------|:--------------|
|itemDescriptorName|name|no||
|repositoryComponentPath|path to repository|no||
|RQLString| RQL request|no||


Get Repository Item
------------------

    <oracle-commerce:get-repository-item itemDescriptorName="user" repositoryComponentPath="/atg/userprofiling/ProfileAdapterRepository" repositoryItemId="1" doc:name="OracleCommerce"/>

| attribute | description | optional | default value |
|:-----------|:-----------|:---------|:--------------|
|itemDescriptorName|name|no||
|repositoryComponentPath|path to repository|no||
|repositoryItemId| item id|no||



Reporting Issues
----------------

We use GitHub:Issues for tracking issues with this connector. You can report new issues at this link https://github.com/arbuzworks/mule-connector-oracle-commerce/issues.
