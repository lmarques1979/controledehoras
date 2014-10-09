package seguranca

import controledehoras.*

class Usuario {

	transient springSecurityService

	String username
	String password
	String email
	String primeironome
	String sobrenome
	String  imagem
	boolean enabled=true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static hasMany = [usuarioempresa: UsuarioEmpresa,usuarioregras: UsuarioRegra]
	
	static transients = ['springSecurityService']

	static constraints = {
		username(unique:true , blank: false, nullable:false)
		password(blank: false , nullable:false)
		email(email:true,blank:false,nullable:false)
		primeironome(blank: false , nullable:false)
		sobrenome(blank: true , nullable:true)
		imagem(blank: true , nullable:true)
	}
	
	static mapping = {
		usuarioempresa cascade: 'all-delete-orphan'
		usuarioregras cascade: 'all-delete-orphan'
		password column: '`password`'
	}

	def buscaNome(Usuario usuario){
		
		def nomecompleto=usuario.primeironome
		if(usuario.sobrenome!=null){
			nomecompleto = nomecompleto + ' ' + usuario.sobrenome
		}
		return nomecompleto
	}
	
	Set<Regra> getAuthorities() {
		UsuarioRegra.findAllByUsuario(this).collect { it.regra } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
