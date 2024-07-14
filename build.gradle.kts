plugins {
    `java-library`
    kotlin("jvm") version "1.8.10"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.papermc.paperweight.userdev") version "1.7.1" apply false
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
    id("xyz.jpenilla.run-paper") version "2.1.0"

}
group = "eu.wejsonekk.bombocraft"
version = "0.1.1-alpha-SNAPSHOT"
bukkit {
    main = "eu.wejsonekk.bombocraft.BomboCraftPlugin"
    name = "bombocraft-network"
    apiVersion = "1.20"
    version = "0.1.1-alpha (build-50)"
    description = "BomboCraft Core"
    website = "https://bombocraft.com"
    author = "WejsoneKKEU | xr-code team"
}
repositories {
    mavenCentral()
    mavenLocal()
    gradlePluginPortal()
    gradleKotlinDsl()
    maven ("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.panda-lang.org/releases")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://repo.eternalcode.pl/releases/")
    maven("https://papermc.io/repo/repository/maven-public/")

}

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")


    implementation("net.kyori:adventure-platform-bukkit:4.2.0")
    implementation("net.kyori:adventure-text-minimessage:4.12.0")
    // LiteCommands
    implementation("dev.rollczi:litecommands-core:3.4.2")

    implementation("dev.rollczi:litecommands-bukkit:3.4.2")

    // cdn
    implementation("net.dzikoysk:cdn:1.14.5")
    implementation("net.dzikoysk:cdn-kt:1.14.5")

    // TriumphGui
    implementation("dev.triumphteam:triumph-gui:3.1.4")

    // panda-utilities
    implementation("org.panda-lang:panda-utilities:0.5.2-alpha")

    // Ormlite jdbc
//    implementation("com.j256.ormlite:ormlite-core:6.1")
//
//    compileOnly("com.j256.ormlite:ormlite-jdbc:6.1")

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

    /* General */
    val lombok = "1.18.32"
    compileOnly("org.projectlombok:lombok:$lombok")
    annotationProcessor("org.projectlombok:lombok:$lombok")
    testCompileOnly("org.projectlombok:lombok:$lombok")
    testAnnotationProcessor("org.projectlombok:lombok:$lombok")
}

tasks {

    runServer {
        minecraftVersion("1.20.6")
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }


    shadowJar {
        archiveClassifier.set("")
        archiveFileName.set("bombocraft-network-${version}.jar")


        exclude(
            "org/intellij/lang/annotations/**",
            "org/jetbrains/annotations/**",
            "META-INF/**",
            "javax/**"
        )


        relocate("com.cryptomorin", "eu.wejsonekk.bombocraft.libs.com.cryptomorin")
        relocate("eu.okaeri", "eu.wejsonekk.bombocraft.libs.eu.okaeri")
        relocate("net.kyori", "eu.wejsonekk.bombocraft.libs.net.kyori")
        relocate("dev.triumphteam", "eu.wejsonekk.bombocraft.libs.dev.triumphteam")
        relocate("org.panda-lang", "eu.wejsonekk.bombocraft.libs.panda-lang")
        relocate("panda.utilities", "eu.wejsonekk.bombocraft.libs.panda.utilities")
        relocate("panda.std", "eu.wejsonekk.bombocraft.libs.panda.std")
        relocate("com.github.benmanes.caffeine", "eu.wejsonekk.bombocraft.libs.caffeine")
//        relocate("org.apache.commons", "eu.wejsonekk.bombocraft.libs.org.apache")

        relocate("org.bson", "eu.wejsonekk.bombocraft.libs.org.bson")
        relocate("com.mongodb", "eu.wejsonekk.bombocraft.libs.com.mongodb")
        relocate("com.zaxxer", "eu.wejsonekk.bombocraft.libs.com.zaxxer")
        relocate("org.slf4j", "eu.wejsonekk.bombocraft.libs.org.slf4j")
        relocate("org.json", "eu.wejsonekk.bombocraft.libs.org.json")
        relocate("com.google.gson", "eu.wejsonekk.bombocraft.libs.com.google.gson")

        minimize()
        mergeServiceFiles()
//        val prefix = "eu.wejsonekk.bombocraft.libs"
//        listOf(
//            "panda.std",
//            "panda.utilities",
//            "org.panda-lang",
//            "eu.okaeri",
//            "net.kyori",
//            "org.bstats",
//            "dev.rollczi.litecommands",
////        "com.eternalcode.gitcheck",
//            "org.json.simple",
////        "org.apache.commons",
//            "javassist",
////        "com.github.benmanes.caffeine",
////        "com.eternalcode.commons"
//
//        ).forEach { pack ->
//            relocate(pack, "$prefix.$pack")
//        }
    }
}