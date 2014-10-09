package seguranca

import org.apache.commons.lang.builder.HashCodeBuilder

class UsuarioRegra implements Serializable {

    private static final long serialVersionUID = 1

	Long id
    Usuario usuario 
    Regra regra

    boolean equals(other) {
        if (!(other instanceof UsuarioRegra)) {
            return false
        }

        other.usuario?.id == usuario?.id &&
            other.regra?.id == regra?.id
    }

    int hashCode() {
        def builder = new HashCodeBuilder()
        if (usuario) builder.append(usuario.id)
        if (regra) builder.append(regra.id)
        builder.toHashCode()
    }

    static UsuarioRegra get(long userId, long roleId) {
        UsuarioRegra.where {
            usuario == Usuario.load(userId) &&
            regra == Regra.load(roleId)
        }.get()
    }

    static UsuarioRegra create(Usuario usuario, Regra regra, boolean flush = false) {
        new UsuarioRegra(usuario: usuario, regra: regra).save(flush: flush, insert: true)
    }

    static boolean remove(Usuario u, Regra r, boolean flush = false) {

        int rowCount = UsuarioRegra.where {
            usuario == Usuario.load(u.id) &&
            regra == Regra.load(r.id)
        }.deleteAll()

        rowCount > 0
    }

    static void removeAll(Usuario u) {
        UsuarioRegra.where {
            usuario == Usuario.load(u.id)
        }.deleteAll()
    }

    static void removeAll(Regra r) {
        UsuarioRegra.where {
            regra == Regra.load(r.id)
        }.deleteAll()
    }

	static constraints = {
		usuario(unique: ['regra'])
	}
	
    static mapping = {
        version false
    }
}
