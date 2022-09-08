import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.apply
import org.gradle.plugin.use.PluginDependency

internal val Project.isApplicationModule: Boolean get() =
	name.contains("app", ignoreCase = true)

fun Project.apply(provider: Provider<PluginDependency>) = apply(plugin = provider.get().pluginId)

fun Project.config(configuration: Project.() -> Unit) {
	subprojects.filter { p -> p.childProjects.isEmpty() }.forEach(configuration)
}

fun Project.applyAndroid(configuration: (isApplication: Boolean) -> Provider<PluginDependency>) {
	apply(provider = configuration(isApplicationModule))
}
