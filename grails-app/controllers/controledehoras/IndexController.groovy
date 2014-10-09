package controledehoras

import grails.plugin.springsecurity.annotation.Secured

class IndexController {

	@Secured('permitAll')
    def index() { }
}
