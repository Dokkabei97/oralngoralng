rootProject.name = "oralngoralng"
include("common")
include("application")
include("domain")
include("infrastructure")
include("interface")
include("interface:user")
findProject(":interface:user")?.name = "user"
