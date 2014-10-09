dataSource {
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = false
//    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
	cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
	singleSession = true // configure OSIV singleSession mode
}

// environment specific settings
environments {
	development {
		dataSource {
			dbCreate = "update" // one of 'create', 'create-drop','update'
			url = "jdbc:mysql://localhost/horas"
			username = "horas"
			password = "horas"
			dialect = Mysql.MyCustomMySQL5InnoDBDialect
			logsql = true
		}
		properties {
			maxActive = 50
			maxIdle = 25
			minIdle = 1
			initialSize = 1
	   
			numTestsPerEvictionRun = 3
			maxWait = 10000
	   
			testOnBorrow = true
			testWhileIdle = true
			testOnReturn = true
	   
			validationQuery = "select now()"
	   
			minEvictableIdleTimeMillis = 1000 * 60 * 5
			timeBetweenEvictionRunsMillis = 1000 * 60 * 5
		 }
		hibernate {
			show_sql = true
		}
	}
	test {
		dataSource {
			dbCreate = "create-drop" // one of 'create', 'create-drop','update'
			url = "jdbc:mysql://localhost/bolao?autoReconnect=true"
			username = "bolao"
			password = "bolao"
		}
	}
	production {
		dataSource {
			username = "horas"
			password = "horas"
			driverClassName = "com.mysql.jdbc.Driver"
			dbCreate = "update"
			url = "jdbc:mysql://localhost/horas?autoReconnect=true"
		}
	}
}