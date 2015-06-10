package controledehoras

import java.util.Date;

class Horas {

	Integer	 dia
	Integer  mes
	Integer  ano
	float  totaldia
	Date entrada1
	Date saida1
	Date entrada2
	Date saida2
	Date saida3
	Date entrada3
	Date saida4
	Date entrada4
	Date saida5
	Date entrada5
	Date dateCreated
	Date lastUpdated
	String observacao
	int totaliza
	static belongsTo = [usuarioempresa:UsuarioEmpresa]
	
    static constraints = {
		
		dia(nullable: false, blank: false)
		mes(nullable: false, blank: false)
		ano(nullable: false, blank: false)
		totaldia(nullable: true, blank: true)
		entrada1(nullable: true, blank: true)
		saida1(nullable: true, blank: true)
		entrada2(nullable: true, blank: true)
		saida2(nullable: true, blank: true)
		saida3(nullable: true, blank: true)
		entrada3(nullable: true, blank: true)
		saida4(nullable: true, blank: true)
		entrada4(nullable: true, blank: true)
		saida5(nullable: true, blank: true)
		entrada5(nullable: true, blank: true)
		observacao(nullable: true, blank: true)
		totaliza(nullable: true, blank: true)
    }
	
	static mapping = {
		autoTimestamp true
	}
	
}
