package controledehoras

import java.util.Date;

import seguranca.Usuario;

class Empresa {

	String razaosocial
	String cnpj
	String imagem
	boolean ativa=true
	Date dateCreated
	Date lastUpdated
	
	static hasMany = [usuarioempresa: UsuarioEmpresa]
	
    static constraints = {
		razaosocial(nullable:false,blank:false)
		cnpj(nullable:true,blank:true ,size:14..14)
		imagem(nullable:true,blank:true)
		ativa(nullable:false)
    }
	
	static mapping = {
		usuarioempresa cascade: 'all-delete-orphan'
		autoTimestamp true
	}
}
