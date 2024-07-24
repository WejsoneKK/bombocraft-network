import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
plugins {
    `java-library`
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.papermc.paperweight.userdev") version "1.7.1" apply false
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
    id("xyz.jpenilla.run-paper") version "2.3.0"

}
group = "eu.wejsonekk.bombocraft"
version = "1.0-SNAPSHOT"
bukkit {
    main = "eu.wejsonekk.bombocraft.BomboCraftPlugin"
    name = "bombocraft-network"
    apiVersion = "1.13"
    version = "1.0"
    description = "BomboCraft Network Suite"
    website = "https://bombocraft.com"
    author = "WejsoneKKEU | xr-code team"
}
repositories {
    mavenCentral()
    mavenLocal()
    gradlePluginPortal()
    gradleKotlinDsl()
    maven { url = uri("https://repo.panda-lang.org/releases") }
    maven { url = uri("https://repo.extendedclip.com/content/repositories/placeholderapi/") }
    maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc")
}

dependencies {
    compileOnly ("org.spigotmc:spigot-api:1.20.6-R0.1-SNAPSHOT")
    implementation("net.kyori:adventure-platform-bukkit:4.2.0")
    implementation("net.kyori:adventure-text-minimessage:4.12.0")
    // LiteCommands
    implementation("dev.rollczi:litecommands-core:3.4.2")

    implementation("dev.rollczi:litecommands-bukkit:3.4.2")

    // cdn
    implementation("net.dzikoysk:cdn:1.14.3")
    // TriumphGui
    implementation("dev.triumphteam:triumph-gui:3.1.4")

    // panda-utilities
    implementation("org.panda-lang:panda-utilities:0.5.2-alpha")

    // Ormlite jdbc
    implementation("com.j256.ormlite:ormlite-core:6.1")

    compileOnly("com.j256.ormlite:ormlite-jdbc:6.1")

    // Hikari
    compileOnly("com.zaxxer:HikariCP:5.0.1")

    // PlaceholderAPI
    compileOnly("me.clip:placeholderapi:2.11.2")

    // LuckPerms
    compileOnly("net.luckperms:api:5.4")

    // Caffeine
//    implementation("com.github.ben-manes.caffeine:caffeine:2.9.3")
    implementation("com.github.ben-manes.caffeine:caffeine:3.1.5")

    // Vault
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")

    // SQLITE
    implementation("org.xerial:sqlite-jdbc:3.46.0.0")
    //    implementation("org.xerial:sqlite-jdbc:3.39.4")
    // CACHE
    implementation("com.j256.ormlite:ormlite-jdbc:6.1")

    /* General */
    val lombok = "1.18.32"
    compileOnly("org.projectlombok:lombok:$lombok")
    annotationProcessor("org.projectlombok:lombok:$lombok")
    testCompileOnly("org.projectlombok:lombok:$lombok")
    testAnnotationProcessor("org.projectlombok:lombok:$lombok")
}


tasks {
    runServer {
        // Configure the Minecraft version for our task.
        // This is the only required configuration besides applying the plugin.
        // Your plugin's jar (or shadowJar if present) will be used automatically.
        minecraftVersion("1.20.6")
    }
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")

}
tasks.withType<ShadowJar> {
    archiveFileName.set("${project.name}-(v${project.version}-(1.20.6).jar")

    exclude(
        "org/intellij/lang/annotations/**",
        "org/jetbrains/annotations/**",
        "META-INF/**",
        "kotlin/**",
        "javax/**"
    )

    val prefix = "eu.wejsonekk.bombocraft.suite.libs"
    listOf(
        "panda.std",
        "panda.utilities",
        "org.panda-lang",
        "eu.okaeri",
        "net.kyori",
        "org.bstats",
        "dev.rollczi.litecommands",
//        "com.eternalcode.gitcheck",
        "org.json.simple",
//        "org.apache.commons",
        "javassist",
//        "com.github.benmanes.caffeine",
//        "com.eternalcode.commons"

    ).forEach { pack ->
        relocate(pack, "$prefix.$pack")
    }

}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}