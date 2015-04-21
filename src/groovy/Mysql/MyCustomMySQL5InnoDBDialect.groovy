package Mysql

import org.hibernate.dialect.MySQL5InnoDBDialect 
import java.sql.Types 

class MyCustomMySQL5InnoDBDialect extends MySQL5InnoDBDialect { 
	
	MyCustomMySQL5InnoDBDialect() { 
		registerColumnType(Types.BIT, 'boolean') 
	}
}  