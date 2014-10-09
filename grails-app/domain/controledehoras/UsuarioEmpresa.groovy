package controledehoras

import java.util.Date;

import seguranca.Usuario;

class UsuarioEmpresa {
	
	Usuario usuario
	Empresa empresa
	Date dateCreated
	Date lastUpdated
	
	static hasMany=[horas: Horas]
	
    static constraints = {
		usuario(unique: ['empresa'])
		empresa(nullable: false , blank: false)
    }
	
	static mapping = {
		horas cascade: 'all-delete-orphan'
		version false
		autoTimestamp true
	}
}
